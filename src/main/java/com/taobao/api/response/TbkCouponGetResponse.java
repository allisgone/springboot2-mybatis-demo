package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.tbk.coupon.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TbkCouponGetResponse extends TaobaoResponse {

	private static final long serialVersionUID = 7273245486927135164L;

	/** 
	 * data
	 */
	@ApiField("data")
	private MapData data;


	public void setData(MapData data) {
		this.data = data;
	}
	public MapData getData( ) {
		return this.data;
	}
	
	/**
 * data
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class MapData extends TaobaoObject {

	private static final long serialVersionUID = 6382829168644236393L;

	/**
		 * 券ID
		 */
		@ApiField("coupon_activity_id")
		private String couponActivityId;
		/**
		 * 优惠券金额
		 */
		@ApiField("coupon_amount")
		private String couponAmount;
		/**
		 * 优惠券结束时间
		 */
		@ApiField("coupon_end_time")
		private String couponEndTime;
		/**
		 * 优惠券剩余量
		 */
		@ApiField("coupon_remain_count")
		private Long couponRemainCount;
		/**
		 * 券类型，1 表示全网公开券，4 表示妈妈渠道券
		 */
		@ApiField("coupon_src_scene")
		private Long couponSrcScene;
		/**
		 * 优惠券门槛金额
		 */
		@ApiField("coupon_start_fee")
		private String couponStartFee;
		/**
		 * 优惠券开始时间
		 */
		@ApiField("coupon_start_time")
		private String couponStartTime;
		/**
		 * 优惠券总量
		 */
		@ApiField("coupon_total_count")
		private Long couponTotalCount;
		/**
		 * 券属性，0表示店铺券，1表示单品券
		 */
		@ApiField("coupon_type")
		private Long couponType;
	

	public String getCouponActivityId() {
			return this.couponActivityId;
		}
		public void setCouponActivityId(String couponActivityId) {
			this.couponActivityId = couponActivityId;
		}
		public String getCouponAmount() {
			return this.couponAmount;
		}
		public void setCouponAmount(String couponAmount) {
			this.couponAmount = couponAmount;
		}
		public String getCouponEndTime() {
			return this.couponEndTime;
		}
		public void setCouponEndTime(String couponEndTime) {
			this.couponEndTime = couponEndTime;
		}
		public Long getCouponRemainCount() {
			return this.couponRemainCount;
		}
		public void setCouponRemainCount(Long couponRemainCount) {
			this.couponRemainCount = couponRemainCount;
		}
		public Long getCouponSrcScene() {
			return this.couponSrcScene;
		}
		public void setCouponSrcScene(Long couponSrcScene) {
			this.couponSrcScene = couponSrcScene;
		}
		public String getCouponStartFee() {
			return this.couponStartFee;
		}
		public void setCouponStartFee(String couponStartFee) {
			this.couponStartFee = couponStartFee;
		}
		public String getCouponStartTime() {
			return this.couponStartTime;
		}
		public void setCouponStartTime(String couponStartTime) {
			this.couponStartTime = couponStartTime;
		}
		public Long getCouponTotalCount() {
			return this.couponTotalCount;
		}
		public void setCouponTotalCount(Long couponTotalCount) {
			this.couponTotalCount = couponTotalCount;
		}
		public Long getCouponType() {
			return this.couponType;
		}
		public void setCouponType(Long couponType) {
			this.couponType = couponType;
		}

}



}
