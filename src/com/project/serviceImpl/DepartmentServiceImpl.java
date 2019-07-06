package com.project.serviceImpl;

import java.util.List;

import com.project.Bean.DepartmentBean;
import com.project.dao.IDepartmentDao;
import com.project.dao.Impl.DepartmentDaoImpl;
import com.project.service.IDepartmentService;
/**
 * 部门业务层实现类
 * @author Administrator
 *
 */
public class DepartmentServiceImpl implements IDepartmentService {
	private IDepartmentDao dDao=new DepartmentDaoImpl();
	@Override
	public void addDepartment(DepartmentBean dept) {
		dDao.addDepartment(dept);
		
	}

	@Override
	public void updateDepartment(int id, String departmentDescribe) {
		dDao.updateDepartment(id, departmentDescribe);
		
	}

	@Override
	public List<DepartmentBean> findAll() {
		
		return dDao.findAll();
	}

	@Override
	public DepartmentBean findById(int id) {
		
		return dDao.findById(id);
	}

}
