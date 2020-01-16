package com.taobao.api.request;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.util.RequestCheckUtils;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.TaobaoObject;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.internal.util.json.JSONWriter;
import com.taobao.api.response.OpenimTribeSendmsgResponse;

/**
 * TOP API: taobao.openim.tribe.sendmsg request
 * 
 * @author top auto create
 * @since 1.0, 2018.07.26
 */
public class OpenimTribeSendmsgRequest extends BaseTaobaoRequest<OpenimTribeSendmsgResponse> {
	
	

	/** 
	* 发送群消息
	 */
	private String msg;

	/** 
	* 群id
	 */
	private Long tribeId;

	/** 
	* 群消息发送者，只有该群的成员才可以发送群消息
	 */
	private String user;

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setMsg(TribeMsg msg) {
		this.msg = new JSONWriter(false,true).write(msg);
	}

	public String getMsg() {
		return this.msg;
	}

	public void setTribeId(Long tribeId) {
		this.tribeId = tribeId;
	}

	public Long getTribeId() {
		return this.tribeId;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setUser(User user) {
		this.user = new JSONWriter(false,true).write(user);
	}

	public String getUser() {
		return this.user;
	}

	public String getApiMethodName() {
		return "taobao.openim.tribe.sendmsg";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("msg", this.msg);
		txtParams.put("tribe_id", this.tribeId);
		txtParams.put("user", this.user);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<OpenimTribeSendmsgResponse> getResponseClass() {
		return OpenimTribeSendmsgResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(tribeId, "tribeId");
	}
	
	/**
 * 群消息发送者，只有该群的成员才可以发送群消息
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class User extends TaobaoObject {

	private static final long serialVersionUID = 1438513557715296223L;

	/**
		 * 用户所属appkey
		 */
		@ApiField("appkey")
		private String appkey;
		/**
		 * 是否是淘宝账号
		 */
		@ApiField("taobao_account")
		private Boolean taobaoAccount;
		/**
		 * 用户id
		 */
		@ApiField("uid")
		private String uid;
	

	public String getAppkey() {
			return this.appkey;
		}
		public void setAppkey(String appkey) {
			this.appkey = appkey;
		}
		public Boolean getTaobaoAccount() {
			return this.taobaoAccount;
		}
		public void setTaobaoAccount(Boolean taobaoAccount) {
			this.taobaoAccount = taobaoAccount;
		}
		public String getUid() {
			return this.uid;
		}
		public void setUid(String uid) {
			this.uid = uid;
		}

}

	/**
 * 发送群消息
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class TribeMsg extends TaobaoObject {

	private static final long serialVersionUID = 6342223613464294297L;

	/**
		 * 是否是at消息， 0表示不是at消息，1表示at指定的用户，2表示at群里所有人
		 */
		@ApiField("at_flag")
		private Long atFlag;
		/**
		 * 当at_flag=1时，必须指定at的用户
		 */
		@ApiListField("atmembers")
		@ApiField("user")
		private List<User> atmembers;
		/**
		 * 自定义push提醒参数，格式为json字符串，该参数为空时，采用系统默认的push；设置该参数时，json字符串必选包含至少包含指定的三个key，"d", "sound", "title"
		 */
		@ApiField("custom_push")
		private String customPush;
		/**
		 * 格式为json字符串， 当消息类型为图片或语音时该参数为必选项，用于描述图片，语音的属性； 该参数json格式必须符合msg_type的要求；当消息类型为图片时，格式必须符合如下样例 ： {“height”：10, "width":10, "type":"jpg"}，当前支持3三种图片类型，gif, jpg,jpeg； 当消息类型为语音时，必须符合如下样例：{“playtime”:10,”type”:”amr”}，语音的type只支持arm
		 */
		@ApiField("media_attrs")
		private String mediaAttrs;
		/**
		 * 文本消息最大长度是4K，图片最大为500K。消息内容格式根据type确定。当type为文本时，内容为文本字符串；当类型为图片或语音时，内容为图片和语音的二进制base64编码生成的字符串；当类型为自定义消息时，内容必须为就送字符串格式，该字符串必须包含header字符，即{"header":{"summary":},...}
		 */
		@ApiField("msg_content")
		private String msgContent;
		/**
		 * 消息类型，目前支持四中类型的消息； msg_type=0 表示普通文本消息； msg_type=2 表示语音消息； msg_type = 16表示图片消息； msg_type=17表示用户自定义消息
		 */
		@ApiField("msg_type")
		private Long msgType;
		/**
		 * 该消息是否需要push
		 */
		@ApiField("push")
		private Boolean push;
	

	public Long getAtFlag() {
			return this.atFlag;
		}
		public void setAtFlag(Long atFlag) {
			this.atFlag = atFlag;
		}
		public List<User> getAtmembers() {
			return this.atmembers;
		}
		public void setAtmembers(List<User> atmembers) {
			this.atmembers = atmembers;
		}
		public String getCustomPush() {
			return this.customPush;
		}
		public void setCustomPush(String customPush) {
			this.customPush = customPush;
		}
		public String getMediaAttrs() {
			return this.mediaAttrs;
		}
		public void setMediaAttrs(String mediaAttrs) {
			this.mediaAttrs = mediaAttrs;
		}
		public String getMsgContent() {
			return this.msgContent;
		}
		public void setMsgContent(String msgContent) {
			this.msgContent = msgContent;
		}
		public Long getMsgType() {
			return this.msgType;
		}
		public void setMsgType(Long msgType) {
			this.msgType = msgType;
		}
		public Boolean getPush() {
			return this.push;
		}
		public void setPush(Boolean push) {
			this.push = push;
		}

}


}