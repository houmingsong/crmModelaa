package com.project.dao.Impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.DepartmentBean;
import com.project.dao.IDepartmentDao;
/**
 * 部门持久层实现类
 * @author Administrator
 *
 */
public class DepartmentDaoImpl extends BaseDao implements IDepartmentDao{

	@Override
	public void addDepartment(DepartmentBean dept) {
		this.setConnection();
		try {
			ps=con.prepareStatement("insert into t_department(department,dtime,departmentDescribe)values(?,?,?)");
			ps.setString(1, dept.getDepartment());
			ps.setDate(2, dept.getDtime());
			ps.setString(3, dept.getDepartmentDescribe());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
	}

	@Override
	public void updateDepartment(int id, String departmentDescribe) {
		this.setConnection();
		try {
			ps=con.prepareStatement("update  t_department set departmentDescribe=? where id=? ");
			ps.setString(1, departmentDescribe);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
		
	}

	@Override
	public List<DepartmentBean> findAll() {
		List<DepartmentBean> list=new ArrayList<DepartmentBean>();
		this.setConnection();
		try {
			ps=con.prepareStatement("select*from t_department");
			rs=ps.executeQuery();
			while(rs.next()) {
				DepartmentBean dept=new DepartmentBean();
				dept.setId(rs.getInt("id"));
				dept.setDepartment(rs.getString("department"));
				dept.setDtime(rs.getDate("dtime"));
				dept.setDepartmentDescribe(rs.getString("departmentDescribe"));
				list.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return list;
	}

	@Override
	public DepartmentBean findById(int id) {
		this.setConnection();
		DepartmentBean dept=null;
		try {
			ps=con.prepareStatement("select*from t_department where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				dept=new DepartmentBean();
				dept.setId(rs.getInt("id"));
				dept.setDepartment(rs.getString("department"));
				dept.setDtime(rs.getDate("dtime"));
				dept.setDepartmentDescribe(rs.getString("departmentDescribe"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return dept;
	}
	public static void main(String[] args) {
//		IDepartmentDao a=new DepartmentDaoImpl();
//		a.addDepartment(new DepartmentBean("aa", Date.valueOf("2018-09-09"), "aaaaaaaaa"));
//		a.updateDepartment(5, "bbbbbb");
//		System.out.println(a.findAll());
//		System.out.println(a.findById(5));
	}
}
