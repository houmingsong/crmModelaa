package com.project.service;

import java.util.List;

import com.project.Bean.CityBean;
/**
 * 城市业务接口
 * @author Administrator
 *
 */
public interface ICityService {
	/**
	 * 查询所有城市
	 * @return 返回城市集合
	 */
	public List<CityBean> findAll();
	/**
	 * 查询所有城市，同时查询每个城市中状态为“推广开展”的学校
	 * @return 返回城市对象集合
	 */
	public List<CityBean> findAllIncludeSchool();
}
