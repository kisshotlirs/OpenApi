package com.mojo.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mojo.api.common.ErrorCode;
import com.mojo.api.exception.BusinessException;
import com.mojo.api.mapper.UserInterfaceInfoMapper;
import com.mojo.api.model.entity.UserInterfaceInfo;
import com.mojo.api.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

/**
 * @author mojo
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {


    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //创建时，所有参数非空
        if (add){
            if (userInterfaceInfo.getInterfaceInfoId()<=0 || userInterfaceInfo.getUserId()<=0){
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"用户或接口不存在");
            }
        }
        if (userInterfaceInfo.getLeftNum()<0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"剩余次数不小于0");
        }
    }

    @Override
    public synchronized boolean invokeCount(long interfaceInfoId, long userId) {
        //非空判断
        if (interfaceInfoId<=0 || userId<=0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper<UserInterfaceInfo> wrapper = new UpdateWrapper<>();
        wrapper.eq("interfaceInfoId",interfaceInfoId);
        wrapper.eq("userId",userId);
        wrapper.gt("leftNum",0);
        wrapper.setSql("leftNum=leftNum-1,totalNum=totalNum+1");
        return this.update(wrapper);
    }
}




