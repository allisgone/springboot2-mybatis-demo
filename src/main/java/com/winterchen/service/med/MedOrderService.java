package com.winterchen.service.med;

import com.winterchen.model.MedOrderDomain;
import com.winterchen.model.MedSocreDomain;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface MedOrderService {

    MedSocreDomain addMedCustomerSocre(MedOrderDomain medOrderDomain) throws Exception;

    MedOrderDomain agreeMedCustomerSocre(MedOrderDomain medOrderDomain) throws Exception;

    MedSocreDomain reduceMedCustomerSocre(MedOrderDomain medOrderDomain) throws Exception;

    MedOrderDomain rejectMedCustomerSocre(MedOrderDomain medOrderDomain) throws Exception;
}
