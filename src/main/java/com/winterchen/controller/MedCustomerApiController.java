package com.winterchen.controller;

import com.winterchen.model.*;
import com.winterchen.service.med.MedCustomerService;
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

    @ResponseBody
    @PostMapping("/save")
    @ApiOperation(value = "更新系统参数", notes = "更新系统参数")
    public MedCustomerDomain save(@RequestBody MedCustomerDomain medCustomerDomain){
        return medCustomerService.saveMedCustomer(medCustomerDomain);
    }

    @ResponseBody
    @GetMapping("/selectCustomerLev")
    @ApiOperation(value = "依据id获取下面的等级信息", notes = "依据id获取下面的等级信息")
    public List<Map> selectCustomerLev(@RequestParam(name = "userId", required = true) Long userId){
        List<Map> medCustomer = medCustomerService.selectCustomerLev(userId);
        return medCustomer;
    }
}
