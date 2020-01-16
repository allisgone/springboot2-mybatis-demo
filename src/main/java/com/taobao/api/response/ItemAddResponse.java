package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;
import java.util.Date;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.item.add response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class ItemAddResponse extends TaobaoResponse {

	private static final long serialVersionUID = 3324579888941123445L;

	/** 
	 * 商品结构,仅有numIid和created返回
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
 * 商品结构,仅有numIid和created返回
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class Item extends TaobaoObject {

	private static final long serialVersionUID = 2779918272395898451L;

	/**
		 * Item的发布时间，目前仅供taobao.item.add和taobao.item.get可用
		 */
		@ApiField("created")
		private Date created;
		/**
		 * 商品iid
		 */
		@ApiField("iid")
		private String iid;
		/**
		 * 商品数字id
		 */
		@ApiField("num_iid")
		private Long numIid;
	

	public Date getCreated() {
			return this.created;
		}
		public void setCreated(Date created) {
			this.created = created;
		}
		public String getIid() {
			return this.iid;
		}
		public void setIid(String iid) {
			this.iid = iid;
		}
		public Long getNumIid() {
			return this.numIid;
		}
		public void setNumIid(Long numIid) {
			this.numIid = numIid;
		}

}



}
