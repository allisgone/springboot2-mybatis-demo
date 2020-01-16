package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.FileItem;
import com.taobao.api.TaobaoUploadRequest;
import com.taobao.api.internal.util.TaobaoHashMap;

import com.taobao.api.response.ProductAddResponse;

/**
 * TOP API: taobao.product.add request
 * 
 * @author top auto create
 * @since 1.0, 2019.03.25
 */
public class ProductAddRequest extends BaseTaobaoRequest<ProductAddResponse> implements TaobaoUploadRequest<ProductAddResponse> {

	
	

	/** 
	* 非关键属性结构:pid:vid;pid:vid.<br>
非关键属性<font color=red>不包含<font>关键属性、销售属性、用户自定义属性、商品属性;
<br>调用taobao.itemprops.get获取pid,调用taobao.itempropvalues.get获取vid.<br><font color=red>注:支持最大长度为512字节<font>
	 */
	private String binds;

	/** 
	* 商品类目ID.调用taobao.itemcats.get获取;注意:必须是叶子类目 id.
	 */
	private Long cid;

	/** 
	* 用户自定义属性,结构：pid1:value1;pid2:value2，如果有型号，系列等子属性用: 隔开 例如：“20000:优衣库:型号:001;632501:1234”，表示“品牌:优衣库:型号:001;货号:1234”
<br><font color=red>注：包含所有自定义属性的传入<font>
	 */
	private String customerProps;

	/** 
	* 产品描述.最大不超过25000个字符
	 */
	private String desc;

	/** 
	* 产品主图片.最大1M,目前仅支持GIF,JPG.
	 */
	private FileItem image;

	/** 
	* 是不是主图
	 */
	private Boolean major;

	/** 
	* 上市时间。目前只支持鞋城类目传入此参数
	 */
	private Date marketTime;

	/** 
	* 产品名称,最大30个字符.
	 */
	private String name;

	/** 
	* native_unkeyprops
	 */
	private String nativeUnkeyprops;

	/** 
	* 外部产品ID
	 */
	private String outerId;

	/** 
	* 产品市场价.精确到2位小数;单位为元.如：200.07
	 */
	private String price;

	/** 
	* 销售属性值别名。格式为pid1:vid1:alias1;pid1:vid2:alia2。只有少数销售属性值支持传入别名，比如颜色和尺寸
	 */
	private String propertyAlias;

	/** 
	* 关键属性 结构:pid:vid;pid:vid.调用taobao.itemprops.get获取pid,调用taobao.itempropvalues.get获取vid;如果碰到用户自定义属性,请用customer_props.
	 */
	private String props;

	/** 
	* 销售属性结构:pid:vid;pid:vid.调用taobao.itemprops.get获取is_sale_prop＝true的pid,调用taobao.itempropvalues.get获取vid.
	 */
	private String saleProps;

	/** 
	* 加入垂直市场，目前只支持以鞋城卖家身份加入名鞋馆(暂时此字段还不起作用，不对外开放)
	 */
	private Long verticalMarket;

	public void setBinds(String binds) {
		this.binds = binds;
	}

	public String getBinds() {
		return this.binds;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setCustomerProps(String customerProps) {
		this.customerProps = customerProps;
	}

	public String getCustomerProps() {
		return this.customerProps;
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

	public void setMarketTime(Date marketTime) {
		this.marketTime = marketTime;
	}

	public Date getMarketTime() {
		return this.marketTime;
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

	public void setPropertyAlias(String propertyAlias) {
		this.propertyAlias = propertyAlias;
	}

	public String getPropertyAlias() {
		return this.propertyAlias;
	}

	public void setProps(String props) {
		this.props = props;
	}

	public String getProps() {
		return this.props;
	}

	public void setSaleProps(String saleProps) {
		this.saleProps = saleProps;
	}

	public String getSaleProps() {
		return this.saleProps;
	}

	public void setVerticalMarket(Long verticalMarket) {
		this.verticalMarket = verticalMarket;
	}

	public Long getVerticalMarket() {
		return this.verticalMarket;
	}

	public String getApiMethodName() {
		return "taobao.product.add";
	}

	public Map<String, String> getTextParams() {
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("binds", this.binds);
		txtParams.put("cid", this.cid);
		txtParams.put("customer_props", this.customerProps);
		txtParams.put("desc", this.desc);
		txtParams.put("major", this.major);
		txtParams.put("market_time", this.marketTime);
		txtParams.put("name", this.name);
		txtParams.put("native_unkeyprops", this.nativeUnkeyprops);
		txtParams.put("outer_id", this.outerId);
		txtParams.put("price", this.price);
		txtParams.put("property_alias", this.propertyAlias);
		txtParams.put("props", this.props);
		txtParams.put("sale_props", this.saleProps);
		txtParams.put("vertical_market", this.verticalMarket);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<ProductAddResponse> getResponseClass() {
		return ProductAddResponse.class;
	}

	public void check() throws ApiRuleException {
		
		RequestCheckUtils.checkMaxLength(binds, 512, "binds");
		RequestCheckUtils.checkNotEmpty(cid, "cid");
		RequestCheckUtils.checkNotEmpty(image, "image");
	}

	public Map<String, FileItem> getFileParams() {
		Map<String, FileItem> params = new HashMap<String, FileItem>();
		params.put("image", this.image);
		return params;
	}
	
	

}