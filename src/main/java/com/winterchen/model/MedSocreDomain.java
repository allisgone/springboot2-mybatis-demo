package com.winterchen.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("med_socre")
public class MedSocreDomain {
    @TableId
    private Long id;

    private Long customerId;
    //状态 0-申请；1-有效；2-无效
    private int status;

    private float socre;

    //@TableField(exist = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

    private String remark;
    //关联一笔订单，来源可溯
    private Long orderId;

}