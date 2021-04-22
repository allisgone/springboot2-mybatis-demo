package com.winterchen.service.med;

import com.baomidou.mybatisplus.extension.service.IService;
import com.winterchen.model.DictionaryItemEntity;

import java.util.List;

/**
 * 字典项
 *
 * @author tanghaihua
 * @email 814100831@qq.com
 * @date 2020-07-29 11:41:03
 */
public interface DictionaryItemService extends IService<DictionaryItemEntity> {


    List<DictionaryItemEntity> getClassification(String dictionaryClassification);

    List<DictionaryItemEntity> getClassification(String dictionaryClassification, int number);

    DictionaryItemEntity getClassificationSingle(String dictionaryClassification);

}

