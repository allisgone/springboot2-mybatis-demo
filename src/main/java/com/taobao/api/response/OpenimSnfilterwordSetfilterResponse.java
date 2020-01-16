package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.openim.snfilterword.setfilter response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class OpenimSnfilterwordSetfilterResponse extends TaobaoResponse {

	private static final long serialVersionUID = 6199251353332172736L;

	/** 
	 * 成功
	 */
	@ApiField("errid")
	private Long errid;

	/** 
	 * 错误原因
	 */
	@ApiField("errmsg")
	private String errmsg;


	public void setErrid(Long errid) {
		this.errid = errid;
	}
	public Long getErrid( ) {
		return this.errid;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getErrmsg( ) {
		return this.errmsg;
	}
	


}
