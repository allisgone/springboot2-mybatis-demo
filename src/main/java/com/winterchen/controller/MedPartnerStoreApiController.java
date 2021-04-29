package com.winterchen.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.winterchen.model.MedCustomerDomain;
import com.winterchen.model.MedPartnerStoreDomain;
import com.winterchen.model.ReturnMsg;
import com.winterchen.service.med.MedCustomerService;
import com.winterchen.service.med.MedPartnerStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Administrator on 2017/8/16.
 */
@RestController
@RequestMapping(value = "/med/partnerStore")
@Api(value = "合作商家操作店铺", tags = {"合作商家操作店铺"})
public class MedPartnerStoreApiController {

    @Autowired
    private MedPartnerStoreService medPartnerStoreService;
    @Autowired
    private MedCustomerService medCustomerService;


    @ResponseBody
    @PostMapping(value = "/saveStore")
    @ApiOperation(value = "保存店铺信息", notes = "保存店铺信息")
    public ReturnMsg<MedPartnerStoreDomain> saveStore(@RequestBody MedPartnerStoreDomain medPartnerStoreDomain) {
        if (medPartnerStoreDomain == null) {
            return new ReturnMsg<>(-1,null,"数据为空");
        }
        MedCustomerDomain exist = medCustomerService.getOne(new QueryWrapper<MedCustomerDomain>().eq("id", medPartnerStoreDomain.getCustomerId())
                .eq("status", 1)
        .eq("user_type",1));
        if (Objects.isNull(exist)) {
            return new ReturnMsg(-1,null,"用户不存在");
        }
        if(Objects.isNull(medPartnerStoreDomain.getCreateTime())){
            medPartnerStoreDomain.setCreateTime(new Timestamp(System.currentTimeMillis()));
        }
        medPartnerStoreService.saveOrUpdate(medPartnerStoreDomain);
        return new ReturnMsg<>(medPartnerStoreDomain);
    }

    @ResponseBody
    @GetMapping("/getStore")
    @ApiOperation(value = "加盟商店铺信息", notes = "加盟商店铺信息")
    public ReturnMsg<MedPartnerStoreDomain> getStore(@RequestParam(name = "id") Long id){
        return new ReturnMsg<>(medPartnerStoreService.getById(id));
    }

    @ResponseBody
    @GetMapping("/getStoreByCustomId")
    @ApiOperation(value = "加盟商店铺信息", notes = "加盟商店铺信息")
    public ReturnMsg<MedPartnerStoreDomain> getStoreByCustomId(@RequestParam(name = "customerId") Long customerId){
        return new ReturnMsg<>(medPartnerStoreService.getOne(new QueryWrapper<MedPartnerStoreDomain>().eq("customer_id", customerId)));
    }

    @GetMapping("/medPartnerStoreList")
    @ApiOperation(value = "商家店铺分页查询", notes = "商家店铺分页查询")
    public ReturnMsg<IPage<MedPartnerStoreDomain>> medPartnerStoreList(@RequestParam(name = "storeName") String storeName,
                                                                 @RequestParam(name = "cateId") int cateId,
                                                                 @RequestParam(name = "page") int page,
                                                                 @RequestParam(name = "limit") int limit){
        try {
            return new ReturnMsg<>(medPartnerStoreService.medPartnerStoreList(storeName,cateId,page,limit));
        } catch (Exception e) {
            return new ReturnMsg<>(-1,null, e.getMessage());
        }
    }
}
