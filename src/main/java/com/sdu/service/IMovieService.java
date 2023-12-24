package com.sdu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdu.pojo.Movie;
import com.sdu.pojo.MovieVo;

import java.util.List;

/**
 * @author LHP
 * @description 电影 Service 接口
 */
public interface IMovieService extends IService<Movie> {
    public MovieVo getMovieById(Integer id);
    public List<MovieVo> getAllMovies();
    public List<MovieVo> getTop10Movies();

    public List<MovieVo> getMoviesByKeyword(String keyword);

    public List<MovieVo> getTop250Movies();

    public List<MovieVo> getRecentMovieByPersonId(String id);
    public List<MovieVo> getBestMovieByPersonId(String id);


    public MovieVo parseMovieToMovieVo(Movie movie);
}
