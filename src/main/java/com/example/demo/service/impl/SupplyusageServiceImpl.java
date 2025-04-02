package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Attendance;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Officesupplies;
import com.example.demo.pojo.Supplyusage;
import com.example.demo.service.OfficesuppliesService;
import com.example.demo.service.SupplyusageService;
import com.example.demo.mapper.SupplyusageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Legend
* @description 针对表【supplyusage】的数据库操作Service实现
* @createDate 2025-04-02 15:39:03
*/
@Service
public class SupplyusageServiceImpl extends ServiceImpl<SupplyusageMapper, Supplyusage>
    implements SupplyusageService{
    @Autowired
    private OfficesuppliesService officesuppliesService;
    @Override
    public Boolean addSupply(Supplyusage supplyusage) {
        if(supplyusage.getCount() == null || supplyusage.getCount() <= 0){
            return false;
        }
        if(supplyusage.getSupplyId() == null){
            return false;
        }
        Officesupplies ans = officesuppliesService.getSupplyById(supplyusage.getSupplyId());
        if(ans == null || ans.getQuantity() < supplyusage.getCount()){
            return false;
        }
        ans.setQuantity(ans.getQuantity() - supplyusage.getCount());
        officesuppliesService.updateById(ans);
        try {
            return this.save(supplyusage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}




