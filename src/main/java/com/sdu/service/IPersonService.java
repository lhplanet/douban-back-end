package com.sdu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdu.pojo.Person;
import com.sdu.pojo.PersonVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LHP
 * @description 人物 Service 接口
 */
public interface IPersonService extends IService<Person> {
    public Person getPersonById(Integer id);

    public List<PersonVo> getPersonsByMovieId(@Param("movieId") Integer id);
}
