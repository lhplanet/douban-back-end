package com.sdu.controller;

import com.sdu.pojo.Movie;
import com.sdu.pojo.MovieVo;
import com.sdu.service.IMovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;

import java.util.*;

/**
 * @author
 * @description 电影 Controller 类
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping("/getMovieById")
    public MovieVo getMovieById(@RequestParam Integer id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/getAllMovies")
    public List<MovieVo> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/getTop10Movies")
    public List<MovieVo> getTop10Movies() {
        return movieService.getTop10Movies();
    }

    @GetMapping("/getMoviesByKeyword")
    public List<MovieVo> getMoviesByKeyword(@RequestParam String keyword) {
        return movieService.getMoviesByKeyword(keyword);
    }

    @GetMapping("/getTop250Movies")
    public List<MovieVo> getTop250Movies() {
        return movieService.getTop250Movies();
    }

    /**
     * 根据人物 id 获取最近的5部作品
     */
    @GetMapping("/getRecentMovieByPersonId")
    public List<MovieVo> getRecentMovieByPersonId(@RequestParam String id) {
        return movieService.getRecentMovieByPersonId(id);
    }

    @GetMapping("/getBestMovieByPersonId")
    public List<MovieVo> getBestMovieByPersonId(@RequestParam String id) {
        return movieService.getBestMovieByPersonId(id);
    }
}
