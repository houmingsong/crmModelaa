package com.project.dao.Impl;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.PlaceNumBean;
import com.project.dao.IPlaceNumDao;
/**
 * ����ͳ�Ƴ־ò�ʵ����
 * @author Administrator
 *
 */
public class PlaceNumDaoImpl extends BaseDao implements IPlaceNumDao{

	@Override
	public List<PlaceNumBean> show() {
		List<PlaceNumBean> list=new ArrayList<PlaceNumBean>();
		this.setConnection();
		try {
			ps=con.prepareStatement("SELECT c.city,COUNT(s.school) '¼��ѧУ',COUNT(CASE WHEN s.conditions='��Ǣ��' THEN 1 END) '��Ǣ��',\r\n" + 
					"COUNT(CASE WHEN s.conditions='����' THEN 1 END) '����', \r\n" + 
					"COUNT(CASE WHEN s.conditions='���δͨ��' THEN 1 END) '���δͨ��',\r\n" + 
					"COUNT(CASE WHEN s.conditions='�ƹ㿪չ' THEN 1 END) '�ƹ㿪չ'\r\n" + 
					" FROM t_city c LEFT JOIN t_school s ON s.cityId=c.id GROUP BY c.city;");
			rs=ps.executeQuery();
			while(rs.next()) {
				PlaceNumBean pn=new PlaceNumBean();
				pn.setCity(rs.getString("city"));
				pn.setAllSchool(rs.getInt("¼��ѧУ"));
				pn.setTalkingSchool(rs.getInt("��Ǣ��"));
				pn.setWaitSchool(rs.getInt("����"));
				pn.setNoPassSchool(rs.getInt("���δͨ��"));
				pn.setPassSchool(rs.getInt("�ƹ㿪չ"));
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
