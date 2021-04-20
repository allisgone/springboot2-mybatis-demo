package com.winterchen.dao;



import com.winterchen.model.CouponDomain;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponDao {


    int insertCoupon(CouponDomain record);

    int updateCoupon(CouponDomain record);

    CouponDomain selectCoupon(Integer id);
}