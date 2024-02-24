package com.msfmydream.model.dto.interfaceinfo;

import com.msfmydream.constant.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

/**
 * 查询请求
 *
 * @author azu
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class InterfaceInfoQueryRequest extends PageRequest implements Serializable {

    /**
     * 主键
     */
    private Long id;

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
    private String requestHeader;

    /**
     * 响应头信息
     */
    private String responseHeader;

    /**
     * 创建人
     */
    private Long userid;

    /**
     * 接口状态（0 关闭，1开启）
     */
    private Integer status;


}
