package com.project.service;

import java.util.List;

import com.project.Bean.PlaceNumBean;
/**
 * 统计地区业务层
 * @author Administrator
 *
 */
public interface IPlaceNumService {
	/**
	 * 显示地区统计信息
	 * @return 返回地区统计集合
	 */
	public List<PlaceNumBean> show();
}
