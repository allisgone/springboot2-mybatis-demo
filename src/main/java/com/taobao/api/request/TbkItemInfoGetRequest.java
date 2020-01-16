package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.TbkItemInfoGetResponse;

/**
 * TOP API: taobao.tbk.item.info.get request
 * 
 * @author top auto create
 * @since 1.0, 2019.10.31
 */
public class TbkItemInfoGetRequest extends BaseTaobaoRequest<TbkItemInfoGetResponse> {
	
	

	/** 
	* ip地址，影响邮费获取，如果不传或者传入不准确，邮费无法精准提供
	 */
	private String ip;

	/** 
	* 商品ID串，用,分割，最大40个
	 */
	private String numIids;

	/** 
	* 链接形式：1：PC，2：无线，默认：１
	 */
	private Long platform;

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return this.ip;
	}

	public void setNumIids(String numIids) {
		this.numIids = numIids;
	}

	public String getNumIids() {
		return this.numIids;
	}

	public void setPlatform(Long platform) {
		this.platform = platform;
	}

	public Long getPlatform() {
		return this.platform;
	}

	public String getApiMethodName() {
		return "taobao.tbk.item.info.get";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("ip", this.ip);
		txtParams.put("num_iids", this.numIids);
		txtParams.put("platform", this.platform);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<TbkItemInfoGetResponse> getResponseClass() {
		return TbkItemInfoGetResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(numIids, "numIids");
	}
	

}