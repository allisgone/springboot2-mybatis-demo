package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.TaobaoObject;
import java.util.Date;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.tbk.dg.newuser.order.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TbkDgNewuserOrderGetResponse extends TaobaoResponse {

	private static final long serialVersionUID = 3845581173281821482L;

	/** 
	 * data
	 */
	@ApiField("results")
	private Results results;


	public void setResults(Results results) {
		this.results = results;
	}
	public Results getResults( ) {
		return this.results;
	}
	
	/**
 * 复购订单，仅适用于手淘拉新
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class OrderData extends TaobaoObject {

	private static final long serialVersionUID = 6155396984829594548L;

	/**
		 * 预估佣金
		 */
		@ApiField("commission")
		private String commission;
		/**
		 * 收货时间
		 */
		@ApiField("confirm_receive_time")
		private String confirmReceiveTime;
		/**
		 * 订单号
		 */
		@ApiField("order_no")
		private String orderNo;
		/**
		 * 支付时间
		 */
		@ApiField("pay_time")
		private String payTime;
	

	public String getCommission() {
			return this.commission;
		}
		public void setCommission(String commission) {
			this.commission = commission;
		}
		public String getConfirmReceiveTime() {
			return this.confirmReceiveTime;
		}
		public void setConfirmReceiveTime(String confirmReceiveTime) {
			this.confirmReceiveTime = confirmReceiveTime;
		}
		public String getOrderNo() {
			return this.orderNo;
		}
		public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
		}
		public String getPayTime() {
			return this.payTime;
		}
		public void setPayTime(String payTime) {
			this.payTime = payTime;
		}

}

	/**
 * resultList
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class MapData extends TaobaoObject {

	private static final long serialVersionUID = 6331186566494937626L;

	/**
		 * 确认收货时间，仅天猫拉新适用
		 */
		@ApiField("accept_time")
		private Date acceptTime;
		/**
		 * 活动id
		 */
		@ApiField("activity_id")
		private String activityId;
		/**
		 * 活动类型，taobao-淘宝 alipay-支付宝 tmall-天猫
		 */
		@ApiField("activity_type")
		private String activityType;
		/**
		 * 来源广告位ID(pid中mm_1_2_3)中第3位
		 */
		@ApiField("adzone_id")
		private Long adzoneId;
		/**
		 * 来源广告位名称
		 */
		@ApiField("adzone_name")
		private String adzoneName;
		/**
		 * 绑卡日期，仅适用于手淘拉新
		 */
		@ApiField("bind_card_time")
		private Date bindCardTime;
		/**
		 * 当前活动为淘宝拉新活动时，bind_time为新激活时间； 当前活动为支付宝拉新活动时，bind_time为绑定时间。
		 */
		@ApiField("bind_time")
		private Date bindTime;
		/**
		 * 日期，格式为"20180202"
		 */
		@ApiField("biz_date")
		private String bizDate;
		/**
		 * 首购时间，仅淘宝，天猫拉新适用
		 */
		@ApiField("buy_time")
		private Date buyTime;
		/**
		 * 领取权益时间
		 */
		@ApiField("get_rights_time")
		private Date getRightsTime;
		/**
		 * 银行卡是否是绑定状态：1-绑定，0-未绑定
		 */
		@ApiField("is_card_save")
		private Long isCardSave;
		/**
		 * loginTime
		 */
		@ApiField("login_time")
		private Date loginTime;
		/**
		 * 来源媒体ID(pid中mm_1_2_3)中第1位
		 */
		@ApiField("member_id")
		private Long memberId;
		/**
		 * 来源媒体名称
		 */
		@ApiField("member_nick")
		private String memberNick;
		/**
		 * 新人手机号
		 */
		@ApiField("mobile")
		private String mobile;
		/**
		 * 订单淘客类型:1.淘客订单；2.非淘客订单，仅淘宝，天猫拉新适用
		 */
		@ApiField("order_tk_type")
		private Long orderTkType;
		/**
		 * 复购订单，仅适用于手淘拉新
		 */
		@ApiListField("orders")
		@ApiField("order_data")
		private List<OrderData> orders;
		/**
		 * 领取红包时间，仅天猫拉新适用
		 */
		@ApiField("receive_time")
		private Date receiveTime;
		/**
		 * 新注册时间，仅淘宝拉新适用
		 */
		@ApiField("register_time")
		private Date registerTime;
		/**
		 * 渠道关系id
		 */
		@ApiField("relation_id")
		private String relationId;
		/**
		 * 来源站点ID(pid中mm_1_2_3)中第2位
		 */
		@ApiField("site_id")
		private Long siteId;
		/**
		 * 来源站点名称
		 */
		@ApiField("site_name")
		private String siteName;
		/**
		 * 新人状态， 当前活动为淘宝拉新活动时，1: 新注册，2:激活，3:首购，4:确认收货； 当前活动为支付宝实名活动时，1：已绑定，2：拉新成功，3：无效用户；当前活动为支付宝新登活动时，3：手淘首购，4：手淘确认收货；当前活动为天猫拉新活动时，2:已领取，3:已首购，4:已收货
		 */
		@ApiField("status")
		private Long status;
		/**
		 * 拉新成功时间，仅支付宝拉新适用
		 */
		@ApiField("success_time")
		private Date successTime;
		/**
		 * 淘宝订单id，仅淘宝，天猫拉新适用
		 */
		@ApiField("tb_trade_parent_id")
		private Long tbTradeParentId;
		/**
		 * 分享用户(unionid)，仅淘宝，天猫拉新适用
		 */
		@ApiField("union_id")
		private String unionId;
		/**
		 * 使用权益时间
		 */
		@ApiField("use_rights_time")
		private Date useRightsTime;
	

	public Date getAcceptTime() {
			return this.acceptTime;
		}
		public void setAcceptTime(Date acceptTime) {
			this.acceptTime = acceptTime;
		}
		public String getActivityId() {
			return this.activityId;
		}
		public void setActivityId(String activityId) {
			this.activityId = activityId;
		}
		public String getActivityType() {
			return this.activityType;
		}
		public void setActivityType(String activityType) {
			this.activityType = activityType;
		}
		public Long getAdzoneId() {
			return this.adzoneId;
		}
		public void setAdzoneId(Long adzoneId) {
			this.adzoneId = adzoneId;
		}
		public String getAdzoneName() {
			return this.adzoneName;
		}
		public void setAdzoneName(String adzoneName) {
			this.adzoneName = adzoneName;
		}
		public Date getBindCardTime() {
			return this.bindCardTime;
		}
		public void setBindCardTime(Date bindCardTime) {
			this.bindCardTime = bindCardTime;
		}
		public Date getBindTime() {
			return this.bindTime;
		}
		public void setBindTime(Date bindTime) {
			this.bindTime = bindTime;
		}
		public String getBizDate() {
			return this.bizDate;
		}
		public void setBizDate(String bizDate) {
			this.bizDate = bizDate;
		}
		public Date getBuyTime() {
			return this.buyTime;
		}
		public void setBuyTime(Date buyTime) {
			this.buyTime = buyTime;
		}
		public Date getGetRightsTime() {
			return this.getRightsTime;
		}
		public void setGetRightsTime(Date getRightsTime) {
			this.getRightsTime = getRightsTime;
		}
		public Long getIsCardSave() {
			return this.isCardSave;
		}
		public void setIsCardSave(Long isCardSave) {
			this.isCardSave = isCardSave;
		}
		public Date getLoginTime() {
			return this.loginTime;
		}
		public void setLoginTime(Date loginTime) {
			this.loginTime = loginTime;
		}
		public Long getMemberId() {
			return this.memberId;
		}
		public void setMemberId(Long memberId) {
			this.memberId = memberId;
		}
		public String getMemberNick() {
			return this.memberNick;
		}
		public void setMemberNick(String memberNick) {
			this.memberNick = memberNick;
		}
		public String getMobile() {
			return this.mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public Long getOrderTkType() {
			return this.orderTkType;
		}
		public void setOrderTkType(Long orderTkType) {
			this.orderTkType = orderTkType;
		}
		public List<OrderData> getOrders() {
			return this.orders;
		}
		public void setOrders(List<OrderData> orders) {
			this.orders = orders;
		}
		public Date getReceiveTime() {
			return this.receiveTime;
		}
		public void setReceiveTime(Date receiveTime) {
			this.receiveTime = receiveTime;
		}
		public Date getRegisterTime() {
			return this.registerTime;
		}
		public void setRegisterTime(Date registerTime) {
			this.registerTime = registerTime;
		}
		public String getRelationId() {
			return this.relationId;
		}
		public void setRelationId(String relationId) {
			this.relationId = relationId;
		}
		public Long getSiteId() {
			return this.siteId;
		}
		public void setSiteId(Long siteId) {
			this.siteId = siteId;
		}
		public String getSiteName() {
			return this.siteName;
		}
		public void setSiteName(String siteName) {
			this.siteName = siteName;
		}
		public Long getStatus() {
			return this.status;
		}
		public void setStatus(Long status) {
			this.status = status;
		}
		public Date getSuccessTime() {
			return this.successTime;
		}
		public void setSuccessTime(Date successTime) {
			this.successTime = successTime;
		}
		public Long getTbTradeParentId() {
			return this.tbTradeParentId;
		}
		public void setTbTradeParentId(Long tbTradeParentId) {
			this.tbTradeParentId = tbTradeParentId;
		}
		public String getUnionId() {
			return this.unionId;
		}
		public void setUnionId(String unionId) {
			this.unionId = unionId;
		}
		public Date getUseRightsTime() {
			return this.useRightsTime;
		}
		public void setUseRightsTime(Date useRightsTime) {
			this.useRightsTime = useRightsTime;
		}

}

	/**
 * data
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class Data extends TaobaoObject {

	private static final long serialVersionUID = 7482721462138787459L;

	/**
		 * 是否有下一页
		 */
		@ApiField("has_next")
		private Boolean hasNext;
		/**
		 * 页码
		 */
		@ApiField("page_no")
		private Long pageNo;
		/**
		 * 每页大小
		 */
		@ApiField("page_size")
		private Long pageSize;
		/**
		 * resultList
		 */
		@ApiListField("results")
		@ApiField("map_data")
		private List<MapData> results;
	

	public Boolean getHasNext() {
			return this.hasNext;
		}
		public void setHasNext(Boolean hasNext) {
			this.hasNext = hasNext;
		}
		public Long getPageNo() {
			return this.pageNo;
		}
		public void setPageNo(Long pageNo) {
			this.pageNo = pageNo;
		}
		public Long getPageSize() {
			return this.pageSize;
		}
		public void setPageSize(Long pageSize) {
			this.pageSize = pageSize;
		}
		public List<MapData> getResults() {
			return this.results;
		}
		public void setResults(List<MapData> results) {
			this.results = results;
		}

}

	/**
 * data
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class Results extends TaobaoObject {

	private static final long serialVersionUID = 1761391487425132969L;

	/**
		 * data
		 */
		@ApiField("data")
		private Data data;
	

	public Data getData() {
			return this.data;
		}
		public void setData(Data data) {
			this.data = data;
		}

}



}
