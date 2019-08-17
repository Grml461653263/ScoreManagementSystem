package com.my.score.utils;

/**
 * 页面信息提示 Created by 孙荣杰 on 2017/8/10.
 */
public class MessageCode {
  /** 未配置 */
  public static final String SYSTEM_UNCONFIGURED = "system.unconfigured";
  /** 查询成功 */
  public static final String FIND_SUCCESS = "find.success";
  /** 查询失败 */
  public static final String FIND_FAIL = "find.fail";
  /** 新建成功 */
  public static final String ADD_SUCCESS = "add.success";
  /** 新建失败 */
  public static final String ADD_FAIL = "add.fail";
  /** 编辑成功 */
  public static final String EDIT_SUCCESS = "edit.success";
  /** 编辑失败 */
  public static final String EDIT_FAIL = "edit.fail";
  /** 删除成功 */
  public static final String DELETE_SUCCESS = "delete.success";
  /** 删除失败 */
  public static final String DELETE_FAIL = "delete.fail";
  /** 导入成功 */
  public static final String IMPORT_SUCCESS = "import.success";
  /** 导入失败 */
  public static final String IMPORT_FAIL = "import.fail";
  /** 导出成功 */
  public static final String EXPORT_SUCCESS = "export.success";
  /** 导出失败 */
  public static final String EXPORT_FAIL = "export.fail";
  /** 保存成功 */
  public static final String SAVE_SUCCESS = "save.success";
  /** 保存失败 */
  public static final String SAVE_FAIL = "save.fail";
  /** 登录成功 */
  public static final String LOGIN_SUCCESS = "login.success";
  /** 登录失败 */
  public static final String LOGIN_FAIL = "login.fail";
  /** 退出成功 */
  public static final String LOGOUT_SUCCESS = "logout.success";
  /** 退出失败 */
  public static final String LOGOUT_FAIL = "logout.fail";
  /** 更新成功 */
  public static final String UPDATE_SUCCESS = "update.success";
  /** 更新失败 */
  public static final String UPDATE_FAIL = "update.fail";
  /** 上传成功 */
  public static final String UPLOAD_SUCCESS = "upload.success";
  /** 上传失败 */
  public static final String UPLOAD_FAIL = "upload.fail";
  /** 支付成功 */
  public static final String PAY_SUCCESS = "pay.success";
  /** 支付失败 */
  public static final String PAY_FAIL = "pay.fail";
  /** 操作成功 */
  public static final String OPERATE_SUCCESS = "operate.success";
  /** 操作失败 */
  public static final String OPERATE_FAIL = "operate.fail";
  /** 系统异常 */
  public static final String SYSTEM_ERROR = "system.error";
  /** 用户session */
  public static final String USER_SESSION = "userSession";
  /** 当前店铺session */
  public static final String STORE_SESSION = "storeSession";
  /** 请选择店铺 */
  public static final String FAIL_STATE_100 = "100";
  /** 店铺不存在或者已关闭 */
  public static final String FAIL_STATE_101 = "101";
  /** 焦点图数量限制：最多5张 */
  public static final String FAIL_STATE_102 = "102";
  /** 没有权限新建店铺 */
  public static final String FAIL_STATE_103 = "103";
  /** 店铺不存在或者没有权限 */
  public static final String FAIL_STATE_104 = "104";
  /** 该焦点图未下架，不能删除 */
  public static final String FAIL_STATE_105 = "105";
  /** 失败 cookie错误 */
  public static final String FAIL_STATE_106 = "106";
  /** 失败 手机号不正确请重新输入 */
  public static final String FAIL_STATE_107 = "107";
  /** 失败 地址不能为空 */
  public static final String FAIL_STATE_108 = "108";
  /** 失败 手机号不能为空 */
  public static final String FAIL_STATE_109 = "109";
  /** 失败 收货人不能为空 */
  public static final String FAIL_STATE_110 = "110";
  /** 失败 发送短信欠费 */
  public static final String FAIL_ARREARAGE = "111";
  /** 失败 请输入详细地址（街道、门牌号，至少包含5个汉字） */
  public static final String FAIL_STATE_112 = "112";
  /** 用户登陆超时请重新登陆 */
  public static final String FAIL_STATE_113 = "113";
  /** 请选择小于2M的JPG、GIF、PNG、JPEG格式图片上传哦~ */
  public static final String FAIL_STATE_114 = "114";
  /** 200:成功 */
  public static final String SUCCESS_CODE = "200";
  /** 300:失败 */
  public static final String FAIL_CODE = "300";
  /** 失败 商品下架 */
  public static final String FAIL_GOODSOFF = "400";
  /** 失败 商品不存在 */
  public static final String FAIL_GOODSNOTEXIST = "401";
  /** 调用失败 */
  public static final String FAIL_STATE_506 = "506";
  /** 失败 发票类型不能为空 */
  public static final String FAIL_STATE_507 = "507";
  /** 失败 发票抬头不能为空 */
  public static final String FAIL_STATE_508 = "508";
  /** 失败 发票内容不能为空 */
  public static final String FAIL_STATE_509 = "509";
  /** 支付宝交易状态 交易不存在 */
  public static final String ALIPAY_STATE_510 = "510";
  /** 支付宝交易状态 交易待付款 */
  public static final String ALIPAY_STATE_511 = "511";
  /** 支付宝交易状态 交易已关闭 */
  public static final String ALIPAY_STATE_512 = "512";
  /** 支付宝交易状态 交易支付成功 */
  public static final String ALIPAY_STATE_513 = "513";
  /** 支付宝交易状态 交易结束 */
  public static final String ALIPAY_STATE_514 = "514";

