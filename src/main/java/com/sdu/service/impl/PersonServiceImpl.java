package com.sdu.service.impl;

import ch.qos.logback.core.joran.spi.ElementSelector;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdu.mapper.MovieMapper;
import com.sdu.mapper.PersonMapper;
import com.sdu.pojo.*;
import com.sdu.service.IPersonService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author LHP
 * @description 人物 Service 实现类
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

    @Autowired
    private PersonMapper personMapper;
    @Override
    public PersonVo getPersonById(Integer id) {
        Person person = personMapper.selectById(id);
        PersonVo personVo = parsePersonToPersonVo(person);
        return personVo;
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
    @Override
    public PersonVo parsePersonToPersonVo(Person person) {
        PersonVo personVo = new PersonVo();

        personVo.setId(person.getId());
        personVo.setName(person.getName());
        personVo.setPoster(person.getPoster());
        personVo.setGender(person.getGender());
        personVo.setConstellation(person.getConstellation());
        personVo.setBirthday(person.getBirthday());
        personVo.setBirthplace(person.getBirthplace());
        personVo.setImdb(person.getImdb());
        personVo.setIntroduction(person.getIntroduction());

        String types = person.getOccupation();
        List<String> typeList = Arrays.asList(types.split(" / "));
        personVo.setOccupation(typeList);

        // 提取图片链接，转换成 List<String>
        String images = person.getImages();
        if (images != null && !images.isEmpty() && images.length() != 2) {
            images = images.substring(2, images.length() - 2);
        }

        List<String> imageList = Arrays.asList(images.split("', '"));
        personVo.setImages(imageList);


        // 提取 awards 字段，转换成 Map<String, Map<String, String>>
        String awards = person.getAwards();
        List<PersonAwards> personAwards = new ArrayList<>();
        awards = awards.substring(1, awards.length()-1);
        if(awards.length() > 5)
        {
            List<String> A = Arrays.asList(awards.split(",},"));
            for(int i = 0; i < A.size(); i++)
            {

                PersonAwards x = new PersonAwards();
                x.setYear(A.get(i).substring(1, 5));
                String y = A.get(i).substring(9);
                List<String> z = Arrays.asList(y.split(","));
                x.setAwardList(z);
                personAwards.add(x);
            }
            personVo.setAwards(personAwards);
        }
        else
        {
            PersonAwards xx = new PersonAwards();
            xx.setYear("无");
            personAwards.add(xx);
            personVo.setAwards(personAwards);
        }
        /*
        JSONObject jsonObject = new JSONObject(awards);
        Map<String, List<String>> awardMap = new HashMap<>();


        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            JSONObject innerObject = jsonObject.getJSONObject(key);
//            Map<String, String> innerMap = new HashMap<>();
List<String> innerMap = new ArrayList<>();
            Iterator<String> innerKeys = innerObject.keys();
            while (innerKeys.hasNext()) {
                String innerKey = innerKeys.next();
                String innerValue = innerKey + "："+innerObject.getString(innerKey);
//                innerMap.put(innerKey, innerValue);
                innerMap.add(innerValue);
            }
            awardMap.put(key, innerMap);
        }*/



        return personVo;
    }


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
