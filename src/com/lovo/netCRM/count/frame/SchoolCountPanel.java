package com.lovo.netCRM.count.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoDate;
import com.lovo.netCRM.component.LovoList;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.lovo.netCRM.component.LovoTitlePanel;
import com.project.Bean.CityBean;
import com.project.Bean.SchoolNumBean;
import com.project.service.ICityService;
import com.project.service.ISchoolNumService;
import com.project.serviceImpl.CityServiceImpl;
import com.project.serviceImpl.SchoolNumServiceImpl;
/**
 * 
 * 四川网脉CRM系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 学校统计面板
 * 开发日期:2012-10-14
 */
public class SchoolCountPanel extends JPanel{
	/**学校表格组件*/
	private LovoTable schoolCountTable;
	/**城市id*/
	private int cityId;
	ISchoolNumService service=new SchoolNumServiceImpl();
	ICityService cservice=new CityServiceImpl();
	
	/**城市列表框*/
	private LovoList cityList = new LovoList(20,90,150,300,this){
		public void onchange(Object cityObj){
			cityId = getCityId(cityObj);
			showAll(cityId);
		}
	};
	
	public SchoolCountPanel(){
		this.setLayout(null);
		this.init();
	}
	/**
	 * 初始化
	 *
	 */
	private void init() {
		new LovoTitleLabel("学 校 统 计",this);
		this.initTable();
	
		this.initData();
	}
	
	public void initData(){
		if(cityId==0){
			this.initList();
		}
		else{
			showAll(cityId);
		}
	}
	

	
	//--------------------------
	/**
	 * 初始化表格
	 */
	private void initTable() {
		schoolCountTable = new LovoTable(this,
				new String[]{"学校名称","网脉班级数量","会员数量","非会员数量"},
				new String[]{"schoolName","classNum","Vip","notVip"},//学校统计实体属性名数组 new String[]{"schoolName","netClassNumber"}
				"id");//主键属性名 schoolId
		schoolCountTable.setSizeAndLocation(180, 90, 550, 300);
		
		
	}
	/**
	 * 初始化城市列表框
	 *
	 */
	private void initList() {
		List<CityBean>list=cservice.findAllIncludeSchool();
		
		cityList.setList(list);
	}
	
	/**
	 * 根据城市对象，得到城市id
	 * @param cityObj 城市对象
	 * @return
	 */
	private int getCityId(Object cityObj){
		int id=((CityBean)cityObj).getId();
		
		return id;
	}
	/**
	 * 显示城市学校所有统计信息
	 * @param cityId 城市id
	 */
	private void showAll(int cityId){
		List<SchoolNumBean>list=service.showSchoolNumBean(cityId);
//		更新表格,插入List集合
		schoolCountTable.updateLovoTable(list);
	}
	
}
