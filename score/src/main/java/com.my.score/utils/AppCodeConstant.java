package com.my.score.utils;

public interface AppCodeConstant {

  // /** 成功 */
  String SUCCESS = "SUCCESS";
  String SUCCESS_MSG = "成功";
  // /** 失败 */
  String ERROR = "ERROR";
  String ERROR_MSG = "失败";

  String SESSION_USER = "session_user";


  // ============== 操作结果编号定义 ===================
  String SAVE_SUCCESS_CODE = "00";
  String SAVE_FAILED_CODE = "01";
  String SAVE_REPEAT_CODE = "02";
  String SAVE_LEADER_NULL_CODE = "03";
  String SAVE_EMPTY_CODE = "04";
  // ============== 操作结果编号定义 ===================

  // ==============消息key定义======================
  String MSG_KEY_SAVE_SUCCESS = "save.success";
  String MSG_KEY_DELETE_SUCCESS = "delete.success";
  String MSG_KEY_LOGIN_SUCCESS = "login.success";
  String MSG_KEY_IMPORT_SUCCESS = "import.success";
  String MSG_KEY_EXPORT_SUCCESS = "export.success";
  String MSG_KEY_SAVE_FAIL = "save.fail";
  String MSG_KEY_UPDATE_FAIL = "update.fail";
  String MSG_KEY_DELETE_FAIL = "delete.fail";
  String MSG_KEY_LOGIN_FAIL_USER = "login.fail.user";
  String MSG_KEY_LOGIN_FAIL_USER_NULL = "login.fail.user.null";
  String MSG_KEY_LOGIN_FAIL_PWD_NULL = "login.fail.pwd.null";
  String MSG_KEY_LOGIN_FAIL_PWD = "login.fail.pwd";
  String MSG_KEY_PWD_CHECK_FIAL = "PWD_CHECK_FIAL";
  String MSG_KEY_SYSTEM_ERROR = "system.error";
  String MSG_KEY_PASSWORD_IS_NOT_TRUE = "password_is_not_true";
  String MSG_KEY_PASSWORD_IS_NOT_EMPTY = "password_is_not_empty";
  String MSG_KEY_IMPORT_FAIL = "import.fail";
  String MSG_KEY_EXPORT_FAIL = "export.fail";
  String MSG_KEY_IDCARD_REPEAT = "idcard.repeat";
  String MSG_KEY_JOB_REPEAT = "job.repeat";
  String MSG_KEY_MEMBER_REPEAT = "member.repeat";
  String MSG_KEY_ITRCODE_REPEAT = "itrCode.repeat";
  String MSG_KEY_MANCODE_REPEAT = "manCode.repeat";
  String MSG_KEY_ROLE_REPEAT = "role.repeat";
  String MSG_KEY_SEND_SUCCESS = "send.success";
  String MSG_KEY_ROLE_IS_USED = "role.is.used";
  String MSG_KEY_POSITION_IS_USED = "position.is.used";
  String MSG_KEY_BONDSMAN_IS_USED = "bondsman.is.used";
  String MSG_KEY_INTERMEDIATOR_IS_USED = "intermediator.is.used";
  String MSG_KEY_TEAM_NULL = "TEAM_NULL";
  String MSG_KEY_MEMBER_NULL = "MEMBER_NULL";
  String MSG_KEY_LEADER_NULL = "LEADER_NULL";
  String MSG_KEY_MEMBER_EXIST = "MEMBER_EXIST";
  String MSG_KEY_TEAM_IS_USED = "TEAM_IS_USED";
  String MSG_KEY_NKIND_IS_EXIST = "NKIND_IS_EXIST";
  String MSG_KEY_GROUP_REPEAT = "group.repeat";

  String MSG_KEY_OBJ_CHANGED = "obj.changed";
  // ==============消息key定义======================
}
