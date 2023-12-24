package com.sdu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdu.mapper.MovieMapper;
import com.sdu.pojo.Movie;
import com.sdu.pojo.MovieVo;
import com.sdu.service.IMovieService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author LHP
 * @description 电影 Service 实现类
 */

@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements IMovieService {

    @Autowired
    private MovieMapper movieMapper;

    /**
     * 根据 id 获取电影信息
     * @param id
     * @return
     */
    @Override
    public MovieVo getMovieById(Integer id) {
        Movie movie = movieMapper.selectById(id);
        MovieVo movieVo = parseMovieToMovieVo(movie);
        return movieVo;
    }

    /**
     * 获取所有电影信息
     * @return
     */
    @Override
    public List<MovieVo> getAllMovies() {
        List<Movie> movieList = movieMapper.getAllMovies();
        List<MovieVo> movieVoList = new ArrayList<>();
        for (Movie movie : movieList) {
            MovieVo movieVo = parseMovieToMovieVo(movie);
            movieVoList.add(movieVo);
        }
        return movieVoList;
    }

    /**
     * 获取评分前10的电影信息
     * @return
     */
    @Override
    public List<MovieVo> getTop10Movies() {
        List<Movie> movieList = movieMapper.getTop10Movies();
        List<MovieVo> movieVoList = new ArrayList<>();
        for (Movie movie : movieList) {
            MovieVo movieVo = parseMovieToMovieVo(movie);
            movieVoList.add(movieVo);
        }
        return movieVoList;
    }

    /**
     * 根据用户输入的关键词获取电影信息
     * @param keyword
     * @return
     */
    @Override
    public List<MovieVo> getMoviesByKeyword(String keyword) {
        List<Movie> movieList = movieMapper.getMoviesByKeyword(keyword);
        List<MovieVo> movieVoList = new ArrayList<>();
        for (Movie movie : movieList) {
            MovieVo movieVo = parseMovieToMovieVo(movie);
            movieVoList.add(movieVo);
        }
        return movieVoList;
    }

    /**
     * 获取评分前250的电影信息
     * @return
     */
    @Override
    public List<MovieVo> getTop250Movies() {
        List<Movie> movieList = movieMapper.getTop250Movies();
        List<MovieVo> movieVoList = new ArrayList<>();
        for (Movie movie : movieList) {
            MovieVo movieVo = parseMovieToMovieVo(movie);
            movieVoList.add(movieVo);
        }
        return movieVoList;
    }

    /**
     * 根据人物 id 获取最近的 5 部作品
     */
    @Override
    public List<MovieVo> getRecentMovieByPersonId(String id) {
        List<Movie> movieList = movieMapper.getRecentMovieByPersonId(id);
        List<MovieVo> movieVoList = new ArrayList<>();
        for (Movie movie : movieList) {
            MovieVo movieVo = parseMovieToMovieVo(movie);
            movieVoList.add(movieVo);
        }
        return movieVoList;
    }
    @Override
    public List<MovieVo> getBestMovieByPersonId(String id) {
        List<Movie> movieList = movieMapper.getBestMovieByPersonId(id);
        List<MovieVo> movieVoList = new ArrayList<>();
        for (Movie movie : movieList) {
            MovieVo movieVo = parseMovieToMovieVo(movie);
            movieVoList.add(movieVo);
        }
        return movieVoList;
    }

    /**
     * 将 实体类Movie 转换成 返回类MovieVo
     * @param movie
     * @return
     */
    @Override
    public MovieVo parseMovieToMovieVo(Movie movie) {
        MovieVo movieVo = new MovieVo();

        movieVo.setId(movie.getId());
        movieVo.setName(movie.getName());
        movieVo.setYear(movie.getYear());
        movieVo.setPoster(movie.getPoster());

        String directors = movie.getDirector();
        List<String> directorList = Arrays.asList(directors.split(" / "));
        movieVo.setDirectors(directorList);

        String scriptWriters = movie.getScriptWriter();
        List<String> scriptWriterList = Arrays.asList(scriptWriters.split(" / "));
        movieVo.setScriptWriters(scriptWriterList);

        String actors = movie.getActor();
        List<String> actorList = Arrays.asList(actors.split(" / "));
        movieVo.setActors(actorList);

        String types = movie.getType();
        List<String> typeList = Arrays.asList(types.split(" / "));
        movieVo.setTypes(typeList);

        String countries = movie.getCountry();
        List<String> countryList = Arrays.asList(countries.split(" / "));
        movieVo.setCountries(countryList);

        movieVo.setLanguage(movie.getLanguage());
        movieVo.setReleaseDate(movie.getReleaseDate());
        movieVo.setDuration(movie.getDuration());
        movieVo.setAlias(movie.getAlias());
        movieVo.setImdb(movie.getImdb());

        // String 转换成 Double
        movieVo.setRating(Double.valueOf(movie.getRating()));

        // String 转换成 Integer
        movieVo.setVotes(Integer.valueOf(movie.getVotes()));

        // String 转换成 Double
        movieVo.setR5(Double.valueOf(movie.getR5().substring(0, movie.getR5().length() - 1)));
        movieVo.setR4(Double.valueOf(movie.getR4().substring(0, movie.getR4().length() - 1)));
        movieVo.setR3(Double.valueOf(movie.getR3().substring(0, movie.getR3().length() - 1)));
        movieVo.setR2(Double.valueOf(movie.getR2().substring(0, movie.getR2().length() - 1)));
        movieVo.setR1(Double.valueOf(movie.getR1().substring(0, movie.getR1().length() - 1)));

        movieVo.setIntroduction(movie.getIntroduction());

        // 提取图片链接，转换成 List<String>
        String images = movie.getImages();
        if (images != null && !images.isEmpty() && images.length() != 2) {
            images = images.substring(2, images.length() - 2);
        }

        List<String> imageList = Arrays.asList(images.split("', '"));
        movieVo.setImages(imageList);

        // 提取 awards 字段，转换成 Map<String, Map<String, String>>
        String awards = movie.getAwards();
        JSONObject jsonObject = new JSONObject(awards);
        Map<String, Map<String, String>> awardMap = new HashMap<>();

        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            JSONObject innerObject = jsonObject.getJSONObject(key);
            Map<String, String> innerMap = new HashMap<>();

            Iterator<String> innerKeys = innerObject.keys();
            while (innerKeys.hasNext()) {
                String innerKey = innerKeys.next();
                String innerValue = innerObject.getString(innerKey);
                innerMap.put(innerKey, innerValue);
            }
            awardMap.put(key, innerMap);
        }
        movieVo.setAwards(awardMap);

        // 提取 alsoLike 字段，转换成 Map<String, String>
        String alsoLikes = movie.getAlsoLike();
        alsoLikes = alsoLikes.substring(0, alsoLikes.length() - 1);
        Map<String, String> moviesMap = new HashMap<>();

        String[] movies = alsoLikes.split(",");
        for (String movieMap : movies) {
            String[] parts = movieMap.split(":");
            if (parts.length == 3) {
                String movieName = parts[0];
                String movieLink = parts[1] + ":" + parts[2];
                moviesMap.put(movieName, movieLink);
            }
        }
        movieVo.setAlsoLikes(moviesMap);

        // 提取 comments 字段，转换成 List<String>
        String comments = movie.getComments();
        comments = comments.substring(2, comments.length() - 2);
        List<String> commentsList = Arrays.asList(comments.split("', '"));
        movieVo.setComments(commentsList);


        String playSources = movie.getPlaySources();
        if (playSources != null && playSources.length() != 2 && !playSources.isEmpty()) {
            playSources = playSources.substring(2, playSources.length() - 2);
        }

        Map<String, String> playSourcesMap = new HashMap<>();

        String[] playSourcesList = playSources.split("', '");
        for (String playSourceMap : playSourcesList) {
            String[] parts = playSourceMap.split(":");
            if (parts.length == 3) {
                String playSourceName = parts[0];
                String playSourceLink = parts[1] + ":" + parts[2];
                playSourcesMap.put(playSourceName, playSourceLink);
            }
        }
        movieVo.setPlaySources(playSourcesMap);


        return movieVo;
    }
}
