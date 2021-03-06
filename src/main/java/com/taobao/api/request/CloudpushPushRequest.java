package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.CloudpushPushResponse;

/**
 * TOP API: taobao.cloudpush.push request
 * 
 * @author top auto create
 * @since 1.0, 2018.07.26
 */
public class CloudpushPushRequest extends BaseTaobaoRequest<CloudpushPushResponse> {
	
	

	/** 
	* Android对应的activity,仅仅当androidOpenType=2有效
	 */
	private String androidActivity;

	/** 
	* 自定义的kv结构,开发者扩展用 针对android
	 */
	private String androidExtParameters;

	/** 
	* android通知声音
	 */
	private String androidMusic;

	/** 
	* 点击通知后动作,1:打开应用 2: 打开应用Activity 3:打开 url
	 */
	private String androidOpenType;

	/** 
	* Android收到推送后打开对应的url,仅仅当androidOpenType=3有效
	 */
	private String androidOpenUrl;

	/** 
	* 防打扰时长,取值范围为1~23
	 */
	private Long antiHarassDuration;

	/** 
	* 防打扰开始时间点,取值范围为0~23
	 */
	private Long antiHarassStartTime;

	/** 
	* 批次编号,用于活动效果统计
	 */
	private String batchNumber;

	/** 
	* 推送内容
	 */
	private String body;

	/** 
	* 设备类型,取值范围为:0~3云推送支持多种设备,各种设备类型编号如下:    iOS设备:deviceType=0; Andriod设备:deviceType=1;如果存在此字段,则向指定的设备类型推送消息。 默认为全部(3);
	 */
	private Long deviceType;

	/** 
	* iOS应用图标右上角角标
	 */
	private String iosBadge;

	/** 
	* 自定义的kv结构,开发者扩展用 针对iOS设备
	 */
	private String iosExtParameters;

	/** 
	* iOS通知声音
	 */
	private String iosMusic;

	/** 
	* 当APP不在线时候，是否通过通知提醒.  针对不同设备，处理逻辑不同。 该参数只针对iOS设备生效， (remind=true  & 发送消息的话(type=0)). 当你的目标设备不在线(既长连接通道不通, 我们会将这条消息的标题，通过苹果的apns通道再送达一次。发apns是发送生产环境的apns，需要在云推送配置的app的iOS生产证书和密码需要正确，否则也发送不了。 (remind=false & 并且是发送消息的话(type=0))，那么设备不在线，则不会再走苹果apns发送了。
	 */
	private Boolean remind;

	/** 
	* 离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到
	 */
	private Boolean storeOffline;

	/** 
	* 通知的摘要
	 */
	private String summery;

	/** 
	* 推送目标: device:推送给设备; account:推送给指定帐号,tag:推送给自定义标签; all: 推送给全部
	 */
	private String target;

	/** 
	* 根据Target来设定，如Target=device, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
	 */
	private String targetValue;

	/** 
	* 离线消息保存时长,取值范围为1~72,若不填,则表示不保存离线消息
	 */
	private Long timeout;

	/** 
	* 推送的标题内容.
	 */
	private String title;

	/** 
	* 0:表示消息(默认为0),1:表示通知
	 */
	private Long type;

	public void setAndroidActivity(String androidActivity) {
		this.androidActivity = androidActivity;
	}

	public String getAndroidActivity() {
		return this.androidActivity;
	}

	public void setAndroidExtParameters(String androidExtParameters) {
		this.androidExtParameters = androidExtParameters;
	}

	public String getAndroidExtParameters() {
		return this.androidExtParameters;
	}

	public void setAndroidMusic(String androidMusic) {
		this.androidMusic = androidMusic;
	}

	public String getAndroidMusic() {
		return this.androidMusic;
	}

	public void setAndroidOpenType(String androidOpenType) {
		this.androidOpenType = androidOpenType;
	}

