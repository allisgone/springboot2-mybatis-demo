package com.winterchen.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("med_customer")
public class MedCustomerDomain {
    @TableId
    private Long id;

    private Long parentId;

    private String userName;

    private String pwdWord;

    private boolean status;

    private int grade;

    private int  userType;

    private int  childLev;

    private float socre;

    private float ratio;

    //@TableField(exist = false)
    private Timestamp createTime;

    private String extData;

}