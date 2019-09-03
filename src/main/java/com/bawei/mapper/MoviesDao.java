package com.bawei.mapper;

import java.util.List;
import java.util.Map;

import com.bawei.bean.Movies;
import com.bawei.bean.Story;

/**
 * @作者 hsj
 * @日期 2019年9月3日
 */
public interface MoviesDao {

	public List<Movies> selectAllMovies(Map<String, Object> map);
	
	public List<Story> selectAllStory();
	
	public int addMo(Movies movies);
	
	public void addMoviesStory(Map<String, Object> map);
	
	public void delMo(String mids);
	
	public void delMoviesStory(String mids);
	
	public Movies selectOneMoviesById(Integer mid);
	
	public int updateMoviesById(Movies movies);
	
	public int deleteById(Integer mid);
}
