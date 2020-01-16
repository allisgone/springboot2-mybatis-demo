package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.baichuan.item.filter response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class BaichuanItemFilterResponse extends TaobaoResponse {

	private static final long serialVersionUID = 7891182346848543435L;

	/** 
	 * 百川接口返回的对象
	 */
	@ApiField("result")
	private ItemFilterResponse result;


	public void setResult(ItemFilterResponse result) {
		this.result = result;
	}
	public ItemFilterResponse getResult( ) {
		return this.result;
	}
	
	/**
 * 百川接口返回的对象
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class ItemFilterResponse extends TaobaoObject {

	private static final long serialVersionUID = 4825838698281731693L;

	/**
		 * 无线平台是否能支持商品加入购物车
		 */
		@ApiField("add_cart_supported")
		private Boolean addCartSupported;
		/**
		 * 无线平台是否能支持商品立即购买
		 */
		@ApiField("buy_now_supported")
		private Boolean buyNowSupported;
		/**
		 * 错误码
		 */
		@ApiField("error_code")
		private String errorCode;
		/**
		 * 错误信息描述
		 */
		@ApiField("error_message")
		private String errorMessage;
		/**
		 * 商品id
		 */
		@ApiField("item_id")
		private Long itemId;
		/**
		 * 不支持的原因
		 */
		@ApiField("reason")
		private String reason;
		/**
		 * 无线平台是否能支持商品交易流程
		 */
		@ApiField("supported")
		private Boolean supported;
		/**
		 * 商品详情应该使用的h5页面
		 */
		@ApiField("uniq_detail_url")
		private String uniqDetailUrl;
	

	public Boolean getAddCartSupported() {
			return this.addCartSupported;
		}
		public void setAddCartSupported(Boolean addCartSupported) {
			this.addCartSupported = addCartSupported;
		}
		public Boolean getBuyNowSupported() {
			return this.buyNowSupported;
		}
		public void setBuyNowSupported(Boolean buyNowSupported) {
			this.buyNowSupported = buyNowSupported;
		}
		public String getErrorCode() {
			return this.errorCode;
		}
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}
		public String getErrorMessage() {
			return this.errorMessage;
		}
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
		public Long getItemId() {
			return this.itemId;
		}
		public void setItemId(Long itemId) {
			this.itemId = itemId;
		}
		public String getReason() {
			return this.reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
		public Boolean getSupported() {
			return this.supported;
		}
		public void setSupported(Boolean supported) {
			this.supported = supported;
		}
		public String getUniqDetailUrl() {
			return this.uniqDetailUrl;
		}
		public void setUniqDetailUrl(String uniqDetailUrl) {
			this.uniqDetailUrl = uniqDetailUrl;
		}

}



}
