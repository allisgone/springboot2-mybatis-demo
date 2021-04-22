package com.winterchen.model;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典项
 * 
 * @author tanghaihua
 * @email 814100831@qq.com
 * @date 2020-07-29 11:41:03
 */
@Data
@TableName("dictionary_item")
public class DictionaryItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId
	private Long id;
	/**
	 * 父级ID
	 */
	private Long pid;
	/**
	 * 字典类型id
	 */
	private Long dictionaryClassificationId;
	/**
	 * 字典项内容
	 */
	private String itemData;

	@TableField(exist = false)
	private JSONObject itemJsonData;
	/**
	 * 排序
	 */
	private Long itemOrder;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 有效性(0：失效,1：有效)
	 */
	private Integer status;

}
