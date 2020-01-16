package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.internal.util.json.JSONValidatingReader;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.tbk.dg.material.optional response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TbkDgMaterialOptionalResponse extends TaobaoResponse {

	private static final long serialVersionUID = 5121538724684262783L;

	/** 
	 * resultList
	 */
	@ApiListField("result_list")
	@ApiField("map_data")
	private List<MapData> resultList;

	/** 
	 * 搜索到符合条件的结果总数
	 */
	@ApiField("total_results")
	private Long totalResults;


	public void setResultList(List<MapData> resultList) {
		this.resultList = resultList;
	}
	public List<MapData> getResultList( ) {
		return this.resultList;
	}

	public void setTotalResults(Long totalResults) {
		this.totalResults = totalResults;
	}
	public Long getTotalResults( ) {
		return this.totalResults;
	}
	
	/**
 * resultList
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class MapData extends TaobaoObject {

	private static final long serialVersionUID = 6862399572244362251L;

	/**
		 * 商品信息-叶子类目id
		 */
		@ApiField("category_id")
		private Long categoryId;
		/**
		 * 商品信息-叶子类目名称
		 */
		@ApiField("category_name")
		private String categoryName;
		/**
		 * 商品信息-佣金比率。1550表示15.5%
		 */
		@ApiField("commission_rate")
		private String commissionRate;
		/**
		 * 商品信息-佣金类型。MKT表示营销计划，SP表示定向计划，COMMON表示通用计划
		 */
		@ApiField("commission_type")
		private String commissionType;
		/**
		 * 优惠券（元） 若属于预售商品，该优惠券付尾款可用，付定金不可用
		 */
		@ApiField("coupon_amount")
		private String couponAmount;
		/**
		 * 优惠券信息-优惠券结束时间
		 */
		@ApiField("coupon_end_time")
		private String couponEndTime;
		/**
		 * 优惠券信息-优惠券id
		 */
		@ApiField("coupon_id")
		private String couponId;
		/**
		 * 优惠券信息-优惠券满减信息
		 */
		@ApiField("coupon_info")
		private String couponInfo;
		/**
		 * 优惠券信息-优惠券剩余量
		 */
		@ApiField("coupon_remain_count")
		private Long couponRemainCount;
		/**
		 * 链接-宝贝+券二合一页面链接
		 */
		@ApiField("coupon_share_url")
		private String couponShareUrl;
		/**
		 * 优惠券信息-优惠券起用门槛，满X元可用。如：满299元减20元
		 */
		@ApiField("coupon_start_fee")
		private String couponStartFee;
		/**
		 * 优惠券信息-优惠券开始时间
		 */
		@ApiField("coupon_start_time")
		private String couponStartTime;
		/**
		 * 优惠券信息-优惠券总量
		 */
		@ApiField("coupon_total_count")
		private Long couponTotalCount;
		/**
		 * 商品信息-是否包含定向计划
		 */
		@ApiField("include_dxjh")
		private String includeDxjh;
		/**
		 * 商品信息-是否包含营销计划
		 */
		@ApiField("include_mkt")
		private String includeMkt;
		/**
		 * 商品信息-定向计划信息
		 */
		@ApiField("info_dxjh")
		private String infoDxjh;
		/**
		 * 商品信息-宝贝描述(推荐理由)
		 */
		@ApiField("item_description")
		private String itemDescription;
		/**
		 * 商品信息-宝贝id
		 */
		@ApiField("item_id")
		private Long itemId;
		/**
		 * 链接-宝贝地址
		 */
		@ApiField("item_url")
		private String itemUrl;
		/**
		 * 拼团专用-拼团几人团
		 */
		@ApiField("jdd_num")
		private Long jddNum;
		/**
		 * 拼团专用-拼团拼成价，单位元
		 */
		@ApiField("jdd_price")
		private String jddPrice;
		/**
		 * 商品信息-一级类目ID
		 */
		@ApiField("level_one_category_id")
		private Long levelOneCategoryId;
		/**
		 * 商品信息-一级类目名称
		 */
		@ApiField("level_one_category_name")
		private String levelOneCategoryName;
		/**
		 * 锁住的佣金率
		 */
		@ApiField("lock_rate")
		private String lockRate;
		/**
		 * 锁佣结束时间
		 */
		@ApiField("lock_rate_end_time")
		private Long lockRateEndTime;
		/**
		 * 锁佣开始时间
		 */
		@ApiField("lock_rate_start_time")
		private Long lockRateStartTime;
		/**
		 * 店铺信息-卖家昵称
		 */
		@ApiField("nick")
		private String nick;
		/**
		 * 商品信息-宝贝id(该字段废弃，请勿再用)
		 */
		@ApiField("num_iid")
		private Long numIid;
		/**
		 * 拼团专用-拼团结束时间
		 */
		@ApiField("oetime")
		private String oetime;
		/**
		 * 拼团专用-拼团一人价（原价)，单位元
		 */
		@ApiField("orig_price")
		private String origPrice;
		/**
		 * 拼团专用-拼团开始时间
		 */
		@ApiField("ostime")
		private String ostime;
		/**
		 * 商品信息-商品主图
		 */
		@ApiField("pict_url")
		private String pictUrl;
		/**
		 * 预售商品-定金（元）
		 */
		@ApiField("presale_deposit")
		private String presaleDeposit;
		/**
		 * 预售商品-优惠
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
		 * 预售商品-付尾款结束时间（毫秒）
		 */
		@ApiField("presale_tail_end_time")
		private Long presaleTailEndTime;
		/**
		 * 预售商品-付尾款开始时间（毫秒）
		 */
		@ApiField("presale_tail_start_time")
		private Long presaleTailStartTime;
		/**
		 * 商品信息-宝贝所在地
		 */
		@ApiField("provcity")
		private String provcity;
		/**
		 * 商品邮费
		 */
		@ApiField("real_post_fee")
		private String realPostFee;
		/**
		 * 商品信息-商品一口价格
		 */
		@ApiField("reserve_price")
		private String reservePrice;
		/**
		 * 拼团专用-拼团已售数量
		 */
		@ApiField("sell_num")
		private Long sellNum;
		/**
		 * 店铺信息-卖家id
		 */
		@ApiField("seller_id")
		private Long sellerId;
		/**
		 * 店铺信息-店铺dsr评分
		 */
		@ApiField("shop_dsr")
		private Long shopDsr;
		/**
		 * 店铺信息-店铺名称
		 */
		@ApiField("shop_title")
		private String shopTitle;
		/**
		 * 商品信息-商品短标题
		 */
		@ApiField("short_title")
		private String shortTitle;
		/**
		 * 商品信息-商品小图列表
		 */
		@ApiListField("small_images")
		@ApiField("string")
		private List<String> smallImages;
		/**
		 * 拼团专用-拼团剩余库存
		 */
		@ApiField("stock")
		private Long stock;
		/**
		 * 商品信息-商品标题
		 */
		@ApiField("title")
		private String title;
		/**
		 * 商品信息-月支出佣金(该字段废弃，请勿再用)
		 */
		@ApiField("tk_total_commi")
		private String tkTotalCommi;
		/**
		 * 商品信息-淘客30天推广量
		 */
		@ApiField("tk_total_sales")
		private String tkTotalSales;
		/**
		 * 营销-天猫营销玩法
		 */
		@ApiField("tmall_play_activity_info")
		private String tmallPlayActivityInfo;
		/**
		 * 拼团专用-拼团库存数量
		 */
		@ApiField("total_stock")
		private Long totalStock;
		/**
		 * 链接-宝贝推广链接
		 */
		@ApiField("url")
		private String url;
		/**
		 * 店铺信息-卖家类型。0表示集市，1表示天猫
		 */
		@ApiField("user_type")
		private Long userType;
		/**
		 * 预售专用-预售数量
		 */
		@ApiField("uv_sum_pre_sale")
		private Long uvSumPreSale;
		/**
		 * 商品信息-30天销量
		 */
		@ApiField("volume")
		private Long volume;
		/**
		 * 商品信息-商品白底图
		 */
		@ApiField("white_image")
		private String whiteImage;
		/**
		 * 链接-物料块id(测试中请勿使用)
		 */
		@ApiField("x_id")
		private String xId;
		/**
		 * 预售有礼-推广链接
		 */
		@ApiField("ysyl_click_url")
		private String ysylClickUrl;
		/**
		 * 预售有礼-佣金比例（ 预售有礼活动享受的推广佣金比例，注：推广该活动有特殊分成规则，请详见：https:tbk.bbs.taobao.comdetail.html?appId=45301&postId=9334376 ）
		 */
		@ApiField("ysyl_commission_rate")
		private String ysylCommissionRate;
		/**
		 * 预售有礼-预估淘礼金（元）
		 */
		@ApiField("ysyl_tlj_face")
		private String ysylTljFace;
		/**
		 * 预售有礼-淘礼金发放时间
		 */
		@ApiField("ysyl_tlj_send_time")
		private String ysylTljSendTime;
		/**
		 * 预售有礼-淘礼金使用结束时间
		 */
		@ApiField("ysyl_tlj_use_end_time")
		private String ysylTljUseEndTime;
		/**
		 * 预售有礼-淘礼金使用开始时间
		 */
		@ApiField("ysyl_tlj_use_start_time")
		private String ysylTljUseStartTime;
		/**
		 * 折扣价（元） 若属于预售商品，付定金时间内，折扣价=预售价
		 */
		@ApiField("zk_final_price")
		private String zkFinalPrice;
	

	public Long getCategoryId() {
			return this.categoryId;
		}
		public void setCategoryId(Long categoryId) {
			this.categoryId = categoryId;
		}
		public String getCategoryName() {
			return this.categoryName;
		}
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		public String getCommissionRate() {
			return this.commissionRate;
		}
		public void setCommissionRate(String commissionRate) {
			this.commissionRate = commissionRate;
		}
		public String getCommissionType() {
			return this.commissionType;
		}
		public void setCommissionType(String commissionType) {
			this.commissionType = commissionType;
		}
		public String getCouponAmount() {
			return this.couponAmount;
		}
		public void setCouponAmount(String couponAmount) {
			this.couponAmount = couponAmount;
		}
		public String getCouponEndTime() {
			return this.couponEndTime;
		}
		public void setCouponEndTime(String couponEndTime) {
			this.couponEndTime = couponEndTime;
		}
		public String getCouponId() {
			return this.couponId;
		}
		public void setCouponId(String couponId) {
			this.couponId = couponId;
		}
		public String getCouponInfo() {
			return this.couponInfo;
		}
		public void setCouponInfo(String couponInfo) {
			this.couponInfo = couponInfo;
		}
		public Long getCouponRemainCount() {
			return this.couponRemainCount;
		}
		public void setCouponRemainCount(Long couponRemainCount) {
			this.couponRemainCount = couponRemainCount;
		}
		public String getCouponShareUrl() {
			return this.couponShareUrl;
		}
		public void setCouponShareUrl(String couponShareUrl) {
			this.couponShareUrl = couponShareUrl;
		}
		public String getCouponStartFee() {
			return this.couponStartFee;
		}
		public void setCouponStartFee(String couponStartFee) {
			this.couponStartFee = couponStartFee;
		}
		public String getCouponStartTime() {
			return this.couponStartTime;
		}
		public void setCouponStartTime(String couponStartTime) {
			this.couponStartTime = couponStartTime;
		}
		public Long getCouponTotalCount() {
			return this.couponTotalCount;
		}
		public void setCouponTotalCount(Long couponTotalCount) {
			this.couponTotalCount = couponTotalCount;
		}
		public String getIncludeDxjh() {
			return this.includeDxjh;
		}
		public void setIncludeDxjh(String includeDxjh) {
			this.includeDxjh = includeDxjh;
		}
		public String getIncludeMkt() {
			return this.includeMkt;
		}
		public void setIncludeMkt(String includeMkt) {
			this.includeMkt = includeMkt;
		}
		public String getInfoDxjh() {
			return this.infoDxjh;
		}
		public void setInfoDxjh(String infoDxjh) {
			this.infoDxjh = infoDxjh;
		}
		public void setInfoDxjhString(String infoDxjh) {
			this.infoDxjh = infoDxjh;
		}
		
		public String getItemDescription() {
			return this.itemDescription;
		}
		public void setItemDescription(String itemDescription) {
			this.itemDescription = itemDescription;
		}
		public Long getItemId() {
			return this.itemId;
		}
		public void setItemId(Long itemId) {
			this.itemId = itemId;
		}
		public String getItemUrl() {
			return this.itemUrl;
		}
		public void setItemUrl(String itemUrl) {
			this.itemUrl = itemUrl;
		}
		public Long getJddNum() {
			return this.jddNum;
		}
		public void setJddNum(Long jddNum) {
			this.jddNum = jddNum;
		}
		public String getJddPrice() {
			return this.jddPrice;
		}
		public void setJddPrice(String jddPrice) {
			this.jddPrice = jddPrice;
		}
		public Long getLevelOneCategoryId() {
			return this.levelOneCategoryId;
		}
		public void setLevelOneCategoryId(Long levelOneCategoryId) {
			this.levelOneCategoryId = levelOneCategoryId;
		}
		public String getLevelOneCategoryName() {
			return this.levelOneCategoryName;
		}
		public void setLevelOneCategoryName(String levelOneCategoryName) {
			this.levelOneCategoryName = levelOneCategoryName;
		}
		public String getLockRate() {
			return this.lockRate;
		}
		public void setLockRate(String lockRate) {
			this.lockRate = lockRate;
		}
		public Long getLockRateEndTime() {
			return this.lockRateEndTime;
		}
		public void setLockRateEndTime(Long lockRateEndTime) {
			this.lockRateEndTime = lockRateEndTime;
		}
		public Long getLockRateStartTime() {
			return this.lockRateStartTime;
		}
		public void setLockRateStartTime(Long lockRateStartTime) {
			this.lockRateStartTime = lockRateStartTime;
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
		public String getOetime() {
			return this.oetime;
		}
		public void setOetime(String oetime) {
			this.oetime = oetime;
		}
		public String getOrigPrice() {
			return this.origPrice;
		}
		public void setOrigPrice(String origPrice) {
			this.origPrice = origPrice;
		}
		public String getOstime() {
			return this.ostime;
		}
		public void setOstime(String ostime) {
			this.ostime = ostime;
		}
		public String getPictUrl() {
			return this.pictUrl;
		}
		public void setPictUrl(String pictUrl) {
			this.pictUrl = pictUrl;
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
		public String getRealPostFee() {
			return this.realPostFee;
		}
		public void setRealPostFee(String realPostFee) {
			this.realPostFee = realPostFee;
		}
		public String getReservePrice() {
			return this.reservePrice;
		}
		public void setReservePrice(String reservePrice) {
			this.reservePrice = reservePrice;
		}
		public Long getSellNum() {
			return this.sellNum;
		}
		public void setSellNum(Long sellNum) {
			this.sellNum = sellNum;
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
		public String getShopTitle() {
			return this.shopTitle;
		}
		public void setShopTitle(String shopTitle) {
			this.shopTitle = shopTitle;
		}
		public String getShortTitle() {
			return this.shortTitle;
		}
		public void setShortTitle(String shortTitle) {
			this.shortTitle = shortTitle;
		}
		public List<String> getSmallImages() {
			return this.smallImages;
		}
		public void setSmallImages(List<String> smallImages) {
			this.smallImages = smallImages;
		}
		public Long getStock() {
			return this.stock;
		}
		public void setStock(Long stock) {
			this.stock = stock;
		}
		public String getTitle() {
			return this.title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getTkTotalCommi() {
			return this.tkTotalCommi;
		}
		public void setTkTotalCommi(String tkTotalCommi) {
			this.tkTotalCommi = tkTotalCommi;
		}
		public String getTkTotalSales() {
			return this.tkTotalSales;
		}
		public void setTkTotalSales(String tkTotalSales) {
			this.tkTotalSales = tkTotalSales;
		}
		public String getTmallPlayActivityInfo() {
			return this.tmallPlayActivityInfo;
		}
		public void setTmallPlayActivityInfo(String tmallPlayActivityInfo) {
			this.tmallPlayActivityInfo = tmallPlayActivityInfo;
		}
		public Long getTotalStock() {
			return this.totalStock;
		}
		public void setTotalStock(Long totalStock) {
			this.totalStock = totalStock;
		}
		public String getUrl() {
			return this.url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public Long getUserType() {
			return this.userType;
		}
		public void setUserType(Long userType) {
			this.userType = userType;
		}
		public Long getUvSumPreSale() {
			return this.uvSumPreSale;
		}
		public void setUvSumPreSale(Long uvSumPreSale) {
			this.uvSumPreSale = uvSumPreSale;
		}
		public Long getVolume() {
			return this.volume;
		}
		public void setVolume(Long volume) {
			this.volume = volume;
		}
		public String getWhiteImage() {
			return this.whiteImage;
		}
		public void setWhiteImage(String whiteImage) {
			this.whiteImage = whiteImage;
		}
		public String getxId() {
			return this.xId;
		}
		public void setxId(String xId) {
			this.xId = xId;
		}
		public String getYsylClickUrl() {
			return this.ysylClickUrl;
		}
		public void setYsylClickUrl(String ysylClickUrl) {
			this.ysylClickUrl = ysylClickUrl;
		}
		public String getYsylCommissionRate() {
			return this.ysylCommissionRate;
		}
		public void setYsylCommissionRate(String ysylCommissionRate) {
			this.ysylCommissionRate = ysylCommissionRate;
		}
		public String getYsylTljFace() {
			return this.ysylTljFace;
		}
		public void setYsylTljFace(String ysylTljFace) {
			this.ysylTljFace = ysylTljFace;
		}
		public String getYsylTljSendTime() {
			return this.ysylTljSendTime;
		}
		public void setYsylTljSendTime(String ysylTljSendTime) {
			this.ysylTljSendTime = ysylTljSendTime;
		}
		public String getYsylTljUseEndTime() {
			return this.ysylTljUseEndTime;
		}
		public void setYsylTljUseEndTime(String ysylTljUseEndTime) {
			this.ysylTljUseEndTime = ysylTljUseEndTime;
		}
		public String getYsylTljUseStartTime() {
			return this.ysylTljUseStartTime;
		}
		public void setYsylTljUseStartTime(String ysylTljUseStartTime) {
			this.ysylTljUseStartTime = ysylTljUseStartTime;
		}
		public String getZkFinalPrice() {
			return this.zkFinalPrice;
		}
		public void setZkFinalPrice(String zkFinalPrice) {
			this.zkFinalPrice = zkFinalPrice;
		}

}



}
