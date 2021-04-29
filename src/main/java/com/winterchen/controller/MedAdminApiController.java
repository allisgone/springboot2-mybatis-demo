package com.winterchen.controller;

import com.winterchen.model.MedOrderDomain;
import com.winterchen.model.ReturnMsg;
import com.winterchen.service.med.MedOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/8/16.
 */
@RestController
@RequestMapping(value = "/med/admin")
@Api(value = "医疗服务管理中心", tags = {"医疗服务管理中心"})
public class MedAdminApiController {

    @Autowired
    private MedOrderService medOrderService;


    @ResponseBody
    @PostMapping("/agreeMedCustomerSocre")
    @ApiOperation(value = "同意积分申请", notes = "同意积分申请")
    public ReturnMsg<Boolean> agreeMedCustomerSocre(@RequestParam(name = "orderId", required = true) Long orderId) {
        try {
            return new ReturnMsg<>(0,medOrderService.agreeMedCustomerSocre(orderId),null);
        } catch (Exception e) {
            return new ReturnMsg<>(-1,null, e.getMessage());
        }
    }
    @ResponseBody
    @DeleteMapping("/rejectMedCustomerSocre")
    @ApiOperation(value = "拒绝积分申请", notes = "拒绝积分申请")
    public ReturnMsg<Boolean> reduceMedCustomerSocre(@RequestParam(name = "orderId", required = true) Long orderId) {
        try {
            return new ReturnMsg<>(medOrderService.rejectMedCustomerSocre(orderId));
        } catch (Exception e) {
            return new ReturnMsg<>(-1,null, e.getMessage());
        }
    }
}
