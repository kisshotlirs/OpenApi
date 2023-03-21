package com.mojo.api.model.dto.userInterfaceInfo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zyl
 * @description: 用户接口关系请求
 */
@Data
public class UserInterfaceInfoUpdateRequest implements Serializable {

    private Long id;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 0-正常，1-禁用
     */
    private Integer status;
}
