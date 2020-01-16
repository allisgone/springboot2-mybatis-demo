package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;
import java.util.HashMap;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.FileItem;
import com.taobao.api.TaobaoUploadRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.ProductUpdateResponse;

/**
 * TOP API: taobao.product.update request
 * 
 * @author top auto create
 * @since 1.0, 2019.03.25
 */
public class ProductUpdateRequest extends BaseTaobaoRequest<ProductUpdateResponse> implements TaobaoUploadRequest<ProductUpdateResponse> {

	
	

	/** 
	* 非关键属性.调用taobao.itemprops.get获取pid,调用taobao.itempropvalues.get获取vid;格式:pid:vid;pid:vid
	 */
	private String binds;

	/** 
	* 产品描述.最大不超过25000个字符
	 */
	private String desc;

	/** 
	* 产品主图.最大500K,目前仅支持GIF,JPG
	 */
	private FileItem image;

	/** 
	* 是否是主图
	 */
	private Boolean major;

	/** 
	* 产品名称.最大不超过30个字符
	 */
	private String name;

	/** 
	* 自定义非关键属性
	 */
	private String nativeUnkeyprops;

	/** 
	* 外部产品ID
	 */
	private String outerId;

	/** 
	* 产品市场价.精确到2位小数;单位为元.如:200.07
	 */
	private String price;

	/** 
	* 产品ID
	 */
	private Long productId;

	/** 
	* 销售属性.调用taobao.itemprops.get获取pid,调用taobao.itempropvalues.get获取vid;格式:pid:vid;pid:vid
	 */
	private String saleProps;

	public void setBinds(String binds) {
		this.binds = binds;
	}

	public String getBinds() {
		return this.binds;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setImage(FileItem image) {
		this.image = image;
	}

	public FileItem getImage() {
		return this.image;
	}

	public void setMajor(Boolean major) {
		this.major = major;
	}

	public Boolean getMajor() {
		return this.major;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setNativeUnkeyprops(String nativeUnkeyprops) {
		this.nativeUnkeyprops = nativeUnkeyprops;
	}

	public String getNativeUnkeyprops() {
		return this.nativeUnkeyprops;
	}

	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}

	public String getOuterId() {
		return this.outerId;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return this.price;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setSaleProps(String saleProps) {
		this.saleProps = saleProps;
	}

	public String getSaleProps() {
		return this.saleProps;
	}

	public String getApiMethodName() {
		return "taobao.product.update";
	}

	public Map<String, String> getTextParams() {
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("binds", this.binds);
		txtParams.put("desc", this.desc);
		txtParams.put("major", this.major);
		txtParams.put("name", this.name);
		txtParams.put("native_unkeyprops", this.nativeUnkeyprops);
		txtParams.put("outer_id", this.outerId);
		txtParams.put("price", this.price);
		txtParams.put("product_id", this.productId);
		txtParams.put("sale_props", this.saleProps);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<ProductUpdateResponse> getResponseClass() {
		return ProductUpdateResponse.class;
	}

	public void check() throws ApiRuleException {
		
		RequestCheckUtils.checkNotEmpty(productId, "productId");
	}

	public Map<String, FileItem> getFileParams() {
		Map<String, FileItem> params = new HashMap<String, FileItem>();
		params.put("image", this.image);
		return params;
	}
	
	

}