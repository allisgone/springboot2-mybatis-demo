package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.TbkDgOptimusMaterialResponse;

/**
 * TOP API: taobao.tbk.dg.optimus.material request
 * 
 * @author top auto create
 * @since 1.0, 2019.10.31
 */
public class TbkDgOptimusMaterialRequest extends BaseTaobaoRequest<TbkDgOptimusMaterialResponse> {
	
	

	/** 
	* mm_xxx_xxx_xxx的第三位
	 */
	private Long adzoneId;

	/** 
	* 内容专用-内容详情ID
	 */
	private Long contentId;

	/** 
	* 内容专用-内容渠道信息
	 */
	private String contentSource;

	/** 
	* 智能匹配-设备号加密类型：MD5，类型为OAID时不传
	 */
	private String deviceEncrypt;

	/** 
	* 智能匹配-设备号类型：IMEI，或者IDFA，或者UTDID（UTDID不支持MD5加密），或者OAID
	 */
	private String deviceType;

	/** 
	* 智能匹配-设备号加密后的值（MD5加密需32位小写），类型为OAID时传原始OAID值
	 */
	private String deviceValue;

	/** 
	* 商品ID，用于相似商品推荐
	 */
	private Long itemId;

	/** 
	* 官方的物料Id(详细物料id见：https:tbk.bbs.taobao.comdetail.html?appId=45301&postId=8576096)
	 */
	private Long materialId;

	/** 
	* 第几页，默认：1
	 */
	private Long pageNo;

	/** 
	* 页大小，默认20，1~100
	 */
	private Long pageSize;

	public void setAdzoneId(Long adzoneId) {
		this.adzoneId = adzoneId;
	}

	public Long getAdzoneId() {
		return this.adzoneId;
	}

	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}

	public Long getContentId() {
		return this.contentId;
	}

	public void setContentSource(String contentSource) {
		this.contentSource = contentSource;
	}

	public String getContentSource() {
		return this.contentSource;
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

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getItemId() {
		return this.itemId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public Long getMaterialId() {
		return this.materialId;
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

	public String getApiMethodName() {
		return "taobao.tbk.dg.optimus.material";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("adzone_id", this.adzoneId);
		txtParams.put("content_id", this.contentId);
		txtParams.put("content_source", this.contentSource);
		txtParams.put("device_encrypt", this.deviceEncrypt);
		txtParams.put("device_type", this.deviceType);
		txtParams.put("device_value", this.deviceValue);
		txtParams.put("item_id", this.itemId);
		txtParams.put("material_id", this.materialId);
		txtParams.put("page_no", this.pageNo);
		txtParams.put("page_size", this.pageSize);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<TbkDgOptimusMaterialResponse> getResponseClass() {
		return TbkDgOptimusMaterialResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(adzoneId, "adzoneId");
		RequestCheckUtils.checkMaxValue(pageSize, 100L, "pageSize");
		RequestCheckUtils.checkMinValue(pageSize, 1L, "pageSize");
	}
	

}