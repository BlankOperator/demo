package com.example.demo.service;

import com.example.demo.pojo.Vehicleimage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Legend
* @description 针对表【vehicleimage】的数据库操作Service
* @createDate 2025-05-28 00:22:40
*/
public interface VehicleimageService extends IService<Vehicleimage> {
    /**
     * 根据车辆ID获取车辆图片
     * @param vehicleId 车辆ID
     * @return Vehicleimage 对象
     */
    Vehicleimage getImageByVehicleId(Integer vehicleId);
}
