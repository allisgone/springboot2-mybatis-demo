package com.winterchen.service.med;

import com.baomidou.mybatisplus.core.metadata.IPage;
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

    float medCustomerScore(String userName) throws Exception;

    IPage<MedSocreDomain> medCustomerScoreList(String userName,String type, int page, int limit) throws Exception;
}
