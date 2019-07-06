package com.project.serviceImpl;

import java.util.List;

import com.project.Bean.SchoolNumBean;
import com.project.dao.ISchoolNumDao;
import com.project.dao.Impl.SchoolNumDaoImpl;
import com.project.service.ISchoolNumService;
/**
 * 统计学校业务层实现类
 * @author Administrator
 *
 */
public class SchoolNumServiceImpl implements ISchoolNumService{
	private ISchoolNumDao sDao=new SchoolNumDaoImpl();
	@Override
	public List<SchoolNumBean> showSchoolNumBean(int cityId) {
		// TODO Auto-generated method stub
		return sDao.showSchoolNumBean(cityId);
	}

}
