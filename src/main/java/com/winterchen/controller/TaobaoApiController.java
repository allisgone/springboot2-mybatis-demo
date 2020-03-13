package com.winterchen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.*;
import com.taobao.api.response.*;
import com.winterchen.config.NetClient;
import com.winterchen.config.TaobaoConfig;
import com.winterchen.model.CouponDomain;
import com.winterchen.model.SysConfigDomain;
import com.winterchen.model.TklObject;
import com.winterchen.model.UserDomain;
import com.winterchen.service.coupon.CouponService;
import com.winterchen.service.sysconfig.SysConfigService;
import com.winterchen.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    private CouponService couponService;
    @Autowired
    private SysConfigService sysConfigService;
    @Autowired
    private TaobaoConfig taobaoConfig;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private NetClient netClient;
    private String token = "yijun2020";

    @ResponseBody
    @GetMapping("/update.sysconfig")
    @ApiOperation(value = "更新系统参数", notes = "更新系统参数")
    public SysConfigDomain updateSysconfig(SysConfigDomain sysConfigDomain){
        return sysConfigService.insertOrUpdatteSysConfig(sysConfigDomain);
    }

    @ResponseBody
    @GetMapping("/coupon")
    @ApiOperation(value = "依据优惠券参数查询优惠券信息", notes = "依据优惠券参数查询优惠券信息")
    public CouponDomain getCouponById(@RequestParam(name = "id", required = true) Integer id){
        CouponDomain couponDomain = couponService.selectCoupon(id);
        if(couponDomain == null)
            return null;
        if(!couponDomain.isReply()){
            couponDomain.setCouponText("请刷新重试");
        }
        return couponDomain;
    }

    @ResponseBody
    @GetMapping("/verifyweixin")
    @ApiOperation(value = "验证消息来自微信服务器", notes = "验证消息来自微信服务器")
    public String verifyWeixin(@RequestParam(name = "signature", required = true)
                            String signature,
                            @RequestParam(name = "timestamp", required = true)
                            String timestamp,
                            @RequestParam(name = "nonce", required = true)
                            String nonce,
                            @RequestParam(name = "echostr", required = true)
                            String echostr){
        System.out.print("signature=" + signature + " timestamp=" +timestamp + " nonce=" + nonce);
        if(checkSignature(signature, timestamp, nonce)) {
            System.out.print("echostr=" + echostr);
            return echostr;
        }
        return null;
    }
    @ResponseBody
    @PostMapping("/verifyweixin")
    @ApiOperation(value = "验证消息来自微信服务器", notes = "验证消息来自微信服务器")
    public String verifyWeixin(@RequestBody String body){
        try {
            //2.加载xml
            System.out.println(body);
            Document document = DocumentHelper.parseText(body);
            //3.获取根节点
            Element rootElement = document.getRootElement();
            Element toUserName = rootElement.element("ToUserName");
            Element fromUserName = rootElement.element("FromUserName");
            Element msgType = rootElement.element("MsgType");
            if(Objects.equals(msgType.getStringValue(),"event")){
                //关注
                Element event = rootElement.element("Event");
                if(Objects.equals(event.getStringValue(),"subscribe")){
                    String reply = String.format("<xml>\n" +
                            "  <ToUserName><![CDATA[%s]]></ToUserName>\n" +
                            "  <FromUserName><![CDATA[%s]]></FromUserName>\n" +
                            "  <CreateTime>%d</CreateTime>\n" +
                            "  <MsgType><![CDATA[text]]></MsgType>\n" +
                            "  <Content><![CDATA[%s]]></Content>\n" +
                            "</xml>",fromUserName.getStringValue(),toUserName.getStringValue(),
                            System.currentTimeMillis(),"小主，你可以尝试在淘宝分享淘口令或者链接发送给我，就能自动查找淘宝/天猫内部优惠券，快来试试吧！");
                    return reply;
                }
            }else if(Objects.equals(msgType.getStringValue(),"text")){
                Element content = rootElement.element("Content");
                CouponDomain couponDomain = new CouponDomain();

                SysConfigDomain sysConfigDomain = sysConfigService.selectSysConfig();
                Map<String,Object> param = new HashMap<>();
                param.put("sid",sysConfigDomain.getSid());
                param.put("pid",sysConfigDomain.getPid());
                param.put("tkl", content.getStringValue());
                param.put("signurl",5);
                String result = netClient.openGaoyongzhuanlianTkl(param);
                couponDomain.setCouponText(result);
                couponService.insertCoupon(couponDomain);
                if(result.indexOf("\"status\":200")==-1){
                   return String.format("<xml>\n" +
                                    "  <ToUserName><![CDATA[%s]]></ToUserName>\n" +
                                    "  <FromUserName><![CDATA[%s]]></FromUserName>\n" +
                                    "  <CreateTime>%d</CreateTime>\n" +
                                    "  <MsgType><![CDATA[text]]></MsgType>\n" +
                                    "  <Content><![CDATA[%s]]></Content>\n" +
                                    "</xml>",
                            fromUserName.getStringValue(),
                            toUserName.getStringValue(),
                            System.currentTimeMillis(),
                            "未找到优惠券，请换个商品试试"
                    );
                }
                TklObject tklObject = objectMapper.readValue(result, TklObject.class);
                TklObject.Content tklContent = tklObject.getContent().get(0);
                //把信息存数据库 并获取数据id带到url上
                return String.format("<xml>\n" +
                                "  <ToUserName><![CDATA[%s]]></ToUserName>\n" +
                                "  <FromUserName><![CDATA[%s]]></FromUserName>\n" +
                                "  <CreateTime>%d</CreateTime>\n" +
                                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                                "  <Content><![CDATA[%s]]></Content>\n" +
                                "</xml>",
                        fromUserName.getStringValue(),
                        toUserName.getStringValue(),
                        System.currentTimeMillis(),
                        //跳转地址和查看参数id
                        String.format("%s<br/>原价:(%s)<br/>优惠价:(%s)<br/><a href='%s%d'>%s--点击领取优惠券</a>",
                                tklContent.getTitle(),
                                tklContent.getSize(),
                                tklContent.getQuanhou_jiage(),
                                sysConfigDomain.getCouponJumpUrl(),
                                couponDomain.getId(),
                                tklContent.getCoupon_info())
                );
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String x = "asdasfdddddddddddddfs";
        x.substring(0,5);
    }
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
    public Object TbkScMaterialOptionalRequest(@RequestParam(name = "q") String q,
                                       @RequestParam(name = "pageSize",defaultValue = "20")Integer pageSize,
                                       @RequestParam(name = "pageNo" ,defaultValue = "1")Integer pageNo) throws IOException {
        SysConfigDomain sysConfigDomain = sysConfigService.selectSysConfig();
        HttpClient client = HttpClients.custom().build();
        HttpGet httpGet=new HttpGet(String.format(
                "https://api.taobaokeapi.com/?usertoken=%s&method=taobao.tbk.sc.material.optional&q=%s&page_size=%d&page_no=%d&adzone_id=%s&site_id=%s",
                sysConfigDomain.getUsertoken(),q,pageSize,pageNo,taobaoConfig.getAdzoneId(),taobaoConfig.getSiteId())
        );
        HttpResponse response = client.execute(httpGet);
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }

    @ResponseBody
    @GetMapping("/api.taobao.get.taobao.cate")
    @ApiOperation(value = " 淘宝客-获取商品分类接口", notes = "获取商品分类接口")
    public Object TbkCateRequest(@RequestParam(name = "parentCid",defaultValue = "0") String parentCid) throws IOException {
        SysConfigDomain sysConfigDomain = sysConfigService.selectSysConfig();
        HttpClient client = HttpClients.custom().build();
        HttpGet httpGet=new HttpGet(String.format(
                "https://api.taobaokeapi.com/?usertoken=%s&method=api.taobao.get.taobao.cate&parent_cid=%s",
                sysConfigDomain.getUsertoken(),parentCid)
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


    private boolean checkSignature(String signature, String timestamp,
                                   String nonce) {
        // 1.将token、timestamp、nonce三个参数进行字典序排序
        String[] arr = new String[] { token, timestamp, nonce };
        Arrays.sort(arr);

        // 2. 将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        content = null;
        // 3.将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }
    private String byteToStr(byte[] byteArray) {
        StringBuilder strDigest = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            strDigest.append(byteToHexStr(byteArray[i]));
        }
        return strDigest.toString();
    }
    private String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }

}
