package com.winterchen.dao;



import com.winterchen.model.SysConfigDomain;

public interface SysConfigDao {


    int insertSysConfig(SysConfigDomain record);

    int updateSysConfig(SysConfigDomain record);

    SysConfigDomain selectSysConfig();
}