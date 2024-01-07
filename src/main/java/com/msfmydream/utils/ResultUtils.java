package com.msfmydream.utils;

import com.msfmydream.common.BaseResponse;

import static com.msfmydream.common.BaseStatus.SUCCESS;

public  class ResultUtils<T> {

    public static BaseResponse success(Object data){

        BaseResponse response = new BaseResponse<>();
        response.setCode(SUCCESS);
        response.setData(data);
        response.setMessage(SUCCESS.message());
        return response;
    }

}
