package com.winterchen.service.sysconfig.impl;

import com.winterchen.dao.SysConfigDao;
import com.winterchen.model.SysConfigDomain;
import com.winterchen.service.sysconfig.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigDao sysConfigDao;


    @Override
    public SysConfigDomain insertOrUpdatteSysConfig(SysConfigDomain record) {
        SysConfigDomain result = sysConfigDao.selectSysConfig();
        if(result == null){
            sysConfigDao.insertSysConfig(record);
            return record;
        }
        sysConfigDao.updateSysConfig(record);
        return sysConfigDao.selectSysConfig();
    }
    @Override
    public SysConfigDomain selectSysConfig() {
        return sysConfigDao.selectSysConfig();
    }
}
