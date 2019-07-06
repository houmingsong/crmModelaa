package com.project.dao;

import java.util.List;

import com.project.Bean.SchoolNumBean;
/**
 * 统计学校持久层
 * @author Administrator
 *
 */
public interface ISchoolNumDao {
	/**
	 * 显示学校统计信息
	 * @param cityId 城市编号
	 * @return 返回学校统计集合
	 */
	public List<SchoolNumBean> showSchoolNumBean(int cityId);
}
