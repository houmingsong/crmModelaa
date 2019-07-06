package com.project.dao;

import java.util.List;

import com.project.Bean.PlaceNumBean;
/**
 * 地区统计持久层
 * @author Administrator
 *
 */
public interface IPlaceNumDao {
	/**
	 * 显示地区统计信息
	 * @return 返回地区统计集合
	 */
	public List<PlaceNumBean> show();
}
