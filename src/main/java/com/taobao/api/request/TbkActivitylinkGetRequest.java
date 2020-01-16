package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.TbkActivitylinkGetResponse;

/**
 * TOP API: taobao.tbk.activitylink.get request
 * 
 * @author top auto create
 * @since 1.0, 2019.07.03
 */
public class TbkActivitylinkGetRequest extends BaseTaobaoRequest<TbkActivitylinkGetResponse> {
	
	

	/** 
	* 推广位id，mm_xx_xx_xx pid三段式中的第三段。adzone_id需属于appKey拥有者
	 */
	private Long adzoneId;

	/** 
	* 1：PC，2：无线，默认：１
	 */
	private Long platform;

	/** 
	* 官方活动ID，从官方活动页获取
	 */
	private Long promotionSceneId;

	/** 
	* 渠道关系ID，仅适用于渠道推广场景
	 */
	private String relationId;

	/** 
	* 媒体平台下达人的淘客pid
	 */
	private String subPid;

	/** 
	* 自定义输入串，英文和数字组成，长度不能大于12个字符，区分不同的推广渠道
	 */
	private String unionId;

	public void setAdzoneId(Long adzoneId) {
		this.adzoneId = adzoneId;
	}

	public Long getAdzoneId() {
		return this.adzoneId;
	}

	public void setPlatform(Long platform) {
		this.platform = platform;
	}

	public Long getPlatform() {
		return this.platform;
	}

	public void setPromotionSceneId(Long promotionSceneId) {
		this.promotionSceneId = promotionSceneId;
	}

	public Long getPromotionSceneId() {
		return this.promotionSceneId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	public String getRelationId() {
		return this.relationId;
	}

	public void setSubPid(String subPid) {
		this.subPid = subPid;
	}

	public String getSubPid() {
		return this.subPid;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getUnionId() {
		return this.unionId;
	}

	public String getApiMethodName() {
		return "taobao.tbk.activitylink.get";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("adzone_id", this.adzoneId);
		txtParams.put("platform", this.platform);
		txtParams.put("promotion_scene_id", this.promotionSceneId);
		txtParams.put("relation_id", this.relationId);
		txtParams.put("sub_pid", this.subPid);
		txtParams.put("union_id", this.unionId);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<TbkActivitylinkGetResponse> getResponseClass() {
		return TbkActivitylinkGetResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(adzoneId, "adzoneId");
		RequestCheckUtils.checkNotEmpty(promotionSceneId, "promotionSceneId");
	}
	

}