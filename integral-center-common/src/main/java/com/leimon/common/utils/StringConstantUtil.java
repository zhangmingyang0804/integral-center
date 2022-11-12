package com.leimon.common.utils;

public final class StringConstantUtil {

	public static final String USER = "USER_";
	public static final String SYQ_APP_USER = "SYQ_APP_USER_";
	public static final String TOKEN = "TOKEN_";
	public static final String SYQ_APP_TOKEN = "SYQ_APP_TOKEN_";
	public static final String SYQ_TOKEN = "SYQ_TOKEN_";//联合登陆token
	public static final String SHQ_TOKEN = "SHQ_TOKEN_";//联合登陆生活圈token
	/** add by zhangxueliang for(bug)327 设备免登录的会调用登录接口多次。 20181210 begin*/
	public static final String DEVICE = "DEVICE_";
	public static final String CONPANYDEVICE = "CONPANY_DEVICE_";
	/** add by zhangxueliang for(bug)327 设备免登录的会调用登录接口多次。 20181210 end*/
	public static final String BOX = "BOX_";
	/** add by lixiaobo for(bug)327 二维码被扫收款记录 20190124 begin*/
	public static final String QRCODE = "QRCODE_";
	/** add by lixiaobo for(bug)327 二维码被扫收款记录。 20190124 end*/

	/** add by zhangxueliang for bug 6626 语音转账与数据库交互频繁 20200106 begin */
	public static final String INTENT = "INTENT_DATA";
	public static final String THEME = "THEME_DATA";
	public static final String BUSINESS_FIELD = "BUSINESS_FIELD_DATA_";
	public static final String FLOWSET =  "FLOWSET_";
	public static final String PAGERULE = "PAGERULE_";
	/** add by zhangxueliang for bug 6626 语音转账与数据库交互频繁 20200106 end */
	
	public static final String FINANCEALL = "FINANCEALL_";  
	public static final String FINANCEDETAIL = "FINANCEDETAIL_";  
	public static final String BUYFINANCEAMT = "BUYFINANCEAMT_";  
	public static final String FINANCEALL_LOCK_KEY = "FINANCEALL_LOCK_KEY";  
	public static final String FINANCEALL_LOCK_VALUE = "FINANCEALL_LOCK_VALUE";

	public static final  Long  PC_LOGIN_TIME=  2592000L;
	public static final Long H5_LOGIN_TIME = 2592000L;

	public static final  String  PC_BUSINESS_TOKEN_=  "PC_BUSINESS_TOKEN_";
	public static final  String  PC_BUSINESS_USER_=  "PC_BUSINESS_USER_";
	public static final  String  H5_BUSINESS_TOKEN_=  "H5_BUSINESS_TOKEN_";
	public static final  String  H5_BUSINESS_USER_=  "H5_BUSINESS_USER_";
	public static final  String  SM2_PRIVATEKEY=  "dab6af4538ae1448a45d9bfea294bce60b74c03142ce3a3d80820c2600f64b4e";





	/** add by zhangxueliang for 交易安全认证模型 20200730 begin*/
	public static final String FRAUD = "FRAUD_";
	public static final String BANK_LIMIT = "BANK_LIMIT";
	/** add by zhangxueliang for 交易安全认证模型 20200730 end*/

	public static final String SOCIAL_PASSWORD_TIMES = "spt_";

	public static final String PLAT_INFO = "PLAT_INFO_";

	public static final String TRADE_INFO="TRADE_INFO_";

	public static final String BACK_PAYMENT="BACK_PAYMENT_";


	/**add by wangafei 社区模型 20210313   start*/

	public static final String COMMUNITY ="COMMUNITY_UAT";
	public static final String SOCIAL_USER ="SOCIAL_USER_";
	public static final String COMMUNITY_DEVICE ="COMMUNITY_DEVICE";
	public static final int FIVE_THOUSAND = 5000;
	public static final int THREE_HUANDR = 300;

	/**add by wangafei 社区模型 20210313   end*/


	public static final String NO_LOGIN = "NOLOGIN_";

	public static final String NOLOGIN_KEY = "NOLOGIN_";
	public static final String NOLOGIN_COMPANY_KEY = "NOLOGIN_COMPANY_";

	public static final String SELLER_POINT = "sellerPointUAT";
	public static final long TWO_THOUSAND = 2000;


	public static final String SELLER_POINT_ALL = "sellerPointAll";
	public static final String SELLER_POINT_LIKE = "sellerPointLike";
	public static final String SELLER_POINT_LIKE_TEMP = "sellerPointLikeTemp";
	public static final String SYQ_SECRETKEY = "syqSecretkey";



	public static final String EXPECTION_ROW_FULLY_CLASS_NAME="EXCEPTION:ROW:";  //自定义异常信息
	public static final String EXPECTION_UNDEFINED="EXPECTION_UNDEFINED";//未定义异常，走全局异常

	public static final String EXPECTION_ROW_SERVICE_SCENE="EXCEPTION:ROW:"; //ESB异常信息
	public static final String EXPECTION_ROW_SERVICE_SCENE_NOEXIST="EXCEPTION:ROW:NOEXIST:"; //ESB未配置信息

	public static final String EXPECTION_ESB_OVERALL="EXPECTION_ESB_OVERALL";//ESB全局过滤配置
	public static final String EXPECTION_ESB_OVERALL_NOEXIST="EXPECTION_ESB_OVERALL_NOEXIST";//ESB全局过滤未配置

	public static final String  BANKCODE_OPENBRANCH_RELATION = "BANKCODE:OPENBRANCH:RELATION:";

	//20220413宝贝成长添加宝贝
	public final static String VALID_CODEMSG_ADDNICKNO="valid:codeMsg:addNickNo_";
	public static final String CHECK_LIVE_MSGBATCH_PUSH_FLAG="checkLiveMsgBatchFlag"; //直播平台消息批量防重校验标识 后面加文件名

	public static final String ACCESS_CONTROL="ACCESS_CONTROL_";//TASK 1835 营业厅业务功能配置化  网关拦截的访问控制key

	public static final String ACCESS_CONTROL_URL="ACCESS_CONTROL_URL_";//TASK 1835 营业厅业务功能配置化  网关拦截的访问控制url

	public static final String ACCESS_CONTROL_DEPT="ACCESS_CONTROL_DEPT_";//TASK 1835 营业厅业务功能配置化  网关拦截的访问控制机构

}
