package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.tbk.dg.newuser.order.sum response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TbkDgNewuserOrderSumResponse extends TaobaoResponse {

	private static final long serialVersionUID = 4753689292974968685L;

	/** 
	 * data
	 */
	@ApiField("results")
	private Data results;


	public void setResults(Data results) {
		this.results = results;
	}
	public Data getResults( ) {
		return this.results;
	}
	
	/**
 * resultList
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class Data extends TaobaoObject {

	private static final long serialVersionUID = 2232699643743328446L;

	/**
		 * 活动ID
		 */
		@ApiField("activity_id")
		private String activityId;
		/**
		 * 首购用户数
		 */
		@ApiField("alipay_user_cnt")
		private Long alipayUserCnt;
		/**
		 * 结算CPA 奖励金额：仅支持member 维度的统计
		 */
		@ApiField("alipay_user_cpa_pre_amt")
		private String alipayUserCpaPreAmt;
		/**
		 * 当日激活且首购结算的CPA 金额：仅适用于八天乐，仅支持member维度的统计
		 */
		@ApiField("bind_buy_user_cpa_pre_amt")
		private String bindBuyUserCpaPreAmt;
		/**
		 * 当日激活且首购的有效用户数：仅适用于八天乐，支持member，adzone维度的统计
		 */
		@ApiField("bind_buy_valid_user_cnt")
		private Long bindBuyValidUserCnt;
		/**
		 * bindCardValidUserCnt
		 */
		@ApiField("bind_card_valid_user_cnt")
		private Long bindCardValidUserCnt;
		/**
		 * 日期
		 */
		@ApiField("biz_date")
		private String bizDate;
		/**
		 * 新激活用户数
		 */
		@ApiField("login_user_cnt")
		private Long loginUserCnt;
		/**
		 * 确认收货用户数
		 */
		@ApiField("rcv_user_cnt")
		private Long rcvUserCnt;
		/**
		 * 结算有效用户数
		 */
		@ApiField("rcv_valid_user_cnt")
		private Long rcvValidUserCnt;
		/**
		 * reBuyValidUserCnt
		 */
		@ApiField("re_buy_valid_user_cnt")
		private Long reBuyValidUserCnt;
		/**
		 * 新注册用户数
		 */
		@ApiField("reg_user_cnt")
		private Long regUserCnt;
		/**
		 * 渠道关系id
		 */
		@ApiField("relation_id")
		private String relationId;
		/**
		 * validNum
		 */
		@ApiField("valid_num")
		private Long validNum;
	

	public String getActivityId() {
			return this.activityId;
		}
		public void setActivityId(String activityId) {
			this.activityId = activityId;
		}
		public Long getAlipayUserCnt() {
			return this.alipayUserCnt;
		}
		public void setAlipayUserCnt(Long alipayUserCnt) {
			this.alipayUserCnt = alipayUserCnt;
		}
		public String getAlipayUserCpaPreAmt() {
			return this.alipayUserCpaPreAmt;
		}
		public void setAlipayUserCpaPreAmt(String alipayUserCpaPreAmt) {
			this.alipayUserCpaPreAmt = alipayUserCpaPreAmt;
		}
		public String getBindBuyUserCpaPreAmt() {
			return this.bindBuyUserCpaPreAmt;
		}
		public void setBindBuyUserCpaPreAmt(String bindBuyUserCpaPreAmt) {
			this.bindBuyUserCpaPreAmt = bindBuyUserCpaPreAmt;
		}
		public Long getBindBuyValidUserCnt() {
			return this.bindBuyValidUserCnt;
		}
		public void setBindBuyValidUserCnt(Long bindBuyValidUserCnt) {
			this.bindBuyValidUserCnt = bindBuyValidUserCnt;
		}
		public Long getBindCardValidUserCnt() {
			return this.bindCardValidUserCnt;
		}
		public void setBindCardValidUserCnt(Long bindCardValidUserCnt) {
			this.bindCardValidUserCnt = bindCardValidUserCnt;
		}
		public String getBizDate() {
			return this.bizDate;
		}
		public void setBizDate(String bizDate) {
			this.bizDate = bizDate;
		}
		public Long getLoginUserCnt() {
			return this.loginUserCnt;
		}
		public void setLoginUserCnt(Long loginUserCnt) {
			this.loginUserCnt = loginUserCnt;
		}
		public Long getRcvUserCnt() {
			return this.rcvUserCnt;
		}
		public void setRcvUserCnt(Long rcvUserCnt) {
			this.rcvUserCnt = rcvUserCnt;
		}
		public Long getRcvValidUserCnt() {
			return this.rcvValidUserCnt;
		}
		public void setRcvValidUserCnt(Long rcvValidUserCnt) {
			this.rcvValidUserCnt = rcvValidUserCnt;
		}
		public Long getReBuyValidUserCnt() {
			return this.reBuyValidUserCnt;
		}
		public void setReBuyValidUserCnt(Long reBuyValidUserCnt) {
			this.reBuyValidUserCnt = reBuyValidUserCnt;
		}
		public Long getRegUserCnt() {
			return this.regUserCnt;
		}
		public void setRegUserCnt(Long regUserCnt) {
			this.regUserCnt = regUserCnt;
		}
		public String getRelationId() {
			return this.relationId;
		}
		public void setRelationId(String relationId) {
			this.relationId = relationId;
		}
		public Long getValidNum() {
			return this.validNum;
		}
		public void setValidNum(Long validNum) {
			this.validNum = validNum;
		}

}



}
