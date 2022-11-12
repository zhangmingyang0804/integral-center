package com.leimon.common.utils;

public class ConstansUtil {
	/* 上次账号 */
	public static final String LAST_ACCOUNT = "LAST_ACCOUNT_";
	/* 最近订单 */
	public static final String LAST_ORDER = "LAST_ORDER_";
    /* xjx, 2022-05-17 需求编号 : 15203 移动营业厅手机号转账泄露客户信息  ,修改描述:手机号转账数据Redis */
	public static final String MOBILE_TRANSFER = "MOBILE_TRANSFER_";

	/** add by liweibin for (BUG)144卡bin处理区分台行和银座  20181121 begin */

	/** add by yuerli 20191212 机构配置化 start*/
	/* 村镇超级网银号 */
	public static final String CZ_BANK_CODE = "320345790018,320584002002,320428090311,320100010011,320653000104,320687000016,320343800019";
	/* 台行超级网银号 */
	public static final String TZ_BANK_CODE = "313345001665";
	/** add by yuerli 20191212 机构配置化 end*/

	/* 卡bin状态 行内 */
	public static final String CARDBIN_BINDSTATUS_SAME = "2";
	/* 卡bin状态 他行 */
	public static final String CARDBIN_BINDSTATUS_DEFFERENT = "1";
	/* 卡bin状态 失败 */
	public static final String CARDBIN_BINDSTATUS_FAULT = "3";
	/** add by liweibin for (BUG)144卡bin处理区分台行和银座  20181121 end */
	
	//超级网银数据同步任务
	public static final String TASK_CHAO_JI_WANG_YIN= "CJWY";
	//转账银行网点文件同步
	public static final String TASK_ZHUAN_ZHANG_WANG_DIAN = "ZZWD";
	//贷款产品文件同步
	public static final String TASK_DAI_KUAN_WEN_JIAN= "DKWJ";
	//信用卡产品文件同步
	public static final String TASK_CREDIT_CARD_WEN_JIAN= "XYKZXWJ";
	//信用卡产品文件同步
	public static final String TASK_CREDIT_CARD_ADDRESS= "XYKADDRESS";
	//信用卡产品文件同步
	public static final String TASK_SELL_MESSAGE_SEQNO= "MESSAGESEQNO";
	//贷款营业网点文件同步
	public static final String TASK_DAI_KUAN_WANG_DIAN = "DKWD";
	//信用分文件同步
	public static final String TASK_XIN_YONG_FEN_ = "XYF";
	//网点查询文件同步
	public static final String TASK_WANG_DIAN_CHA_XUN="WDCX";
	//组织机构文件同步
	public static final String TASK_ZHU_ZHI_JI_GOU = "ZZJG";
	//Zuul网关配置
	public static final String TASK_ZUUL_CONFIG_Type2 = "ZWGPZ_Type2";
	/**
	 * 账户频度 定时任务
	 */
	public static final String TASK_ACCOUNT_FREQUENCY = "ZHPD";
	/**
	 *常用IP 定时任务
	 */
	public static final String TASK_COMMON0_IP = "CYIP";
	/**
	 *交易时段 定时任务
	 */
	public static final String TASK_TRADE_PERIOD = "JYSD";
	/**
	 *常用地址(gps) 定时任务
	 */
	public static final String TASK_COMMON_ADDRESS = "CYDZ";
	
	/** update by yuerli TASK418常用手机型号  20190505 start*/

	/**
	 *常用地址(省市区) 定时任务
	 */
	public static final String TASK_COMMON_ADDRESS_SSQ = "CYDZ_SSQ";

	/**
	 *常用手机信息 定时任务
	 */
	public static final String TASK_COMMON_MOBLIE = "CYSJ";

	/**
	 *自动分区 定时任务
	 */
	public static final String AUTO_PARTITION = "AUTO_PARTITION";

	/** update by yuerli TASK418常用手机型号  20190505 end*/

	/**
	 *取客户经理文件,解析并入库(ygzpdyb.txt) 定时任务
	 */
	public static final String TASK_CUSTOMER_PIC = "YGZPDYB";
	
	/**
	 *本地记录推送到大数据 定时任务
	 */
	public static final String TASK_PUSH_LOCAL_DATA = "PLD";
	
	/**
	 *本地记录推送到大数据 定时任务
	 */
	
	public static final String TASK_PUSH_BOX_DATA = "BOX";
	/**
	 *同步客户经理信息 定时任务
	 */
	public static final String TASK_CUSTOMER_MESSAGE_INFO = "CMI";
	
