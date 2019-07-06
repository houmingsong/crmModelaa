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
 * ����ҵ���ʵ����
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
			List<SchoolBean> schoolList=sDao.findByItem(c.getId(), null, "�ƹ㿪չ");
			c.setSchoolList(schoolList);
		}
		return list;
	}

}
