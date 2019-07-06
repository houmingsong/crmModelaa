package com.project.dao;

import java.util.List;

import com.project.Bean.CityBean;
/**
 * 查询城市持久层
 * @author Administrator
 *
 */
public interface ICityDao {
	/**
	 * 查询所有城市
	 * @return 返回城市集合
	 */
	public List<CityBean> findAll();
	
}
