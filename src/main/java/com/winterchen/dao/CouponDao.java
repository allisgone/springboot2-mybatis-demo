package com.winterchen.dao;



import com.winterchen.model.CouponDomain;

public interface CouponDao {


    int insertCoupon(CouponDomain record);

    int updateCoupon(CouponDomain record);

    CouponDomain selectCoupon(Integer id);
}