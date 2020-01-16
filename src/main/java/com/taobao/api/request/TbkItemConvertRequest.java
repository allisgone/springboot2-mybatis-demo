package com.taobao.api.request;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.response.TbkItemConvertResponse;

import java.util.Map;

/**
 * TOP API: taobao.appip.get request
 * 
 * @author top auto create
 * @since 1.0, 2018.07.25
 */
public class TbkItemConvertRequest extends BaseTaobaoRequest<TbkItemConvertResponse> {
	
	

	public String getApiMethodName() {
		return "taobao.tbk.item.convert";
	}

	private String fields;
	private String numIids;
	private String adzoneId;
	private String platform;
	private String unid;
	private String dx;

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public String getNumIids() {
		return numIids;
	}

	public void setNumIids(String numIids) {
		this.numIids = numIids;
	}

	public String getAdzoneId() {
		return adzoneId;
	}

	public void setAdzoneId(String adzoneId) {
		this.adzoneId = adzoneId;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public String getDx() {
		return dx;
	}

	public void setDx(String dx) {
		this.dx = dx;
	}

	public Map<String, String> getTextParams() {
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("fields", this.fields);
		txtParams.put("numIids", this.numIids);
		txtParams.put("adzoneId", this.adzoneId);
		txtParams.put("platform", this.platform);
		txtParams.put("unid", this.unid);
		txtParams.put("dx", this.dx);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<TbkItemConvertResponse> getResponseClass() {
		return TbkItemConvertResponse.class;
	}

	public void check() throws ApiRuleException {
	}
	

}