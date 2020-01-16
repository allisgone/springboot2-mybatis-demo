package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;
import java.util.Date;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.item.update response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class ItemUpdateResponse extends TaobaoResponse {

	private static final long serialVersionUID = 5732913962529837491L;

	/** 
	 * 商品结构
	 */
	@ApiField("item")
	private Item item;


	public void setItem(Item item) {
		this.item = item;
	}
	public Item getItem( ) {
		return this.item;
	}
	
	/**
 * 商品结构
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class Item extends TaobaoObject {

	private static final long serialVersionUID = 1384578796643333468L;

	/**
		 * 商品iid
		 */
		@ApiField("iid")
		private String iid;
		/**
		 * 商品修改时间（格式：yyyy-MM-dd HH:mm:ss）
		 */
		@ApiField("modified")
		private Date modified;
		/**
		 * 商品数字id
		 */
		@ApiField("num_iid")
		private Long numIid;
	

	public String getIid() {
			return this.iid;
		}
		public void setIid(String iid) {
			this.iid = iid;
		}
		public Date getModified() {
			return this.modified;
		}
		public void setModified(Date modified) {
			this.modified = modified;
		}
		public Long getNumIid() {
			return this.numIid;
		}
		public void setNumIid(Long numIid) {
			this.numIid = numIid;
		}

}



}
