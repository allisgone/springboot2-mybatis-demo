package com.winterchen.service.med.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.*;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winterchen.dao.MedSmsCodeDao;
import com.winterchen.model.MedSmsCodeDomain;
import com.winterchen.service.med.MedSmsCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Random;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "medSmsCodeService")
public class MedSmsCodeServiceImpl extends ServiceImpl<MedSmsCodeDao, MedSmsCodeDomain> implements MedSmsCodeService {

    @Autowired
    private MedSmsCodeDao medSmsCodeDao;

    //产品名称:云通信短信API产品,开发者无需替换
    private static final String product = "Dysmsapi";

    //产品域名,开发者无需替换
    private static final String domain = "dysmsapi.aliyuncs.com";

    private static final String sign = "阳光会员";
    // 开发者akID
    private static final String accessKeyId = "";

    //开发者ak秘钥
    private static final String accessKeySecret = "";
    /**
     * 发送短信
     *
     * @param phoneNum
     * @param sendType
     */
    @Override
    public MedSmsCodeDomain send(String phoneNum,int sendType) throws Exception{
        MedSmsCodeDomain medSmsCodeDomain = this.getOne(new QueryWrapper<MedSmsCodeDomain>().eq("phone", phoneNum)
        .eq("send_type", sendType));
        Timestamp towMinuteBefor = new Timestamp(System.currentTimeMillis()-2*60*1000);
        if(Objects.nonNull(medSmsCodeDomain)){
            if(medSmsCodeDomain.getCreateTime().after(towMinuteBefor)) {
                medSmsCodeDomain.setSmsCode(null);
                return medSmsCodeDomain;
            }
        }else{
            medSmsCodeDomain = new MedSmsCodeDomain();
        }
        //注册SMS_205700298  登录 SMS_205700300
        String template;
        if(1 == sendType){
            template = "SMS_205700300";
        }else{
            template = "SMS_205700298";
        }
        //生成六位随机数字短信验证码
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        //验证码转为对应格式的json串
        String jsonContent = "{\"code\":\"" + verifyCode + "\"}";
        //补全请求参数
        SendSmsRequest request = new SendSmsRequest();

        request.setPhoneNumbers(phoneNum);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(sign);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(template);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam(jsonContent);

        //发送短信
        SendSmsResponse response = sendSms(request,accessKeyId,accessKeySecret);
        //判断阿里云服务器是否正确返回
        if (response.getCode() != null && !response.getCode().equals("OK")) {
            if ((response.getCode() != null && "sv.BUSINESS_LIMIT_CONTROL".equals(response.getCode()))) {
                throw new Exception("同一手机30秒之内，只允许发送一个手机短信码");
            }
            if ((response.getCode() != null && ("isv.BUSINESS_LIMIT_CONTROL").equals(response.getCode()))) {
                throw new Exception("手机短信发送过于频繁，请您稍后再尝试");
            }
            if ("isv.MOBILE_NUMBER_ILLEGAL".equals(response.getCode())){
                throw new Exception("请输入正确的手机号");
            }
            throw new Exception(response.getMessage());
        }
        //更新或添加手机短信验证码至数据库，用于之后的短信验证码验证（有效期五分钟）
        medSmsCodeDomain.setCreateTime(new Timestamp(System.currentTimeMillis()));
        medSmsCodeDomain.setSmsCode(verifyCode);
        medSmsCodeDomain.setPhone(phoneNum);
        medSmsCodeDomain.setSendType(sendType);
        this.saveOrUpdate(medSmsCodeDomain);
        medSmsCodeDomain.setSmsCode(null);
        return medSmsCodeDomain;
    }

    private static SendSmsResponse sendSms(SendSmsRequest request, String accessKeyId, String accessKeySecret) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");


        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容

        //使用post提交
        request.setMethod(MethodType.POST);

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId(param.getOutId());


        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;

    }
    /*public static void main(String[] args) {
        String sign = "阳光会员";
        // 开发者akID
        String accessKeyId = "LTAI4GGrLqfXqdzSn6C3jAcx";

        //开发者ak秘钥
        String accessKeySecret = "9zKwomlpio7QxlpfIsJOztktV5u0XV";
        //生成六位随机数字短信验证码
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        //验证码转为对应格式的json串
        String jsonContent = "{\"code\":\"" + verifyCode + "\"}";
        //补全请求参数
        SmsParam param = new SmsParam();
        param.setPhoneNumbers("18874711213");
        param.setSignName(sign);
        param.setTemplateCode("SMS_205700300");
        param.setTemplateParam(jsonContent);
        try {
            SendSmsResponse sendSmsResponse = sendSms(param,accessKeyId,accessKeySecret);
            System.out.println(sendSmsResponse);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }*/

}
