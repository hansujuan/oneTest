package com.bawei.service;

import java.util.List;
import java.util.Map;

import com.bawei.bean.Movies;
import com.bawei.bean.Story;

/**
 * @作者 hsj
 * @日期 2019年9月3日
 */
public interface IMoviesService {

	public List<Movies> selectAllMovies(Map<String, Object> map);
	
	public List<Story> selectAllStory();

	public String addMovies(Movies movies, Integer[] sid);

	public String delAll(String mids);

	public Movies selectOneMoviesById(Integer mid);

	public String updateMoviesById(Movies movies,Integer[] sid);
}
