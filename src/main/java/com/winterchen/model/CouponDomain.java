package com.winterchen.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CouponDomain {
    private Integer id;

    private String couponText;

    private Timestamp createTime;

    private boolean reply;

}