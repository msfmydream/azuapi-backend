package com.msfmydream.utils;

import com.msfmydream.common.BaseResponse;

import static com.msfmydream.common.BaseStatus.SUCCESS;

public  class ResultUtils<T> {

    public static <T> BaseResponse success(T data){

        return BaseResponse.with(SUCCESS, data);
    }

}
