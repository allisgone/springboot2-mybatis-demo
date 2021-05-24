package com.winterchen.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("med_customer")
public class MedCustomerDomain {
    @TableId
    private Long id;

    private Long parentId;

    private Long rootId;

    private String userName;

    @TableField(exist = false)
    private String smsCode;

    private boolean status = true;

    private int grade;

    private int  userType;

    private int  childLev;

    private float socre;

    private float level1Ratio;

    private float level2Ratio;

    private float proxyRatio;

    //@TableField(exist = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

    private String extData;

}