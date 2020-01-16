package com.taobao.api.request;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.internal.util.json.JSONWriter;
import com.taobao.api.response.TbkDgWishListResponse;

/**
 * TOP API: taobao.tbk.dg.wish.list request
 * 
 * @author top auto create
 * @since 1.0, 2019.10.23
 */
public class TbkDgWishListRequest extends BaseTaobaoRequest<TbkDgWishListResponse> {
	
	

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
		return "taobao.tbk.dg.wish.list";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("param0", this.param0);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<TbkDgWishListResponse> getResponseClass() {
		return TbkDgWishListResponse.class;
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

	private static final long serialVersionUID = 5352962476194835259L;

	/**
		 * 清单id
		 */
		@ApiField("wish_list_id")
		private String wishListId;
	

	public String getWishListId() {
			return this.wishListId;
		}
		public void setWishListId(String wishListId) {
			this.wishListId = wishListId;
		}

}


}