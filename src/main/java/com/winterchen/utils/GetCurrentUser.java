package com.winterchen.utils;

import com.alibaba.fastjson.JSON;
import com.winterchen.model.MedCustomerDomain;

import javax.servlet.http.HttpServletRequest;

public class GetCurrentUser {
    public static MedCustomerDomain convertFormRequest(HttpServletRequest request){
        String sessionId = request.getHeader("Med-SessionId");
        MedCustomerDomain currentUser = JSON.parseObject(sessionId,MedCustomerDomain.class);
        return currentUser;
    }
}
