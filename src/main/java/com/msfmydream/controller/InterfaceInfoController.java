package com.msfmydream.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msfmydream.common.BaseResponse;
import com.msfmydream.common.BaseStatus;
import com.msfmydream.common.DeleteRequest;
import com.msfmydream.constant.CommonConstant;
import com.msfmydream.exception.BusinessException;
import com.msfmydream.model.dto.interfaceinfo.InterfaceInfoAddRequest;
import com.msfmydream.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.msfmydream.model.dto.interfaceinfo.InterfaceInfoUpdateRequest;
import com.msfmydream.model.entity.InterfaceInfo;
import com.msfmydream.service.InterfaceInfoService;
import com.msfmydream.utils.ResultUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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


    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteInterfaceInfo(@RequestBody DeleteRequest deleteRequest, HttpServletRequest httpServletRequest){
        if(deleteRequest == null && deleteRequest.getId() <= 0){
            throw new BusinessException(BaseStatus.PARAM_ERROR);
        }
        long id = deleteRequest.getId();
        //check is exist
        InterfaceInfo oldInterface = interfaceInfoService.getById(id);
        if( oldInterface == null){
            throw new BusinessException(BaseStatus.NOT_FOUND);
        }
        boolean b = interfaceInfoService.removeById(id);
        return ResultUtils.success(b);
    }

    @PostMapping("/update")
    public BaseResponse<Boolean> updatePost(@RequestBody InterfaceInfoUpdateRequest interfaceInfoUpdateRequest,
                                            HttpServletRequest request) {
        if (interfaceInfoUpdateRequest == null || interfaceInfoUpdateRequest.getId() <= 0) {
            throw new BusinessException(BaseStatus.PARAM_ERROR);
        }
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        BeanUtils.copyProperties(interfaceInfoUpdateRequest, interfaceInfo);
        // 参数校验
        interfaceInfoService.validInterfaceInfo(interfaceInfo, false);

        long id = interfaceInfoUpdateRequest.getId();
        // 判断是否存在
        InterfaceInfo oldInterface = interfaceInfoService.getById(id);
        if (oldInterface == null) {
            throw new BusinessException(BaseStatus.NOT_FOUND);
        }
        boolean result = interfaceInfoService.updateById(interfaceInfo);
        return ResultUtils.success(result);
    }



    @GetMapping("/get")
    public BaseResponse<InterfaceInfo> getPostById(long id) {
        if (id <= 0) {
            throw new BusinessException(BaseStatus.PARAM_ERROR);
        }
        InterfaceInfo interfaceInfo = interfaceInfoService.getById(id);
        return ResultUtils.success(interfaceInfo);
    }


    @GetMapping("/list")
    public BaseResponse<List<InterfaceInfo>> listPost(InterfaceInfoQueryRequest interfaceInfoQueryRequest) {
        InterfaceInfo interfaceInfoQuery = new InterfaceInfo();
        if (interfaceInfoQueryRequest != null) {
            BeanUtils.copyProperties(interfaceInfoQueryRequest, interfaceInfoQuery);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>(interfaceInfoQuery);
        List<InterfaceInfo> interfaceInfosList = interfaceInfoService.list(queryWrapper);
        return ResultUtils.success(interfaceInfosList);
    }


    @GetMapping("/list/page")
    public BaseResponse<Page<InterfaceInfo>> listPostByPage(InterfaceInfoQueryRequest interfaceinfoQueryRequest,
                                                            HttpServletRequest httpServletRequest) {
        if (interfaceinfoQueryRequest == null) {
            throw new BusinessException(BaseStatus.PARAM_ERROR);
        }
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        BeanUtils.copyProperties(interfaceinfoQueryRequest, interfaceInfo);
        long current = interfaceinfoQueryRequest.getCurrent();
        long size = interfaceinfoQueryRequest.getPageSize();
        String sortField = interfaceinfoQueryRequest.getSortField();
        String sortOrder = interfaceinfoQueryRequest.getSortOrder();
        String description = interfaceInfo.getDescription();
        // description 需支持模糊搜索
        interfaceInfo.setDescription(null);
        // 限制爬虫
        if (size > 50) {
            throw new BusinessException(BaseStatus.PARAM_ERROR);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>(interfaceInfo);
        queryWrapper.like(StringUtils.isNotBlank(description), "description", description);
        queryWrapper.orderBy(StringUtils.isNotBlank(sortField),
                sortOrder.equals(CommonConstant.SORT_ORDER_ASC), sortField);
        Page<InterfaceInfo> postPage = interfaceInfoService.page(new Page<>(current, size), queryWrapper);
        return ResultUtils.success(postPage);
    }

}
