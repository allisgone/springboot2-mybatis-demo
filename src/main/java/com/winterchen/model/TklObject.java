package com.winterchen.model;


import lombok.Data;

import java.util.List;

@Data
public class TklObject{
    private int status;

    private List<Content> content;

    @Data
    public static class Content{
        private String code;

        private String type_one_id;

        private String tao_id;

        private String title;

        private String jianjie;

        private String pict_url;

        private String user_type;

        private String seller_id;

        private String shop_dsr;

        private String volume;

        private String size;

        private String quanhou_jiage;

        private String date_time_yongjin;

        private String tkrate3;

        private String yongjin_type;

        private String coupon_id;

        private String coupon_start_time;

        private String coupon_end_time;

        private String coupon_info_money;

        private String coupon_total_count;

        private String coupon_remain_count;

        private String coupon_info;

        private String juhuasuan;

        private String taoqianggou;

        private String haitao;

        private String jiyoujia;

        private String jinpaimaijia;

        private String pinpai;

        private String pinpai_name;

        private String yunfeixian;

        private String nick;

        private String small_images;

        private String white_image;

        private String tao_title;

        private String provcity;

        private String shop_title;

        private String zhibo_url;

        private String sellCount;

        private String commentCount;

        private String favcount;

        private String score1;

        private String score2;

        private String score3;

        private String creditLevel;

        private String shopIcon;

        private String pcDescContent;

        private String taobao_url;

        private String category_id;

        private String category_name;

        private String level_one_category_id;

        private String level_one_category_name;

        private String tkfee3;

        private String biaoqian;

        private String coupon_click_url;

        private String item_url;

        private String tkl;
    }
}