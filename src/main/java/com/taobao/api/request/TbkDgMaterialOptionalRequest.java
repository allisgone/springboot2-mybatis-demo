package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.TbkDgMaterialOptionalResponse;

/**
 * TOP API: taobao.tbk.dg.material.optional request
 * 
 * @author top auto create
 * @since 1.0, 2019.10.18
 */
public class TbkDgMaterialOptionalRequest extends BaseTaobaoRequest<TbkDgMaterialOptionalResponse> {
	
	

	/** 
	* mm_xxx_xxx_12345678三段式的最后一段数字
	 */
	private Long adzoneId;

	/** 
	* 商品筛选-后台类目ID。用,分割，最大10个，该ID可以通过taobao.itemcats.get接口获取到
	 */
	private String cat;

	/** 
	* 智能匹配-设备号加密类型：MD5
	 */
	private String deviceEncrypt;

	/** 
	* 智能匹配-设备号类型：IMEI，或者IDFA，或者UTDID（UTDID不支持MD5加密），或者OAID
	 */
	private String deviceType;

	/** 
	* 智能匹配-设备号加密后的值（MD5加密需32位小写）
	 */
	private String deviceValue;

	/** 
	* 商品筛选-KA媒体淘客佣金比率上限。如：1234表示12.34%
	 */
	private Long endKaTkRate;

	/** 
	* 商品筛选-折扣价范围上限。单位：元
	 */
	private Long endPrice;

	/** 
	* 商品筛选-淘客佣金比率上限。如：1234表示12.34%
	 */
	private Long endTkRate;

	/** 
	* 优惠券筛选-是否有优惠券。true表示该商品有优惠券，false或不设置表示不限
	 */
	private Boolean hasCoupon;

	/** 
	* 商品筛选-好评率是否高于行业均值。True表示大于等于，false或不设置表示不限
	 */
	private Boolean includeGoodRate;

	/** 
	* 商品筛选(特定媒体支持)-成交转化是否高于行业均值。True表示大于等于，false或不设置表示不限
	 */
	private Boolean includePayRate30;

	/** 
	* 商品筛选(特定媒体支持)-退款率是否低于行业均值。True表示大于等于，false或不设置表示不限
	 */
	private Boolean includeRfdRate;

	/** 
	* ip参数影响邮费获取，如果不传或者传入不准确，邮费无法精准提供
	 */
	private String ip;

	/** 
	* 商品筛选-是否海外商品。true表示属于海外商品，false或不设置表示不限
	 */
	private Boolean isOverseas;

	/** 
	* 商品筛选-是否天猫商品。true表示属于天猫商品，false或不设置表示不限
	 */
	private Boolean isTmall;

	/** 
	* 商品筛选-所在地
	 */
	private String itemloc;

	/** 
	* 锁佣结束时间
	 */
	private Long lockRateEndTime;

	/** 
	* 锁佣开始时间
	 */
	private Long lockRateStartTime;

	/** 
	* 不传时默认物料id=2836；如果直接对消费者投放，可使用官方个性化算法优化的搜索物料id=17004
	 */
	private Long materialId;

	/** 
	* 商品筛选-是否包邮。true表示包邮，false或不设置表示不限
	 */
	private Boolean needFreeShipment;

	/** 
	* 商品筛选-是否加入消费者保障。true表示加入，false或不设置表示不限
	 */
	private Boolean needPrepay;

	/** 
	* 商品筛选-牛皮癣程度。取值：1不限，2无，3轻微
	 */
	private Long npxLevel;

	/** 
	* 第几页，默认：１
	 */
	private Long pageNo;

	/** 
	* 页大小，默认20，1~100
	 */
	private Long pageSize;

	/** 
	* 链接形式：1：PC，2：无线，默认：１
	 */
	private Long platform;

	/** 
	* 商品筛选-查询词
	 */
	private String q;

	/** 
	* 排序_des（降序），排序_asc（升序），销量（total_sales），淘客佣金比率（tk_rate）， 累计推广量（tk_total_sales），总支出佣金（tk_total_commi），价格（price）
	 */
	private String sort;

	/** 
	* 商品筛选(特定媒体支持)-店铺dsr评分。筛选大于等于当前设置的店铺dsr评分的商品0-50000之间
	 */
	private Long startDsr;

	/** 
	* 商品筛选-KA媒体淘客佣金比率下限。如：1234表示12.34%
	 */
	private Long startKaTkRate;

	/** 
	* 商品筛选-折扣价范围下限。单位：元
	 */
	private Long startPrice;

	/** 
	* 商品筛选-淘客佣金比率下限。如：1234表示12.34%
	 */
	private Long startTkRate;

	public void setAdzoneId(Long adzoneId) {
		this.adzoneId = adzoneId;
	}

