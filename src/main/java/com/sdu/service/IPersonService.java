package com.sdu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdu.pojo.Movie;
import com.sdu.pojo.MovieVo;
import com.sdu.pojo.Person;
import com.sdu.pojo.PersonVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LHP
 * @description 人物 Service 接口
 */
public interface IPersonService extends IService<Person> {
    public PersonVo getPersonById(Integer id);

    public List<PersonVo> getPersonsByMovieId(@Param("movieId") Integer id);


    public PersonVo parsePersonToPersonVo(Person person);
}
