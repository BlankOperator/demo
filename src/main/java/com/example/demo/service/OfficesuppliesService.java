package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dto.SupplyDto;
import com.example.demo.pojo.Officesupplies;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Legend
* @description 针对表【officesupplies】的数据库操作Service
* @createDate 2025-04-02 14:15:15
*/
public interface OfficesuppliesService extends IService<Officesupplies> {
    /**
     * 添加办公用品
     * @param officesupplies 办公用品
     * @return 是否添加成功
     */
    Integer addSupply(Officesupplies officesupplies);

    Officesupplies getSupplyById(Integer supplyId);

    Page<SupplyDto> getSupplyList(Page<Officesupplies> page);
}
