package com.bawei.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bawei.bean.Movies;
import com.bawei.bean.Story;
import com.bawei.service.IMoviesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @作者 hsj
 * @日期 2019年9月3日
 */
@Controller
public class MoviesController {

	@Resource
	private IMoviesService ms;
//	注入
	@RequestMapping("list.do")
	public ModelAndView selectAllMovies(@RequestParam(required=false,defaultValue="1")Integer pageNum,String mname){
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("mname", mname);
		System.out.println("-----"+mname);
		PageHelper.startPage(pageNum, 3);
		System.out.println("-----------------");
		System.out.println("*************************");
		System.out.println("11111111111111111");
		List<Movies> list = ms.selectAllMovies(map);
		PageInfo<Movies> page = new PageInfo<>(list);
//		分页
		mv.setViewName("list");
		mv.getModelMap().put("page", page);
		mv.getModelMap().put("mname", mname);
//		模糊
		return mv;
	}
//	列表的方法，包括模糊查询
	@RequestMapping("add.do")
	public String add(Model model){
		List<Story> list = ms.selectAllStory();
		model.addAttribute("list", list);
		return "addMovies";
	}
//	动态显式多选框
	@RequestMapping("addMovies.do")
	@ResponseBody
	public String addMovies(Movies movies,Integer[] sid){
		String str = ms.addMovies(movies,sid);
		return str;
	}
//	添加电影信息，并映射多对多的关系
	@RequestMapping("delAll.do")
	@ResponseBody
	public String delAll(String mids){
		String str = ms.delAll(mids);
		return str;
	}
//	批量删除的方法
	@RequestMapping("updateMovies.do")
	@ResponseBody
	public Map<String, Object> updateMovies(Integer mid){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Story> list = ms.selectAllStory();
		Movies movies = ms.selectOneMoviesById(mid);
		map.put("list", list);
		map.put("movies", movies);
//		修改显式映射多对多的关系，进行回显数据
		return map;
	}
//	修改的方法
	@RequestMapping("updateMoviesById.do")
	@ResponseBody
	public String updateMoviesById(Movies movies,Integer[] sid){
		String str = ms.updateMoviesById(movies,sid);
		return str;
	}
//	修改的方法
}
