package com.project.serviceImpl;


import java.text.SimpleDateFormat;
import java.util.List;
import java.sql.Date;
import com.project.Bean.EmployeeBean;
import com.project.Bean.JobBean;
import com.project.Bean.LogBean;
import com.project.dao.IEmployeeDao;
import com.project.dao.IJobDao;
import com.project.dao.ILogDao;
import com.project.dao.Impl.EmployeeDaoImpl;
import com.project.dao.Impl.JobDaoImpl;
import com.project.dao.Impl.LogDaoImpl;
import com.project.service.IEmployeeService;
/**
 * 员工业务层实现类
 * @author Administrator
 *
 */
public class EmployeeServiceImpl implements IEmployeeService{
/***/
	private IEmployeeDao eDao=new EmployeeDaoImpl();
	private IJobDao jDao=new JobDaoImpl();
	private ILogDao lDao=new LogDaoImpl();
	@Override
	public EmployeeBean login(String codeName, String pwd) {//封装员工的职位对象
		EmployeeBean em=eDao.login(codeName, pwd);
		if(em!=null) {			
		
			JobBean job=jDao.findById(em.getJobID());			
		em.setJb(job);
		SimpleDateFormat s=new SimpleDateFormat("HH:mm:ss");
		String str=s.format(new Date(System.currentTimeMillis()));		
		LogBean log=new LogBean();	
		log.setlogDescribe("用户"+em.getEname()+"在"+str+"登录系统");
		lDao.writeLog(log);
		}
		return em;
	}

	@Override
	public void add(EmployeeBean em) {
		eDao.add(em);
		
	}

	@Override
	public void del(int id) {
		
		eDao.del(id);
		
	}

	@Override
	public void update(int id, String tel, String party, int jobId, int departmentId) {
		eDao.update(id, tel, party, jobId, departmentId);
	}

	@Override
	public EmployeeBean findById(int id) {
		
		return eDao.findById(id);
	}

	@Override
	public List<EmployeeBean> findByItem(String ename, String edu, String department, String job) {
	return eDao.findByItem(ename, edu, department, job);
	}

	@Override
	public void changePwd(int id, String pwd) {
		eDao.changePwd(id, pwd);
		
	}

	@Override
	public List<EmployeeBean> findBySchool(int schoolId) {
		return eDao.findBySchool(schoolId);
	}

	@Override
	public List<EmployeeBean> findByDepartment(int deptId) {
		return eDao.findByDepartment(deptId);
	}

}
