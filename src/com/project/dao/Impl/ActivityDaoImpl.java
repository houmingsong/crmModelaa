package com.project.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.project.Bean.ActivityBean;
import com.project.dao.IActivityDao;
/**
 *  活动持久层实现类
 * @author Administrator
 *
 */
public class ActivityDaoImpl extends BaseDao implements IActivityDao {

	@Override
	public void add(ActivityBean ab) {
		this.setConnection();
		try {
			ps=con.prepareStatement("insert into t_activity(schoolId,activity,activityTime,place,theme,department,employee)values(?,?,?,?,?,?,?)");
			ps.setInt(1, ab.getSchoolId());
			ps.setString(2, ab.getActivity());
			ps.setDate(3, ab.getActivityTime());
			ps.setString(4, ab.getPlace());
			ps.setString(5, ab.getTheme());
			ps.setString(6, ab.getDepartment());
			ps.setString(7, ab.getEmployee());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
	}

	@Override
	public List<ActivityBean> findActivityBySchoolID(int schoolld) {
		List<ActivityBean> list=new ArrayList<ActivityBean>();
		this.setConnection();
		try {
			ps=con.prepareStatement("select*from t_activity where schoolId=?");
			ps.setInt(1, schoolld);
			rs=ps.executeQuery();
			while(rs.next()){
				ActivityBean ab=new ActivityBean();
				ab.setId(rs.getInt("id"));
				ab.setSchoolId(rs.getInt("schoolId"));
				ab.setActivity(rs.getString("activity"));
				ab.setActivityTime(rs.getDate("activityTime"));
				ab.setPlace(rs.getString("place"));
				ab.setTheme(rs.getString("theme"));
				ab.setDepartment(rs.getString("department"));
				ab.setEmployee(rs.getString("employee"));
				list.add(ab);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		
		return list;
	}
	public static void main(String[] args) {
		IActivityDao a=new ActivityDaoImpl();
		//a.add(new ActivityBean(1, "篮球", Date.valueOf("2018-09-08"), "篮球场", "1v1", "人事部", "周老师"));
		//System.out.println(a.findActivityBySchoolID(1));;
	}

}
