package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Officeimage;
import com.example.demo.service.OfficeimageService;
import com.example.demo.mapper.OfficeimageMapper;
import org.springframework.stereotype.Service;

/**
* @author Legend
* @description 针对表【officeimage】的数据库操作Service实现
* @createDate 2025-05-27 21:20:22
*/
@Service
public class OfficeimageServiceImpl extends ServiceImpl<OfficeimageMapper, Officeimage>
    implements OfficeimageService{

    @Override
    public Officeimage getOfficeImageBySupplyId(Integer supplyId) {
        LambdaQueryWrapper<Officeimage> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Officeimage::getOfficeId, supplyId);
        return this.getOne(wrapper);
    }
}




