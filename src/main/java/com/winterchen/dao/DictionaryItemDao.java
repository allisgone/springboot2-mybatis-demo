package com.winterchen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.winterchen.model.DictionaryItemEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 字典项
 * 
 * @author tanghaihua
 * @email 814100831@qq.com
 * @date 2020-07-29 11:41:03
 */
@Mapper
public interface DictionaryItemDao extends BaseMapper<DictionaryItemEntity> {

    List<DictionaryItemEntity> seleteClassification(@Param("params") Map<String, Object> map);

    DictionaryItemEntity seleteClassificationSingle(@Param("params") Map<String, Object> map);
}
