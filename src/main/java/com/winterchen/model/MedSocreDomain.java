package com.winterchen.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("med_socre")
public class MedSocreDomain {
    @TableId
    private Long id;

    private Long customerId;

    private boolean status;

    private float socre;

    //@TableField(exist = false)
    private Timestamp createTime;

}