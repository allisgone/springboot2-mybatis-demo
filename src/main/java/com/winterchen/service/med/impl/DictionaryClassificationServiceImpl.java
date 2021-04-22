package com.winterchen.service.med.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.winterchen.dao.DictionaryClassificationDao;
import com.winterchen.model.DictionaryClassificationEntity;
import com.winterchen.service.med.DictionaryClassificationService;
import org.springframework.stereotype.Service;


@Service("dictionaryClassificationService")
public class DictionaryClassificationServiceImpl extends ServiceImpl<DictionaryClassificationDao, DictionaryClassificationEntity> implements DictionaryClassificationService {


}