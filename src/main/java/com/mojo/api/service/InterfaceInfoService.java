package com.mojo.api.service;

import com.mojo.api.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mojo.api.model.entity.Post;

/**
* @author mojo
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-02-20 16:43:22
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 校验
     *
     * @param interfaceInfo
     * @param add 是否为创建校验
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

}
