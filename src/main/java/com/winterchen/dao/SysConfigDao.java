package com.winterchen.dao;



import com.winterchen.model.SysConfigDomain;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysConfigDao {


    int insertSysConfig(SysConfigDomain record);

    int updateSysConfig(SysConfigDomain record);

    SysConfigDomain selectSysConfig();
}