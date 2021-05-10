package com.winterchen.utils;

import com.alibaba.fastjson.JSON;
import com.winterchen.model.MedCustomerDomain;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class GetCurrentUser {
    public static MedCustomerDomain convertFormRequest(HttpServletRequest request){
        try {
            String sessionId = request.getHeader("Med-SessionId");
            MedCustomerDomain currentUser = JSON.parseObject(URLDecoder.decode(sessionId, "utf-8"), MedCustomerDomain.class);
            return currentUser;
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return null;
    }
}