	public String getAndroidOpenType() {
		return this.androidOpenType;
	}

	public void setAndroidOpenUrl(String androidOpenUrl) {
		this.androidOpenUrl = androidOpenUrl;
	}

	public String getAndroidOpenUrl() {
		return this.androidOpenUrl;
	}

	public void setAntiHarassDuration(Long antiHarassDuration) {
		this.antiHarassDuration = antiHarassDuration;
	}

	public Long getAntiHarassDuration() {
		return this.antiHarassDuration;
	}

	public void setAntiHarassStartTime(Long antiHarassStartTime) {
		this.antiHarassStartTime = antiHarassStartTime;
	}

	public Long getAntiHarassStartTime() {
		return this.antiHarassStartTime;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getBatchNumber() {
		return this.batchNumber;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBody() {
		return this.body;
	}

	public void setDeviceType(Long deviceType) {
		this.deviceType = deviceType;
	}

	public Long getDeviceType() {
		return this.deviceType;
	}

	public void setIosBadge(String iosBadge) {
		this.iosBadge = iosBadge;
	}

	public String getIosBadge() {
		return this.iosBadge;
	}

	public void setIosExtParameters(String iosExtParameters) {
		this.iosExtParameters = iosExtParameters;
	}

	public String getIosExtParameters() {
		return this.iosExtParameters;
	}

	public void setIosMusic(String iosMusic) {
		this.iosMusic = iosMusic;
	}

	public String getIosMusic() {
		return this.iosMusic;
	}

	public void setRemind(Boolean remind) {
		this.remind = remind;
	}

	public Boolean getRemind() {
		return this.remind;
	}

	public void setStoreOffline(Boolean storeOffline) {
		this.storeOffline = storeOffline;
	}

	public Boolean getStoreOffline() {
		return this.storeOffline;
	}

	public void setSummery(String summery) {
		this.summery = summery;
	}

	public String getSummery() {
		return this.summery;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTargetValue(String targetValue) {
		this.targetValue = targetValue;
	}

	public String getTargetValue() {
		return this.targetValue;
	}

	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}

	public Long getTimeout() {
		return this.timeout;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getType() {
		return this.type;
	}

	public String getApiMethodName() {
		return "taobao.cloudpush.push";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("android_activity", this.androidActivity);
		txtParams.put("android_ext_parameters", this.androidExtParameters);
		txtParams.put("android_music", this.androidMusic);
		txtParams.put("android_open_type", this.androidOpenType);
		txtParams.put("android_open_url", this.androidOpenUrl);
		txtParams.put("anti_harass_duration", this.antiHarassDuration);
		txtParams.put("anti_harass_start_time", this.antiHarassStartTime);
		txtParams.put("batch_number", this.batchNumber);
		txtParams.put("body", this.body);
		txtParams.put("device_type", this.deviceType);
		txtParams.put("ios_badge", this.iosBadge);
		txtParams.put("ios_ext_parameters", this.iosExtParameters);
		txtParams.put("ios_music", this.iosMusic);
		txtParams.put("remind", this.remind);
		txtParams.put("store_offline", this.storeOffline);
		txtParams.put("summery", this.summery);
		txtParams.put("target", this.target);
		txtParams.put("target_value", this.targetValue);
		txtParams.put("timeout", this.timeout);
		txtParams.put("title", this.title);
		txtParams.put("type", this.type);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<CloudpushPushResponse> getResponseClass() {
		return CloudpushPushResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(body, "body");
		RequestCheckUtils.checkNotEmpty(deviceType, "deviceType");
		RequestCheckUtils.checkNotEmpty(remind, "remind");
		RequestCheckUtils.checkNotEmpty(storeOffline, "storeOffline");
		RequestCheckUtils.checkNotEmpty(target, "target");
		RequestCheckUtils.checkNotEmpty(targetValue, "targetValue");
		RequestCheckUtils.checkNotEmpty(title, "title");
	}
	

}