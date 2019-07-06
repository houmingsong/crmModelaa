package com.project.serviceImpl;

import java.util.List;

import com.project.Bean.JobBean;
import com.project.dao.IJobDao;
import com.project.dao.Impl.JobDaoImpl;
import com.project.service.IJobService;
/**
 * 职位业务层实现类
 * @author Administrator
 *
 */
public class JobServiceImpl implements IJobService{
	private IJobDao jDao=new JobDaoImpl();
	@Override
	public void addJob(JobBean jb) {
		jDao.addJob(jb);
		
	}

	@Override
	public void update(int id, String isDataPower, String isSchoolPower, String isUserPower, String isStatisticsPower) {
		jDao.update(id, isDataPower, isSchoolPower, isUserPower, isStatisticsPower);
		
	}

	@Override
	public List<JobBean> findAll() {
		
		return jDao.findAll();
	}

	@Override
	public JobBean findById(int id) {
		
		return jDao.findById(id);
	}

}
