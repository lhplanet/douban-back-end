package com.sdu.pojo;

import lombok.Data;

/**
 * @author LHP
 * @description 人物返回类
 */
@Data
public class PersonVo {
    /**
     * 人物id
     */
    private Integer id;
    /**
     * 人物姓名
     */
    private String name;
    /**
     * 人物海报
     */
    private String poster;
    /**
     * 人物性别
     */
    private String gender;
    /**
     * 人物星座
     */
    private String constellation;
    /**
     * 人物出生日期
     */
    private String birthday;
    /**
     * 人物出生地
     */
    private String birthplace;
    /**
     * 人物职业
     */
    private String occupation;
    /**
     * 人物IMDb编号
     */
    private String imdb;
    /**
     * 人物简介
     */
    private String introduction;
    /**
     * 人物图片
     */
    private String images;
    /**
     * 人物获奖情况
     */
    private String awards;
    /**
     * 人物职位
     */
    private String work;
}
