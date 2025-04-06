package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dto.VehicleUsageDto;
import com.example.demo.pojo.Vehicleusage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Legend
* @description 针对表【vehicleusage】的数据库操作Service
* @createDate 2025-04-06 17:29:28
*/
public interface VehicleusageService extends IService<Vehicleusage> {
    Boolean addVehicleUsage(Vehicleusage vehicleusage);

    Page<VehicleUsageDto> getVehicleUsageList(Page<Vehicleusage> page);
}
