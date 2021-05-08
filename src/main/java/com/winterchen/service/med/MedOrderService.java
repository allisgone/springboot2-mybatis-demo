package com.winterchen.service.med;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.winterchen.model.MedOrderDomain;
import com.winterchen.model.MedSocreDomain;


/**
 * Created by Administrator on 2018/4/19.
 */
public interface MedOrderService extends IService<MedOrderDomain> {

    MedSocreDomain addMedCustomerSocre(MedOrderDomain medOrderDomain) throws Exception;

    boolean agreeMedCustomerSocre(Long orderId) throws Exception;

    MedSocreDomain reduceMedCustomerSocre(MedOrderDomain medOrderDomain) throws Exception;

    MedOrderDomain reduceMedCustomerSocreConfirm(Long orderId,Long targetId) throws Exception;

    MedOrderDomain rejectMedCustomerSocre(Long orderId,Long targetId) throws Exception;

    float medCustomerScore(String userName) throws Exception;

    IPage<MedOrderDomain> medCustomerOrderPageList(String userName,String type, int page, int limit) throws Exception;

    MedOrderDomain getByOrderId(Long id);
}
