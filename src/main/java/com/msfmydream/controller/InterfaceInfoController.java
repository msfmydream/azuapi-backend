package com.msfmydream.controller;


import com.msfmydream.common.BaseResponse;
import com.msfmydream.model.dto.interfaceinfo.InterfaceInfoAddRequest;
import com.msfmydream.model.entity.InterfaceInfo;
import com.msfmydream.service.InterfaceInfoService;
import com.msfmydream.utils.ResultUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/interfaceinfo")
@Slf4j
@Api(value = "interface 接口信息")
public class InterfaceInfoController {


    @Resource
    private InterfaceInfoService interfaceInfoService;

    @PostMapping("/add")
    public BaseResponse<Long> addInterfaceInfo(@RequestBody InterfaceInfoAddRequest interfaceInfoAddRequest,
                                               HttpServletRequest httpServletRequest){
        if(interfaceInfoAddRequest == null){
            //TODO 自定义BusinessException
        }


        InterfaceInfo interFaceInfo = new InterfaceInfo();
        BeanUtils.copyProperties(interfaceInfoAddRequest,interFaceInfo);

        //TODO 此处的userID 需改为登录用户的userID
        interFaceInfo.setUserid(0L);

        boolean result = interfaceInfoService.save(interFaceInfo);
        if(!result){
            //抛出异常
        }
        long newInterfaceInfoId = interFaceInfo.getId();

        return ResultUtils.success(newInterfaceInfoId);
    }



}
