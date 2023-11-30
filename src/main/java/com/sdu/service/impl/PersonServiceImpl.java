package com.sdu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdu.mapper.PersonMapper;
import com.sdu.pojo.Person;
import com.sdu.pojo.PersonVo;
import com.sdu.service.IPersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LHP
 * @description 人物 Service 实现类
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

    @Override
    public Person getPersonById(Integer id) {
        Person person = baseMapper.selectById(id);
        return person;
    }

    @Override
    public List<PersonVo> getPersonsByMovieId(Integer id) {
        List<PersonVo> personVoList = baseMapper.getPersonsByMovieId(id);
//        List<PersonVo> personVoList = new ArrayList<>();
        return personVoList;
    }

    /**
     * 将 实体类Person 转换成 返回类PersonVo
     *
     * @param person
     * @return
     */
//    private PersonVo parsePersonToPersonVo(Person person) {
//        PersonVo personVo = new PersonVo();
//        personVo.setId(person.getId());
//        personVo.setName(person.getName());
//        personVo.setPoster(person.getPoster());
//        personVo.setGender(person.getGender());
//        personVo.setConstellation(person.getConstellation());
//        personVo.setBirthday(person.getBirthday());
//        personVo.setBirthplace(person.getBirthplace());
//        personVo.setOccupation(person.getOccupation());
//        personVo.setImdb(person.getImdb());
//        personVo.setIntroduction(person.getIntroduction());
//        personVo.setImages(person.getImages());
//        personVo.setAwards(person.getAwards());
//        personVo.setWork(person.getWork());
//
//
//        return personVo;
//    }
}
