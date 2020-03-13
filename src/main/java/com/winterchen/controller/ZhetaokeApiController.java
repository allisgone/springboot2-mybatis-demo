package com.winterchen.controller;

import com.winterchen.config.NetClient;
import com.winterchen.model.SysConfigDomain;
import com.winterchen.service.sysconfig.SysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;


/**
 * Created by Administrator on 2017/8/16.
 */
@RestController
@RequestMapping(value = "/zhetaoke")
@Api(value = "后端折淘客服务中心", tags = {"后端折淘客服务中心"})
public class ZhetaokeApiController {

    @Autowired
    private SysConfigService sysConfigService;
    @Autowired
    private NetClient netClient;

    @ResponseBody
    @GetMapping("/api_all")
    @ApiOperation(value = "全站领券商品", notes = "全站领券商品")
    public Object apiAllRequest(@RequestParam Map<String, Object> param){
        return netClient.apiAll(param);
    }

    @ResponseBody
    @GetMapping("/api_detail")
    @ApiOperation(value = "全网商品详情API接口", notes = "全网商品详情API接口")
    public Object apiDetailRequest(@RequestParam Map<String, Object> param){
        return netClient.apiDetail(param);
    }

    @ResponseBody
    @GetMapping("/api_quanwang")
    @ApiOperation(value = "全网搜索商品API接口", notes = "全网搜索商品API接口")
    public Object apiQuanwangRequest(@RequestParam Map<String, Object> param){
        return netClient.apiQuanwang(param);
    }

    @ResponseBody
    @GetMapping("/api_videos")
    @ApiOperation(value = "视频(抖货)商品API接口", notes = "视频(抖货)商品API接口")
    public Object apiVideosRequest(@RequestParam Map<String, Object> param){
        return netClient.apiVideos(param);
    }

    @ResponseBody
    @GetMapping("/open_item_guess_like")
    @ApiOperation(value = "猜你喜欢API（相似商品API）", notes = "猜你喜欢API（相似商品API）")
    public Object openItemGuessLikeRequest(@RequestParam Map<String, Object> param){
        return netClient.openItemGuessLike(param);
    }

    @ResponseBody
    @GetMapping("/open_qrpic")
    @ApiOperation(value = "二维码发单图API（朋友圈文案）", notes = "二维码发单图API（朋友圈文案）")
    public Object openQrpicRequest(@RequestParam Map<String, Object> param){
        SysConfigDomain sysConfigDomain = sysConfigService.selectSysConfig();
        param.put("sid",sysConfigDomain.getSid());
        return netClient.openQrpic(param);
    }

    @ResponseBody
    @GetMapping("/api_xiaoshi")
    @ApiOperation(value = "两小时销量榜API", notes = "两小时销量榜API")
    public Object apiXiaoshiRequest(@RequestParam Map<String, Object> param){
        return netClient.apiXiaoshi(param);
    }

    @ResponseBody
    @GetMapping("/api_quantian")
    @ApiOperation(value = "全天销量榜API", notes = "全天销量榜API")
    public Object apiQuantianRequest(@RequestParam Map<String, Object> param){
        return netClient.apiQuantian(param);
    }

    @ResponseBody
    @GetMapping("/api_shishi")
    @ApiOperation(value = "实时人气榜API", notes = "实时人气榜API")
    public Object apiShishiRequest(@RequestParam Map<String, Object> param){
        return netClient.apiShishi(param);
    }

    @ResponseBody
    @GetMapping("/api_yongjin")
    @ApiOperation(value = "实时支出佣金榜API", notes = "实时支出佣金榜API")
    public Object apiYongjinRequest(@RequestParam Map<String, Object> param){
        return netClient.apiYongjin(param);
    }

    @ResponseBody
    @GetMapping("/api_guanjianci")
    @ApiOperation(value = "关键词词典API：返回top10w词表，搜索量极大，曝光量极高的词", notes = "关键词词典API：返回top10w词表，搜索量极大，曝光量极高的词")
    public Object apiGuanjianciRequest(@RequestParam Map<String, Object> param){
        return netClient.apiGuanjianci(param);
    }

