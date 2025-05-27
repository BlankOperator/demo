package com.example.demo.service;

import com.example.demo.pojo.Officeimage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Legend
* @description 针对表【officeimage】的数据库操作Service
* @createDate 2025-05-27 21:20:22
*/
public interface OfficeimageService extends IService<Officeimage> {
    Officeimage getOfficeImageBySupplyId(Integer supplyId);
}
