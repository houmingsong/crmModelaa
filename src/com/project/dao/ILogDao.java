package com.project.dao;

import java.sql.Date;
import java.util.List;

import com.project.Bean.LogBean;
/**
 * 日志持久层
 * @author Administrator
 *
 */
public interface ILogDao {
	/**
	 * 写登录日志
	 * @param lb 传入日志对象
	 */
	public void writeLog(LogBean lb);
	
	
	/**
	 * 按日期查询日志
	 * @param startTime 起始日期
	 * @param endTime 结束日期
	 * @return 返回日志集合
	 */
	public List<LogBean> findByDate(Date startTime,Date endTime);
}
