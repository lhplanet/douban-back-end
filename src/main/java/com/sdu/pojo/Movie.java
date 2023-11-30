package com.sdu.pojo;

import lombok.Data;

/**
 * @author LHP
 * @description 电影实体类
 */
@Data
public class Movie {
    /**
     * 电影id
     */
    private Integer id;
    /**
     * 电影名称
     */
    private String name;
    /**
     * 电影年份
     */
    private String year;
    /**
     * 电影海报
     */
    private String poster;
    /**
     * 导演
     */
    private String director;
    /**
     * 编剧
     */
    private String scriptWriter;
    /**
     * 演员
     */
    private String actor;
    /**
     * 类型
     */
    private String type;
    /**
     * 国家/地区
     */
    private String country;
    /**
     * 语言
     */
    private String language;
    /**
     * 上映日期
     */
    private String releaseDate;
    /**
     * 片长
     */
    private String duration;
    /**
     * 又名
     */
    private String alias;
    /**
     * IMDb链接
     */
    private String imdb;
    /**
     * 评分
     */
    private String rating;
    /**
     * 评分人数
     */
    private String votes;
    /**
     * 五星人数
     */
    private String r5;
    /**
     * 四星人数
     */
    private String r4;
    /**
     * 三星人数
     */
    private String r3;
    /**
     * 二星人数
     */
    private String r2;
    /**
     * 一星人数
     */
    private String r1;
    /**
     * 电影简介
     */
    private String introduction;
    /**
     * 电影图片
     */
    private String images;
    /**
     * 获奖情况
     */
    private String awards;
    /**
     * 喜欢它的人还喜欢
     */
    private String alsoLike;
    /**
     * 评论
     */
    private String comments;
    /**
     * 在哪看这部电影
     */
    private String playSources;

}
