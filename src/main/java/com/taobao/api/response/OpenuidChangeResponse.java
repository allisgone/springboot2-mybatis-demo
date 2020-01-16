package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.openuid.change response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class OpenuidChangeResponse extends TaobaoResponse {

	private static final long serialVersionUID = 5848864988874729645L;

	/** 
	 * 转换到新的openUId
	 */
	@ApiField("new_open_uid")
	private String newOpenUid;


	public void setNewOpenUid(String newOpenUid) {
		this.newOpenUid = newOpenUid;
	}
	public String getNewOpenUid( ) {
		return this.newOpenUid;
	}
	


}
