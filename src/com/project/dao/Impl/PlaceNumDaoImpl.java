package com.project.dao.Impl;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.PlaceNumBean;
import com.project.dao.IPlaceNumDao;
/**
 * 地区统计持久层实现类
 * @author Administrator
 *
 */
public class PlaceNumDaoImpl extends BaseDao implements IPlaceNumDao{

	@Override
	public List<PlaceNumBean> show() {
		List<PlaceNumBean> list=new ArrayList<PlaceNumBean>();
		this.setConnection();
		try {
			ps=con.prepareStatement("SELECT c.city,COUNT(s.school) '录入学校',COUNT(CASE WHEN s.conditions='接洽中' THEN 1 END) '接洽中',\r\n" + 
					"COUNT(CASE WHEN s.conditions='待审' THEN 1 END) '待审', \r\n" + 
					"COUNT(CASE WHEN s.conditions='审核未通过' THEN 1 END) '审核未通过',\r\n" + 
					"COUNT(CASE WHEN s.conditions='推广开展' THEN 1 END) '推广开展'\r\n" + 
					" FROM t_city c LEFT JOIN t_school s ON s.cityId=c.id GROUP BY c.city;");
			rs=ps.executeQuery();
			while(rs.next()) {
				PlaceNumBean pn=new PlaceNumBean();
				pn.setCity(rs.getString("city"));
				pn.setAllSchool(rs.getInt("录入学校"));
				pn.setTalkingSchool(rs.getInt("接洽中"));
				pn.setWaitSchool(rs.getInt("待审"));
				pn.setNoPassSchool(rs.getInt("审核未通过"));
				pn.setPassSchool(rs.getInt("推广开展"));
				list.add(pn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return list;
	}
	public static void main(String[] args) {
//		IPlaceNumDao p=new PlaceNumDaoImpl();
//		System.out.println(p.show());
	}

}
