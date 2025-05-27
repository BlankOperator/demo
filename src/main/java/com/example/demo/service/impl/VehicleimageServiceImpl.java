package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Vehicleimage;
import com.example.demo.service.VehicleimageService;
import com.example.demo.mapper.VehicleimageMapper;
import org.springframework.stereotype.Service;

/**
* @author Legend
* @description 针对表【vehicleimage】的数据库操作Service实现
* @createDate 2025-05-28 00:22:40
*/
@Service
public class VehicleimageServiceImpl extends ServiceImpl<VehicleimageMapper, Vehicleimage>
    implements VehicleimageService{

    @Override
    public Vehicleimage getImageByVehicleId(Integer vehicleId) {
        LambdaQueryWrapper<Vehicleimage> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Vehicleimage::getVehicleId, vehicleId);
        return this.getOne(queryWrapper);
    }
}




