package com.winterchen.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.winterchen.model.*;
import com.winterchen.service.med.MedCustomerService;
import com.winterchen.service.med.MedOrderService;
import com.winterchen.service.med.MedSmsCodeService;
import com.winterchen.utils.ZXingBackGroundUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.net.URLDecoder;
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
    @Autowired
    private MedSmsCodeService medSmsCodeService;

    @ResponseBody
    @GetMapping("/sendSms")
    @ApiOperation(value = "发送短信验证码", notes = "发送短信验证码")
    public ReturnMsg<MedSmsCodeDomain> sendSms(@RequestParam(name = "phone") String phone,@RequestParam(name = "sendType") int sendType){
        try {
            return new ReturnMsg<>(medSmsCodeService.send(phone,sendType));
        } catch (Exception e) {
            return new ReturnMsg<>(-1,null, e.getMessage());
        }
    }

    @ResponseBody
    @PostMapping("/saveMedCustomer")
    @ApiOperation(value = "保存用户", notes = "保存用户")
    public ReturnMsg<MedCustomerDomain> saveMedCustomer(@RequestBody MedCustomerDomain medCustomerDomain){
        try {
            return new ReturnMsg<>(medCustomerService.saveMedCustomer(medCustomerDomain));
        } catch (Exception e) {
            return new ReturnMsg<>(-1,null, e.getMessage());
        }
    }
    @ResponseBody
    @GetMapping("/loginMedCustomer")
    @ApiOperation(value = "登录用户", notes = "登录用户")
    public ReturnMsg<MedCustomerDomain> loginMedCustomer(@RequestParam(name = "userName") String userName,
                                                         @RequestParam(name = "smsCode") String smsCode){
            MedCustomerDomain medCustomerDomain = new MedCustomerDomain();
            medCustomerDomain.setUserName(userName);
            medCustomerDomain.setSmsCode(smsCode);
            try {
                return new ReturnMsg<>(medCustomerService.loginMedCustomer(medCustomerDomain));
            } catch (Exception e) {
                return new ReturnMsg<>(-1,null, e.getMessage());
            }
    }

    @GetMapping("/medCustomerScore")
    @ApiOperation(value = "用户总积分查询", notes = "用户总积分查询")
    public ReturnMsg<Float> medCustomerScore(@RequestParam(name = "userName") String userName) {
        MedCustomerDomain medCustomerDomain = new MedCustomerDomain();
        medCustomerDomain.setUserName(userName);

        try {
            return new ReturnMsg<>(medOrderService.medCustomerScore(userName));
        } catch (Exception e) {
            return new ReturnMsg<>(-1,null, e.getMessage());
        }
    }

    @ResponseBody
    @PostMapping("/medCustomerSet")
    @ApiOperation(value = "用户设置", notes = "用户设置")
    public ReturnMsg<MedCustomerDomain> medCustomerSet(@RequestBody MedCustomerDomain medCustomerDomain) {

        try {
            return new ReturnMsg<>(medCustomerService.medCustomerSet(medCustomerDomain));
        } catch (Exception e) {
            return new ReturnMsg<>(-1,null, e.getMessage());
        }
    }

    @GetMapping("/medCustomerScoreList")
    @ApiOperation(value = "用户积分查询", notes = "用户积分查询")
    public ReturnMsg<IPage<MedSocreDomain>> medCustomerScoreList(@RequestParam(name = "userName") String userName,
                                                                 @RequestParam(name = "type") String type,
                                                                 @RequestParam(name = "page") int page,
                                                                 @RequestParam(name = "limit") int limit){

        try {
            return new ReturnMsg<>(medOrderService.medCustomerScoreList(userName,type,page,limit));
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
    @PostMapping("/addMedCustomerSocreApply")
    @ApiOperation(value = "申请订单积分", notes = "申请订单积分")
    public ReturnMsg<MedSocreDomain> addMedCustomerSocreApply(@RequestBody MedOrderDomain medOrderDomain) {
        try {
            return new ReturnMsg<>(0,medOrderService.addMedCustomerSocre(medOrderDomain),null);
        } catch (Exception e) {
            return new ReturnMsg<>(-1,null, e.getMessage());
        }
    }
    @ResponseBody
    @PostMapping("/reduceMedCustomerSocreApply")
    @ApiOperation(value = "申请扣减积分", notes = "申请扣减积分")
    public ReturnMsg<MedSocreDomain> reduceMedCustomerSocreApply(@RequestBody MedOrderDomain medOrderDomain) {
        try {
            return new ReturnMsg<>(0,medOrderService.reduceMedCustomerSocre(medOrderDomain),null);
        } catch (Exception e) {
            return new ReturnMsg<>(-1,null, e.getMessage());
        }
    }

    @GetMapping("/selectOrderById")
    @ApiOperation(value = "依据id获取抵扣申请", notes = "依据id获取抵申请")
    public ReturnMsg<MedOrderDomain> selectOrderById(@RequestParam(name = "orderId", required = true) Long orderId){
        return new ReturnMsg<>(medOrderService.getByOrderId(orderId));
    }

    @PutMapping("/reduceMedCustomerSocreConfirm")
    @ApiOperation(value = "确认加盟商抵扣申请信息", notes = "确认加盟商抵扣申请信息")
    public ReturnMsg<MedOrderDomain> reduceMedCustomerSocreConfirm(@RequestParam(name = "orderId", required = true) Long orderId){
        try {
            return new ReturnMsg<>(medOrderService.reduceMedCustomerSocreConfirm(orderId));
        } catch (Exception e) {
            return new ReturnMsg<>(-1,null, e.getMessage());
        }
    }

    @RequestMapping(value = "/{qrContent}/{backgroundUrl}/{size}/{positionX}/{positionY}/get.png",method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
    @ApiOperation(value = "海报生成接口-输出图片.png")
    public void getQrPngImage(HttpServletResponse response, @PathVariable("qrContent") String qrContent,
                              @PathVariable("backgroundUrl") String backgroundUrl,
                              @PathVariable("size") Integer size,
                              @PathVariable("positionX") Integer positionX,
                              @PathVariable("positionY") Integer positionY) throws Exception {
        qrContent = URLDecoder.decode(qrContent,"utf-8");
        backgroundUrl = URLDecoder.decode(backgroundUrl,"utf-8");
        ServletOutputStream out = response.getOutputStream();
        BufferedImage bufferedImage = ZXingBackGroundUtils.drawLogoQRCode(null,qrContent,size);
        BufferedImage resultImg = ZXingBackGroundUtils.mergeImage(backgroundUrl,bufferedImage,positionX,positionY,null,0,0,0,0,null,null,0,0,0);
        ImageIO.write(resultImg, "png", out);
        if(out != null){
            out.close();
        }
    }
}
