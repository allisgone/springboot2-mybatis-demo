package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.tbk.activitylink.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TbkActivitylinkGetResponse extends TaobaoResponse {

	private static final long serialVersionUID = 7124136942698571664L;

	/** 
	 * bizErrorCode
	 */
	@ApiField("biz_error_code")
	private Long bizErrorCode;

	/** 
	 * bizErrorDesc
	 */
	@ApiField("biz_error_desc")
	private String bizErrorDesc;

	/** 
	 * 淘宝联盟官方活动推广URL
	 */
	@ApiField("data")
	private String data;

	/** 
	 * resultCode
	 */
	@ApiField("result_code")
	private Long resultCode;

	/** 
	 * resultMsg
	 */
	@ApiField("result_msg")
	private String resultMsg;


	public void setBizErrorCode(Long bizErrorCode) {
		this.bizErrorCode = bizErrorCode;
	}
	public Long getBizErrorCode( ) {
		return this.bizErrorCode;
	}

	public void setBizErrorDesc(String bizErrorDesc) {
		this.bizErrorDesc = bizErrorDesc;
	}
	public String getBizErrorDesc( ) {
		return this.bizErrorDesc;
	}

	public void setData(String data) {
		this.data = data;
	}
	public String getData( ) {
		return this.data;
	}

	public void setResultCode(Long resultCode) {
		this.resultCode = resultCode;
	}
	public Long getResultCode( ) {
		return this.resultCode;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getResultMsg( ) {
		return this.resultMsg;
	}
	


}
