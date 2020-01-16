package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.tbk.dg.optimus.material response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TbkDgOptimusMaterialResponse extends TaobaoResponse {

	private static final long serialVersionUID = 1489726146222985467L;

	/** 
	 * 推荐信息-是否抄底
	 */
	@ApiField("is_default")
	private String isDefault;

	/** 
	 * resultList
	 */
	@ApiListField("result_list")
	@ApiField("map_data")
	private List<MapData> resultList;


	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	public String getIsDefault( ) {
		return this.isDefault;
	}

	public void setResultList(List<MapData> resultList) {
		this.resultList = resultList;
	}
	public List<MapData> getResultList( ) {
		return this.resultList;
	}
	
	/**
 * 商品信息-商品关联词
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class WordMapData extends TaobaoObject {

	private static final long serialVersionUID = 7478118713832141811L;

	/**
		 * 链接-商品相关关联词落地页地址
		 */
		@ApiField("url")
		private String url;
		/**
		 * 商品相关的关联词
		 */
		@ApiField("word")
		private String word;
	

	public String getUrl() {
			return this.url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getWord() {
			return this.word;
		}
		public void setWord(String word) {
			this.word = word;
		}

}

	/**
 * resultList
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class MapData extends TaobaoObject {

	private static final long serialVersionUID = 8249163994622284514L;

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
		 * 链接-宝贝推广链接
		 */
		@ApiField("click_url")
		private String clickUrl;
		/**
		 * 商品信息-佣金比率(%)
		 */
		@ApiField("commission_rate")
		private String commissionRate;
		/**
		 * 优惠券（元） 若属于预售商品，该优惠券付尾款可用，付定金不可用
		 */
		@ApiField("coupon_amount")
		private Long couponAmount;
		/**
		 * 链接-宝贝+券二合一页面链接(该字段废弃，请勿再用)
		 */
		@ApiField("coupon_click_url")
		private String couponClickUrl;
		/**
		 * 优惠券信息-优惠券结束时间
		 */
		@ApiField("coupon_end_time")
		private String couponEndTime;
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
		 * 商品信息-宝贝描述（推荐理由,不一定有）
		 */
		@ApiField("item_description")
		private String itemDescription;
		/**
		 * 商品信息-宝贝id
		 */
		@ApiField("item_id")
		private Long itemId;
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
		 * 聚划算信息-聚淘结束时间
		 */
		@ApiField("ju_online_end_time")
		private String juOnlineEndTime;
		/**
		 * 聚划算信息-聚淘开始时间
		 */
		@ApiField("ju_online_start_time")
		private String juOnlineStartTime;
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
		 * 猫超玩法信息-折扣条件，价格百分数存储，件数按数量存储。可以有多个折扣条件，与折扣字段对应，','分割
		 */
		@ApiField("maochao_play_conditions")
		private String maochaoPlayConditions;
		/**
		 * 猫超玩法信息-玩法类型，2:折扣(满n件折扣),5:减钱(满n元减m元)
		 */
		@ApiField("maochao_play_discount_type")
		private String maochaoPlayDiscountType;
		/**
		 * 猫超玩法信息-折扣，折扣按照百分数存储，其余按照单位分存储。可以有多个折扣，','分割
		 */
		@ApiField("maochao_play_discounts")
		private String maochaoPlayDiscounts;
		/**
		 * 猫超玩法信息-活动结束时间，精确到毫秒
		 */
		@ApiField("maochao_play_end_time")
		private String maochaoPlayEndTime;
		/**
		 * 猫超玩法信息-当前是否包邮，1:是，0:否
		 */
		@ApiField("maochao_play_free_post_fee")
		private String maochaoPlayFreePostFee;
		/**
		 * 猫超玩法信息-活动开始时间，精确到毫秒
		 */
		@ApiField("maochao_play_start_time")
		private String maochaoPlayStartTime;
		/**
		 * 多件券单品件数
		 */
		@ApiField("multi_coupon_item_count")
		private String multiCouponItemCount;
		/**
		 * 多件券优惠比例
		 */
		@ApiField("multi_coupon_zk_rate")
		private String multiCouponZkRate;
		/**
		 * 商品信息-新人价
		 */
		@ApiField("new_user_price")
		private String newUserPrice;
		/**
		 * 店铺信息-卖家昵称
		 */
		@ApiField("nick")
		private String nick;
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
		 * 预售商品-优惠信息
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
		 * 多件券件单价
		 */
		@ApiField("price_after_multi_coupon")
		private String priceAfterMultiCoupon;
		/**
		 * 满减满折优惠（满2件打5折中值为5；满300减20中值为20）
		 */
		@ApiField("promotion_condition")
		private String promotionCondition;
		/**
		 * 满减满折门槛（满2件打5折中值为2；满300减20中值为300）
		 */
		@ApiField("promotion_discount")
		private String promotionDiscount;
		/**
		 * 满减满折信息
		 */
		@ApiField("promotion_info")
		private String promotionInfo;
		/**
		 * 满减满折的类型（1. 满减 2. 满折）
		 */
		@ApiField("promotion_type")
		private String promotionType;
		/**
		 * 商品信息-一口价
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
		 * 天猫限时抢可售  -结束时间（毫秒）
		 */
		@ApiField("tmall_play_activity_end_time")
		private Long tmallPlayActivityEndTime;
		/**
		 * 营销-天猫营销玩法
		 */
		@ApiField("tmall_play_activity_info")
		private String tmallPlayActivityInfo;
		/**
		 * 天猫限时抢可售  -开始时间（毫秒）
		 */
		@ApiField("tmall_play_activity_start_time")
		private Long tmallPlayActivityStartTime;
		/**
		 * 拼团专用-拼团库存数量
		 */
		@ApiField("total_stock")
		private Long totalStock;
		/**
		 * 店铺信息-卖家类型，0表示集市，1表示商城
		 */
		@ApiField("user_type")
		private Long userType;
		/**
		 * 商品信息-预售数量
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
		 * 商品信息-商品关联词
		 */
		@ApiListField("word_list")
		@ApiField("word_map_data")
		private List<WordMapData> wordList;
		/**
		 * 物料块id(测试中请勿使用)
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
		public String getClickUrl() {
			return this.clickUrl;
		}
		public void setClickUrl(String clickUrl) {
			this.clickUrl = clickUrl;
		}
		public String getCommissionRate() {
			return this.commissionRate;
		}
		public void setCommissionRate(String commissionRate) {
			this.commissionRate = commissionRate;
		}
		public Long getCouponAmount() {
			return this.couponAmount;
		}
		public void setCouponAmount(Long couponAmount) {
			this.couponAmount = couponAmount;
		}
		public String getCouponClickUrl() {
			return this.couponClickUrl;
		}
		public void setCouponClickUrl(String couponClickUrl) {
			this.couponClickUrl = couponClickUrl;
		}
		public String getCouponEndTime() {
			return this.couponEndTime;
		}
		public void setCouponEndTime(String couponEndTime) {
			this.couponEndTime = couponEndTime;
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
		public String getJuOnlineEndTime() {
			return this.juOnlineEndTime;
		}
		public void setJuOnlineEndTime(String juOnlineEndTime) {
			this.juOnlineEndTime = juOnlineEndTime;
		}
		public String getJuOnlineStartTime() {
			return this.juOnlineStartTime;
		}
		public void setJuOnlineStartTime(String juOnlineStartTime) {
			this.juOnlineStartTime = juOnlineStartTime;
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
		public String getMaochaoPlayConditions() {
			return this.maochaoPlayConditions;
		}
		public void setMaochaoPlayConditions(String maochaoPlayConditions) {
			this.maochaoPlayConditions = maochaoPlayConditions;
		}
		public String getMaochaoPlayDiscountType() {
			return this.maochaoPlayDiscountType;
		}
		public void setMaochaoPlayDiscountType(String maochaoPlayDiscountType) {
			this.maochaoPlayDiscountType = maochaoPlayDiscountType;
		}
		public String getMaochaoPlayDiscounts() {
			return this.maochaoPlayDiscounts;
		}
		public void setMaochaoPlayDiscounts(String maochaoPlayDiscounts) {
			this.maochaoPlayDiscounts = maochaoPlayDiscounts;
		}
		public String getMaochaoPlayEndTime() {
			return this.maochaoPlayEndTime;
		}
		public void setMaochaoPlayEndTime(String maochaoPlayEndTime) {
			this.maochaoPlayEndTime = maochaoPlayEndTime;
		}
		public String getMaochaoPlayFreePostFee() {
			return this.maochaoPlayFreePostFee;
		}
		public void setMaochaoPlayFreePostFee(String maochaoPlayFreePostFee) {
			this.maochaoPlayFreePostFee = maochaoPlayFreePostFee;
		}
		public String getMaochaoPlayStartTime() {
			return this.maochaoPlayStartTime;
		}
		public void setMaochaoPlayStartTime(String maochaoPlayStartTime) {
			this.maochaoPlayStartTime = maochaoPlayStartTime;
		}
		public String getMultiCouponItemCount() {
			return this.multiCouponItemCount;
		}
		public void setMultiCouponItemCount(String multiCouponItemCount) {
			this.multiCouponItemCount = multiCouponItemCount;
		}
		public String getMultiCouponZkRate() {
			return this.multiCouponZkRate;
		}
		public void setMultiCouponZkRate(String multiCouponZkRate) {
			this.multiCouponZkRate = multiCouponZkRate;
		}
		public String getNewUserPrice() {
			return this.newUserPrice;
		}
		public void setNewUserPrice(String newUserPrice) {
			this.newUserPrice = newUserPrice;
		}
		public String getNick() {
			return this.nick;
		}
		public void setNick(String nick) {
			this.nick = nick;
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
		public String getPriceAfterMultiCoupon() {
			return this.priceAfterMultiCoupon;
		}
		public void setPriceAfterMultiCoupon(String priceAfterMultiCoupon) {
			this.priceAfterMultiCoupon = priceAfterMultiCoupon;
		}
		public String getPromotionCondition() {
			return this.promotionCondition;
		}
		public void setPromotionCondition(String promotionCondition) {
			this.promotionCondition = promotionCondition;
		}
		public String getPromotionDiscount() {
			return this.promotionDiscount;
		}
		public void setPromotionDiscount(String promotionDiscount) {
			this.promotionDiscount = promotionDiscount;
		}
		public String getPromotionInfo() {
			return this.promotionInfo;
		}
		public void setPromotionInfo(String promotionInfo) {
			this.promotionInfo = promotionInfo;
		}
		public String getPromotionType() {
			return this.promotionType;
		}
		public void setPromotionType(String promotionType) {
			this.promotionType = promotionType;
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
		public Long getTmallPlayActivityEndTime() {
			return this.tmallPlayActivityEndTime;
		}
		public void setTmallPlayActivityEndTime(Long tmallPlayActivityEndTime) {
			this.tmallPlayActivityEndTime = tmallPlayActivityEndTime;
		}
		public String getTmallPlayActivityInfo() {
			return this.tmallPlayActivityInfo;
		}
		public void setTmallPlayActivityInfo(String tmallPlayActivityInfo) {
			this.tmallPlayActivityInfo = tmallPlayActivityInfo;
		}
		public Long getTmallPlayActivityStartTime() {
			return this.tmallPlayActivityStartTime;
		}
		public void setTmallPlayActivityStartTime(Long tmallPlayActivityStartTime) {
			this.tmallPlayActivityStartTime = tmallPlayActivityStartTime;
		}
		public Long getTotalStock() {
			return this.totalStock;
		}
		public void setTotalStock(Long totalStock) {
			this.totalStock = totalStock;
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
		public List<WordMapData> getWordList() {
			return this.wordList;
		}
		public void setWordList(List<WordMapData> wordList) {
			this.wordList = wordList;
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
