package com.taobao.api.request;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.TaobaoObject;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.internal.util.json.JSONWriter;
import com.taobao.api.response.TbkDgWishUpdateResponse;

/**
 * TOP API: taobao.tbk.dg.wish.update request
 * 
 * @author top auto create
 * @since 1.0, 2019.10.23
 */
public class TbkDgWishUpdateRequest extends BaseTaobaoRequest<TbkDgWishUpdateResponse> {
	
	

	/** 
	* 参数
	 */
	private String param0;

	public void setParam0(String param0) {
		this.param0 = param0;
	}

	public void setParam0(WishOption param0) {
		this.param0 = new JSONWriter(false,true).write(param0);
	}

	public String getParam0() {
		return this.param0;
	}

	public String getApiMethodName() {
		return "taobao.tbk.dg.wish.update";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("param0", this.param0);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<TbkDgWishUpdateResponse> getResponseClass() {
		return TbkDgWishUpdateResponse.class;
	}

	public void check() throws ApiRuleException {
	}
	
	/**
 * 参数
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class WishOption extends TaobaoObject {

	private static final long serialVersionUID = 5861287314899548279L;

	/**
		 * adzoneid
		 */
		@ApiField("adzone_id")
		private Long adzoneId;
		/**
		 * 商品id列表
		 */
		@ApiListField("item_id_list")
		@ApiField("string")
		private List<String> itemIdList;
		/**
		 * siteId
		 */
		@ApiField("site_id")
		private Long siteId;
		/**
		 * 清单id
		 */
		@ApiField("wish_list_id")
		private String wishListId;
	

	public Long getAdzoneId() {
			return this.adzoneId;
		}
		public void setAdzoneId(Long adzoneId) {
			this.adzoneId = adzoneId;
		}
		public List<String> getItemIdList() {
			return this.itemIdList;
		}
		public void setItemIdList(List<String> itemIdList) {
			this.itemIdList = itemIdList;
		}
		public Long getSiteId() {
			return this.siteId;
		}
		public void setSiteId(Long siteId) {
			this.siteId = siteId;
		}
		public String getWishListId() {
			return this.wishListId;
		}
		public void setWishListId(String wishListId) {
			this.wishListId = wishListId;
		}

}


}