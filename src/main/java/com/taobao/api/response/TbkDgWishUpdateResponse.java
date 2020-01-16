package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.tbk.dg.wish.update response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TbkDgWishUpdateResponse extends TaobaoResponse {

	private static final long serialVersionUID = 6885975251463867481L;

	/** 
	 * 结果
	 */
	@ApiField("data")
	private WishInfo data;


	public void setData(WishInfo data) {
		this.data = data;
	}
	public WishInfo getData( ) {
		return this.data;
	}
	
	/**
 * 结果
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class WishInfo extends TaobaoObject {

	private static final long serialVersionUID = 8543565229985591939L;

	/**
		 * 清单id
		 */
		@ApiField("wish_list_id")
		private String wishListId;
		/**
		 * 清单分享链接
		 */
		@ApiField("wish_list_url")
		private String wishListUrl;
	

	public String getWishListId() {
			return this.wishListId;
		}
		public void setWishListId(String wishListId) {
			this.wishListId = wishListId;
		}
		public String getWishListUrl() {
			return this.wishListUrl;
		}
		public void setWishListUrl(String wishListUrl) {
			this.wishListUrl = wishListUrl;
		}

}



}
