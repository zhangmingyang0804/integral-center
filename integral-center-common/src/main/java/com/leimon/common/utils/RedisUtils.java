package com.leimon.common.utils;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @package: com.leimon.common.utils
 * @className: RedisUtils.java
 * @author: ext create by zmy
 * @create: 00:48 2022/11/12
 **/
@Slf4j
public class RedisUtils {
    @SuppressWarnings("rawtypes")
    private static RedisTemplate redisTemplate = null;

    private static RedisTemplate getRedisTemplate() {
        if (redisTemplate == null) {
            try {
                redisTemplate = SpringContextUtils.getBeanByName("redisTemplate");
                if (redisTemplate == null) {
                    redisTemplate = SpringContextUtils.getBeanByClass(RedisTemplate.class);
                }
            } catch (Exception e) {
                log.error("Redis 初始化异常:{}", e);
            }
        }
        return redisTemplate;
    }

    // 向redis里存入数据
    @SuppressWarnings("unchecked")
    public static void setKey(String key, String value) {
        ValueOperations<String, String> ops = getRedisTemplate().opsForValue();
        ops.set(key, value);
    }

    //sadd 数据
    public static Long sadd(String key, String value) {
        Long flag = getRedisTemplate().opsForSet().add(key, value);
        return flag;
    }

    // 从redis中取数据
    @SuppressWarnings("unchecked")
    public static String getValue(String key) {
        ValueOperations<String, String> ops = getRedisTemplate().opsForValue();
        return ops.get(key);
    }

    @SuppressWarnings("unchecked")
    public static void deleteByPrex(String prex) {
        Set<String> keys = getRedisTemplate().keys(prex);
        if (!CollectionUtils.isEmpty(keys)) {
            getRedisTemplate().delete(keys);
        }
    }

    // 向redis里存入数据和设置缓存时间（以秒为单位）
    @SuppressWarnings("unchecked")
    public static void setKeyAndCacheTime(String key, String value, long timeout) {
        ValueOperations<String, String> ops = getRedisTemplate().opsForValue();
        ops.set(key, value, timeout, TimeUnit.SECONDS);

    }

    // 向redis存入的数据做-1 操作
    @SuppressWarnings("unchecked")
    public static void setValueDecrement(String key) {
        getRedisTemplate().boundValueOps(key).increment(-1);
    }

    // 向redis存入的数据做+1 操作
    @SuppressWarnings("unchecked")
    public static void setValueIncrement(String key) {
        getRedisTemplate().boundValueOps(key).increment(+1);
    }

    // 根据key获取过期时间
    @SuppressWarnings("unchecked")
    public static Long getDeadLine(String key) {
        return getRedisTemplate().getExpire(key);
    }

    // 根据key删除缓存
    @SuppressWarnings("unchecked")
    public static void deleteByKey(String key) {
        getRedisTemplate().delete(key);
    }

    // 检查key是否存在，返回boolean值
    @SuppressWarnings("unchecked")
    public static Boolean existKey(String key) {
        return getRedisTemplate().hasKey(key);
    }

    /**
     * 获取分页数据
     *
     * @param key
     * @param pageNo
     * @param rowsPerPage 每页记录数
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Set<String> getPageDate(String key, int pageNo, int rowsPerPage) {
        int start = (pageNo - 1) * rowsPerPage;
        int end = pageNo * rowsPerPage - 1;
        ZSetOperations<String, String> options = getRedisTemplate().opsForZSet();
        Set<String> pageDates = options.range(key, start, end);
        return pageDates;
    }

    /**
     * 获取分页数据
     *
     * @param key
     * @param pageNo
     * @param rowsPerPage 每页记录数
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List getListPageDate(String key, int pageNo, int rowsPerPage) {
        int start = (pageNo - 1) * rowsPerPage;
        int end = pageNo * rowsPerPage - 1;
        ListOperations ops = getRedisTemplate().opsForList();
        return ops.range(key, start, end);
    }

    /**
     * 添加有序集合数据
     *
     * @param key
     * @param dataList
     */
    @SuppressWarnings("unchecked")
    public static void zAddDate(String key, List<Object> dataList) {
        ZSetOperations<String, Object> options = getRedisTemplate().opsForZSet();
        int index = 0;
//		Set<TypedTuple<String>> dataSet = new HashSet<TypedTuple<String>>();
        for (Object obj : dataList) {
            options.add(key, obj, index++);
        }
    }

