package com.winterchen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.winterchen.model.MedCustomerDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MedCustomerDao extends BaseMapper<MedCustomerDomain> {


    List<Map> selectCustomerLev(Long userId);

    List<MedCustomerDomain> selectByUserType(Integer userType);
}