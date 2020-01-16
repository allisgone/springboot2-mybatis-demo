package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.openim.tribe.sendmsg response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class OpenimTribeSendmsgResponse extends TaobaoResponse {

	private static final long serialVersionUID = 6648163379745537456L;

	/** 
	 * 错误信息
	 */
	@ApiField("message")
	private String message;

	/** 
	 * 错误码
	 */
	@ApiField("tribe_code")
	private Long tribeCode;


	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage( ) {
		return this.message;
	}

	public void setTribeCode(Long tribeCode) {
		this.tribeCode = tribeCode;
	}
	public Long getTribeCode( ) {
		return this.tribeCode;
	}
	


}
