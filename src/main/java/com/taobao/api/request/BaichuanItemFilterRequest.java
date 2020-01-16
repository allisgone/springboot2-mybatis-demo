package com.taobao.api.request;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.internal.util.json.JSONWriter;
import com.taobao.api.response.BaichuanItemFilterResponse;

/**
 * TOP API: taobao.baichuan.item.filter request
 * 
 * @author top auto create
 * @since 1.0, 2018.07.25
 */
public class BaichuanItemFilterRequest extends BaseTaobaoRequest<BaichuanItemFilterResponse> {
	
	

	/** 
	* 筛选接口请求
	 */
	private String itemFilterRequest;

	public void setItemFilterRequest(String itemFilterRequest) {
		this.itemFilterRequest = itemFilterRequest;
	}

	public void setItemFilterRequest(ItemFilterRequest itemFilterRequest) {
		this.itemFilterRequest = new JSONWriter(false,true).write(itemFilterRequest);
	}

	public String getItemFilterRequest() {
		return this.itemFilterRequest;
	}

	public String getApiMethodName() {
		return "taobao.baichuan.item.filter";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("item_filter_request", this.itemFilterRequest);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<BaichuanItemFilterResponse> getResponseClass() {
		return BaichuanItemFilterResponse.class;
	}

	public void check() throws ApiRuleException {
	}
	
	/**
 * 筛选接口请求
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class ItemFilterRequest extends TaobaoObject {

	private static final long serialVersionUID = 5678132149431119427L;

	/**
		 * 第三方app名称
		 */
		@ApiField("app_name")
		private String appName;
		/**
		 * 第三方app的版本号
		 */
		@ApiField("app_version")
		private String appVersion;
		/**
		 * 扩展参数用字符串标示的key：value的形式
		 */
		@ApiField("extra")
		private String extra;
		/**
		 * 商品id
		 */
		@ApiField("item_id")
		private Long itemId;
		/**
		 * 商品详情的PC原始URL
		 */
		@ApiField("src_url")
		private String srcUrl;
		/**
		 * 第三方的app的ua
		 */
		@ApiField("user_agent")
		private String userAgent;
	

	public String getAppName() {
			return this.appName;
		}
		public void setAppName(String appName) {
			this.appName = appName;
		}
		public String getAppVersion() {
			return this.appVersion;
		}
		public void setAppVersion(String appVersion) {
			this.appVersion = appVersion;
		}
		public String getExtra() {
			return this.extra;
		}
		public void setExtra(String extra) {
			this.extra = extra;
		}
		public Long getItemId() {
			return this.itemId;
		}
		public void setItemId(Long itemId) {
			this.itemId = itemId;
		}
		public String getSrcUrl() {
			return this.srcUrl;
		}
		public void setSrcUrl(String srcUrl) {
			this.srcUrl = srcUrl;
		}
		public String getUserAgent() {
			return this.userAgent;
		}
		public void setUserAgent(String userAgent) {
			this.userAgent = userAgent;
		}

}


}