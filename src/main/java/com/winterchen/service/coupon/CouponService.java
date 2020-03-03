package com.winterchen.service.coupon;

import com.winterchen.model.CouponDomain;

/**
 * Created by lenovo on 2020-02-09.
 */
public interface CouponService {
    int insertCoupon(CouponDomain record);

    int updateCoupon(CouponDomain record);

    CouponDomain selectCoupon(Integer id);
}
