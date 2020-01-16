package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.TbkDgNewuserOrderSumResponse;

/**
 * TOP API: taobao.tbk.dg.newuser.order.sum request
 * 
 * @author top auto create
 * @since 1.0, 2019.07.04
 */
public class TbkDgNewuserOrderSumRequest extends BaseTaobaoRequest<TbkDgNewuserOrderSumResponse> {
	
	

	/** 
	* 活动id， 活动名称与活动ID列表，请参见https:tbk.bbs.taobao.comdetail.html?appId=45301&postId=8599277
	 */
	private String activityId;

	/** 
	* mm_xxx_xxx_xxx的第三位
	 */
	private Long adzoneId;

	/** 
	* 页码，默认1
	 */
	private Long pageNo;

	/** 
	* 页大小，默认20，1~100
	 */
	private Long pageSize;

	/** 
	* 结算月份
	 */
	private String settleMonth;

	/** 
	* mm_xxx_xxx_xxx的第二位
	 */
	private Long siteId;

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getActivityId() {
		return this.activityId;
	}

	public void setAdzoneId(Long adzoneId) {
		this.adzoneId = adzoneId;
	}

	public Long getAdzoneId() {
		return this.adzoneId;
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

	public void setSettleMonth(String settleMonth) {
		this.settleMonth = settleMonth;
	}

	public String getSettleMonth() {
		return this.settleMonth;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getSiteId() {
		return this.siteId;
	}

	public String getApiMethodName() {
		return "taobao.tbk.dg.newuser.order.sum";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("activity_id", this.activityId);
		txtParams.put("adzone_id", this.adzoneId);
		txtParams.put("page_no", this.pageNo);
		txtParams.put("page_size", this.pageSize);
		txtParams.put("settle_month", this.settleMonth);
		txtParams.put("site_id", this.siteId);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<TbkDgNewuserOrderSumResponse> getResponseClass() {
		return TbkDgNewuserOrderSumResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(activityId, "activityId");
		RequestCheckUtils.checkNotEmpty(pageNo, "pageNo");
		RequestCheckUtils.checkNotEmpty(pageSize, "pageSize");
		RequestCheckUtils.checkMaxValue(pageSize, 100L, "pageSize");
		RequestCheckUtils.checkMinValue(pageSize, 1L, "pageSize");
	}
	

}