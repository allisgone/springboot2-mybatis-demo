package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.tbk.item.info.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TbkItemInfoGetResponse extends TaobaoResponse {

	private static final long serialVersionUID = 2497488121848713663L;

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
	
	/**
 * 淘宝客商品
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class NTbkItem extends TaobaoObject {

	private static final long serialVersionUID = 4139687641473797717L;

	/**
		 * 叶子类目名称
		 */
		@ApiField("cat_leaf_name")
		private String catLeafName;
		/**
		 * 一级类目名称
		 */
		@ApiField("cat_name")
		private String catName;
		/**
		 * 是否包邮
		 */
		@ApiField("free_shipment")
		private Boolean freeShipment;
		/**
		 * 好评率是否高于行业均值
		 */
		@ApiField("h_good_rate")
		private Boolean hGoodRate;
		/**
		 * 成交转化是否高于行业均值
		 */
		@ApiField("h_pay_rate30")
		private Boolean hPayRate30;
		/**
		 * 退款率是否低于行业均值
		 */
		@ApiField("i_rfd_rate")
		private Boolean iRfdRate;
		/**
		 * 是否加入消费者保障
		 */
		@ApiField("is_prepay")
		private Boolean isPrepay;
		/**
		 * 商品链接
		 */
		@ApiField("item_url")
		private String itemUrl;
		/**
		 * 聚划算满减  -结束时间（毫秒）
		 */
		@ApiField("ju_play_end_time")
		private Long juPlayEndTime;
		/**
		 * 聚划算满减  -开始时间（毫秒）
		 */
		@ApiField("ju_play_start_time")
		private Long juPlayStartTime;
		/**
		 * 商品库类型，支持多库类型输出，以英文逗号分隔“,”分隔，1:营销商品主推库，2. 内容商品库，如果值为空则不属于1，2这两种商品类型
		 */
		@ApiField("material_lib_type")
		private String materialLibType;
		/**
		 * 店铺名称
		 */
		@ApiField("nick")
		private String nick;
		/**
		 * 商品ID
		 */
		@ApiField("num_iid")
		private Long numIid;
		/**
		 * 商品主图
		 */
		@ApiField("pict_url")
		private String pictUrl;
		/**
		 * 1聚划算满减：满N件减X元，满N件X折，满N件X元）  2天猫限时抢：前N分钟每件X元，前N分钟满N件每件X元，前N件每件X元）
		 */
		@ApiField("play_info")
		private String playInfo;
		/**
		 * 预售商品-定金（元）
		 */
		@ApiField("presale_deposit")
		private String presaleDeposit;
		/**
		 * 预售商品-商品优惠信息
		 */
		@ApiField("presale_discount_fee_text")
		private String presaleDiscountFeeText;
		/**
		 * 预售商品-付定金结束时间（毫秒）
		 */
		@ApiField("presale_end_time")
		private Long presaleEndTime;
		/**
		 * 预售商品-付定金开始时间（毫秒）
		 */
		@ApiField("presale_start_time")
		private Long presaleStartTime;
		/**
		 * 预售商品-付定金结束时间（毫秒）
		 */
		@ApiField("presale_tail_end_time")
		private Long presaleTailEndTime;
		/**
		 * 预售商品-付尾款开始时间（毫秒）
		 */
		@ApiField("presale_tail_start_time")
		private Long presaleTailStartTime;
		/**
		 * 商品所在地
		 */
		@ApiField("provcity")
		private String provcity;
		/**
		 * 卖家等级
		 */
		@ApiField("ratesum")
		private Long ratesum;
		/**
		 * 商品一口价格
		 */
		@ApiField("reserve_price")
		private String reservePrice;
		/**
		 * 卖家id
		 */
		@ApiField("seller_id")
		private Long sellerId;
		/**
		 * 店铺dsr 评分
		 */
		@ApiField("shop_dsr")
		private Long shopDsr;
		/**
		 * 商品小图列表
		 */
		@ApiListField("small_images")
		@ApiField("string")
		private List<String> smallImages;
		/**
		 * 商品标题
		 */
		@ApiField("title")
		private String title;
		/**
		 * 天猫限时抢可售  -结束时间（毫秒）
		 */
		@ApiField("tmall_play_activity_end_time")
		private Long tmallPlayActivityEndTime;
		/**
		 * 天猫限时抢可售  -开始时间（毫秒）
		 */
		@ApiField("tmall_play_activity_start_time")
		private Long tmallPlayActivityStartTime;
		/**
		 * 卖家类型，0表示集市，1表示商城
		 */
		@ApiField("user_type")
		private Long userType;
		/**
		 * 30天销量
		 */
		@ApiField("volume")
		private Long volume;
		/**
		 * 折扣价（元） 若属于预售商品，付定金时间内，折扣价=预售价
		 */
		@ApiField("zk_final_price")
		private String zkFinalPrice;
	

	public String getCatLeafName() {
			return this.catLeafName;
		}
		public void setCatLeafName(String catLeafName) {
			this.catLeafName = catLeafName;
		}
		public String getCatName() {
			return this.catName;
		}
		public void setCatName(String catName) {
			this.catName = catName;
		}
		public Boolean getFreeShipment() {
			return this.freeShipment;
		}
		public void setFreeShipment(Boolean freeShipment) {
			this.freeShipment = freeShipment;
		}
		public Boolean gethGoodRate() {
			return this.hGoodRate;
		}
		public void sethGoodRate(Boolean hGoodRate) {
			this.hGoodRate = hGoodRate;
		}
		public Boolean gethPayRate30() {
			return this.hPayRate30;
		}
		public void sethPayRate30(Boolean hPayRate30) {
			this.hPayRate30 = hPayRate30;
		}
		public Boolean getiRfdRate() {
			return this.iRfdRate;
		}
		public void setiRfdRate(Boolean iRfdRate) {
			this.iRfdRate = iRfdRate;
		}
		public Boolean getIsPrepay() {
			return this.isPrepay;
		}
		public void setIsPrepay(Boolean isPrepay) {
			this.isPrepay = isPrepay;
		}
		public String getItemUrl() {
			return this.itemUrl;
		}
		public void setItemUrl(String itemUrl) {
			this.itemUrl = itemUrl;
		}
		public Long getJuPlayEndTime() {
			return this.juPlayEndTime;
		}
		public void setJuPlayEndTime(Long juPlayEndTime) {
			this.juPlayEndTime = juPlayEndTime;
		}
		public Long getJuPlayStartTime() {
			return this.juPlayStartTime;
		}
		public void setJuPlayStartTime(Long juPlayStartTime) {
			this.juPlayStartTime = juPlayStartTime;
		}
		public String getMaterialLibType() {
			return this.materialLibType;
		}
		public void setMaterialLibType(String materialLibType) {
			this.materialLibType = materialLibType;
		}
		public String getNick() {
			return this.nick;
		}
		public void setNick(String nick) {
			this.nick = nick;
		}
		public Long getNumIid() {
			return this.numIid;
		}
		public void setNumIid(Long numIid) {
			this.numIid = numIid;
		}
		public String getPictUrl() {
			return this.pictUrl;
		}
		public void setPictUrl(String pictUrl) {
			this.pictUrl = pictUrl;
		}
		public String getPlayInfo() {
			return this.playInfo;
		}
		public void setPlayInfo(String playInfo) {
			this.playInfo = playInfo;
		}
		public String getPresaleDeposit() {
			return this.presaleDeposit;
		}
		public void setPresaleDeposit(String presaleDeposit) {
			this.presaleDeposit = presaleDeposit;
		}
		public String getPresaleDiscountFeeText() {
			return this.presaleDiscountFeeText;
		}
		public void setPresaleDiscountFeeText(String presaleDiscountFeeText) {
			this.presaleDiscountFeeText = presaleDiscountFeeText;
		}
		public Long getPresaleEndTime() {
			return this.presaleEndTime;
		}
		public void setPresaleEndTime(Long presaleEndTime) {
			this.presaleEndTime = presaleEndTime;
		}
		public Long getPresaleStartTime() {
			return this.presaleStartTime;
		}
		public void setPresaleStartTime(Long presaleStartTime) {
			this.presaleStartTime = presaleStartTime;
		}
		public Long getPresaleTailEndTime() {
			return this.presaleTailEndTime;
		}
		public void setPresaleTailEndTime(Long presaleTailEndTime) {
			this.presaleTailEndTime = presaleTailEndTime;
		}
		public Long getPresaleTailStartTime() {
			return this.presaleTailStartTime;
		}
		public void setPresaleTailStartTime(Long presaleTailStartTime) {
			this.presaleTailStartTime = presaleTailStartTime;
		}
		public String getProvcity() {
			return this.provcity;
		}
		public void setProvcity(String provcity) {
			this.provcity = provcity;
		}
		public Long getRatesum() {
			return this.ratesum;
		}
		public void setRatesum(Long ratesum) {
			this.ratesum = ratesum;
		}
		public String getReservePrice() {
			return this.reservePrice;
		}
		public void setReservePrice(String reservePrice) {
			this.reservePrice = reservePrice;
		}
		public Long getSellerId() {
			return this.sellerId;
		}
		public void setSellerId(Long sellerId) {
			this.sellerId = sellerId;
		}
		public Long getShopDsr() {
			return this.shopDsr;
		}
		public void setShopDsr(Long shopDsr) {
			this.shopDsr = shopDsr;
		}
		public List<String> getSmallImages() {
			return this.smallImages;
		}
		public void setSmallImages(List<String> smallImages) {
			this.smallImages = smallImages;
		}
		public String getTitle() {
			return this.title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Long getTmallPlayActivityEndTime() {
			return this.tmallPlayActivityEndTime;
		}
		public void setTmallPlayActivityEndTime(Long tmallPlayActivityEndTime) {
			this.tmallPlayActivityEndTime = tmallPlayActivityEndTime;
		}
		public Long getTmallPlayActivityStartTime() {
			return this.tmallPlayActivityStartTime;
		}
		public void setTmallPlayActivityStartTime(Long tmallPlayActivityStartTime) {
			this.tmallPlayActivityStartTime = tmallPlayActivityStartTime;
		}
		public Long getUserType() {
			return this.userType;
		}
		public void setUserType(Long userType) {
			this.userType = userType;
		}
		public Long getVolume() {
			return this.volume;
		}
		public void setVolume(Long volume) {
			this.volume = volume;
		}
		public String getZkFinalPrice() {
			return this.zkFinalPrice;
		}
		public void setZkFinalPrice(String zkFinalPrice) {
			this.zkFinalPrice = zkFinalPrice;
		}

}



}
