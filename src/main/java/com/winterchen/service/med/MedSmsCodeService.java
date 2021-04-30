package com.winterchen.service.med;

import com.baomidou.mybatisplus.extension.service.IService;
import com.winterchen.model.MedSmsCodeDomain;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface MedSmsCodeService extends IService<MedSmsCodeDomain> {
    MedSmsCodeDomain send(String phoneNum, int sendType)  throws Exception;
}
