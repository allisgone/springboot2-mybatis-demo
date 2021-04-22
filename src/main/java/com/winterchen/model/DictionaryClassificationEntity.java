package com.winterchen.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典类型
 * 
 * @author tanghaihua
 * @email 814100831@qq.com
 * @date 2020-07-29 11:41:03
 */
@Data
@TableName("dictionary_classification")
public class DictionaryClassificationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId
	private Long id;
	/**
	 * 字典项类型 1 单独项 2数组项
	 */
	private Integer itemType;
	/**
	 * 字典类型值
	 */
	private String dictionaryClassification;
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
