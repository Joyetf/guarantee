package com.ahzx.baohanapi.common.result;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ResultCodeEnum {

    SUCCESS(true,200,"成功"),
    ERROR(false,500,"失败"),

    UNKOWN_REASON(false,20001,"未知错误"),

    BAD_SQL_GRAMMAR(false,21001,"sql语法错误"),
    JSON_PARSE_ERROR(false,21002,"json解析异常"),
    PARAM_ERROR(false,21003,"参数不正确"),
    FILE_UPLOAD_ERROR(false, 21004, "文件上传错误"),
    FILE_DELETE_ERROR(false, 21005, "文件刪除错误"),
    EXCEL_DATA_IMPORT_ERROR(false, 21006, "Excel数据导入错误"),
    PARAM_MISSING(false,21007,"参数缺失"),

    URL_ENCODE_ERROR(false,22001,"URL编码失败"),
    ILLEGAL_CALLBACK_REQUEST_ERROR(false,22002,"非法回调请求"),
    FETCH_USERINFO_ERROR(false,22003,"获取用户信息失败"),
    ARITHMETIC_ERROR(false,22004,"算术运算异常"),

    GATEWAY_ERROR(false,23001,"服务不能访问"),
    PHONE_ERROR(false,23002,"手机号不正确"),
    ACCOUNT_ERROR(false,23003,"账号不正确");

    private Boolean success;
    private Integer code;
    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
