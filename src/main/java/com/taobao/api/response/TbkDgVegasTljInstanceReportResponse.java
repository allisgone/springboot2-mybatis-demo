package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.tbk.dg.vegas.tlj.instance.report response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TbkDgVegasTljInstanceReportResponse extends TaobaoResponse {

	private static final long serialVersionUID = 5836289698487934651L;

	/** 
	 * 接口返回model
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
public static class TljInstanceReportDto extends TaobaoObject {

	private static final long serialVersionUID = 2193695372418116849L;

	/**
		 * 引导成交金额
		 */
		@ApiField("alipay_amount")
		private String alipayAmount;
		/**
		 * 退款红包金额
		 */
		@ApiField("fp_refund_amount")
		private String fpRefundAmount;
		/**
		 * 退款红包个数
		 */
		@ApiField("fp_refund_num")
		private Long fpRefundNum;
		/**
		 * 引导预估佣金金额
		 */
		@ApiField("pre_commission_amount")
		private String preCommissionAmount;
		/**
		 * 失效回退金额
		 */
		@ApiField("refund_amount")
		private String refundAmount;
		/**
		 * 失效回退红包个数
		 */
		@ApiField("refund_num")
		private Long refundNum;
		/**
		 * 解冻金额
		 */
		@ApiField("unfreeze_amount")
		private String unfreezeAmount;
		/**
		 * 解冻红包个数
		 */
		@ApiField("unfreeze_num")
		private Long unfreezeNum;
		/**
		 * 红包核销金额
		 */
		@ApiField("use_amount")
		private String useAmount;
		/**
		 * 红包核销个数
		 */
		@ApiField("use_num")
		private Long useNum;
		/**
		 * 红包领取金额
		 */
		@ApiField("win_amount")
		private String winAmount;
		/**
		 * 红包领取个数
		 */
		@ApiField("win_num")
		private Long winNum;
	

	public String getAlipayAmount() {
			return this.alipayAmount;
		}
		public void setAlipayAmount(String alipayAmount) {
			this.alipayAmount = alipayAmount;
		}
		public String getFpRefundAmount() {
			return this.fpRefundAmount;
		}
		public void setFpRefundAmount(String fpRefundAmount) {
			this.fpRefundAmount = fpRefundAmount;
		}
		public Long getFpRefundNum() {
			return this.fpRefundNum;
		}
		public void setFpRefundNum(Long fpRefundNum) {
			this.fpRefundNum = fpRefundNum;
		}
		public String getPreCommissionAmount() {
			return this.preCommissionAmount;
		}
		public void setPreCommissionAmount(String preCommissionAmount) {
			this.preCommissionAmount = preCommissionAmount;
		}
		public String getRefundAmount() {
			return this.refundAmount;
		}
		public void setRefundAmount(String refundAmount) {
			this.refundAmount = refundAmount;
		}
		public Long getRefundNum() {
			return this.refundNum;
		}
		public void setRefundNum(Long refundNum) {
			this.refundNum = refundNum;
		}
		public String getUnfreezeAmount() {
			return this.unfreezeAmount;
		}
		public void setUnfreezeAmount(String unfreezeAmount) {
			this.unfreezeAmount = unfreezeAmount;
		}
		public Long getUnfreezeNum() {
			return this.unfreezeNum;
		}
		public void setUnfreezeNum(Long unfreezeNum) {
			this.unfreezeNum = unfreezeNum;
		}
		public String getUseAmount() {
			return this.useAmount;
		}
		public void setUseAmount(String useAmount) {
			this.useAmount = useAmount;
		}
		public Long getUseNum() {
			return this.useNum;
		}
		public void setUseNum(Long useNum) {
			this.useNum = useNum;
		}
		public String getWinAmount() {
			return this.winAmount;
		}
		public void setWinAmount(String winAmount) {
			this.winAmount = winAmount;
		}
		public Long getWinNum() {
			return this.winNum;
		}
		public void setWinNum(Long winNum) {
			this.winNum = winNum;
		}

}

	/**
 * 接口返回model
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class Result extends TaobaoObject {

	private static final long serialVersionUID = 4247578727389639929L;

	/**
		 * model
		 */
		@ApiField("model")
		private TljInstanceReportDto model;
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
		 * 是否成功
		 */
		@ApiField("success")
		private Boolean success;
	

	public TljInstanceReportDto getModel() {
			return this.model;
		}
		public void setModel(TljInstanceReportDto model) {
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
