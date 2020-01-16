package com.taobao.api.request;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.internal.util.json.JSONWriter;
import com.taobao.api.response.TbkContentEffectGetResponse;

/**
 * TOP API: taobao.tbk.content.effect.get request
 * 
 * @author top auto create
 * @since 1.0, 2019.07.04
 */
public class TbkContentEffectGetRequest extends BaseTaobaoRequest<TbkContentEffectGetResponse> {
	
	

	/** 
	* 入参
	 */
	private String option;

	public void setOption(String option) {
		this.option = option;
	}

	public void setOption(ContentEffectPageOption option) {
		this.option = new JSONWriter(false,true).write(option);
	}

	public String getOption() {
		return this.option;
	}

	public String getApiMethodName() {
		return "taobao.tbk.content.effect.get";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("option", this.option);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<TbkContentEffectGetResponse> getResponseClass() {
		return TbkContentEffectGetResponse.class;
	}

	public void check() throws ApiRuleException {
	}
	
	/**
 * 入参
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class ContentEffectPageOption extends TaobaoObject {

	private static final long serialVersionUID = 1395831531292711738L;

	/**
		 * 内容id，如不指定则不做为筛选条件
		 */
		@ApiField("content_id")
		private String contentId;
		/**
		 * 页码从1开始
		 */
		@ApiField("page_no")
		private Long pageNo;
		/**
		 * 页数，最大1000
		 */
		@ApiField("page_size")
		private Long pageSize;
		/**
		 * 如若不传则不做为筛选条件
		 */
		@ApiField("pid")
		private String pid;
		/**
		 * 选择效果日期，如果不传即按日期倒序排
		 */
		@ApiField("time")
		private String time;
	

	public String getContentId() {
			return this.contentId;
		}
		public void setContentId(String contentId) {
			this.contentId = contentId;
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
		public String getPid() {
			return this.pid;
		}
		public void setPid(String pid) {
			this.pid = pid;
		}
		public String getTime() {
			return this.time;
		}
		public void setTime(String time) {
			this.time = time;
		}

}


}