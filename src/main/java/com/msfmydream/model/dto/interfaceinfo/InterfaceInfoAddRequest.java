package com.msfmydream.model.dto.interfaceinfo;

import lombok.Data;

/**
 * 添加请求
 *
 * @author azu
 */
@Data
public class InterfaceInfoAddRequest {


    /**
     * 接口名称
     */
    private String name;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 请求类型
     */
    private String method;

    /**
     * 接口描述信息
     */
    private String description;

    /**
     * 请求头信息
     */
    private String requestheader;

    /**
     * 响应头信息
     */
    private String reponseheader;

}
