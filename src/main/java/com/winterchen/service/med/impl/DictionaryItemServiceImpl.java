package com.winterchen.service.med.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winterchen.dao.DictionaryItemDao;
import com.winterchen.model.DictionaryItemEntity;
import com.winterchen.service.med.DictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("dictionaryItemService")
public class DictionaryItemServiceImpl extends ServiceImpl<DictionaryItemDao, DictionaryItemEntity> implements DictionaryItemService {

    @Autowired
    private DictionaryItemDao dictionaryItemDao;

    @Override
    public List<DictionaryItemEntity> getClassification(String dictionaryClassification) {
        return this.getClassification(dictionaryClassification,-1);
    }

    @Override
    public List<DictionaryItemEntity> getClassification(String dictionaryClassification, int number) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dictionaryClassification",dictionaryClassification);
        map.put("number",number);
        List<DictionaryItemEntity> list = dictionaryItemDao.seleteClassification(map);
        if(list != null || list.size() > 0){
            list.forEach(e->e.setItemJsonData(JSON.parseObject(e.getItemData())));
        }
        return list;
    }

    @Override
    public DictionaryItemEntity getClassificationSingle(String dictionaryClassification) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dictionaryClassification",dictionaryClassification);
        DictionaryItemEntity dictionaryItemEntity = dictionaryItemDao.seleteClassificationSingle(map);
        if(dictionaryItemEntity!=null){
            dictionaryItemEntity.setItemJsonData(JSON.parseObject(dictionaryItemEntity.getItemData()));
        }
        return dictionaryItemEntity;
    }

}