package com.winterchen.controller;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.*;
import com.taobao.api.response.*;
import com.winterchen.config.TaobaoConfig;
import com.winterchen.model.UserDomain;
import com.winterchen.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by Administrator on 2017/8/16.
 */
@RestController
@RequestMapping(value = "/taobao")
@Api(value = "后端淘宝服务中心", tags = {"后端淘宝服务中心"})
public class TaobaoApiController {

    @Autowired
    private UserService userService;
    @Autowired
    private TaobaoConfig taobaoConfig;

    @ResponseBody
    @PostMapping("/add")
    @ApiOperation(value = "添加用户", notes = "添加单个用户")
    public int addUser(UserDomain user){
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    @ApiOperation(value = "查询列表", notes = "查询用户列表")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        TaobaoClient client=new DefaultTaobaoClient(taobaoConfig.getServerUrl(), taobaoConfig.getTbk().getAppkey(), taobaoConfig.getTbk().getAppsecret());
        TbkTpwdCreateRequest tbkTpwdCreateRequest = new TbkTpwdCreateRequest();
        tbkTpwdCreateRequest.setText("【爆款推荐】好口碑塔罗科血橙当季水果新鲜包邮整箱红橙子5/10斤雪橙应季脐橙1");
        tbkTpwdCreateRequest.setUrl("https://s.click.taobao.com/XHukeqv");
        try {
            TbkTpwdCreateResponse rsp = client.execute(tbkTpwdCreateRequest);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return userService.findAllUser(pageNum,pageSize);
    }

    @ResponseBody
    @PostMapping("/taobao.tbk.item.recommend.get")
    @ApiOperation(value = " 淘宝客-公用-商品关联推荐", notes = " 淘宝客-公用-商品关联推荐")
    public Object TbkItemRecommendGetRequest(@RequestBody TbkItemRecommendGetRequest tbkItemRecommendGetRequest) throws ApiException {
        TaobaoClient client=new DefaultTaobaoClient(taobaoConfig.getServerUrl(), taobaoConfig.getTbk().getAppkey(), taobaoConfig.getTbk().getAppsecret());
        TbkItemRecommendGetResponse rsp = client.execute(tbkItemRecommendGetRequest);
        return rsp.getBody();
    }


    @ResponseBody
    @PostMapping("/taobao.tbk.item.info.get")
    @ApiOperation(value = " 淘宝客-公用-淘宝客商品详情查询(简版)", notes = "淘宝客-公用-淘宝客商品详情查询(简版)")
    public Object TbkItemInfoGetRequest(@RequestBody TbkItemInfoGetRequest tbkItemInfoGetRequest) throws ApiException {
        TaobaoClient client=new DefaultTaobaoClient(taobaoConfig.getServerUrl(), taobaoConfig.getTbk().getAppkey(), taobaoConfig.getTbk().getAppsecret());
        TbkItemInfoGetResponse rsp = client.execute(tbkItemInfoGetRequest);
        return rsp.getBody();
    }

    @ResponseBody
    @PostMapping("/taobao.tbk.uatm.favorites.get")
    @ApiOperation(value = "淘宝客-推广者-选品库宝贝列表", notes = "淘宝客-推广者-选品库宝贝列表")
    public Object TbkUatmFavoritesGetRequest(@RequestBody TbkUatmFavoritesGetRequest tbkUatmFavoritesGetRequest) throws ApiException {
        TaobaoClient client=new DefaultTaobaoClient(taobaoConfig.getServerUrl(), taobaoConfig.getTbk().getAppkey(), taobaoConfig.getTbk().getAppsecret());
        TbkUatmFavoritesGetResponse rsp = client.execute(tbkUatmFavoritesGetRequest);
        return rsp.getBody();
    }

    //adzone_id推广位id，需要在淘宝联盟后台创建；且属于appkey备案的媒体id（siteid）
    @ResponseBody
    @PostMapping("/taobao.tbk.uatm.favorites.item.get")
    @ApiOperation(value = " 淘宝客-推广者-选品库宝贝信息", notes = " 淘宝客-推广者-选品库宝贝信息")
    public Object TbkItemInfoGetRequest(@RequestBody TbkUatmFavoritesItemGetRequest tbkUatmFavoritesItemGetRequest) throws ApiException {
        TaobaoClient client=new DefaultTaobaoClient(taobaoConfig.getServerUrl(), taobaoConfig.getTbk().getAppkey(), taobaoConfig.getTbk().getAppsecret());
        TbkUatmFavoritesItemGetResponse rsp = client.execute(tbkUatmFavoritesItemGetRequest);
        return rsp.getBody();
    }

    @ResponseBody
    @PostMapping("/taobao.tbk.tpwd.create")
    @ApiOperation(value = "淘口令", notes = "淘口令")
    public Object TbkTpwdCreateRequest(@RequestBody TbkTpwdCreateRequest tbkTpwdCreateRequest) throws ApiException {
        TaobaoClient client=new DefaultTaobaoClient(taobaoConfig.getServerUrl(), taobaoConfig.getTbk().getAppkey(), taobaoConfig.getTbk().getAppsecret());
        //TbkTpwdCreateRequest tbkTpwdCreateRequest = new TbkTpwdCreateRequest();
        //tbkTpwdCreateRequest.setText("【爆款推荐】好口碑塔罗科血橙当季水果新鲜包邮整箱红橙子5/10斤雪橙应季脐橙1");
        //tbkTpwdCreateRequest.setUrl("https://s.click.taobao.com/XHukeqv");
        TbkTpwdCreateResponse rsp = client.execute(tbkTpwdCreateRequest);
        return rsp.getBody();
    }

    @ResponseBody
    @PostMapping("/taobao.tbk.item.convert")
    @ApiOperation(value = " 淘宝客-推广者-商品链接转换", notes = "淘宝客-推广者-商品链接转换")
    public Object TbkItemConvertRequest(@RequestBody TbkItemConvertRequest tbkItemConvertRequest) throws ApiException {
        TaobaoClient client=new DefaultTaobaoClient(taobaoConfig.getServerUrl(), taobaoConfig.getTbk().getAppkey(), taobaoConfig.getTbk().getAppsecret());
        TbkItemConvertResponse rsp = client.execute(tbkItemConvertRequest);
        return rsp.getBody();
    }

    @ResponseBody
    @GetMapping("/taobao.tbk.sc.material.optional")
    @ApiOperation(value = " 淘宝客-获取全网淘客商品", notes = "获取全网淘客商品")
    public Object TbkScMaterialOptionalRequest(@RequestParam(name = "usertoken") String usertoken,
                                       @RequestParam(name = "q") String q,
                                       @RequestParam(name = "pageSize",defaultValue = "20")Integer pageSize,
                                       @RequestParam(name = "pageNo" ,defaultValue = "1")Integer pageNo) throws IOException {
        HttpClient client = HttpClients.custom().build();
        HttpGet httpGet=new HttpGet(String.format(
                "https://api.taobaokeapi.com/?usertoken=%s&method=taobao.tbk.sc.material.optional&q=%s&page_size=%d&page_no=%d&adzone_id=%s&site_id=%s",
                usertoken,q,pageSize,pageNo,taobaoConfig.getAdzoneId(),taobaoConfig.getSiteId())
        );
        HttpResponse response = client.execute(httpGet);
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }

    @ResponseBody
    @GetMapping("/api.taobao.get.taobao.cate")
    @ApiOperation(value = " 淘宝客-获取商品分类接口", notes = "获取商品分类接口")
    public Object TbkCateRequest(@RequestParam(name = "usertoken") String usertoken,
                                               @RequestParam(name = "parentCid",defaultValue = "0") String parentCid) throws IOException {
        HttpClient client = HttpClients.custom().build();
        HttpGet httpGet=new HttpGet(String.format(
                "https://api.taobaokeapi.com/?usertoken=%s&method=api.taobao.get.taobao.cate&parent_cid=%s",
                usertoken,parentCid)
        );
        HttpResponse response = client.execute(httpGet);
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }


    @ResponseBody
    @GetMapping("/taobao.tbk.coupon.list")
    @ApiOperation(value = " 淘宝客-推广者-淘宝天猫优惠券JSON接口", notes = "淘宝天猫优惠券JSON接口")
    @Deprecated
    public Object TbkCouponListRequest(@RequestParam("pid") String pid,@RequestParam("category") String category,@RequestParam("queryCount")Integer queryCount) throws IOException {
        HttpClient client = HttpClients.custom().build();
        HttpGet httpGet=new HttpGet(String.format("http://uland.taobao.com/cp/coupon_list?pid=%s&category=%s&queryCount=%d",pid,category,queryCount));
        HttpResponse response = client.execute(httpGet);
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }



}
