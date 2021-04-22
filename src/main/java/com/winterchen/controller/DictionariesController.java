package com.winterchen.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.winterchen.model.*;
import com.winterchen.service.med.DictionaryClassificationService;
import com.winterchen.service.med.DictionaryItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 字典
 *
 * @author tanghaihua
 * @email 814100831@qq.com
 * @date 2020-07-29 11:41:03
 */
@RestController
@RequestMapping("commonequity/dictionariesController")
@Api(value = "字典",description = "字典",tags = {"字典"})
public class DictionariesController{
    @Autowired
    private DictionaryClassificationService dictionaryClassificationService;

    @Autowired
    private DictionaryItemService dictionaryItemService;

    /**
     * 保存
     */
    @PostMapping("/saveorupdate-single")
    @ApiOperation(value = "保存单个字典", notes = "保存字典")
    @Transactional(rollbackFor = Exception.class)
    public ReturnMsg<DictionaryClassificationEntity> save(@RequestBody DictionaryInput dictionaryInput){
        Date date = new Date();
        //字典类型入库begin
        //先判断字典项类型是否存在
        DictionaryClassificationEntity dictionaryClassificationEntity = dictionaryClassificationService.getOne(
                new QueryWrapper<DictionaryClassificationEntity>()
                        .eq("dictionary_classification",dictionaryInput.getDictionaryClassification()));

        if(dictionaryClassificationEntity==null){//新增
            dictionaryClassificationEntity = new DictionaryClassificationEntity();
            dictionaryClassificationEntity.setItemType(1);
            dictionaryClassificationEntity.setDictionaryClassification(dictionaryInput.getDictionaryClassification());
            dictionaryClassificationEntity.setCreateTime(date);
            dictionaryClassificationEntity.setStatus(1);
            dictionaryClassificationEntity.setRemarks(dictionaryInput.getRemarks());
            dictionaryClassificationService.save(dictionaryClassificationEntity);
        }else{//修改
            dictionaryClassificationEntity.setRemarks(dictionaryInput.getRemarks());
            dictionaryClassificationService.updateById(dictionaryClassificationEntity);
        }


        //字典项入库begin
        DictionaryItemEntity findDictionaryItemEntity = dictionaryItemService.getOne(new QueryWrapper<DictionaryItemEntity>()
        .eq("dictionary_classification_id",dictionaryClassificationEntity.getId()));
        if(Objects.isNull(findDictionaryItemEntity)){
            findDictionaryItemEntity = new DictionaryItemEntity();
            findDictionaryItemEntity.setDictionaryClassificationId(dictionaryClassificationEntity.getId());
            findDictionaryItemEntity.setItemData(dictionaryInput.getItemData().toJSONString());
            findDictionaryItemEntity.setItemOrder(dictionaryInput.getItemOrder());
            findDictionaryItemEntity.setCreateTime(date);
            findDictionaryItemEntity.setRemarks(dictionaryInput.getItemRemarks());
            findDictionaryItemEntity.setStatus(1);
            dictionaryItemService.save(findDictionaryItemEntity);
        }else{
            findDictionaryItemEntity.setRemarks(dictionaryInput.getItemRemarks());
            findDictionaryItemEntity.setItemOrder(dictionaryInput.getItemOrder());
            findDictionaryItemEntity.setItemData(dictionaryInput.getItemData().toJSONString());
            dictionaryItemService.updateById(findDictionaryItemEntity);
        }
        //字典项入库end

        return new ReturnMsg<>(dictionaryClassificationEntity);
    }

    /**
     * 删除单个字典项
     */
    @GetMapping("/delete-dictionaryitem")
    @ApiOperation(value = "删除单个字典项", notes = "删除单个字典项")
    public ReturnMsg<String> deleteDictionaryItem(@ApiParam(name = "id", value = "字典项id", required = true) @RequestParam Long id){
        DictionaryItemEntity dictionaryItemEntity = dictionaryItemService.getById(id);
        if(Objects.isNull(dictionaryItemEntity)){
            return new ReturnMsg(-1,null,"没找到该字典项");
        }
        dictionaryItemService.removeById(id);
        DictionaryClassificationEntity dictionaryClassificationEntity = dictionaryClassificationService.getOne(
                new QueryWrapper<DictionaryClassificationEntity>()
                        .eq("id",dictionaryItemEntity.getDictionaryClassificationId()));
        if(dictionaryClassificationEntity == null){
            return new ReturnMsg(-1,null,"没找到该字典");
        }
        dictionaryClassificationService.removeById(dictionaryClassificationEntity.getId());

        return new ReturnMsg("删除成功");
    }

