package com.winterchen.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
@Data
public class NetClient {
    @Value("${zhetaoke_appkey}")
    private String zhetaokeAppkey;
    private static final String ENCODING = "UTF-8";
    private static final String API_ALL = "https://api.zhetaoke.com:10001/api/api_all.ashx?appkey=%s";
    private static final String API_ALL_BAK = "http://api.zhetaoke.cn:10000/api/api_all.ashx?appkey=%s";
    private static final String  API_DETAIL = "https://api.zhetaoke.com:10002/api/api_detail.ashx?appkey=%s";
    private static final String  API_DETAIL_BAK = "http://api.zhetaoke.cn:10000/api/api_detail.ashx?appkey=%s";
    private static final String  API_QUANWANG = "https://api.zhetaoke.com:10003/api/api_quanwang.ashx?appkey=%s";
    private static final String API_QUANWANG_BAK = "http://api.zhetaoke.cn:10000/api/api_quanwang.ashx?appkey=%s";
    private static final String  API_VIDEOS= "https://api.zhetaoke.com:10001/api/api_videos.ashx?appkey=%s";
    private static final String  OPEN_ITEM_GUESS_LIKE= "https://api.zhetaoke.com:10001/api/open_item_guess_like.ashx?appkey=%s";
    private static final String  OPEN_QRPIC = "https://api.zhetaoke.com:10002/api/open_qrpic.ashx?appkey=%s";
    private static final String API_XIAOSHI = "https://api.zhetaoke.com:10001/api/api_xiaoshi.ashx?appkey=%s";
    private static final String  API_QUANTIAN = "https://api.zhetaoke.com:10001/api/api_quantian.ashx?appkey=%s";
    private static final String API_SHISHI = "https://api.zhetaoke.com:10001/api/api_shishi.ashx?appkey=%s";
    private static final String API_YONGJIN = "https://api.zhetaoke.com:10001/api/api_yongjin.ashx?appkey=%s";
    private static final String API_GUANJIANCI = "https://api.zhetaoke.com:10001/api/api_guanjianci.ashx?appkey=%s";
    private static final String API_SUGGEST = "https://api.zhetaoke.com:10001/api/api_suggest.ashx?appkey=%s";
    private static final String API_LUNBO = "https://api.zhetaoke.com:10001/api/api_lunbo.ashx?appkey=%s";
    private static final String API_LIWU_ZHUANTI = "https://api.zhetaoke.com:10001/api/api_liwu_zhuanti.ashx?appkey=%s";

    private static final String OPEN_GAOYONGZHUANLIAN = "https://api.zhetaoke.com:10001/api/open_gaoyongzhuanlian.ashx?appkey=%s";
    private static final String OPEN_GAOYONGZHUANLIAN_BAK = "http://api.zhetaoke.cn:10000/api/open_gaoyongzhuanlian.ashx?appkey=%s";
    private static final String  OPEN_GAOYONGZHUANLIAN_TKL = "https://api.zhetaoke.com:10001/api/open_gaoyongzhuanlian_tkl.ashx?appkey=%s";
    private static final String OPEN_GAOYONGZHUANLIAN_TKL_BAK = "http://api.zhetaoke.cn:10000/api/open_gaoyongzhuanlian_tkl.ashx?appkey=%s";
    private static final String  OPEN_SHORTURL_BAIDU_GET = "https://api.zhetaoke.com:10001/api/open_shorturl_baidu_get.ashx?appkey=%s";
    private static final String OPEN_TKL_CREATE = "https://api.zhetaoke.com:10001/api/open_tkl_create.ashx?appkey=%s";
    private static final String  OPEN_ITEM_INFO = "https://api.zhetaoke.com:10001/api/open_item_info.ashx?appkey=%s";

    private HttpClient client = HttpClients.custom().build();

