package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.tbk.dg.vegas.tlj.create response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TbkDgVegasTljCreateResponse extends TaobaoResponse {

	private static final long serialVersionUID = 4256671122934886952L;

	/** 
	 * result
	 */
	@ApiField("result")
	private Result result;


	public void setResult(Result result) {
		this.result = result;
	}
	public Result getResult( ) {
		return this.result;
	}
	
	/**
 * model
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class RightsInstanceCreateResult extends TaobaoObject {

	private static final long serialVersionUID = 2684445653527294671L;

	/**
		 * 淘礼金Id
		 */
		@ApiField("rights_id")
		private String rightsId;
		/**
		 * 淘礼金领取Url
		 */
		@ApiField("send_url")
		private String sendUrl;
		/**
		 * 投放code
		 */
		@ApiField("vegas_code")
		private String vegasCode;
	

	public String getRightsId() {
			return this.rightsId;
		}
		public void setRightsId(String rightsId) {
			this.rightsId = rightsId;
		}
		public String getSendUrl() {
			return this.sendUrl;
		}
		public void setSendUrl(String sendUrl) {
			this.sendUrl = sendUrl;
		}
		public String getVegasCode() {
			return this.vegasCode;
		}
		public void setVegasCode(String vegasCode) {
			this.vegasCode = vegasCode;
		}

}

	/**
 * result
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class Result extends TaobaoObject {

	private static final long serialVersionUID = 4185367215661724426L;

	/**
		 * model
		 */
		@ApiField("model")
		private RightsInstanceCreateResult model;
		/**
		 * msgCode
		 */
		@ApiField("msg_code")
		private String msgCode;
		/**
		 * msgInfo
		 */
		@ApiField("msg_info")
		private String msgInfo;
		/**
		 * success
		 */
		@ApiField("success")
		private Boolean success;
	

	public RightsInstanceCreateResult getModel() {
			return this.model;
		}
		public void setModel(RightsInstanceCreateResult model) {
			this.model = model;
		}
		public String getMsgCode() {
			return this.msgCode;
		}
		public void setMsgCode(String msgCode) {
			this.msgCode = msgCode;
		}
		public String getMsgInfo() {
			return this.msgInfo;
		}
		public void setMsgInfo(String msgInfo) {
			this.msgInfo = msgInfo;
		}
		public Boolean getSuccess() {
			return this.success;
		}
		public void setSuccess(Boolean success) {
			this.success = success;
		}

}



}
