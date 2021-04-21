package com.winterchen.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.winterchen.model.MedOrderDomain;
import com.winterchen.model.MedSocreDomain;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MedOrderDao extends BaseMapper<MedOrderDomain> {

    float sumCustomerSocre(Long customerId);
}