    private String generateUrl(String api,Map<String,Object> param){
        if(api == null)
            return null;
        api = String.format(api.toString(),this.zhetaokeAppkey);
        StringBuffer urlAddParam = new StringBuffer(api);
        if(Objects.nonNull(param) && !param.isEmpty()){
            if(api.indexOf("?")!=-1){
                param.forEach((k,v)->{if(v!=null && !v.equals("null") && !k.equals("appkey")) urlAddParam.append("&").append(k).append("=").append(v);});
            }else{
                urlAddParam.append("?");
                param.forEach((k,v)->{if(v!=null && !v.equals("null") && !k.equals("appkey")) urlAddParam.append(k).append("=").append(v).append("&");});
            }
        }
        return urlAddParam.toString();
    }

    private String getForResult(String api,String bakApi,Map<String,Object> param){
        String url = this.generateUrl(api,param);
        try {
            if(url == null)
                return null;
             return getForResult(url);
        }catch (IOException e){
            log.error("请求失败,{}" + e.getMessage(), e);
            try {
                url = this.generateUrl(bakApi, param);
                if(url == null)
                    return null;
                return getForResult(url);
            }catch (IOException ex){
                log.error("备用地址请求失败,{}" + ex.getMessage(), ex);
            }
            return null;
        }
    }
    private String getForResult(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpClientResponse = client.execute(httpGet);
        String getAccessTokenResult = EntityUtils.toString(httpClientResponse.getEntity(), ENCODING);
        log.info("请求结果,{}",getAccessTokenResult);
        return getAccessTokenResult;
    }
    @Data
    private class UrlEntity {
        /**
         * 基础url
         */
        private String baseUrl;
        /**
         * url参数
         */
        private Map<String, String> params = new HashMap<>();
    }

    /**
     * 解析url
     *
     * @param url
     * @return
     */
    private UrlEntity parse(String url) {
        UrlEntity entity = new UrlEntity();
        if (url == null) {
            return entity;
        }
        url = url.trim();
        if (url.equals("")) {
            return entity;
        }
        String[] urlParts = url.split("\\?");
        entity.setBaseUrl(urlParts[0]);
        //没有参数
        if (urlParts.length == 1) {
            return entity;
        }
        //有参数
        String[] params = urlParts[1].split("&");
        for (String param : params) {
            String[] keyValue = param.split("=");
            entity.getParams().put(keyValue[0], keyValue[1]);
        }

        return entity;
    }

    public String apiAll(Map<String,Object> param){
        return this.getForResult(API_ALL,API_ALL_BAK,param);
    }

    public String apiDetail(Map<String,Object> param){
        return this.getForResult(API_DETAIL,API_DETAIL_BAK,param);
    }

    public String apiQuanwang(Map<String,Object> param){
        return this.getForResult(API_QUANWANG,API_QUANWANG_BAK,param);
    }

    public String apiVideos(Map<String,Object> param){
        return this.getForResult(API_VIDEOS,API_VIDEOS,param);
    }

    public String openItemGuessLike(Map<String,Object> param){
        return this.getForResult(OPEN_ITEM_GUESS_LIKE,OPEN_ITEM_GUESS_LIKE,param);
    }

    public String openQrpic(Map<String,Object> param){
        return this.getForResult(OPEN_QRPIC,OPEN_QRPIC,param);
    }

    public String apiXiaoshi(Map<String,Object> param){
        return this.getForResult(API_XIAOSHI,API_XIAOSHI,param);
    }

    public String apiQuantian(Map<String,Object> param){
        return this.getForResult(API_QUANTIAN,API_QUANTIAN,param);
    }

    public String apiShishi(Map<String,Object> param){
        return this.getForResult(API_SHISHI,API_SHISHI,param);
    }
    public String apiYongjin(Map<String,Object> param){
        return this.getForResult(API_YONGJIN,API_YONGJIN,param);
    }

    public String apiGuanjianci(Map<String,Object> param){
        return this.getForResult(API_GUANJIANCI,API_GUANJIANCI,param);
    }

