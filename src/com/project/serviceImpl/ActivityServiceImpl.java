package com.project.serviceImpl;

import java.util.List;

import com.project.Bean.ActivityBean;
import com.project.dao.IActivityDao;
import com.project.dao.Impl.ActivityDaoImpl;
import com.project.service.IActivityService;
/**
 * ѧУ�ҵ���ʵ����
 * @author Administrator
 *
 */
public class ActivityServiceImpl implements IActivityService{
	private IActivityDao aDao=new ActivityDaoImpl();
	@Override
	public void add(ActivityBean ab) {
		aDao.add(ab);
		
	}

	@Override
	public List<ActivityBean> findActivityBySchoolID(int schoolld) {
		return aDao.findActivityBySchoolID(schoolld);
	}

}
