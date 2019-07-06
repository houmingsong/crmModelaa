package com.project.serviceImpl;

import java.util.List;

import com.project.Bean.StudentBean;
import com.project.Bean.VisitBean;
import com.project.dao.IStudentDao;
import com.project.dao.IVisitDao;
import com.project.dao.Impl.StudentDaoImpl;
import com.project.dao.Impl.VisitDaoImpl;
import com.project.service.IStudentService;
/**
 * 学生业务层实现类
 * @author Administrator
 *
 */
public class StudentServiceImpl implements IStudentService{
	private IStudentDao sDao=new StudentDaoImpl();
	private IVisitDao vdao=new VisitDaoImpl();
	@Override
	public void add(StudentBean stub) {
		sDao.add(stub);
		
	}

	@Override
	public void update(int id, int classId, String tel, String fatherTel, String motherTel, String commment,
			String condition) {
		sDao.update(id, classId, tel, fatherTel, motherTel, commment, condition);
	}

	@Override
	public void del(int id) {
		vdao.del(id);
		sDao.del(id);
		
	}

	@Override
	public List<StudentBean> find(int schoolId, String studentName, String className, String condition) {
		// TODO Auto-generated method stub
		return sDao.find(schoolId, studentName, className, condition);
	}

	@Override
	public StudentBean findById(int id) {
		StudentBean stb=sDao.findById(id);
		List<VisitBean> list=vdao.findById(id);
		stb.setVisitList(list);
		return stb;
	}

}
