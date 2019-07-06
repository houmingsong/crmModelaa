package com.project.dao.Impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.SchoolBean;
import com.project.dao.ISchoolDao;
/**
 * 学校持久层实现类
 * @author Administrator
 *
 */
public class SchoolDaoImpl extends BaseDao implements ISchoolDao{

	@Override
	public List<SchoolBean> findByCityId(int cityId) {
		List<SchoolBean> list=new ArrayList<SchoolBean>();
		this.setConnection();
		try {
			ps=con.prepareStatement("select* from t_school s,t_city c ,t_department d where s.cityId=c.id and d.id=s.departmentId and cityId=?");
			ps.setInt(1, cityId);
			rs=ps.executeQuery();
			while(rs.next()) {
				SchoolBean sb=new SchoolBean();
				sb.setId(rs.getInt("id"));
				sb.setSchool(rs.getString("school"));
				sb.setPresident(rs.getString("president"));
				sb.setsTime(rs.getDate("sTime"));
				sb.setConditions(rs.getString("conditions"));
				sb.setTel(rs.getString("tel"));
				sb.setCityId(rs.getInt("cityId"));
				sb.setCity(rs.getString("c.city"));
				sb.setTeacherAmount(rs.getInt("teacherAmount"));
				sb.setAddress(rs.getString("address"));
				sb.setStudentAmount(rs.getInt("studentAmount"));
				sb.setSchoolDescribe(rs.getString("schoolDescribe"));
				sb.setIp(rs.getString("ip"));
				sb.setTraffic(rs.getString("traffic"));
				sb.setApproveIdea(rs.getString("approveIdea"));
				sb.setDepartmentId(rs.getInt("departmentId"));
				sb.setDepartment(rs.getString("department"));
				sb.setApplyDate(rs.getDate("applyDate"));
				sb.setPassDate(rs.getDate("passDate"));
				list.add(sb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return list;
	}

	@Override
	public void addschool(SchoolBean sb) {
		this.setConnection();
		try {
			ps=con.prepareStatement("insert into t_school(school,president,sTime,conditions,tel,cityId,teacherAmount,address,studentAmount,schoolDescribe,ip,traffic,approveIdea,departmentId,applyDate,passDate)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, sb.getSchool());
			ps.setString(2, sb.getPresident());
			ps.setDate(3, sb.getsTime());
			ps.setString(4, sb.getConditions());
			ps.setString(5, sb.getTel());
			ps.setInt(6, sb.getCityId());
			ps.setInt(7, sb.getTeacherAmount());
			ps.setString(8,sb.getAddress());
			ps.setInt(9, sb.getStudentAmount());
			ps.setString(10, sb.getSchoolDescribe());
			ps.setString(11, sb.getIp());
			ps.setString(12, sb.getTraffic());
			ps.setString(13, sb.getApproveIdea());
			ps.setInt(14,sb.getDepartmentId());
			ps.setDate(15, sb.getApplyDate());
			ps.setDate(16, sb.getPassDate());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
	}

	@Override
	public void updateSchool(int id, String president, int teacherAmount, int studentAmount, String ip,String traffic) {
		this.setConnection();
		try {
			ps=con.prepareStatement("update t_school set president=?,teacherAmount=?,studentAmount=?,ip=?,traffic=? where id=?");
			ps.setString(1, president);
			ps.setInt(2, teacherAmount);
			ps.setInt(3, studentAmount);
			ps.setString(4, ip);
			ps.setString(5, traffic);
			ps.setInt(6, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
	}

	@Override
	public void apply(int id, String condition, Date applyDate) {
		this.setConnection();
		try {
			ps=con.prepareStatement("update  t_school set conditions=?,applyDate=? where id=?");
			ps.setString(1, condition);
			ps.setDate(2, applyDate);
			ps.setInt(3, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
	}

	@Override
	public void back(int id, String approveIdea, String conditions) {
		this.setConnection();
		try {
			ps=con.prepareStatement("update  t_school set approveIdea=?,conditions=? where id=?");
			ps.setString(1, approveIdea);
			ps.setString(2, conditions);
			ps.setInt(3, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
	}

	@Override
	public void pass(int id, String approveIdea, String conditions, Date passDate) {
		this.setConnection();
		try {
			ps=con.prepareStatement("update  t_school set approveIdea=?,conditions=?,passDate=? where id=?");
			ps.setString(1, approveIdea);
			ps.setString(2, conditions);
			ps.setDate(3, passDate);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
	}

	@Override
	public List<SchoolBean> findByItem(int cityId, String schoolName, String conditions) {
		List<SchoolBean> list=new ArrayList<SchoolBean>();
		String sql="select*from t_school s  where  cityId=?  ";
		
		if(schoolName!=null&&schoolName.length()!=0) {
			sql+="and school like '%"+schoolName+"%' ";
		}
		if(conditions!=null&&conditions.length()!=0) {
			sql+="and conditions = '"+conditions+"' ";
		}
		this.setConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, cityId);
			rs=ps.executeQuery();
			while(rs.next()) {
				SchoolBean sb=new SchoolBean();
				sb.setId(rs.getInt("id"));
				sb.setSchool(rs.getString("school"));
				sb.setPresident(rs.getString("president"));
				sb.setsTime(rs.getDate("sTime"));
				sb.setConditions(rs.getString("conditions"));
				sb.setTel(rs.getString("tel"));
				sb.setCityId(rs.getInt("cityId"));
				sb.setTeacherAmount(rs.getInt("teacherAmount"));
				sb.setAddress(rs.getString("address"));
				sb.setStudentAmount(rs.getInt("studentAmount"));
				sb.setSchoolDescribe(rs.getString("schoolDescribe"));
				sb.setIp(rs.getString("ip"));
				sb.setTraffic(rs.getString("traffic"));
				sb.setApproveIdea(rs.getString("approveIdea"));
				sb.setDepartmentId(rs.getInt("departmentId"));
				sb.setApplyDate(rs.getDate("applyDate"));
				sb.setPassDate(rs.getDate("passDate"));
				list.add(sb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return list;
	}

	@Override
	public SchoolBean findById(int id) {
		SchoolBean sb=null;
		this.setConnection();
		try {
			ps=con.prepareStatement("select*from t_school s,t_city c,t_department d where s.departmentId=d.id and s.cityId=c.id and s.id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				sb=new SchoolBean();
				sb.setId(rs.getInt("id"));
				sb.setSchool(rs.getString("school"));
				sb.setPresident(rs.getString("president"));
				sb.setsTime(rs.getDate("sTime"));
				sb.setConditions(rs.getString("conditions"));
				sb.setTel(rs.getString("tel"));
				sb.setCityId(rs.getInt("cityId"));
				sb.setCity(rs.getString("city"));
				sb.setTeacherAmount(rs.getInt("teacherAmount"));
				sb.setAddress(rs.getString("address"));
				sb.setStudentAmount(rs.getInt("studentAmount"));
				sb.setSchoolDescribe(rs.getString("schoolDescribe"));
				sb.setIp(rs.getString("ip"));
				sb.setTraffic(rs.getString("traffic"));
				sb.setApproveIdea(rs.getString("approveIdea"));
				sb.setDepartmentId(rs.getInt("departmentId"));
				sb.setDepartment(rs.getString("department"));
				sb.setApplyDate(rs.getDate("applyDate"));
				sb.setPassDate(rs.getDate("passDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
		return sb;
	}
	public static void main(String[] args) {
		ISchoolDao a=new SchoolDaoImpl();
//		System.out.println(a.findByCityId(1));
//		a.addschool(new SchoolBean("aaa", "aaa", Date.valueOf("2018-08-08"), "aaa", "aaa", 1, "aaa", 20, "aaa", 10, "aaa", "aaa", "aaa", "aaa", 1, "aaa", Date.valueOf("2018-08-08"), Date.valueOf("2018-08-08")));
//		a.updateSchool(2, "bbb", 30, 30, "bbb", "bbb");
//		a.apply(7, "123", Date.valueOf("1999-09-09"));
//		a.back(7, "pp", "qq");
//		a.pass(7, "www", "eee", Date.valueOf("2000-09-09"));
//		System.out.println(a.findByItem(1, "大学", null));
//		System.out.println(a.findById(7));
	}
}
