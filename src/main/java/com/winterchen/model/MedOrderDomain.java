package com.winterchen.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("med_order")
public class MedOrderDomain {
    @TableId
    private Long id;

    private Long customerId;
    //状态 0-申请；1-有效；2-无效
    private int status;

    private float socre;

    //@TableField(exist = false)
    private Timestamp createTime;

    private String remark;
    //关联一笔订单，来源可溯
    private String orderName;

}