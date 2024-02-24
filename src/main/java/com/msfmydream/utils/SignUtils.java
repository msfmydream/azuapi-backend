package com.msfmydream.utils;


import cn.hutool.crypto.digest.DigestUtil;

/**
 *  签名工具类
 */
public class SignUtils {

    public String getSign(String body, String secretKey){
        return DigestUtil.md5Hex(body + "_" + secretKey);
    }

}
