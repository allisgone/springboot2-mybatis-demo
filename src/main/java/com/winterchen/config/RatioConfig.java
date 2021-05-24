package com.winterchen.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 分佣比例
 *
 * @author yijun
 */
@ConfigurationProperties(prefix = "ratio")
@Component
@Slf4j
@Data
public class RatioConfig {

    //第一级比率
    private float level1Ratio;
    //第二级比率
    private float level2Ratio;
    //加盟商独立比率
    private float proxyRatio;
    //加盟商分佣级别
    private int partnerChildLev;
}
