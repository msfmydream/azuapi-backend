package com.msfmydream.common;

public enum BaseStatus implements StatusCode{

    SUCCESS(200,"success"),
    PARAM_ERROR(400,"Invalid parameters"),
    NOT_FOUND(404,"Resource not found"),
    FAILURE(500,"application internal error"),

    NOT_LOGIN_ERROR(40100, "未登录"),
    NO_AUTH_ERROR(40101, "无权限"),

    OPERATION_ERROR(50002, "操作失败"),

    SYSTEM_ERROR(50001,"system error");


    private final int code;
    private final String message;

    BaseStatus(int code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return String.valueOf(this.code);
    }
}
