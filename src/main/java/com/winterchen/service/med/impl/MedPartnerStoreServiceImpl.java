package com.winterchen.service.med.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winterchen.dao.MedPartnerStoreDao;
import com.winterchen.model.MedPartnerStoreDomain;
import com.winterchen.service.med.MedPartnerStoreService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "medPartnerStoreService")
public class MedPartnerStoreServiceImpl extends ServiceImpl<MedPartnerStoreDao, MedPartnerStoreDomain> implements MedPartnerStoreService {

    @Autowired
    private MedPartnerStoreDao medPartnerStoreDao;


    @Override
    public IPage<MedPartnerStoreDomain> medPartnerStoreList(String storeName, int cateId, int page, int limit){
        return medPartnerStoreDao.selectPage(new Page<>(page, limit),
                new QueryWrapper<MedPartnerStoreDomain>().like(StringUtils.isNotBlank(storeName),"store_name", storeName).eq(cateId > -1,"cate_id", cateId));
    }

}