	/**
	 *推送 行为埋点日志 定时任务
	 */
	public static final String TASK_PUSH_UNIFORM_BEHAVIOR_DATA = "PUBD";
	
	
	/**
	 *推送 h5行为埋点日志 定时任务
	 */
	public static final String TASK_PUSH_H5_BEHAVIOR_DATA = "PHBD";
	
	
	/**
	 *推送 自动化埋点日志 定时任务
	 */
	public static final String TASK_PUSH_UNIFORM_BEHAVIOR_AUTO_DATA = "PUBAD";
	
	/**
	 *下载客户经理照片 定时任务
	 */
	public static final String TASK_DOWN_CUSTOMER_PIC = "DCP";
	
	/**
	 *推送esblog 定时任务
	 */
	public static final String TASK_ESB_LOG = "ESBLOG";
	
	/**
	 *推送requestlog 定时任务
	 */
	public static final String TASK_REQUEST_LOG = "REQUESTLOG";

	/** add by yuerli 定时扫描商品劵、优惠劵表处理过期 20210120 start*/
	/**
	 * 账户频度 定时任务
	 */
	public static final String TASK_COUPON = "COUPON";
	/** add by yuerli 定时扫描商品劵、优惠劵表处理过期 20210120 end*/


	/**
	 *推送 行内员工信息保存 定时任务
	 * 需求 2022001555
	 */
	public static final String TASK_PUSH_INFO_EMP_DATA = "INFO_EMP";



	public static final String TASK_AUTO_DOWN = "AUTODOWN";

	public static final String TASK_AUTO_UP = "AUTOUP";

	public static final String TASK_AUTO_COMPLETED ="AUTOCOMPLETED";

	public static final String TASK_AUTO_CANCLE = "AUTOCANCLE";

	public static final String TASK_AUTO_REPAY = "AUTOREPAY";

	public static final String TASK_SCAN_MIDDLE = "SCANMIDDLE";

	public static final String TASK_ANALYSE_CSV = "ANALYSECSV";

	public static final String TASK_LOGIN_CUSTOMER = "LOGINCUSTOMER";
	/**
	 *版本转换code
	 */
	public static final String ZEOR_ZEOR = "00";
	
	public static final String ZEOR_ONE = "01";
	
	public static final String ZEOR_TWO = "02";
	
	public static final String ZEOR_THREE = "03";
	
	/** add by liweibin for (TASK)246认证方式记录  20190215 begin */
	//密码
	public final static String AUTHMODE_PASSWORD = "P";
	//短信
	public final static String AUTHMODE_MESSAGE = "M";
	//人脸
	public final static String AUTHMODE_LIAN = "L";
	//指纹
	public final static String AUTHMODE_FINGERPRINT = "FP";
	//口令
	public final static String AUTHMODE_OTP = "O";
	//证书
	public final static String AUTHMODE_USB = "U";
	
	//密码验证标记
	public final static String AUTHMODE_PASSWORD_VERIFYFLAG = "000000000000";
	//免密验证标记
	public final static String AUTHMODE_NO_VERIFYFLAG = "100000000000";
	//指纹验证标记
	public final static String AUTHMODE_FINGERPRINT_VERIFYFLAG = "010000000000";
	//短信验证标记
	public final static String AUTHMODE_MESSAGE_VERIFYFLAG = "000100000000";
	//人脸验证标记
	public final static String AUTHMODE_LIAN_VERIFYFLAG = "001000000000";
	//口令验证标记
	public final static String AUTHMODE_OTP_VERIFYFLAG = "000010000000";
	//证书验证标记
	public final static String AUTHMODE_USB_VERIFYFLAG = "000001000000";
	/** add by liweibin for (TASK)246认证方式记录  20190215 end */


	/** add by liweibin for (TASK)435企业网银登录  20190522 begin */
	//安卓设备类型
	public final static String DEVICE_TYPE_ANDROID = "android";
	//iOS设备类型
	public final static String DEVICE_TYPE_IOS = "iOS";
	//企业网银安卓设备类型
	public final static String DEVICE_TYPE_PMBBS_ANDROID = "PMBBS.ANDROID";
	//企业网银iOS设备类型
	public final static String DEVICE_TYPE_PMBBS_IOS = "PMBBS.IPHONE";

	/** add by liweibin for (TASK)435企业网银登录  20190522 end */

	/** add by yuerli  for DEV_TASK601_LWB(TASK)601 增加生意圈订单号   20190717 begin */
	//生意圈支付标志  1-生意圈支付
	public final static String PAY_MODE = "1";
	/** add by yuerli  for DEV_TASK601_LWB(TASK)601 增加生意圈订单号   20190717 end */