    public String apiSuggest(Map<String,Object> param){
        return this.getForResult(API_SUGGEST,API_SUGGEST,param);
    }

    public String apiLunbo(Map<String,Object> param){
        return this.getForResult(API_LUNBO,API_LUNBO,param);
    }

    public String apiLiwuZhuanti(Map<String,Object> param){
        return this.getForResult(API_LIWU_ZHUANTI,API_LIWU_ZHUANTI,param);
    }

    public String openGaoyongzhuanlian(Map<String,Object> param){
        return this.getForResult(OPEN_GAOYONGZHUANLIAN,OPEN_GAOYONGZHUANLIAN_BAK,param);
    }

    public String openGaoyongzhuanlianTkl(Map<String,Object> param){
        return this.getForResult(OPEN_GAOYONGZHUANLIAN_TKL,OPEN_GAOYONGZHUANLIAN_TKL_BAK,param);
    }

    public String openShorturlBaiduGet(Map<String,Object> param){
        return this.getForResult(OPEN_SHORTURL_BAIDU_GET,OPEN_SHORTURL_BAIDU_GET,param);
    }


    public String openKklCreate(Map<String,Object> param){
        return this.getForResult(OPEN_TKL_CREATE,OPEN_TKL_CREATE,param);
    }

    public String openItemInfo(Map<String,Object> param){
        return this.getForResult(OPEN_ITEM_INFO,OPEN_ITEM_INFO,param);
    }

    public String apiLunboDetail(String refUrl,Map param) throws IOException {
        UrlEntity urlEntity = parse(refUrl);
        urlEntity.getParams().putAll(param);
        urlEntity.getParams().put("appkey",this.zhetaokeAppkey);
        StringBuffer urlAddParam = new StringBuffer(urlEntity.getBaseUrl());
        if(Objects.nonNull(urlEntity.getParams()) && !urlEntity.getParams().isEmpty()){
            if(urlEntity.getBaseUrl().indexOf("?")!=-1){
                urlEntity.getParams().forEach((k,v)->{if(v!=null && !v.equals("null")) urlAddParam.append("&").append(k).append("=").append(v);});
            }else{
                urlAddParam.append("?");
                urlEntity.getParams().forEach((k,v)->{if(v!=null && !v.equals("null")) urlAddParam.append(k).append("=").append(v).append("&");});
            }
        }
        return this.getForResult(urlAddParam.toString());
    }
    public String category(){
        return "{\"content\":[{\"id\":null,\"value\":\"\\u5168\\u90e8\"},{\"id\":\"1\",\"value\":\"\\u5973\\u88c5\"},{\"id\":\"2\",\"value\":\"\\u6bcd\\u5a74\"},{\"id\":\"3\",\"value\":\"\\u7f8e\\u5986\"},{\"id\":\"4\",\"value\":\"\\u5c45\\u5bb6\\u65e5\\u7528\"},{\"id\":\"5\",\"value\":\"\\u978b\\u54c1\"},{\"id\":\"6\",\"value\":\"\\u7f8e\\u98df\"},{\"id\":\"7\",\"value\":\"\\u6587\\u5a31\\u8f66\\u54c1\"},{\"id\":\"8\",\"value\":\"\\u6570\\u7801\\u5bb6\\u7535\"},{\"id\":\"9\",\"value\":\"\\u7537\\u88c5\"},{\"id\":\"10\",\"value\":\"\\u5185\\u8863\"},{\"id\":\"11\",\"value\":\"\\u7bb1\\u5305\"},{\"id\":\"12\",\"value\":\"\\u914d\\u9970\"},{\"id\":\"13\",\"value\":\"\\u6237\\u5916\\u8fd0\\u52a8\"},{\"id\":\"14\",\"value\":\"\\u5bb6\\u88c5\\u5bb6\\u7eba\"}]}";
    }


}
