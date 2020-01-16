package com.taobao.api.request;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.TaobaoObject;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.internal.util.json.JSONWriter;
import com.taobao.api.response.OpenimImmsgPushResponse;

/**
 * TOP API: taobao.openim.immsg.push request
 * 
 * @author top auto create
 * @since 1.0, 2018.07.26
 */
public class OpenimImmsgPushRequest extends BaseTaobaoRequest<OpenimImmsgPushResponse> {
	
	

	/** 
	* openim消息结构体
	 */
	private String immsg;

	public void setImmsg(String immsg) {
		this.immsg = immsg;
	}

	public void setImmsg(ImMsg immsg) {
		this.immsg = new JSONWriter(false,true).write(immsg);
	}

	public String getImmsg() {
		return this.immsg;
	}

	public String getApiMethodName() {
		return "taobao.openim.immsg.push";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("immsg", this.immsg);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<OpenimImmsgPushResponse> getResponseClass() {
		return OpenimImmsgPushResponse.class;
	}

	public void check() throws ApiRuleException {
	}
	
	/**
 * openim消息结构体
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class ImMsg extends TaobaoObject {

	private static final long serialVersionUID = 2745434977998215553L;

	/**
		 * 发送的消息内容。根据不同消息类型，传不同的值。0(文本消息):填消息内容字符串。1(图片):base64编码的jpg或gif文件。3(语音):base64编码的amr文件。8(地理位置):经纬度，格式如 111,222
		 */
		@ApiField("context")
		private String context;
		/**
		 * 如果为1，则表示发送方是一个淘宝账号，该账号必须是本appkey绑定过的客服账号，并且只能给本appkey的用户发消息。通过该参数可以从服务端发起一个客服到用户的会话。
		 */
		@ApiField("from_taobao")
		private Long fromTaobao;
		/**
		 * 消息发送者
		 */
		@ApiField("from_user")
		private String fromUser;
		/**
		 * json map，媒体信息属性。根据msgtype变化。0(文本):填空即可。 1(图片):需要图片格式，{"type":"jpg"}或{"type":"gif"}。   2(语音): 需要文件格式和语音长度信息{"type":"amr","playtime":5}
		 */
		@ApiField("media_attr")
		private String mediaAttr;
		/**
		 * 消息类型。0:文本消息。1:图片消息，只支持jpg、gif。2:语音消息，只支持amr。8:地理位置信息。
		 */
		@ApiField("msg_type")
		private Long msgType;
		/**
		 * 接收方appkey，默认本app，跨app发送时需要用到
		 */
		@ApiField("to_appkey")
		private String toAppkey;
		/**
		 * 消息接受者
		 */
		@ApiListField("to_users")
		@ApiField("string")
		private List<String> toUsers;
	

	public String getContext() {
			return this.context;
		}
		public void setContext(String context) {
			this.context = context;
		}
		public Long getFromTaobao() {
			return this.fromTaobao;
		}
		public void setFromTaobao(Long fromTaobao) {
			this.fromTaobao = fromTaobao;
		}
		public String getFromUser() {
			return this.fromUser;
		}
		public void setFromUser(String fromUser) {
			this.fromUser = fromUser;
		}
		public String getMediaAttr() {
			return this.mediaAttr;
		}
		public void setMediaAttr(String mediaAttr) {
			this.mediaAttr = mediaAttr;
		}
		public Long getMsgType() {
			return this.msgType;
		}
		public void setMsgType(Long msgType) {
			this.msgType = msgType;
		}
		public String getToAppkey() {
			return this.toAppkey;
		}
		public void setToAppkey(String toAppkey) {
			this.toAppkey = toAppkey;
		}
		public List<String> getToUsers() {
			return this.toUsers;
		}
		public void setToUsers(List<String> toUsers) {
			this.toUsers = toUsers;
		}

}


}