    /**
     * 设置key超时时间
     *
     * @param key
     * @param expireTime
     * @param timeUnit
     * @return
     */
    @SuppressWarnings("unchecked")
    public static boolean setExpireTime(String key, int expireTime, TimeUnit timeUnit) {
        return getRedisTemplate().expire(key, expireTime, timeUnit);

    }

    /**
     * 查询有序集合总记录数
     *
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public static long getTotal(String key) {
        ZSetOperations<String, String> options = getRedisTemplate().opsForZSet();
        Long total = options.count(key, 0, Integer.MAX_VALUE);
        return total;
    }

    /**
     * 获取用户信息
     *
     * @param clientSeqNo
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Map getUserInfo(String clientSeqNo) {
        ValueOperations<String, String> ops = getRedisTemplate().opsForValue();
        String userRedis = ops.get(StringConstantUtil.USER + clientSeqNo);
        if (StringUtils.isEmpty(userRedis)) {
            return null;
        }
        Map map = JSON.parseObject(userRedis, Map.class);
        return map;
    }

    /**
     * 获取免登陆用户信息
     *
     * @param deviceId
     * @param bankSystemType
     * @return
     */
    public static Map getNologinUserInfo(String deviceId, String bankSystemType) {
        ValueOperations<String, String> ops = getRedisTemplate().opsForValue();
        String userRedis = ops.get(StringConstantUtil.NOLOGIN_KEY + deviceId + bankSystemType);
        if (StringUtils.isEmpty(userRedis)) {
            return null;
        }
        Map map = JSON.parseObject(userRedis, Map.class);
        return map;
    }


    /**
     * 根据设备号获取用户信息
     * @param deviceId
     * @return
     */
    /**
     * add by zhangxueliang for(bug)327 设备免登录的会调用登录接口多次。 20181210 begin
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Map getUserInfoByDeviceId(String deviceId) {
        ValueOperations<String, String> operations = getRedisTemplate().opsForValue();
        String deviceIdRedis = operations.get(StringConstantUtil.DEVICE + deviceId);
        if (StringUtils.isEmpty(deviceIdRedis)) {
            return null;
        }
        Map map = JSON.parseObject(deviceIdRedis, Map.class);
        return map;
    }

    /**
     * add by zhangxueliang for(bug)327 设备免登录的会调用登录接口多次。 20181210 end
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Map getUserInfoByDeviceIdForFace(String deviceId) {
        ValueOperations<String, String> operations = getRedisTemplate().opsForValue();
        String deviceIdRedis = operations.get(deviceId);
        if (StringUtils.isEmpty(deviceIdRedis)) {
            return null;
        }
        Map map = JSON.parseObject(deviceIdRedis, Map.class);
        return map;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Map getCompanyUserInfoByDeviceId(String deviceId) {
        ValueOperations<String, String> operations = getRedisTemplate().opsForValue();
        String deviceIdRedis = operations.get(StringConstantUtil.CONPANYDEVICE + deviceId);
        if (StringUtils.isEmpty(deviceIdRedis)) {
            return null;
        }
        Map map = JSON.parseObject(deviceIdRedis, Map.class);
        return map;
    }

    /**
     * 销毁用户信息
     *
     * @param clientSeqNo
     */
    public static void destroyUserInfo(String clientSeqNo) {
        deleteByKey(StringConstantUtil.TOKEN + clientSeqNo);        //清空TOKEN信息
        deleteByKey(StringConstantUtil.USER + clientSeqNo);            //清空用户信息
        deleteByKey(ConstansUtil.LAST_ORDER + clientSeqNo);            //清空交易对象   add by liweibin for (108)登出清理用户数据  20181205
    }

    /**
     * 存入list数据
     *
     * @param key
     * @param list
     */
    public static void setList(String key, List list) {
        ListOperations ops = getRedisTemplate().opsForList();
        ops.leftPushAll(key, list);
    }

    /**
     * 存入覆盖list数据
     *
     * @param key
     * @param list
     */
    public static void setNewList(String key, List list) {
        //删除key
        getRedisTemplate().delete(key);
        ListOperations ops = getRedisTemplate().opsForList();
        ops.leftPushAll(key, list);
    }

