package com.winterchen.service.med.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winterchen.dao.MedPartnerStoreDao;
import com.winterchen.model.MedPartnerStoreDomain;
import com.winterchen.service.med.MedPartnerStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "medPartnerStoreService")
public class MedPartnerStoreServiceImpl extends ServiceImpl<MedPartnerStoreDao, MedPartnerStoreDomain> implements MedPartnerStoreService {

    @Autowired
    private MedPartnerStoreDao medPartnerStoreDao;

}