	/** add by liweibin for(task)720 生意圈身份选定登录 20190919 begin*/
	public final static String BUSINESS_CIRCLE_IDENTITY_PERSON = "P";		//生意圈身份个人
	public final static String BUSINESS_CIRCLE_IDENTITY_COMPANY = "C";		//生意圈身份个人
	public final static String BUSINESS_CIRCLE_IDENTITY_REDIS = "BusinessCircleIdentity";		//生意圈redis存的key
	public final static String BUSINESS_CIRCLE_IDENTITY_YES = "1";		//是
	public final static String BUSINESS_CIRCLE_IDENTITY_NO = "0";		//否
	/** add by liweibin for(task)720 生意圈身份选定登录 20190919 end*/


	/** add by tbj for(task)869 获取资产负债 20190919 begin*/
	public final static String GET_TOTAL = "GETTOTAL_";		//获取资产负债服务
	/** add by tbj for(task)869 获取资产负债查询 20190919 end*/


	public final static String ABP_LOG_CONFIG = "ABP_LOG_CONFIG";
	public final static String ABP_LOG_CONFIG_BACKSTAGE = "back";
	public final static String ABP_LOG_CONFIG_ERP = "erp";

//  生活圈日志配置key add by lzw 20210422 begin
	public final static String SHQ_LOG_CONFIG = "SHQ_LOG_CONFIG";
	public final static String SHQ_BACKSTAGE_USER_MSG = "SHQ_BACKSTAGE_USER_MSG";
//	生活圈日志配置key add by lzw 20210422 end

	/** add by zhangxueliang for(task)953 机构同步 20190919 begin*/
	public final static String TASK_DEPT_SYNC = "JGTB";
	/** add by zhangxueliang for(task)953 机构同步 20190919 end*/

	/** add by zhangxueliang for bug 修复首页接口查询客户营销数据频繁的问题 20200306 begin*/
	public final static String MARK_DATA = "MARK_";
	/** add by zhangxueliang for bug 修复首页接口查询客户营销数据频繁的问题 20200306 end*/


	public final static String NOT_SHOW_PERSONAL_LOG_FILTER_TYPE = "NOT_SHOW_PERSONAL_LOG_FILTER_TYPE"; // 不需要展示的 APP 个人操作日志的类型

	public final static String advertData = "advert_";
	public final static String buttonData = "button_";
	public final static String city = "city_";
	public final static String LOCATION_KEY = "location_key_";

	// ZUUL网关配置
	public static final String ZUUL_URL_CONFIG= "ZUUL_URL_CONFIG";

	public static final String TASK_CREATE_PAYMENT_LIMIT = "CREATEPAYMENTLIMIT";

	public static final String ZUUL_URL_CONFIG_MAP= "ZUUL_URL_CONFIG_MAP";

	/** add by lzh 网关配置type  1=设备、2=防重、3=个人、4=企业,5--个人带信息登录，6--企业带信息登录 begain*/
	public static final String TYPE_device= "1";
	public static final String TYPE_PERSON= "3";
	public static final String TYPE_COMPANY= "4";
	public static final String TYPE_PERSON_NOLOGIN= "5";
	public static final String TYPE_COMPANY_NOLOGIN= "6";
	/** add by lzh 网关配置type   end*/

	public static final String TYPE_PUBLICLOGIN= "8";   //联合登录需要检验的路径，即使配置免登陆，依然需要校验,只添加部分生活圈路径
	public static final String USER_FACE_STATUS_REDIS_KEY = "userFaceStatusRedisKey_";

	public final static String seckey="a7c7569a92c1f100";

	// 推送房产估值记录到大数据
	public static final String TASK_PUSH_REALESTATE_VALUATION_DATA = "TPREVD";
	/**
	 *同步客户经理信息 定时任务
	 */
	public static final String TASK_DOWN_CUSTOMER_MANAGER_INFO = "TDCMI";

	// 入库扫码贷白名单数据
	public static final String TASK_DOWN_SCAN_LOAN_ALLOW_LIST = "TDSLAL";

	public static final String TASK_UP_ONLINE_ACCOUNT = "TUOA"; // add by 何佳晴 for [2022001382对电子渠道监控系统优化改造的需求]  2022-07-13

	/**
	 * 何佳晴 2022-04-20
	 * 需求号： 2022000715-移动营业厅银行列表技术优化需求<br/>
	 * 修改逻辑： PT_CLS_INFO.TXT文件同步任务<br/>
	 */
	public static final String TASK_DOWN_PT_CLS_INFO = "TDPCITXT"; // 任务标识
	public static final String TASK_DOWN_PT_CLS_INFO_CONFIG_NAME = "PT_CLS_INFO"; // 服务器等配置名称
	/** 何佳晴 2022000715-移动营业厅银行列表技术优化需求 2022-04-20 end */

	// 林志伟，2022-09-28 BUG号：25796 tzb-backstage中的2个有关生活圈调用的2个服务往framework-common-service迁移 修改描述：从后管迁移过来
	public final static long REDIS_MAX_TIME = 1800; // 机构数据在redis中存放的时间
}
