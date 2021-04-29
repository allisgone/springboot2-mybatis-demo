package com.winterchen.service.med.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winterchen.dao.MedImageDao;
import com.winterchen.model.MedImageDomain;
import com.winterchen.service.med.MedImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "medImageService")
public class MedImageServiceImpl extends ServiceImpl<MedImageDao, MedImageDomain> implements MedImageService {

    @Autowired
    private MedImageDao medImageDao;

    public MedImageDomain saveImage(MedImageDomain medImageDomain){
        medImageDao.insert(medImageDomain);
        medImageDomain.setContent(null);
        return medImageDomain;
    }

    public MedImageDomain getImage(Long id){
        return medImageDao.selectById(id);
    }
}
