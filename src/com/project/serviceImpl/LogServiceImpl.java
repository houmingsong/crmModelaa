package com.project.serviceImpl;

import java.sql.Date;
import java.util.List;

import com.project.Bean.LogBean;
import com.project.dao.ILogDao;
import com.project.dao.Impl.LogDaoImpl;
import com.project.service.ILogService;
/**
 * 日志业务层实现类
 * @author Administrator
 *
 */
public class LogServiceImpl implements ILogService {
	private ILogDao lDao=new LogDaoImpl();
	@Override
	public List<LogBean> findByDate(Date startTime, Date endTime) {
		return lDao.findByDate(startTime, endTime);
	}

}