    /**
     * 存入覆盖list数据
     *
     * @param key
     * @param list
     */
    public static void setNewList(String key, List list, Long time) {
        //删除key
        getRedisTemplate().delete(key);
        ListOperations ops = getRedisTemplate().opsForList();
        ops.leftPushAll(key, list);
        getRedisTemplate().expire(key, time, TimeUnit.SECONDS);
    }


    /**
     * 存入一个过去过期的值
     *
     * @param key
     * @param list
     * @param time
     */
    public static void setList(String key, List list, Long time) {
        ListOperations ops = getRedisTemplate().opsForList();
        getRedisTemplate().delete(key);
        ops.leftPushAll(key, list);
        getRedisTemplate().expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 获取list列表  starIndex,endIndex为-1的时候查询所有的
     *
     * @param key
     * @param starIndex
     * @param endIndex
     * @return
     */
    public static List getList(String key, Long starIndex, Long endIndex) {
        if (starIndex == null) {
            starIndex = 0L;
        }
        if (endIndex == null) {
            endIndex = -1L;
        }
        ListOperations ops = getRedisTemplate().opsForList();
        return ops.range(key, starIndex, endIndex);
    }

    /**
     * 设置set的集合
     *
     * @param key
     * @param set
     */
    public static void setList(String key, Set set) {
        SetOperations ops = getRedisTemplate().opsForSet();
        ops.difference(key, set);
    }

    /**
     * 设置set集合的过期时间
     *
     * @param key
     * @param set
     * @param time
     */
    public static void setList(String key, Set set, Long time) {
        SetOperations ops = getRedisTemplate().opsForSet();
        ops.difference(key, set);
        getRedisTemplate().expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 获取set集合
     *
     * @param key
     * @return
     */
    public static Set getSetList(String key) {
        SetOperations ops = getRedisTemplate().opsForSet();
        return ops.members(key);
    }


    /**
     * 存入list数据
     *
     * @param key
     * @param object
     */
    public static void setSecondTimeList(String key, Object object, int secondTime) {
        ListOperations ops = getRedisTemplate().opsForList();
        //先根据key查询是否有值
        List list = ops.range(key, 0L, -1L);
        if (list != null) {
            //判断值是否过期如果过期就移出
            Iterator<Map> it = list.iterator();
            while (it.hasNext()) {
                Map maps = (Map) it.next();
                ;
                Date date = (Date) maps.get("time");
                if (date != null) {
                    //比较的结果 -1是小于，0，等于，1是大于
                    int covert = Calendar.getInstance().getTime().compareTo(date);
                    if (covert != -1) {
                        //删除当前值
                        it.remove();
                    }
                }
            }
            Map<String, Object> map = new HashMap<String, Object>();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, secondTime);
            map.put("time", calendar.getTime());
            map.put("list", object);
            list.add(map);
        }
        //删除key
        getRedisTemplate().delete(key);
        //保存key
        ops.leftPushAll(key, list);
    }


    /**
     * @param key  redis取的集合
     * @param desc true 降序 false 升序
     * @return
     */
    public static List getTimeList(String key, boolean desc) {
        ListOperations ops = getRedisTemplate().opsForList();
        //先根据key查询是否有值
        List list = ops.range(key, 0L, -1L);
        List resultList = new ArrayList();
        //取出集合
        for (int i = 0; i < list.size(); i++) {
            Map map = (Map) list.get(i);
            resultList.add(map.get("list"));
        }
        //去掉重复数据
        Set<Object> set = new HashSet<Object>();
        for (Object object : resultList) {
            set.add(object);
        }
        //判断重复的数量
        List<SortBean> coutList = new ArrayList<SortBean>();
        for (Object o : set) {
            int cont = 0;
            for (Object lobject : resultList) {
                //相等
                if (o.equals(lobject)) {
                    cont = cont + 1;
                }
            }
            SortBean sortBean = new SortBean();
            sortBean.setCount(cont);
            sortBean.setObject(o);
            coutList.add(sortBean);
        }
        if (desc) {
            //从大到小
            Collections.sort(coutList, new Comparator<SortBean>() {
                @Override
                public int compare(SortBean o1, SortBean o2) {
                    if (o1.getCount() > o2.getCount()) {
                        return 1;
                    }
                    if (o1.getCount() == o2.getCount()) {
                        return 0;
                    }
                    return -1;
                }
            });
        } else {
            //排序从小到大
            Collections.sort(coutList, new Comparator<SortBean>() {
                @Override
                public int compare(SortBean o1, SortBean o2) {
                    if (o1.getCount() < o2.getCount()) {
                        return 1;
                    }
                    if (o1.getCount() == o2.getCount()) {
                        return 0;
                    }
                    return -1;
                }
            });
        }
        //排序后的集合
        List<Object> descList = new ArrayList<Object>();
        for (SortBean s : coutList) {
            descList.add(s.getObject());
        }
        return descList;
    }


    /**
     * 储蓄罐获取返回给硬件的信息
     *
     * @param deviceId
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Map getBoxInfo(String deviceId) {
        ValueOperations<String, String> ops = getRedisTemplate().opsForValue();
        String userRedis = ops.get(StringConstantUtil.BOX + deviceId);
        if (StringUtils.isEmpty(userRedis)) {
            return null;
        }
        Map map = JSON.parseObject(userRedis, Map.class);
        return map;
    }


    /**
     * 获取值 返回map
     *
     * @param key
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Map getInfo(String key) {
        ValueOperations<String, String> ops = getRedisTemplate().opsForValue();
        String userRedis = ops.get(key);
        if (StringUtils.isEmpty(userRedis)) {
            return null;
        }
        Map map = JSON.parseObject(userRedis, Map.class);
        return map;
    }

    /** add by fanda for(bug)170 设备查询利率会循环调用接口多次。 20190118 start*/
    /**
     * 获取利率
     *
     * @param key
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Map getDepositInterestRateDate(String key) {
        ValueOperations<String, String> ops = getRedisTemplate().opsForValue();
        String InterestRateDate = ops.get(key);
        if (StringUtils.isEmpty(InterestRateDate)) {
            return null;
        }
        Map map = JSON.parseObject(InterestRateDate, Map.class);
        return map;
    }

    /**
     * add by fanda for(bug)170 设备查询利率会循环调用接口多次。 20190118 end
     */


    public static boolean setNx(final String key, final String value, long expire) {
        boolean result = (boolean) getRedisTemplate().execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisTemplate().getStringSerializer();
                Boolean aBoolean = connection.setNX(serializer.serialize(key), serializer.serialize(value));
                if (aBoolean) {
                    getRedisTemplate().expire(key, expire, TimeUnit.SECONDS);
                }
                return aBoolean;
            }
        });
        return result;
    }

    public static Long getIncr() {
        RedisAtomicLong ter = new RedisAtomicLong("business_auto_parm", getRedisTemplate().getConnectionFactory());
        Long incr = ter.getAndIncrement();
        Long orgParm = 8100000L;
        return orgParm + incr;
    }


    /**
     * 查询一个元素
     *
     * @param key
     * @param value
     */
    public static Double score(String key, String value) {
        return getRedisTemplate().opsForZSet().score(key, value);
    }


    /**
     * 添加一个元素到zset中
     *
     * @param key
     * @param value
     * @param score
     */
    public static void addZset(String key, String value, double score) {
        getRedisTemplate().opsForZSet().add(key, value, score);
    }

    /**
     * 删除一个元素
     *
     * @param key
     * @param value
     */
    public static void removeZset(String key, String value) {
        getRedisTemplate().opsForZSet().remove(key, value);
    }


    /**
     * 返回有序的集合，score小的放前面
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<String> rangeZset(String key, int start, int end) {
        return getRedisTemplate().opsForZSet().range(key, start, end);
    }

    /**
     * 返回有序的集合，score大的在前面
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<String> revRange(String key, int start, int end) {
        return getRedisTemplate().opsForZSet().reverseRange(key, start, end);
    }

    /**
     * 2021.4.7 存入取出int数据 rll start
     */
    // 向redis里存入int数据
    @SuppressWarnings("unchecked")
    public static void setKeyForInteger(String key, Integer value) {
        ValueOperations<String, Integer> ops = getRedisTemplate().opsForValue();
        ops.set(key, value);
    }

    // 从redis中取int数据
    @SuppressWarnings("unchecked")
    public static Integer getIntegerValue(String key) {
        ValueOperations<String, Integer> ops = getRedisTemplate().opsForValue();
        return ops.get(key);
    }
    /** 2021.4.7 存入取出int数据 rll end */
}

@Data
class SortBean {
    private int count;
    private Object object;
}