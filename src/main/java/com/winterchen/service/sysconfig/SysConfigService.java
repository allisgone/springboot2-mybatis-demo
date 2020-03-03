package com.winterchen.service.sysconfig;

import com.winterchen.model.SysConfigDomain;

/**
 * Created by lenovo on 2020-02-09.
 */
public interface SysConfigService {
    SysConfigDomain insertOrUpdatteSysConfig(SysConfigDomain record);

    SysConfigDomain selectSysConfig();
}