    @ResponseBody
    @GetMapping("/api_suggest")
    @ApiOperation(value = "联想词API：根据搜索关键词返回联想词，完善您的搜索功能", notes = "联想词API：根据搜索关键词返回联想词，完善您的搜索功能")
    public Object apiSuggestRequest(@RequestParam Map<String, Object> param){
        return netClient.apiSuggest(param);
    }

    @ResponseBody
    @GetMapping("/api_lunbo")
    @ApiOperation(value = "轮播图API", notes = "轮播图API")
    public Object apiLunboRequest(@RequestParam Map<String, Object> param){
        return netClient.apiLunbo(param);
    }

    @ResponseBody
    @GetMapping("/api_liwu_zhuanti")
    @ApiOperation(value = "精选礼物专题API", notes = "精选礼物专题API")
    public Object apiLiwuZhuantiRequest(@RequestParam Map<String, Object> param){
        return netClient.apiLiwuZhuanti(param);
    }

    @ResponseBody
    @GetMapping("/open_gaoyongzhuanlian")
    @ApiOperation(value = "高佣转链API接口", notes = "高佣转链API接口")
    public Object openGaoyongzhuanlianRequest(@RequestParam Map<String, Object> param){
        SysConfigDomain sysConfigDomain = sysConfigService.selectSysConfig();
        param.put("sid",sysConfigDomain.getSid());
        param.put("pid",sysConfigDomain.getPid());
        return netClient.openGaoyongzhuanlian(param);
    }

    @ResponseBody
    @GetMapping("/open_gaoyongzhuanlian_tkl")
    @ApiOperation(value = "高佣转链API接口(淘口令)", notes = "高佣转链API接口(淘口令)")
    public Object openGaoyongzhuanlianTklRequest(@RequestParam Map<String, Object> param){
        SysConfigDomain sysConfigDomain = sysConfigService.selectSysConfig();
        param.put("sid",sysConfigDomain.getSid());
        param.put("pid",sysConfigDomain.getPid());
        return netClient.openGaoyongzhuanlianTkl(param);
    }

    @ResponseBody
    @GetMapping("/open_shorturl_baidu_get")
    @ApiOperation(value = "百度短链接转换API", notes = "百度短链接转换API")
    public Object openShorturlBaiduGetRequest(@RequestParam Map<String, Object> param){
        SysConfigDomain sysConfigDomain = sysConfigService.selectSysConfig();
        param.put("sid",sysConfigDomain.getSid());
        return netClient.openShorturlBaiduGet(param);
    }


    @ResponseBody
    @GetMapping("/open_kkl_create")
    @ApiOperation(value = "淘口令生成API", notes = "淘口令生成API")
    public Object openKklCreateRequest(@RequestParam Map<String, Object> param){
        SysConfigDomain sysConfigDomain = sysConfigService.selectSysConfig();
        param.put("sid",sysConfigDomain.getSid());
        return netClient.openKklCreate(param);
    }

    @ResponseBody
    @GetMapping("/open_item_info")
    @ApiOperation(value = "全网商品详情API（简版）", notes = "全网商品详情API（简版）")
    public Object openItemInfoRequest(@RequestParam Map<String, Object> param){
        SysConfigDomain sysConfigDomain = sysConfigService.selectSysConfig();
        param.put("sid",sysConfigDomain.getSid());
        return netClient.openItemInfo(param);
    }

    @ResponseBody
    @PostMapping("/api_lunbo_detail")
    @ApiOperation(value = "依据轮播图内容地址获取推荐商品数据", notes = "依据轮播图内容地址获取推荐商品数据")
    public Object apiLunboDetailRequest(@RequestBody Map<String, String> map) throws IOException {
        String refUrl = String.valueOf(map.get("refUrl"));
        map.remove("refUrl");
        return netClient.apiLunboDetail(refUrl,map);
    }

    @ResponseBody
    @GetMapping("/category")
    @ApiOperation(value = "分类", notes = "分类")
    public Object category(){
        return netClient.category();
    }

}
