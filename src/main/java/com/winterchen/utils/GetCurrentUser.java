package com.winterchen.utils;

import com.alibaba.fastjson.JSON;
import com.winterchen.model.MedCustomerDomain;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class GetCurrentUser {
    private GetCurrentUser(){

    }
    public static MedCustomerDomain convertFormRequest(){
        try {
            HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
            String sessionId = request.getHeader("Med-SessionId");
            MedCustomerDomain currentUser = JSON.parseObject(URLDecoder.decode(sessionId, "utf-8"), MedCustomerDomain.class);
            return currentUser;
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return null;
    }
}
