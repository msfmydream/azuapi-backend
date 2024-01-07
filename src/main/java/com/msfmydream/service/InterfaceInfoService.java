package com.msfmydream.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.msfmydream.model.entity.InterfaceInfo;

/**
* @author azu
* @description 针对表【interface_info(接口信息表)】的数据库操作Service
* @createDate 2024-01-07 13:12:50
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {


    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);


}
