package com.example.demo.service;

import com.example.demo.dto.ParkingSpaceDto;
import com.example.demo.pojo.Parkingspace;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Legend
* @description 针对表【parkingspace】的数据库操作Service
* @createDate 2025-04-06 12:21:33
*/
public interface ParkingspaceService extends IService<Parkingspace> {

    Boolean addParkingSpace(Parkingspace parkingspace);


//    Boolean deleteParkingSpace(Integer id);


    Boolean updateParkingSpace(Parkingspace parkingspace);

    List<ParkingSpaceDto> getParkingSpaceList();

}
