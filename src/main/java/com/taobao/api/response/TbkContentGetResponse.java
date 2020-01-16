package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.tbk.content.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TbkContentGetResponse extends TaobaoResponse {

	private static final long serialVersionUID = 6329891591673521816L;

	/** 
	 * result
	 */
	@ApiField("result")
	private RpcResult result;


	public void setResult(RpcResult result) {
		this.result = result;
	}
	public RpcResult getResult( ) {
		return this.result;
	}
	
	/**
 * 内容列表
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class MapData extends TaobaoObject {

	private static final long serialVersionUID = 4392741628412336194L;

	/**
		 * 达人头像 URL
		 */
		@ApiField("author_avatar")
		private String authorAvatar;
		/**
		 * 达人ID
		 */
		@ApiField("author_id")
		private String authorId;
		/**
		 * 达人昵称
		 */
		@ApiField("author_nick")
		private String authorNick;
		/**
		 * 文章链接
		 */
		@ApiField("clink")
		private String clink;
		/**
		 * 内容分类，多个分类用英文逗号分隔
		 */
		@ApiField("content_categories")
		private String contentCategories;
		/**
		 * 内容ID
		 */
		@ApiField("content_id")
		private Long contentId;
		/**
		 * 封面图，多张图用英文逗号分隔
		 */
		@ApiListField("images")
		@ApiField("string")
		private List<String> images;
		/**
		 * 宝贝id列表
		 */
		@ApiListField("item_ids")
		@ApiField("number")
		private List<Long> itemIds;
		/**
		 * 大促标签
		 */
		@ApiField("promotion_tag")
		private String promotionTag;
		/**
		 * 内容发布时间
		 */
		@ApiField("publish_time")
		private String publishTime;
		/**
		 * 质量分。质量分越高代表内容质量和收益越好
		 */
		@ApiField("score")
		private Long score;
		/**
		 * 【未开放】内容摘要
		 */
		@ApiField("summary")
		private String summary;
		/**
		 * 【未开放】内容标签，多个标签用英文逗号分隔
		 */
		@ApiField("tags")
		private String tags;
		/**
		 * 内容的标题
		 */
		@ApiField("title")
		private String title;
		/**
		 * 展示样式，内容类型：1.图文、2.图集
		 */
		@ApiField("type")
		private String type;
		/**
		 * 本期仅支持3。展示样式，0:无图样式 1:单图样式 3:三图样式 4:大图样式
		 */
		@ApiField("ui_style")
		private String uiStyle;
		/**
		 * 内容更新时间
		 */
		@ApiField("update_time")
		private String updateTime;
	

	public String getAuthorAvatar() {
			return this.authorAvatar;
		}
		public void setAuthorAvatar(String authorAvatar) {
			this.authorAvatar = authorAvatar;
		}
		public String getAuthorId() {
			return this.authorId;
		}
		public void setAuthorId(String authorId) {
			this.authorId = authorId;
		}
		public String getAuthorNick() {
			return this.authorNick;
		}
		public void setAuthorNick(String authorNick) {
			this.authorNick = authorNick;
		}
		public String getClink() {
			return this.clink;
		}
		public void setClink(String clink) {
			this.clink = clink;
		}
		public String getContentCategories() {
			return this.contentCategories;
		}
		public void setContentCategories(String contentCategories) {
			this.contentCategories = contentCategories;
		}
		public Long getContentId() {
			return this.contentId;
		}
		public void setContentId(Long contentId) {
			this.contentId = contentId;
		}
		public List<String> getImages() {
			return this.images;
		}
		public void setImages(List<String> images) {
			this.images = images;
		}
		public List<Long> getItemIds() {
			return this.itemIds;
		}
		public void setItemIds(List<Long> itemIds) {
			this.itemIds = itemIds;
		}
		public String getPromotionTag() {
			return this.promotionTag;
		}
		public void setPromotionTag(String promotionTag) {
			this.promotionTag = promotionTag;
		}
		public String getPublishTime() {
			return this.publishTime;
		}
		public void setPublishTime(String publishTime) {
			this.publishTime = publishTime;
		}
		public Long getScore() {
			return this.score;
		}
		public void setScore(Long score) {
			this.score = score;
		}
		public String getSummary() {
			return this.summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		public String getTags() {
			return this.tags;
		}
		public void setTags(String tags) {
			this.tags = tags;
		}
		public String getTitle() {
			return this.title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getType() {
			return this.type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getUiStyle() {
			return this.uiStyle;
		}
		public void setUiStyle(String uiStyle) {
			this.uiStyle = uiStyle;
		}
		public String getUpdateTime() {
			return this.updateTime;
		}
		public void setUpdateTime(String updateTime) {
			this.updateTime = updateTime;
		}

}

	/**
 * result
 *
 * @author top auto create
 * @since 1.0, null
 */
public static class RpcResult extends TaobaoObject {

	private static final long serialVersionUID = 7476376925441188898L;

	/**
		 * data
		 */
		@ApiField("data")
		private MapData data;
	

	public MapData getData() {
			return this.data;
		}
		public void setData(MapData data) {
			this.data = data;
		}

}



}
