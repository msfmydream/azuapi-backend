package com.msfmydream.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 删除请求
 *
 * @author azu
 */

@Data
public class DeleteRequest implements Serializable {

    private Long id;
}
