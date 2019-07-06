package com.lovo.netCRM.classManager.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoAccordion;
import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.project.Bean.ClassBean;
import com.project.Bean.SchoolBean;
import com.project.service.ICityService;
import com.project.service.IClassService;
import com.project.service.ISchoolService;
import com.project.serviceImpl.CityServiceImpl;
import com.project.serviceImpl.ClassServiceImpl;
import com.project.serviceImpl.SchoolServiceImpl;

/**
 * 
 * 四川网脉CRM系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 班级管理面板
 * 开发日期:2012-10-14
 */
public class ClassManagerPanel extends JPanel{
	/**班级表格组件*/
	private LovoTable classTable;
	/**窗体对象*/
	private JFrame jf;
	/**城市手风琴组件*/
	private LovoAccordion cityAccordion;
	/**学校id*/
	private int schoolId;
	
	IClassService service=new ClassServiceImpl();
	ICityService cservice=new CityServiceImpl();
	ISchoolService lservice=new SchoolServiceImpl();
	
	public ClassManagerPanel(JFrame jf){
		this.jf = jf;
		this.setLayout(null);
		this.init();
	}
	/**
	 * 初始化
	 *
	 */
	private void init() {
		new LovoTitleLabel("班 级 管 理",this);
		this.initTable();
		this.initButton();
		this.initData();
		cityAccordion.setBounds(20,90,150,300);
	}
	
	/**
	 * 初始化数据
	 */
	public void initData(){
		if(schoolId==0){
			if(cityAccordion == null){
				this.initAccordion();
			}
			this.updateAccordion();
		}
		else{
			this.updateClassTable(schoolId);
		}
		
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	/**
	 * 初始化按钮
	 *
	 */
	private void initButton() {
		LovoButton lbadd = new LovoButton("添加班级",200,500,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
//				if(schoolId == 0){
//					JOptionPane.showMessageDialog(null,"请选择学校");
//					return;
//				}
				
				new ClassAddDialog(jf,schoolId,ClassManagerPanel.this);
			}});
		
		
		LovoButton lbupdate = new LovoButton("修改班级",400,500,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = classTable.getKey();
//				if(key == -1){
//					JOptionPane.showMessageDialog(null,"请选择行");
//					return;
//				}
				
				new ClassUpdateDialog(jf,key,ClassManagerPanel.this);
			}});
	}
	
	//--------------------------
	/**
	 * 根据学校对象得到学校ID
	 * @param schoolObj
	 * @return
	 */
	private int getSchoolId(Object schoolObj){
		
		int id=	((SchoolBean)schoolObj).getId();
		return id;
	}
	
	
	/**
	 * 初始化表格
	 */
	private void initTable() {
		classTable = new LovoTable(this,
				new String[]{"班级名称","开班时间","班级人数","带班老师"},
				new String[]{"className","classTime","studentAmount","teacher"},//班级实体属性名数组 new String[]{"className","time"}
				"id");//主键属性名 classId
		classTable.setSizeAndLocation(180, 90, 550, 300);
		
	}
	/**
	 * 初始化手风琴组件
	 *
	 */
	private void initAccordion() {
		//第二个参数为城市集合cityList，第三个参数为城市类中学校集合的属性名schoolList
		 cityAccordion = new LovoAccordion(this,cservice.findAll(),"schoolList"){
				
				/**
				 * 学校列表框点击事件
				 * @param schoolObj 学校对象
				 */
			 @Override
				public void clickEvent(Object schoolObj) {
				 	schoolId = getSchoolId(schoolObj);

				 	updateClassTable(schoolId);
				}
			};
	}
	
	/**
	 * 更新手风琴
	 */
	private void updateAccordion(){
		this.cityAccordion.updateAccordion(cservice.findAll());
	}
	/**
	 * 更新表格
	 * @param schoolId
	 */
	private void updateClassTable(int schoolId){
		//更新表格,插入List集合
		List<ClassBean>list=service.findBySchool(schoolId);
		classTable.updateLovoTable(list);
	}

}
