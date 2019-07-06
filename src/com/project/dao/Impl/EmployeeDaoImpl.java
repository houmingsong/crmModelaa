package com.project.dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.EmployeeBean;

import com.project.dao.IEmployeeDao;
import com.project.dao.Impl.BaseDao;
/**
 * 员工信息持久层实现类
 * @author Administrator
 *
 */
public class EmployeeDaoImpl extends BaseDao implements IEmployeeDao{

	@Override
	public EmployeeBean login(String codeName, String pwd) {
		this.setConnection();
		EmployeeBean em=null;
		try {
			ps=con.prepareStatement("SELECT*FROM t_employee e WHERE  codeName=? AND pwd=?");
			ps.setString(1, codeName);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			if(rs.next()) {
				em=new EmployeeBean();
				em.setId(rs.getInt("id"));
				em.setEname(rs.getString("ename"));
				em.setBirthday(rs.getDate("birthday"));
				em.setSex(rs.getString("sex"));
				em.setEdu(rs.getString("edu"));
				em.setTel(rs.getString("tel"));
				em.setDepartmentId(rs.getInt("departmentId"));
				em.setJobID(rs.getInt("jobId"));
				em.setCodeName(rs.getString("codeName"));
				em.setPwd(rs.getString("pwd"));
				em.setMajor(rs.getString("major"));
				em.setParty(rs.getString("party"));
				em.setAddress(rs.getString("address"));
				em.setJobTime(rs.getDate("jobTime"));
				em.setImgPath(rs.getString("imgPath"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return em;
	}

	@Override
	public void add(EmployeeBean em) {
		this.setConnection();
		try {
			ps=con.prepareStatement("insert into t_employee(ename,sex,birthday,edu,tel,departmentId,jobId,codeName,pwd,major,party,address,jobTime,imgPath)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, em.getEname());
			ps.setString(2, em.getSex());
			ps.setDate(3, em.getBirthday());
			ps.setString(4, em.getEdu());
			ps.setString(5, em.getTel());
			ps.setInt(6, em.getDepartmentId());
			ps.setInt(7, em.getJobID());
			ps.setString(8, em.getCodeName());
			ps.setString(9, em.getPwd());
			ps.setString(10, em.getMajor());
			ps.setString(11, em.getParty());
			ps.setString(12, em.getAddress());
			ps.setDate(13, em.getJobTime());
			ps.setString(14, em.getImgPath());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
	}

	@Override
	public void del(int id) {
		this.setConnection();
		try {
			ps=con.prepareStatement("delete from t_employee where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
		
	}

	@Override
	public void update(int id, String tel, String party, int jobId, int departmentId) {
		this.setConnection();
		try {
			ps=con.prepareStatement("update t_employee set tel=?,party=?,jobId=?,departmentId=? where id=?");
			ps.setString(1, tel);
			ps.setString(2, party);
			ps.setInt(3, jobId);
			ps.setInt(4, departmentId);
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
	}

	@Override
	public EmployeeBean findById(int id) {
		this.setConnection();
		 EmployeeBean em=null;
		try {
			ps=con.prepareStatement("select e.*,d.department,j.job from t_employee e,t_department d,t_job j where e.jobId=j.id and e.departmentId=d.id and e.id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				em=new EmployeeBean();
				em.setId(rs.getInt("e.id"));
				em.setEname(rs.getString("ename"));
				em.setBirthday(rs.getDate("birthday"));
				em.setSex(rs.getString("sex"));
				em.setEdu(rs.getString("edu"));
				em.setTel(rs.getString("tel"));
				em.setDepartmentId(rs.getInt("departmentId"));
				em.setDepartment(rs.getString("department"));
				em.setJobID(rs.getInt("jobId"));
				em.setJob(rs.getString("job"));
				em.setCodeName(rs.getString("codeName"));
				em.setPwd(rs.getString("pwd"));
				em.setMajor(rs.getString("major"));
				em.setParty(rs.getString("party"));
				em.setAddress(rs.getString("address"));
				em.setJobTime(rs.getDate("jobTime"));
				em.setImgPath(rs.getString("imgPath"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return em;
	}

	@Override
	public List<EmployeeBean> findByItem(String ename, String edu, String department, String job) {
		List<EmployeeBean> list=new ArrayList<EmployeeBean>();
		String sql="SELECT e.*,d.department,j.job FROM t_job j,t_department d,t_employee e WHERE e.departmentId=d.id AND j.id=e.jobId  ";
		if(ename!=null&&ename.length()!=0) {
			sql+="and ename like '%"+ename+"%' ";
		}
		if(edu!=null&&edu.length()!=0) {
			sql+="and edu like '%"+edu+"%' ";
		}
		if(department!=null&&department.length()!=0) {
			sql+="and department like '%"+department+"%' ";
		}
		if(job!=null&&job.length()!=0) {
			sql+="and job like '%"+job+"%' ";
		}
		this.setConnection();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				EmployeeBean em=new EmployeeBean();
				em.setId(rs.getInt("id"));
				em.setEname(rs.getString("ename"));
				em.setBirthday(rs.getDate("birthday"));
				em.setSex(rs.getString("sex"));
				em.setEdu(rs.getString("edu"));
				em.setTel(rs.getString("tel"));
				em.setDepartmentId(rs.getInt("departmentId"));
				em.setDepartment(rs.getString("department"));
				em.setJobID(rs.getInt("jobId"));
				em.setJob(rs.getString("job"));
				em.setCodeName(rs.getString("codeName"));
				em.setPwd(rs.getString("pwd"));
				em.setMajor(rs.getString("major"));
				em.setParty(rs.getString("party"));
				em.setAddress(rs.getString("address"));
				em.setJobTime(rs.getDate("jobTime"));
				em.setImgPath(rs.getString("imgPath"));
				list.add(em);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return list;
	}

	@Override
	public void changePwd(int id, String pwd) {
		this.setConnection();
		try {
			ps=con.prepareStatement("update t_employee set pwd=? where id=?");
			ps.setString(1, pwd);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
	}

	@Override
	public List<EmployeeBean> findBySchool(int schoolId) {
		
		List<EmployeeBean> list=new ArrayList<EmployeeBean>();
		this.setConnection();
		try {
			ps=con.prepareStatement("select e.* from t_school s,t_employee e where e.departmentId=s.departmentId  and s.id=?");
			ps.setInt(1, schoolId);
			rs=ps.executeQuery();
			while(rs.next()) {
				EmployeeBean em=new EmployeeBean();
				em.setId(rs.getInt("id"));
				em.setEname(rs.getString("ename"));
				em.setBirthday(rs.getDate("birthday"));
				em.setSex(rs.getString("sex"));
				em.setEdu(rs.getString("edu"));
				em.setTel(rs.getString("tel"));
				em.setDepartmentId(rs.getInt("departmentId"));
				em.setJobID(rs.getInt("jobId"));
				em.setCodeName(rs.getString("codeName"));
				em.setPwd(rs.getString("pwd"));
				em.setMajor(rs.getString("major"));
				em.setParty(rs.getString("party"));
				em.setAddress(rs.getString("address"));
				em.setJobTime(rs.getDate("jobTime"));
				em.setImgPath(rs.getString("imgPath"));
				list.add(em);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return list;
	}

	@Override
	public List<EmployeeBean> findByDepartment(int deptId) {
		List<EmployeeBean> list=new ArrayList<EmployeeBean>();
		this.setConnection();
		
		try {
			ps=con.prepareStatement("select * from t_employee where  departmentId=?");
			ps.setInt(1,deptId);
			rs=ps.executeQuery();
			while(rs.next()) {
				EmployeeBean em=new EmployeeBean();
				em.setId(rs.getInt("id"));
				em.setEname(rs.getString("ename"));
				em.setBirthday(rs.getDate("birthday"));
				em.setSex(rs.getString("sex"));
				em.setEdu(rs.getString("edu"));
				em.setTel(rs.getString("tel"));
				em.setDepartmentId(rs.getInt("departmentId"));
				em.setJobID(rs.getInt("jobId"));
				em.setCodeName(rs.getString("codeName"));
				em.setPwd(rs.getString("pwd"));
				em.setMajor(rs.getString("major"));
				em.setParty(rs.getString("party"));
				em.setAddress(rs.getString("address"));
				em.setJobTime(rs.getDate("jobTime"));
				em.setImgPath(rs.getString("imgPath"));
				list.add(em);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return list;
	}
	
		public static void main(String[] args) {
			IEmployeeDao a=new EmployeeDaoImpl();
//正确			System.out.println(a.login("zzz", "111"));
	//正确
//	a.add(new EmployeeBean("aaa", "男", Date.valueOf("1990-08-08"), "本科", "111111",1,2, "1112", "1112", "aaa", "党员", "aaaaa", Date.valueOf("2018-10-01"), "1.ddd"));
//			a.del(21);
//			a.update(20, "aaaaa", "党员",2 , 2);
//			System.out.println(a.findById(1));
//			System.out.println(a.findByItem(null, "本科", null, null));
//			a.changePwd(1, "222");
//			System.out.println(a.findBySchool(1));
//			System.out.println(a.findByDepartment(1));
		}
	}