  /** 返回状态 success */
  public static final String SUCCESS_STATUS = "success";

  /** 返回状态 error */
  public static final String FAIL_STATUS = "error";

  /*************** 6开头，订单相关返回值定义 **************/
  /** 订单不存在 */
  public static final String FAIL_STATE_600 = "600";
  /** 系统异常，请稍后再试 */
  public static final String FAIL_STATE_699 = "699";

  /*************** 8开头，微信支付返回值定义 **************/
  /** 订单不存在 */
  public static final String FAIL_STATE_800 = "800";
  /** 订单已支付 */
  public static final String FAIL_STATE_801 = "801";
  /** 订单已转入退款 */
  public static final String FAIL_STATE_802 = "802";
  /** 订单已关闭 */
  public static final String FAIL_STATE_803 = "803";
  /** 订单已有用户正在支付 */
  public static final String FAIL_STATE_804 = "804";
  /** 系统异常，请稍后再试 */
  public static final String FAIL_STATE_899 = "899";

  /*************** 9开头，其他类型返回值定义 **************/
  /** 手机号不能为空 */
  public static final String FAIL_STATE_900 = "900";
  /** 手机号码格式错误 */
  public static final String FAIL_STATE_901 = "901";
  /** 已经超过20次，无法发送短信验证码 */
  public static final String FAIL_STATE_902 = "902";
  /** 请60秒后再发送 */
  public static final String FAIL_STATE_903 = "903";
  /** 短信服务异常，如需协助请联系客服：4007-167-956 */
  public static final String FAIL_STATE_904 = "904";
  /** 手机号或者验证码不正确请重新输入 */
  public static final String FAIL_STATE_905 = "905";
  /** 您输入的手机号码和验证码不匹配，请核实后重新输入 */
  public static final String FAIL_STATE_906 = "906";
  /** 获取用户信息失败 */
  public static final String FAIL_STATE_907 = "907";
  /** 用户不存在 */
  public static final String FAIL_STATE_908 = "908";
  /** 系统异常，请稍后再试 */
  public static final String FAIL_STATE_999 = "999";

  /*************** 3开头，服务项目返回值定义 **************/
  /** 服务项目不存在 */
  public static final String FAIL_STATE_301 = "301";
  /** 服务项目已下架 */
  public static final String FAIL_STATE_302 = "302";
  /** 部分服务项目已下架 */
  public static final String FAIL_STATE_303 = "303";
  /** 商品名称重复 */
  public static final String FAIL_STATE_304 = "304";
  /** 该商品未下架，不能删除 */
  public static final String FAIL_STATE_305 = "305";
  /** 系统异常，请稍后再试 */
  public static final String FAIL_STATE_399 = "399";

  /*************** 2开头，服务项目类别返回值定义 **************/
  /** 服务项目类别不存在 */
  public static final String FAIL_STATE_201 = "201";
  /** 服务项目须知不存在 */
  public static final String FAIL_STATE_202 = "202";
  /** 服务项目未下架，不可删除 */
  public static final String FAIL_STATE_203 = "203";
  /** 商品不存在或不属于该店铺 */
  public static final String FAIL_STATE_204 = "204";
  /** 商品分类已被选，请重新选择 */
  public static final String FAIL_STATE_205 = "205";
  /** 须知内容不能为空 */
  public static final String FAIL_STATE_206 = "206";
  /** 分类名称重复 */
  public static final String FAIL_STATE_207 = "207";
  /** 有商品关联，不可删除 */
  public static final String FAIL_STATE_208 = "208";

  /*************** 上传文件返回自定义 **************/
  /** 文件不能为空 */
  public static final String FAIL_STATE_A100 = "A100";
  /** 文件大小不能超过$｛maxSize｝K */
  public static final String FAIL_STATE_A101 = "A101";
  /** 文件名不能包含后面字符：, */
  public static final String FAIL_STATE_A102 = "A102";
  /** 文件名（含扩展名）长度不能超过255个字符 */
  public static final String FAIL_STATE_A103 = "A103";
  /** 不能上传不合法格式的文件 */
  public static final String FAIL_STATE_A104 = "A104";
  /** 图片宽高限制为：{imgWidth}x{imgHeight}px */
  public static final String FAIL_STATE_A105 = "A105";
  /** 图片类型限制为：PNG、JPEG（.jpg;.jpeg;.jpe;.jfif） */
  public static final String FAIL_STATE_A106 = "A106";
  /** 图片宽度限制为：{imgWidth}px */
  public static final String FAIL_STATE_A107 = "A107";
  /** 图片高度限制为：{imgHeight}px */
  public static final String FAIL_STATE_A108 = "A108";


  /*************** 系统用户自定义 **************/
  /** 请输入账号 */
  public static final String FAIL_STATE_B100 = "B100";
  /** 请输入密码 */
  public static final String FAIL_STATE_B101 = "B101";
  /** 账号或密码输入错误 */
  public static final String FAIL_STATE_B102 = "B102";
  /** 用户登录超时请重新登录 */
  public static final String FAIL_STATE_B103 = "B103";


  /*************** 系统排程自定义 **************/
  /** 表达式有误，不能被解析 */
  public static final String FAIL_STATE_C100 = "C100";
  /** 未找到调用类 */
  public static final String FAIL_STATE_C101 = "C101";
  /** 未找到调用方法 */
  public static final String FAIL_STATE_C102 = "C102";
  /** 排程不存在或者排程为启用状态 */
  public static final String FAIL_STATE_C103 = "C103";
  
  /******************自定义**************************/
  public static final String SUCCESS= "成功";
  public static final String FAIL= "失败";
}
