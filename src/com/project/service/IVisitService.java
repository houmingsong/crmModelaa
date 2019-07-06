package com.project.service;

import java.sql.Date;

import com.project.Bean.VisitBean;
/**
 * 回访记录业务层
 * @author Administrator
 *
 */
public interface IVisitService {
	/**
	 * 添加回访记录
	 * @param vb 访问记录对象
	 */
	public void addVisit(VisitBean vb);
}
