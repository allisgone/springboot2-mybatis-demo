package com.winterchen.service.med;

import com.winterchen.model.MedCustomerDomain;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface MedCustomerService {

    List<Map> selectCustomerLev(Long userId);

    List<MedCustomerDomain> selectByUserType(Integer userType);

    MedCustomerDomain saveMedCustomer(MedCustomerDomain medCustomerDomain) throws Exception;
}
