package com.project.serviceImpl;

import java.util.List;

import com.project.Bean.CityBean;
import com.project.Bean.SchoolBean;
import com.project.dao.ICityDao;
import com.project.dao.ISchoolDao;

import com.project.dao.Impl.CityDaoImpl;
import com.project.dao.Impl.SchoolDaoImpl;

import com.project.service.ICityService;
/**
 * 城市业务层实现类
 * @author Administrator
 *
 */
public class CityServiceImpl implements ICityService{
	private ICityDao cDao=new CityDaoImpl();
	private ISchoolDao sDao=new SchoolDaoImpl();
	@Override
	public List<CityBean> findAll() {
		List<CityBean> list=cDao.findAll();
		for (CityBean c : list) {
			List<SchoolBean> schoolList=sDao.findByItem(c.getId(), null, null);
			c.setSchoolList(schoolList);
		}
		return list;
	}

	@Override
	public List<CityBean> findAllIncludeSchool() {
		 List<CityBean> list=cDao.findAll();
		for (CityBean c : list) {
			List<SchoolBean> schoolList=sDao.findByItem(c.getId(), null, "推广开展");
			c.setSchoolList(schoolList);
		}
		return list;
	}

}
