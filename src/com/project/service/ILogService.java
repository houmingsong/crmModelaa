package com.project.service;

import java.sql.Date;
import java.util.List;

import com.project.Bean.LogBean;
/**
 * 日志业务层
 * @author Administrator
 *
 */
public interface ILogService {
	/**
	 * 按日期查询日志
	 * @param startTime 起始日期
	 * @param endTime 结束日期
	 * @return 返回日志集合
	 */
	public List<LogBean> findByDate(Date startTime,Date endTime);
	
	
}
