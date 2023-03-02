package com.mojo.api.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author mojo
 * @description: 封装id请求
 * @date 2023/3/2 0002 22:52
 */
@Data
public class IdRequest implements Serializable {

    private Long id;

    private static final long serialVersionUID = 1L;
}
