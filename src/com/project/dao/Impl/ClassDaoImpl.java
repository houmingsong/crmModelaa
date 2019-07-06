package com.project.dao.Impl;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.ClassBean;
import com.project.dao.IClassDao;
/**
 * 班级管理持久层实现类
 * @author Administrator
 *
 */
public class ClassDaoImpl extends BaseDao implements IClassDao{

	@Override
	public void addClass(ClassBean cb) {
		this.setConnection();
		try {
			ps=con.prepareStatement("insert into t_class(className,classTime,teacher,schoolId)values(?,?,?,?)");
			ps.setString(1, cb.getClassName());
			ps.setDate(2, cb.getClassTime());
			ps.setString(3, cb.getTeacher());
			ps.setInt(4, cb.getSchoolId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
	}

	@Override
	public void update(int id, String teacher) {
		this.setConnection();
		try {
			ps=con.prepareStatement("update  t_class set teacher=? where id=?");
			ps.setString(1, teacher);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
	}

	@Override
	public List<ClassBean> findBySchool(int schoolId) {
		List<ClassBean> list=new ArrayList<ClassBean>();
		this.setConnection();
		try {
			ps=con.prepareStatement("select *,count(s.id) from t_class c left join t_student s on c.id=s.classNameId where schoolId=? group by c.id");
			ps.setInt(1, schoolId);
			rs=ps.executeQuery();
			while(rs.next()) {
				ClassBean cb=new ClassBean();
				cb.setId(rs.getInt("id"));
				cb.setClassName(rs.getString("className"));
				cb.setClassTime(rs.getDate("classTime"));
				cb.setTeacher(rs.getString("teacher"));
				cb.setSchoolId(rs.getInt("schoolId"));
				cb.setStudentAmount(rs.getInt("count(s.id)"));
				cb.setSchoolId(rs.getInt("schoolId"));
				list.add(cb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return list;
	}

	@Override
	public ClassBean findById(int id) {
		ClassBean cb=null;
		this.setConnection();
		try {
			ps=con.prepareStatement("select c.*,count(s.id) from t_class c,t_student s where c.id=s.classNameId and  c.id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				cb=new ClassBean();
				cb.setId(rs.getInt("id"));
				cb.setClassName(rs.getString("className"));
				cb.setClassTime(rs.getDate("classTime"));
				cb.setTeacher(rs.getString("teacher"));
				cb.setSchoolId(rs.getInt("schoolId"));
				cb.setStudentAmount(rs.getInt("count(s.id)"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return cb;
	}
	public static void main(String[] args) {
		IClassDao a=new ClassDaoImpl();
//		a.addClass(new ClassBean("J155", Date.valueOf("2018-09-09"), "李老师", 1));
//		a.update(7, "张老师");
//		System.out.println(a.findBySchool(1));
//		System.out.println(a.findById(1));
	}

}
