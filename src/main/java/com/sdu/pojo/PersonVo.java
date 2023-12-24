package com.sdu.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author LHP
 * @description 人物返回类
 */
@Data
public class PersonVo {

    private Integer id;
    private String name;
    private String poster;
    private String gender;
    private String constellation;
    private String birthday;
    private String birthplace;
    private List<String> occupation;
    private String imdb;
    private String introduction;
    private List<String> images;
    private List<PersonAwards> awards;
    private String work;
}
