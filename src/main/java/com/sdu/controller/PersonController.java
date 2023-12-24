package com.sdu.controller;

import com.sdu.pojo.MovieVo;
import com.sdu.pojo.Person;
import com.sdu.pojo.PersonVo;
import com.sdu.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LHP
 * @description 人物 Controller 类
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    /**
     * 根据 id 获取人物信息
     * @param id
     * @return
     */
    @GetMapping("/getPersonById")
    public PersonVo getPersonById(@RequestParam Integer id) {
        return personService.getPersonById(id);
    }

    /**
     * 根据电影 id 获取人物信息列表
     * @param id
     * @return
     */
    @GetMapping("/getPersonsByMovieId")
    public List<PersonVo> getPersonsByMovieId(@RequestParam Integer id) {
        return personService.getPersonsByMovieId(id);
    }

}
