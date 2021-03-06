package com.winterchen.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SysConfigDomain {
    private Integer id;

    private String couponJumpUrl;

    private String usertoken;

    private String sid;

    private String pid;

    private Timestamp updateTime;

}