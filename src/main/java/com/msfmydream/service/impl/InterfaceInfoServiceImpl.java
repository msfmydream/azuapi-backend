package com.msfmydream.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msfmydream.service.InterfaceInfoService;
import com.msfmydream.model.entity.InterfaceInfo;
import com.msfmydream.mapper.InterfaceInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author azu
* @description 针对表【interface_info(接口信息表)】的数据库操作Service实现
* @createDate 2024-01-07 13:12:50
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {



    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {

    }
}




