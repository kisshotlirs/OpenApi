package com.mojo.api.model.dto.interfaceInfo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zyl
 * @description: 测试调用请求
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {

    private Long id;

    /**
     * 用户请求参数
     * 形式：[ {"name": "username",""type": "string"} ]
     */
    private String userRequestParams;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
