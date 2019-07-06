package com.project.serviceImpl;

import java.util.List;

import com.project.Bean.ClassBean;
import com.project.dao.IClassDao;
import com.project.dao.Impl.ClassDaoImpl;
import com.project.service.IClassService;
/**
 * 班级管理业务层实现类
 * @author Administrator
 *
 */
public class ClassServiceImpl implements IClassService {
	private IClassDao cDao=new ClassDaoImpl();
	@Override
	public void addClass(ClassBean cb) {
		cDao.addClass(cb);
		
	}

	@Override
	public ClassBean findById(int id) {
		return cDao.findById(id);
	}

	@Override
	public void update(int id, String teacher) {
		cDao.update(id, teacher);
		
	}

	@Override
	public List<ClassBean> findBySchool(int schoolId) {
		List<ClassBean> list=cDao.findBySchool(schoolId);
		
		return list;
	}

}
