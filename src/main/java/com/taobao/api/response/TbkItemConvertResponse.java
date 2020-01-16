package com.taobao.api.response;

import com.taobao.api.TaobaoResponse;
import com.taobao.api.domain.NTbkItem;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * TOP API: taobao.openuid.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TbkItemConvertResponse extends TaobaoResponse {

	private static final long serialVersionUID = 7367681224619629522L;

	/**
	 * 淘宝客商品
	 */
	@ApiListField("results")
	@ApiField("n_tbk_item")
	private List<NTbkItem> results;


	public void setResults(List<NTbkItem> results) {
		this.results = results;
	}
	public List<NTbkItem> getResults( ) {
		return this.results;
	}




}
