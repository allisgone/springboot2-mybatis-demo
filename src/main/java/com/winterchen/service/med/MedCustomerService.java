package com.winterchen.service.med;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.IService;
import com.winterchen.model.MedCustomerDomain;

import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface MedCustomerService extends IService<MedCustomerDomain> {

    JSONArray selectCustomerLev(Long userId);

    List<MedCustomerDomain> selectByUserType(Integer userType);

    MedCustomerDomain saveMedCustomer(MedCustomerDomain medCustomerDomain) throws Exception;

    MedCustomerDomain loginMedCustomer(MedCustomerDomain medCustomerDomain) throws Exception;

    MedCustomerDomain medCustomerSet(MedCustomerDomain medCustomerDomain) throws Exception;
}
