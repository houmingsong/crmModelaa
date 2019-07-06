package com.project.serviceImpl;


import java.sql.Date;
import java.util.List;

import com.project.Bean.CommunicationBean;
import com.project.Bean.SchoolBean;
import com.project.dao.ICommunicationDao;
import com.project.dao.ISchoolDao;
import com.project.dao.Impl.CommunicationDaoImpl;
import com.project.dao.Impl.SchoolDaoImpl;
import com.project.service.ISchoolService;
/**
 * 学校信息业务层实现类
 * @author Administrator
 *
 */
public class SchoolServiceImpl implements ISchoolService{
	private ISchoolDao sDao=new SchoolDaoImpl();
	private  ICommunicationDao cdao=new CommunicationDaoImpl();
	@Override
	public void addschool(SchoolBean sb) {
		sDao.addschool(sb);
		
	}

	@Override
	public void updateSchool(int id, String president, int teacherAmount, int studentAmount, String ip,
			String traffic) {
		sDao.updateSchool(id, president, teacherAmount, studentAmount, ip, traffic);
		
	}

	@Override
	public void apply(int id) {
		sDao.apply(id, "待审", new Date(System.currentTimeMillis()));
		
	}

	@Override
	public void back(int id, String approveIdea) {
		
		sDao.back(id, approveIdea, "审核未通过");
		
	}

	@Override
	public void pass(int id, String approveIdea) {
		sDao.pass(id, approveIdea, "推广开展", java.sql.Date.valueOf(new Date(System.currentTimeMillis()).toString()));
		
	}

	@Override
	public List<SchoolBean> find(int cityId, String schoolName, String condition) {
		
		return sDao.findByItem(cityId, schoolName, condition);
	}

	@Override
	public SchoolBean findById(int id) {
		SchoolBean school=sDao.findById(id);
		List<CommunicationBean> list= cdao.findBySchoolId(id);
		school.setCommuunicationList(list);
		return school;
	}

}
