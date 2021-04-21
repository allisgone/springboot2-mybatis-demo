package com.winterchen.controller;

import com.winterchen.model.*;
import com.winterchen.service.med.MedCustomerService;
import com.winterchen.service.med.MedOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * Created by Administrator on 2017/8/16.
 */
@RestController
@RequestMapping(value = "/med")
@Api(value = "医疗服务中心", tags = {"医疗服务中心"})
public class MedCustomerApiController {

    @Autowired
    private MedCustomerService medCustomerService;
    @Autowired
    private MedOrderService medOrderService;

    @ResponseBody
    @PostMapping("/saveMedCustomer")
    @ApiOperation(value = "保存用户", notes = "保存用户")
    public ReturnMsg<MedCustomerDomain> saveMedCustomer(@RequestBody MedCustomerDomain medCustomerDomain){
        try {
            return new ReturnMsg<>(0,medCustomerService.saveMedCustomer(medCustomerDomain), null);
        } catch (Exception e) {
            return new ReturnMsg<>(-1,null, e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping("/selectCustomerLev")
    @ApiOperation(value = "依据id获取下面的等级信息", notes = "依据id获取下面的等级信息")
    public List<Map> selectCustomerLev(@RequestParam(name = "userId", required = true) Long userId){
        List<Map> medCustomer = medCustomerService.selectCustomerLev(userId);
        return medCustomer;
    }

    @ResponseBody
    @PostMapping("/addMedCustomerSocre")
    @ApiOperation(value = "申请订单积分", notes = "申请订单积分")
    public ReturnMsg<MedSocreDomain> addMedCustomerSocre(@RequestBody MedOrderDomain medOrderDomain) {
        try {
            return new ReturnMsg<>(0,medOrderService.addMedCustomerSocre(medOrderDomain),null);
        } catch (Exception e) {
            return new ReturnMsg<>(-1,null, e.getMessage());
        }
    }
    @ResponseBody
    @PostMapping("/reduceMedCustomerSocre")
    @ApiOperation(value = "申请扣减积分", notes = "申请扣减积分")
    public ReturnMsg<MedSocreDomain> reduceMedCustomerSocre(@RequestBody MedOrderDomain medOrderDomain) {
        try {
            return new ReturnMsg<>(0,medOrderService.reduceMedCustomerSocre(medOrderDomain),null);
        } catch (Exception e) {
            return new ReturnMsg<>(-1,null, e.getMessage());
        }
    }
}
