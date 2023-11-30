package com.sdu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdu.pojo.Person;
import com.sdu.pojo.PersonVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LHP
 * @description 人物 Mapper 接口
 */
@Mapper
public interface PersonMapper extends BaseMapper<Person> {
//    public List<Person> getPersonById(Integer id);

    public List<PersonVo> getPersonsByMovieId(Integer movieId);
}