	public Long getAdzoneId() {
		return this.adzoneId;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getCat() {
		return this.cat;
	}

	public void setDeviceEncrypt(String deviceEncrypt) {
		this.deviceEncrypt = deviceEncrypt;
	}

	public String getDeviceEncrypt() {
		return this.deviceEncrypt;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceType() {
		return this.deviceType;
	}

	public void setDeviceValue(String deviceValue) {
		this.deviceValue = deviceValue;
	}

	public String getDeviceValue() {
		return this.deviceValue;
	}

	public void setEndKaTkRate(Long endKaTkRate) {
		this.endKaTkRate = endKaTkRate;
	}

	public Long getEndKaTkRate() {
		return this.endKaTkRate;
	}

	public void setEndPrice(Long endPrice) {
		this.endPrice = endPrice;
	}

	public Long getEndPrice() {
		return this.endPrice;
	}

	public void setEndTkRate(Long endTkRate) {
		this.endTkRate = endTkRate;
	}

	public Long getEndTkRate() {
		return this.endTkRate;
	}

	public void setHasCoupon(Boolean hasCoupon) {
		this.hasCoupon = hasCoupon;
	}

	public Boolean getHasCoupon() {
		return this.hasCoupon;
	}

	public void setIncludeGoodRate(Boolean includeGoodRate) {
		this.includeGoodRate = includeGoodRate;
	}

	public Boolean getIncludeGoodRate() {
		return this.includeGoodRate;
	}

	public void setIncludePayRate30(Boolean includePayRate30) {
		this.includePayRate30 = includePayRate30;
	}

	public Boolean getIncludePayRate30() {
		return this.includePayRate30;
	}

	public void setIncludeRfdRate(Boolean includeRfdRate) {
		this.includeRfdRate = includeRfdRate;
	}

	public Boolean getIncludeRfdRate() {
		return this.includeRfdRate;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIsOverseas(Boolean isOverseas) {
		this.isOverseas = isOverseas;
	}

	public Boolean getIsOverseas() {
		return this.isOverseas;
	}

	public void setIsTmall(Boolean isTmall) {
		this.isTmall = isTmall;
	}

	public Boolean getIsTmall() {
		return this.isTmall;
	}

	public void setItemloc(String itemloc) {
		this.itemloc = itemloc;
	}

	public String getItemloc() {
		return this.itemloc;
	}

	public void setLockRateEndTime(Long lockRateEndTime) {
		this.lockRateEndTime = lockRateEndTime;
	}

	public Long getLockRateEndTime() {
		return this.lockRateEndTime;
	}

	public void setLockRateStartTime(Long lockRateStartTime) {
		this.lockRateStartTime = lockRateStartTime;
	}

	public Long getLockRateStartTime() {
		return this.lockRateStartTime;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public Long getMaterialId() {
		return this.materialId;
	}

	public void setNeedFreeShipment(Boolean needFreeShipment) {
		this.needFreeShipment = needFreeShipment;
	}

	public Boolean getNeedFreeShipment() {
		return this.needFreeShipment;
	}

	public void setNeedPrepay(Boolean needPrepay) {
		this.needPrepay = needPrepay;
	}

	public Boolean getNeedPrepay() {
		return this.needPrepay;
	}

	public void setNpxLevel(Long npxLevel) {
		this.npxLevel = npxLevel;
	}

	public Long getNpxLevel() {
		return this.npxLevel;
	}

	public void setPageNo(Long pageNo) {
		this.pageNo = pageNo;
	}

	public Long getPageNo() {
		return this.pageNo;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPageSize() {
		return this.pageSize;
	}

	public void setPlatform(Long platform) {
		this.platform = platform;
	}

	public Long getPlatform() {
		return this.platform;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getQ() {
		return this.q;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSort() {
		return this.sort;
	}

	public void setStartDsr(Long startDsr) {
		this.startDsr = startDsr;
	}

	public Long getStartDsr() {
		return this.startDsr;
	}

	public void setStartKaTkRate(Long startKaTkRate) {
		this.startKaTkRate = startKaTkRate;
	}

	public Long getStartKaTkRate() {
		return this.startKaTkRate;
	}

	public void setStartPrice(Long startPrice) {
		this.startPrice = startPrice;
	}

	public Long getStartPrice() {
		return this.startPrice;
	}

	public void setStartTkRate(Long startTkRate) {
		this.startTkRate = startTkRate;
	}

	public Long getStartTkRate() {
		return this.startTkRate;
	}

	public String getApiMethodName() {
		return "taobao.tbk.dg.material.optional";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("adzone_id", this.adzoneId);
		txtParams.put("cat", this.cat);
		txtParams.put("device_encrypt", this.deviceEncrypt);
		txtParams.put("device_type", this.deviceType);
		txtParams.put("device_value", this.deviceValue);
		txtParams.put("end_ka_tk_rate", this.endKaTkRate);
		txtParams.put("end_price", this.endPrice);
		txtParams.put("end_tk_rate", this.endTkRate);
		txtParams.put("has_coupon", this.hasCoupon);
		txtParams.put("include_good_rate", this.includeGoodRate);
		txtParams.put("include_pay_rate_30", this.includePayRate30);
		txtParams.put("include_rfd_rate", this.includeRfdRate);
		txtParams.put("ip", this.ip);
		txtParams.put("is_overseas", this.isOverseas);
		txtParams.put("is_tmall", this.isTmall);
		txtParams.put("itemloc", this.itemloc);
		txtParams.put("lock_rate_end_time", this.lockRateEndTime);
		txtParams.put("lock_rate_start_time", this.lockRateStartTime);
		txtParams.put("material_id", this.materialId);
		txtParams.put("need_free_shipment", this.needFreeShipment);
		txtParams.put("need_prepay", this.needPrepay);
		txtParams.put("npx_level", this.npxLevel);
		txtParams.put("page_no", this.pageNo);
		txtParams.put("page_size", this.pageSize);
		txtParams.put("platform", this.platform);
		txtParams.put("q", this.q);
		txtParams.put("sort", this.sort);
		txtParams.put("start_dsr", this.startDsr);
		txtParams.put("start_ka_tk_rate", this.startKaTkRate);
		txtParams.put("start_price", this.startPrice);
		txtParams.put("start_tk_rate", this.startTkRate);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<TbkDgMaterialOptionalResponse> getResponseClass() {
		return TbkDgMaterialOptionalResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(adzoneId, "adzoneId");
		RequestCheckUtils.checkMaxValue(startDsr, 50000L, "startDsr");
	}
	

}