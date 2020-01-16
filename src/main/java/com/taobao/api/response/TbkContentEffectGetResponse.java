package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.tbk.content.effect.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TbkContentEffectGetResponse extends TaobaoResponse {

	private static final long serialVersionUID = 7273949727178567481L;

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
 * contentEffectList
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class Contenteffectlist extends TaobaoObject {

	private static final long serialVersionUID = 3191687265569269495L;

	/**
		 * 当日直接引导订单数
		 */
		@ApiField("alipay_num")
		private Long alipayNum;
		/**
		 * 内容id
		 */
		@ApiField("content_id")
		private String contentId;
		/**
		 * cpcFee
		 */
		@ApiField("cpc_fee")
		private String cpcFee;
		/**
		 * cpsPreFee
		 */
		@ApiField("cps_pre_fee")
		private String cpsPreFee;
		/**
		 * cpsSettleFee
		 */
		@ApiField("cps_settle_fee")
		private String cpsSettleFee;
		/**
		 * 当日该内容下宝贝点击次数
		 */
		@ApiField("ipv")
		private Long ipv;
		/**
		 * 当日该内容下宝贝点击人数
		 */
		@ApiField("iuv")
		private Long iuv;
		/**
		 * 媒体pid
		 */
		@ApiField("pid")
		private String pid;
		/**
		 * 时间
		 */
		@ApiField("time")
		private String time;
	

	public Long getAlipayNum() {
			return this.alipayNum;
		}
		public void setAlipayNum(Long alipayNum) {
			this.alipayNum = alipayNum;
		}
		public String getContentId() {
			return this.contentId;
		}
		public void setContentId(String contentId) {
			this.contentId = contentId;
		}
		public String getCpcFee() {
			return this.cpcFee;
		}
		public void setCpcFee(String cpcFee) {
			this.cpcFee = cpcFee;
		}
		public String getCpsPreFee() {
			return this.cpsPreFee;
		}
		public void setCpsPreFee(String cpsPreFee) {
			this.cpsPreFee = cpsPreFee;
		}
		public String getCpsSettleFee() {
			return this.cpsSettleFee;
		}
		public void setCpsSettleFee(String cpsSettleFee) {
			this.cpsSettleFee = cpsSettleFee;
		}
		public Long getIpv() {
			return this.ipv;
		}
		public void setIpv(Long ipv) {
			this.ipv = ipv;
		}
		public Long getIuv() {
			return this.iuv;
		}
		public void setIuv(Long iuv) {
			this.iuv = iuv;
		}
		public String getPid() {
			return this.pid;
		}
		public void setPid(String pid) {
			this.pid = pid;
		}
		public String getTime() {
			return this.time;
		}
		public void setTime(String time) {
			this.time = time;
		}

}

	/**
 * model
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class ContentEffectPageDto extends TaobaoObject {

	private static final long serialVersionUID = 6255827513115836723L;

	/**
		 * contentEffectList
		 */
		@ApiListField("content_effect_list")
		@ApiField("contenteffectlist")
		private List<Contenteffectlist> contentEffectList;
	

	public List<Contenteffectlist> getContentEffectList() {
			return this.contentEffectList;
		}
		public void setContentEffectList(List<Contenteffectlist> contentEffectList) {
			this.contentEffectList = contentEffectList;
		}

}

	/**
 * result
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class Result extends TaobaoObject {

	private static final long serialVersionUID = 4765841469248559631L;

	/**
		 * model
		 */
		@ApiField("model")
		private ContentEffectPageDto model;
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
	

	public ContentEffectPageDto getModel() {
			return this.model;
		}
		public void setModel(ContentEffectPageDto model) {
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
