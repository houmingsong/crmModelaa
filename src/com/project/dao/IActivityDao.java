package com.project.dao;

import java.util.List;

import com.project.Bean.ActivityBean;
/**
 * 活动持久层
 * @author Administrator
 *
 */
public interface IActivityDao {
	/**
	 * 添加活动信息
	 * @param ab 传入活动对象
	 */
	public void add(ActivityBean ab);
	
	
	/**
	 * 显示学校活动信息，根据学校Id查看学校活动信息
	 * @param schoolld 学校id
	 * @return 返回活动集合
	 */
	public List<ActivityBean> findActivityBySchoolID(int schoolld);
}
