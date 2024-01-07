package com.msfmydream.exception;

import com.msfmydream.common.BaseStatus;

public class BusinessException extends RuntimeException {

    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(BaseStatus errorCode) {
        super(errorCode.message());
        this.code = errorCode.code();
    }

    public BusinessException(BaseStatus errorCode, String message) {
        super(message);
        this.code = errorCode.code();
    }

    public int getCode() {
        return code;
    }
}
