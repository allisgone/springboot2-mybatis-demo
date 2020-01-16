package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.TbkContentGetResponse;

/**
 * TOP API: taobao.tbk.content.get request
 * 
 * @author top auto create
 * @since 1.0, 2019.07.04
 */
public class TbkContentGetRequest extends BaseTaobaoRequest<TbkContentGetResponse> {
	
	

	/** 
	* 推广位
	 */
	private Long adzoneId;

	/** 
	* 表示取这个时间点以前的数据，以毫秒为单位（出参中的last_timestamp是指本次返回的内容中最早一条的数据，下一次作为before_timestamp传过来，即可实现翻页）
	 */
	private Long beforeTimestamp;

	/** 
	* 类目
	 */
	private Long cid;

	/** 
	* 默认可不传,内容库类型:1 优质内容
	 */
	private Long contentSet;

	/** 
	* 表示期望获取条数
	 */
	private Long count;

	/** 
	* 图片高度
	 */
	private Long imageHeight;

	/** 
	* 图片宽度
	 */
	private Long imageWidth;

	/** 
	* 内容类型，1:图文、2: 图集、3: 短视频
	 */
	private Long type;

	public void setAdzoneId(Long adzoneId) {
		this.adzoneId = adzoneId;
	}

	public Long getAdzoneId() {
		return this.adzoneId;
	}

	public void setBeforeTimestamp(Long beforeTimestamp) {
		this.beforeTimestamp = beforeTimestamp;
	}

	public Long getBeforeTimestamp() {
		return this.beforeTimestamp;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setContentSet(Long contentSet) {
		this.contentSet = contentSet;
	}

	public Long getContentSet() {
		return this.contentSet;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getCount() {
		return this.count;
	}

	public void setImageHeight(Long imageHeight) {
		this.imageHeight = imageHeight;
	}

	public Long getImageHeight() {
		return this.imageHeight;
	}

	public void setImageWidth(Long imageWidth) {
		this.imageWidth = imageWidth;
	}

	public Long getImageWidth() {
		return this.imageWidth;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getType() {
		return this.type;
	}

	public String getApiMethodName() {
		return "taobao.tbk.content.get";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("adzone_id", this.adzoneId);
		txtParams.put("before_timestamp", this.beforeTimestamp);
		txtParams.put("cid", this.cid);
		txtParams.put("content_set", this.contentSet);
		txtParams.put("count", this.count);
		txtParams.put("image_height", this.imageHeight);
		txtParams.put("image_width", this.imageWidth);
		txtParams.put("type", this.type);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<TbkContentGetResponse> getResponseClass() {
		return TbkContentGetResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(adzoneId, "adzoneId");
		RequestCheckUtils.checkMaxValue(imageHeight, 1000L, "imageHeight");
		RequestCheckUtils.checkMinValue(imageHeight, 10L, "imageHeight");
		RequestCheckUtils.checkMaxValue(imageWidth, 1000L, "imageWidth");
		RequestCheckUtils.checkMinValue(imageWidth, 10L, "imageWidth");
	}
	

}