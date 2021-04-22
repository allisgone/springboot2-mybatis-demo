package com.winterchen.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yijun
 * @date 2020\4\22 0022
 */
@Data
public class DictionaryListInput implements Serializable {

    private static final long serialVersionUID = -9166363487825929536L;
    /**
     * 字典类型值
     */
    private String dictionaryClassification;

    /**
     * 字典值 json 字符串
     */
    private item[] itemDatas;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 是否需要清除掉原所有字典项
     */
    private Boolean needDeleteItems=false;
    @Data
    public static class item{
        public item() {
        }

        /**
         * 字典项id
         */
        private Long id;
        /**
         * 字典值 json 字符串
         */
        private JSONObject itemData;

        /**
         * 排序
         */
        private Long itemOrder;

        /**
         * 备注
         */
        private String remarks;
    }
}
