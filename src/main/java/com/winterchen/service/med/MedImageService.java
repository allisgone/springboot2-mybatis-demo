package com.winterchen.service.med;

import com.baomidou.mybatisplus.extension.service.IService;
import com.winterchen.model.MedImageDomain;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface MedImageService extends IService<MedImageDomain> {
    MedImageDomain saveImage(MedImageDomain medImageDomain);

    MedImageDomain getImage(Long id);
}
