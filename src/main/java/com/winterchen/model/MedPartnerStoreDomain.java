package com.winterchen.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("med_partner_store")
public class MedPartnerStoreDomain {
    @TableId
    private Long id;

    private Long customerId;

    private String address;

    private String phone;

    private String tel;

    private String storeName;

    private float price;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

    private String represent;

    private String carousel;

    private int cateId;

}