package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.Attendance;
import com.example.demo.pojo.Supplyusage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Legend
* @description 针对表【supplyusage】的数据库操作Service
* @createDate 2025-04-02 15:39:03
*/
public interface SupplyusageService extends IService<Supplyusage> {
    /**
     * 添加一条使用记录
     * @param supplyusage 使用记录
     * @return 是否添加成功
     */
    Boolean addSupply(Supplyusage supplyusage);

}
