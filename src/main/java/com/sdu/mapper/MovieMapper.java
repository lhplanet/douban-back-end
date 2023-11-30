package com.sdu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdu.pojo.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LHP
 * @description 电影 Mapper 接口
 */
@Mapper
public interface MovieMapper extends BaseMapper<Movie> {

    public List<Movie> getAllMovies();
    public List<Movie> getTop10Movies();
    public List<Movie> getMoviesByKeyword(@Param("keyword") String keyword);
    public List<Movie> getTop250Movies();
}
