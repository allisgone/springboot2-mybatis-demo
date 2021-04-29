package com.winterchen.service.med;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.winterchen.model.MedPartnerStoreDomain;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface MedPartnerStoreService extends IService<MedPartnerStoreDomain> {
    IPage<MedPartnerStoreDomain> medPartnerStoreList(String storeName, int cateId, int page, int limit);
}
