package com.winterchen.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 淘宝账号配置
 *
 * @author yijun
 */
@ConfigurationProperties(prefix = "taobao")
@Component
@Slf4j
@Data
public class TaobaoConfig {

    private String serverUrl;
    private String adzoneId;
    private String siteId;
    private Tbk tbk = new Tbk();
    private Baichuan baichuan = new Baichuan();

    @Data
    public class Tbk{
        private String appkey;
        private String appsecret;
    }
    @Data
    public class Baichuan{
        private String appkey;
        private String appsecret;
    }
}
