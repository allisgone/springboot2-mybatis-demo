package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Date;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.TbkDgVegasTljCreateResponse;

/**
 * TOP API: taobao.tbk.dg.vegas.tlj.create request
 * 
 * @author top auto create
 * @since 1.0, 2019.12.27
 */
public class TbkDgVegasTljCreateRequest extends BaseTaobaoRequest<TbkDgVegasTljCreateResponse> {
	
	

	/** 
	* 妈妈广告位Id
	 */
	private Long adzoneId;

	/** 
	* CPS佣金计划类型
	 */
	private String campaignType;

	/** 
	* 宝贝id
	 */
	private Long itemId;

	/** 
	* 淘礼金名称，最大10个字符
	 */
	private String name;

	/** 
	* 单个淘礼金面额，支持两位小数，单位元
	 */
	private String perFace;

	/** 
	* 安全开关
	 */
	private Boolean securitySwitch;

	/** 
	* 发放截止时间
	 */
	private Date sendEndTime;

	/** 
	* 发放开始时间
	 */
	private Date sendStartTime;

	/** 
	* 淘礼金总个数
	 */
	private Long totalNum;

	/** 
	* 使用结束日期。如果是结束时间模式为相对时间，时间格式为1-7直接的整数, 例如，1（相对领取时间1天）； 如果是绝对时间，格式为yyyy-MM-dd，例如，2019-01-29，表示到2019-01-29 23:59:59结束
	 */
	private String useEndTime;

	/** 
	* 结束日期的模式,1:相对时间，2:绝对时间
	 */
	private Long useEndTimeMode;

	/** 
	* 使用开始日期。相对时间，无需填写，以用户领取时间作为使用开始时间。绝对时间，格式 yyyy-MM-dd，例如，2019-01-29，表示从2019-01-29 00:00:00 开始
	 */
	private String useStartTime;

	/** 
	* 单用户累计中奖次数上限
	 */
	private Long userTotalWinNumLimit;

	public void setAdzoneId(Long adzoneId) {
		this.adzoneId = adzoneId;
	}

	public Long getAdzoneId() {
		return this.adzoneId;
	}

	public void setCampaignType(String campaignType) {
		this.campaignType = campaignType;
	}

	public String getCampaignType() {
		return this.campaignType;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getItemId() {
		return this.itemId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPerFace(String perFace) {
		this.perFace = perFace;
	}

	public String getPerFace() {
		return this.perFace;
	}

	public void setSecuritySwitch(Boolean securitySwitch) {
		this.securitySwitch = securitySwitch;
	}

	public Boolean getSecuritySwitch() {
		return this.securitySwitch;
	}

	public void setSendEndTime(Date sendEndTime) {
		this.sendEndTime = sendEndTime;
	}

	public Date getSendEndTime() {
		return this.sendEndTime;
	}

	public void setSendStartTime(Date sendStartTime) {
		this.sendStartTime = sendStartTime;
	}

	public Date getSendStartTime() {
		return this.sendStartTime;
	}

	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}

	public Long getTotalNum() {
		return this.totalNum;
	}

	public void setUseEndTime(String useEndTime) {
		this.useEndTime = useEndTime;
	}

	public String getUseEndTime() {
		return this.useEndTime;
	}

	public void setUseEndTimeMode(Long useEndTimeMode) {
		this.useEndTimeMode = useEndTimeMode;
	}

	public Long getUseEndTimeMode() {
		return this.useEndTimeMode;
	}

	public void setUseStartTime(String useStartTime) {
		this.useStartTime = useStartTime;
	}

	public String getUseStartTime() {
		return this.useStartTime;
	}

	public void setUserTotalWinNumLimit(Long userTotalWinNumLimit) {
		this.userTotalWinNumLimit = userTotalWinNumLimit;
	}

	public Long getUserTotalWinNumLimit() {
		return this.userTotalWinNumLimit;
	}

	public String getApiMethodName() {
		return "taobao.tbk.dg.vegas.tlj.create";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("adzone_id", this.adzoneId);
		txtParams.put("campaign_type", this.campaignType);
		txtParams.put("item_id", this.itemId);
		txtParams.put("name", this.name);
		txtParams.put("per_face", this.perFace);
		txtParams.put("security_switch", this.securitySwitch);
		txtParams.put("send_end_time", this.sendEndTime);
		txtParams.put("send_start_time", this.sendStartTime);
		txtParams.put("total_num", this.totalNum);
		txtParams.put("use_end_time", this.useEndTime);
		txtParams.put("use_end_time_mode", this.useEndTimeMode);
		txtParams.put("use_start_time", this.useStartTime);
		txtParams.put("user_total_win_num_limit", this.userTotalWinNumLimit);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<TbkDgVegasTljCreateResponse> getResponseClass() {
		return TbkDgVegasTljCreateResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(adzoneId, "adzoneId");
		RequestCheckUtils.checkNotEmpty(itemId, "itemId");
		RequestCheckUtils.checkNotEmpty(name, "name");
		RequestCheckUtils.checkNotEmpty(perFace, "perFace");
		RequestCheckUtils.checkNotEmpty(securitySwitch, "securitySwitch");
		RequestCheckUtils.checkNotEmpty(sendStartTime, "sendStartTime");
		RequestCheckUtils.checkNotEmpty(totalNum, "totalNum");
		RequestCheckUtils.checkNotEmpty(userTotalWinNumLimit, "userTotalWinNumLimit");
	}
	

}