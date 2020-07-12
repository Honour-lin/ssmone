package com.weilinyang.service.impl;

import com.weilinyang.mapper.DepartMapper;
import com.weilinyang.pojo.Depart;
import com.weilinyang.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportServiceImpl implements ImportService {

    @Autowired
    private DepartMapper departMapper;



    public void importData(List<Depart> departs) {
        departMapper.batchInsert(departs);
    }
}
