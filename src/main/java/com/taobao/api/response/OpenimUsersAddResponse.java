package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.openim.users.add response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class OpenimUsersAddResponse extends TaobaoResponse {

	private static final long serialVersionUID = 2462798394752994579L;

	/** 
	 * 添加帐号失败的具体信息
	 */
	@ApiListField("fail_msg")
	@ApiField("string")
	private List<String> failMsg;

	/** 
	 * 添加失败的用户id
	 */
	@ApiListField("uid_fail")
	@ApiField("string")
	private List<String> uidFail;

	/** 
	 * 成功用户列表
	 */
	@ApiListField("uid_succ")
	@ApiField("string")
	private List<String> uidSucc;


	public void setFailMsg(List<String> failMsg) {
		this.failMsg = failMsg;
	}
	public List<String> getFailMsg( ) {
		return this.failMsg;
	}

	public void setUidFail(List<String> uidFail) {
		this.uidFail = uidFail;
	}
	public List<String> getUidFail( ) {
		return this.uidFail;
	}

	public void setUidSucc(List<String> uidSucc) {
		this.uidSucc = uidSucc;
	}
	public List<String> getUidSucc( ) {
		return this.uidSucc;
	}
	


}