    /**
     * 保存
     */
    @PostMapping("/saveorupdate-list")
    @ApiOperation(value = "保存多项字典", notes = "保存字典")
    @Transactional(rollbackFor = Exception.class)
    public ReturnMsg<DictionaryClassificationEntity> save(@RequestBody DictionaryListInput dictionaryListInput){
        Date date = new Date();
        //字典类型入库begin
        //先判断字典项类型是否存在
        DictionaryClassificationEntity dictionaryClassificationEntity = dictionaryClassificationService.getOne(
                new QueryWrapper<DictionaryClassificationEntity>()
                        .eq("dictionary_classification",dictionaryListInput.getDictionaryClassification()));

        if(dictionaryClassificationEntity == null){//新增
            dictionaryClassificationEntity = new DictionaryClassificationEntity();
            dictionaryClassificationEntity.setItemType(2);
            dictionaryClassificationEntity.setDictionaryClassification(dictionaryListInput.getDictionaryClassification());
            dictionaryClassificationEntity.setCreateTime(date);
            dictionaryClassificationEntity.setStatus(1);
            dictionaryClassificationEntity.setRemarks(dictionaryListInput.getRemarks());
            dictionaryClassificationService.save(dictionaryClassificationEntity);
        }else{//修改
            dictionaryClassificationEntity.setRemarks(dictionaryListInput.getRemarks());
            dictionaryClassificationService.updateById(dictionaryClassificationEntity);
        }
        //字典类型入库end
        //判断是否要清除掉所有字典项
        if(dictionaryListInput.getNeedDeleteItems()){
            dictionaryItemService.remove(new QueryWrapper<DictionaryItemEntity>().eq("dictionary_classification_id",dictionaryClassificationEntity.getId()));
        }
        //字典项入库begin
        for(DictionaryListInput.item dictionaryItem : dictionaryListInput.getItemDatas()){
            DictionaryItemEntity dictionaryItemEntity = new DictionaryItemEntity();
            dictionaryItemEntity.setDictionaryClassificationId(dictionaryClassificationEntity.getId());
            dictionaryItemEntity.setItemData(dictionaryItem.getItemData().toJSONString());
            dictionaryItemEntity.setItemOrder(dictionaryItem.getItemOrder());
            dictionaryItemEntity.setCreateTime(date);
            dictionaryItemEntity.setRemarks(dictionaryItem.getRemarks());
            dictionaryItemEntity.setStatus(1);
            //id不为空就修改 否则新增
            dictionaryItemEntity.setId(dictionaryItem.getId());
            dictionaryItemService.saveOrUpdate(dictionaryItemEntity);
        }
        //字典项入库end
        return new ReturnMsg<>(dictionaryClassificationEntity);
    }

    /**
     * 删除字典数据
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除字典数据", notes = "删除字典数据")
    @Transactional(rollbackFor = Exception.class)
    public ReturnMsg<String> delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id){

        //字典类型删除begin
        //先判断字典项类型是否存在
        DictionaryClassificationEntity dictionaryClassificationEntity = dictionaryClassificationService.getById(id);
        if(dictionaryClassificationEntity == null){
            return new ReturnMsg(-1,null,"没找到该字典项");
        }
        dictionaryClassificationService.removeById(dictionaryClassificationEntity.getId());
        //字典类型删除end

        //字典项删除begin
        dictionaryItemService.remove(new QueryWrapper<DictionaryItemEntity>().eq("dictionary_classification_id",dictionaryClassificationEntity.getId()));
        //字典项删除end
        return new ReturnMsg("删除成功");
    }


    /**
     * 根据渠道和字典类型值获取多个字典项
     * @param dictionaryClassification
     * @return
     */
    @GetMapping("/getListByChannelIdAndClassification")
    @ApiOperation(value = "根据渠道和字典类型值获取多个字典项", notes = "根据渠道和字典类型值获取多个字典项")
    public ReturnMsg<List<DictionaryItemEntity>> getListByChannelIdAndClassification( @ApiParam(name = "dictionaryClassification", value = "字典类型值", required = true) @RequestParam(required = true) String dictionaryClassification){
        List<DictionaryItemEntity> list =  dictionaryItemService.getClassification(dictionaryClassification);
        return new ReturnMsg<>(list);
    }

    /**
     * 根据渠道和字典类型值获取单个字典项
     * @param dictionaryClassification
     * @return
     */
    @GetMapping("/getSingleByChannelIdAndClassification")
    @ApiOperation(value = "根据渠道和字典类型值获取单个字典项", notes = "根据渠道和字典类型值获取单个字典项")
    public ReturnMsg<DictionaryItemEntity> getSingleByChannelIdAndClassification(@ApiParam(name = "dictionaryClassification", value = "字典类型值", required = true) @RequestParam(required = true) String dictionaryClassification){
        DictionaryItemEntity dictionaryItemEntity =  dictionaryItemService.getClassificationSingle(dictionaryClassification);
        return new ReturnMsg<>(dictionaryItemEntity);
    }


}
