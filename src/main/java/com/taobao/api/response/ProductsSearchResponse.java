package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.products.search response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class ProductsSearchResponse extends TaobaoResponse {

	private static final long serialVersionUID = 1749817165534254199L;

	/** 
	 * 返回具体信息为入参fields请求的字段信息
	 */
	@ApiListField("products")
	@ApiField("product")
	private List<Product> products;

	/** 
	 * 结果总数
	 */
	@ApiField("total_results")
	private Long totalResults;


	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Product> getProducts( ) {
		return this.products;
	}

	public void setTotalResults(Long totalResults) {
		this.totalResults = totalResults;
	}
	public Long getTotalResults( ) {
		return this.totalResults;
	}
	
	/**
 * 返回具体信息为入参fields请求的字段信息
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class Product extends TaobaoObject {

	private static final long serialVersionUID = 2475365997981878524L;

	/**
		 * 商品类目ID.必须是叶子类目ID
		 */
		@ApiField("cid")
		private Long cid;
		/**
		 * 产品名称
		 */
		@ApiField("name")
		private String name;
		/**
		 * 产品的主图片地址.(绝对地址,格式:http:hostimage_path)
		 */
		@ApiField("pic_url")
		private String picUrl;
		/**
		 * 产品的市场价.单位为元.精确到2位小数;如:200.07
		 */
		@ApiField("price")
		private String price;
		/**
		 * 产品ID
		 */
		@ApiField("product_id")
		private Long productId;
		/**
		 * 产品的关键属性列表.格式：pid:vid;pid:vid
		 */
		@ApiField("props")
		private String props;
		/**
		 * 当前状态(0 商家确认 1 屏蔽 3 小二确认 2 未确认 -1 删除)
		 */
		@ApiField("status")
		private Long status;
		/**
		 * 淘宝标准产品编码
		 */
		@ApiField("tsc")
		private String tsc;
	

	public Long getCid() {
			return this.cid;
		}
		public void setCid(Long cid) {
			this.cid = cid;
		}
		public String getName() {
			return this.name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPicUrl() {
			return this.picUrl;
		}
		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}
		public String getPrice() {
			return this.price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public Long getProductId() {
			return this.productId;
		}
		public void setProductId(Long productId) {
			this.productId = productId;
		}
		public String getProps() {
			return this.props;
		}
		public void setProps(String props) {
			this.props = props;
		}
		public Long getStatus() {
			return this.status;
		}
		public void setStatus(Long status) {
			this.status = status;
		}
		public String getTsc() {
			return this.tsc;
		}
		public void setTsc(String tsc) {
			this.tsc = tsc;
		}

}



}
