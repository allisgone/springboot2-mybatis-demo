package com.winterchen.service.coupon.impl;

import com.winterchen.dao.CouponDao;
import com.winterchen.model.CouponDomain;
import com.winterchen.service.coupon.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "couponService")
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponDao couponDao;

    @Override
    public int insertCoupon(CouponDomain record) {
        return couponDao.insertCoupon(record);
    }

    @Override
    public int updateCoupon(CouponDomain record) {
        return couponDao.updateCoupon(record);
    }

    @Override
    public CouponDomain selectCoupon(Integer id) {
        return couponDao.selectCoupon(id);
    }
}
