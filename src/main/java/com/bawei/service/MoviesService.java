package com.bawei.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bawei.bean.Movies;
import com.bawei.bean.Story;
import com.bawei.mapper.MoviesDao;

/**
 * @作者 hsj
 * @日期 2019年9月3日
 */
@Service
public class MoviesService implements IMoviesService{

	@Resource
	private MoviesDao md;
//注入
	public List<Movies> selectAllMovies(Map<String, Object> map) {
		return md.selectAllMovies(map);
	}
// 列表数据显式
	public List<Story> selectAllStory() {
		return md.selectAllStory();
	}
// 动态回显多选框
	public String addMovies(Movies movies, Integer[] sid) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = md.addMo(movies);
		Integer mid = movies.getMid();
		for (Integer s : sid) {
			map.put("mid", mid);
			map.put("sid", s);
			md.addMoviesStory(map);
			map.clear();
		}
//		循环添加数据
		return "succ";
	}
//添加数据，且映射多对多的关系
	public String delAll(String mids) {
		md.delMo(mids);
		md.delMoviesStory(mids);
		return "succ";
	}
//批零删除的方法
	public Movies selectOneMoviesById(Integer mid) {
		return md.selectOneMoviesById(mid);
	}
// 回显数据，作为修改
	public String updateMoviesById(Movies movies,Integer[] sid) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = md.updateMoviesById(movies);
//		修改的方法
		int j = md.deleteById(movies.getMid());
		for (Integer s : sid) {
			map.put("mid", movies.getMid());
			map.put("sid", s);
			md.addMoviesStory(map);
			map.clear();
		}
//		循环
		return "succ";
	}
//	修改数据，映射多对多
}
