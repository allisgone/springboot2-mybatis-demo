package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.TbkDgVegasTljInstanceReportResponse;

/**
 * TOP API: taobao.tbk.dg.vegas.tlj.instance.report request
 * 
 * @author top auto create
 * @since 1.0, 2019.09.11
 */
public class TbkDgVegasTljInstanceReportRequest extends BaseTaobaoRequest<TbkDgVegasTljInstanceReportResponse> {
	
	

	/** 
	* 实例ID
	 */
	private String rightsId;

	public void setRightsId(String rightsId) {
		this.rightsId = rightsId;
	}

	public String getRightsId() {
		return this.rightsId;
	}

	public String getApiMethodName() {
		return "taobao.tbk.dg.vegas.tlj.instance.report";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("rights_id", this.rightsId);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<TbkDgVegasTljInstanceReportResponse> getResponseClass() {
		return TbkDgVegasTljInstanceReportResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(rightsId, "rightsId");
	}
	

}