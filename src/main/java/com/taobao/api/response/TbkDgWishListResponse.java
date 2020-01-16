package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.tbk.dg.wish.list response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TbkDgWishListResponse extends TaobaoResponse {

	private static final long serialVersionUID = 2611948345157834646L;

	/** 
	 * 清单列表
	 */
	@ApiListField("data_list")
	@ApiField("wish_info")
	private List<WishInfo> dataList;


	public void setDataList(List<WishInfo> dataList) {
		this.dataList = dataList;
	}
	public List<WishInfo> getDataList( ) {
		return this.dataList;
	}
	
	/**
 * 清单列表
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class WishInfo extends TaobaoObject {

	private static final long serialVersionUID = 6513556542699248419L;

	/**
		 * 清单商品
		 */
		@ApiListField("item_id_list")
		@ApiField("string")
		private List<String> itemIdList;
		/**
		 * 清单id
		 */
		@ApiField("wish_list_id")
		private String wishListId;
		/**
		 * 清单链接
		 */
		@ApiField("wish_list_url")
		private String wishListUrl;
	

	public List<String> getItemIdList() {
			return this.itemIdList;
		}
		public void setItemIdList(List<String> itemIdList) {
			this.itemIdList = itemIdList;
		}
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
