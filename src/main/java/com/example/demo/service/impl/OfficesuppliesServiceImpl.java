package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.SupplyDto;
import com.example.demo.pojo.Attendance;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Officeimage;
import com.example.demo.pojo.Officesupplies;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.OfficeimageService;
import com.example.demo.service.OfficesuppliesService;
import com.example.demo.mapper.OfficesuppliesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author Legend
* @description 针对表【officesupplies】的数据库操作Service实现
* @createDate 2025-04-02 14:15:15
*/
@Service
public class OfficesuppliesServiceImpl extends ServiceImpl<OfficesuppliesMapper, Officesupplies>
    implements OfficesuppliesService{

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private OfficeimageService officeimageService;

    @Override
    public Integer addSupply(Officesupplies officesupplies) {
        this.save(officesupplies);
        return officesupplies.getSupplyId();
    }

    @Override
    public Officesupplies getSupplyById(Integer supplyId) {
        return this.getById(supplyId);
    }

    @Override
    public Page<SupplyDto> getSupplyList(Page<Officesupplies> page, String keyword) {
        LambdaQueryWrapper<Officesupplies> wrapper = new LambdaQueryWrapper<>();
        boolean condition = keyword != null && !"".equals(keyword);
        wrapper.like(condition, Officesupplies::getName, keyword)
               .or().like(condition, Officesupplies::getPurchasedBy, keyword)
               .or().like(condition, Officesupplies::getQuantity, keyword);
        wrapper.orderByDesc(Officesupplies::getPurchaseDate);
        Page<Officesupplies> ans = this.page(page, wrapper);
        List<SupplyDto> supplyDtoList = new ArrayList<>();
        for (Officesupplies supply : ans.getRecords()) {
            SupplyDto supplyDto = new SupplyDto();
            supplyDto.setSupplyId(supply.getSupplyId());
            supplyDto.setName(supply.getName());
            supplyDto.setPurchaseDate(supply.getPurchaseDate());
            supplyDto.setQuantity(supply.getQuantity());
            Employee employee = employeeService.getById(supply.getPurchasedBy());
            Officeimage officeimage = officeimageService.getOfficeImageBySupplyId(supply.getSupplyId());
            supplyDto.setImageUrl("http://localhost:9091/image/" + officeimage.getName());
            supplyDto.setUsername(employee.getName());
            supplyDtoList.add(supplyDto);
        }
        Page<SupplyDto> supplyDtoPage = new Page<>();
        supplyDtoPage.setRecords(supplyDtoList);
        supplyDtoPage.setTotal(ans.getTotal());
        return supplyDtoPage;
    }
}




