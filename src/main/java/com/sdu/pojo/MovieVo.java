package com.sdu.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author LHP
 * @description 电影返回类
 */
@Data
public class MovieVo {
    private Integer id;
    private String name;
    private String year;
    private String poster;
    private List<String> directors;
    private List<String> scriptWriters;
    private List<String> actors;
    private List<String> types;
    private List<String> countries;
    private String language;
    private String releaseDate;
    private String duration;
    private String alias;
    private String imdb;
    private Double rating;
    private Integer votes;
    private Double r5;
    private Double r4;
    private Double r3;
    private Double r2;
    private Double r1;
    private String introduction;
    private List<String> images;
    private Map<String, Map<String, String>> awards;
    private Map<String, String> alsoLikes;
    private List<String> comments;
    private Map<String, String> playSources;
}
