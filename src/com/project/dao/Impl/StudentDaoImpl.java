package com.project.dao.Impl;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.StudentBean;
import com.project.dao.IStudentDao;
/**
 * 学生信息持久层实现类
 * @author Administrator
 *
 */
public class StudentDaoImpl extends BaseDao implements IStudentDao {

	@Override
	public void add(StudentBean stub) {
		this.setConnection();
		try {
			ps=con.prepareStatement("insert into t_student(studentName,sex,birthday,classNameId,address,scondition,tel,fatherName,fatherTel,motherName,motherTel,scomment)values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, stub.getStudentName());
			ps.setString(2, stub.getSex());
			ps.setDate(3, stub.getBirthday());
			ps.setInt(4, stub.getClassNameID());
			ps.setString(5, stub.getAddress());
			ps.setString(6, stub.getScondition());
			ps.setString(7, stub.getTel());
			ps.setString(8, stub.getFatherName());
			ps.setString(9, stub.getFatherTel());
			ps.setString(10, stub.getMotherName());
			ps.setString(11, stub.getMotherTel());
			ps.setString(12, stub.getScommment());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
	}

	@Override
	public void update(int id, int classId, String tel, String fatherTel, String motherTel, String scommment,String scondition) {
		this.setConnection();
		try {
			ps=con.prepareStatement("update  t_student set classNameId=?,tel=?,fatherTel=?,motherTel=?,scomment=?,scondition=? where id=?");
			ps.setInt(1, classId);
			ps.setString(2, tel);
			ps.setString(3, fatherTel);
			ps.setString(4, motherTel);
			ps.setString(5, scommment);
			ps.setString(6, scondition);
			ps.setInt(7, id);
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
			ps=con.prepareStatement("delete from t_student where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
	}

	@Override
	public List<StudentBean> find(int schoolId, String studentName, String className, String condition) {
		List<StudentBean> list=new ArrayList<StudentBean>();
		String sql="select*from t_student st,t_class c,t_school sc where st.classNameId=c.id and c.schoolId=sc.id and sc.id=? ";
		if(studentName!=null&&studentName.length()!=0) {
			sql+="and studentName like '%"+studentName+"%' ";
		}
		if(className!=null&&className.length()!=0) {
			sql+="and className like '%"+className+"%' ";
		}
		if(condition!=null&&condition.length()!=0) {
			sql+="and scondition='"+condition+"' ";
		}
		this.setConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, schoolId);
			rs=ps.executeQuery();
			while(rs.next()) {
				StudentBean st=new StudentBean();
				st.setId(rs.getInt("id"));
				st.setStudentName(rs.getString("studentName"));
				st.setSex(rs.getString("sex"));
				st.setBirthday(rs.getDate("birthday"));
				st.setClassName(rs.getString("c.className"));
				st.setClassNameID(rs.getInt("classNameId"));
				st.setAddress(rs.getString("address"));
				st.setScondition(rs.getString("scondition"));
				st.setTel(rs.getString("tel"));
				st.setFatherName(rs.getString("fatherName"));
				st.setFatherTel(rs.getString("fatherTel"));
				st.setMotherName(rs.getString("motherName"));
				st.setMotherTel(rs.getString("motherTel"));
				st.setScommment(rs.getString("scomment"));
				list.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return list;
	}

	@Override
	public StudentBean findById(int id) {
		StudentBean st=null;
		this.setConnection();
		try {
			ps=con.prepareStatement("select*from t_student s,t_class c where s.classNameId=c.id and s.id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				st=new StudentBean();
				st.setId(rs.getInt("id"));
				st.setStudentName(rs.getString("studentName"));
				st.setSex(rs.getString("sex"));
				st.setBirthday(rs.getDate("birthday"));
				st.setClassName(rs.getString("c.className"));
				st.setClassNameID(rs.getInt("classNameId"));
				st.setAddress(rs.getString("address"));
				st.setScondition(rs.getString("scondition"));
				st.setTel(rs.getString("tel"));
				st.setFatherName(rs.getString("fatherName"));
				st.setFatherTel(rs.getString("fatherTel"));
				st.setMotherName(rs.getString("motherName"));
				st.setMotherTel(rs.getString("motherTel"));
				st.setScommment(rs.getString("scomment"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
		
		return st;
	}
	public static void main(String[] args) {
		IStudentDao a=new StudentDaoImpl();
//		a.add(new StudentBean("aaa", "男", Date.valueOf("1980-08-09"), 1,"aaaaaa", "会员", "aaaaaa", "aaaaaa", "aaaaaa", "aaaaaa", "aaaaaa", "aaaaaa"));
//		a.update(20, 2, "123", "111", "222", "444", "会员");
//		a.del(21);
//		System.out.println(a.find(1, null, null, null));
//		System.out.println(a.findById(20));
	}

}
