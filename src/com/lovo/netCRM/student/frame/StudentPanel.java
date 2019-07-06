package com.lovo.netCRM.student.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoAccordion;
import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoComboBox;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.lovo.netCRM.component.LovoTitlePanel;
import com.lovo.netCRM.component.LovoTxt;
import com.project.Bean.SchoolBean;
import com.project.Bean.StudentBean;
import com.project.service.ICityService;
import com.project.service.ISchoolService;
import com.project.service.IStudentService;
import com.project.serviceImpl.CityServiceImpl;
import com.project.serviceImpl.SchoolServiceImpl;
import com.project.serviceImpl.StudentServiceImpl;

/**
 * 
 * 四川网脉CRM系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 学生面板
 * 开发日期:2012-10-14
 */
public class StudentPanel extends JPanel{
	/**学生表格组件*/
	private LovoTable studentTable;
	/**窗体对象*/
	private JFrame jf;
	/**城市手风琴组件*/
	private LovoAccordion cityAccordion;
	/**点中的学校id*/
	private int schoolId;
	/**学生姓名文本框*/
	private LovoTxt nameTxt;
	/**班级文本框*/
	private LovoTxt classTxt;
	/**学校状态下拉框*/
	private LovoComboBox statusBox;
	
	
	IStudentService sservice=new StudentServiceImpl();
	ICityService service=new CityServiceImpl();
	ISchoolService lservice=new SchoolServiceImpl();
	IStudentService stu = new StudentServiceImpl();
	public StudentPanel(JFrame jf){
		this.jf = jf;
		this.setLayout(null);
		this.init();
	}
	/**
	 * 初始化
	 *
	 */
	private void init() {
		new LovoTitleLabel("学 生 管 理",this);
		this.initTable();
		this.initButton();
		this.initData();
		cityAccordion.setBounds(20,90,150,300);
		this.initFindPanel();
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
			this.updateStudentTable(schoolId);
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
		
		LovoButton lbadd = new LovoButton("添加学生",50,500,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(schoolId == 0){
					JOptionPane.showMessageDialog(null,"请选择学校");
					return;
				}
				
				new StudentAddDialog(jf,schoolId,StudentPanel.this);
			}});
		
		LovoButton lbshow = new LovoButton("查看学生信息",170,500,this);
		lbshow.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = studentTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"请选择行");
					return;
				}
				
				new StudentShowDialog(jf,key);
			}});
		
		
		LovoButton lbdel = new LovoButton("删除学生",290,500,this);
		lbdel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = studentTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"请选择行");
					return;
				}
				
				delEmployee(key);
			}});
		
		
		LovoButton lbupdate = new LovoButton("修改学生信息",50,570,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = studentTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"请选择行");
					return;
				}
				
				new StudentUpdateDialog(jf,schoolId,key,StudentPanel.this);
			}});
		
		LovoButton lbAddBack = new LovoButton("添加回防记录",170,570,this);
		lbAddBack.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = studentTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"请选择行");
					return;
				}
				
				new StudentVisitAddialog(jf,key,schoolId);
			}});
	}
	/**
	 * 初始化查询按钮
	 *
	 */
	private void initFindPanel(){
		LovoTitlePanel jp = new LovoTitlePanel("查询学生",400, 400, 320, 250,this);
	
		nameTxt = new LovoTxt("学生姓名",30,50,jp);
		classTxt = new LovoTxt("班级",30,100,jp);
		this.statusBox = new LovoComboBox<String>("状态",new String[]{"全部","会员","非会员"},30,150,jp);
		
		LovoButton lb = new LovoButton("查找",180,200,jp);
		lb.setSize(60, 20);
		
		lb.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(schoolId == 0){
				JOptionPane.showMessageDialog(null,"请选择学校");
					return;
				}
				findStudent(schoolId);
				
			}});
		
	}

	
	//--------------------------
	/**
	 * 根据学校对象得到学校ID
	 * @param schoolObj 学校对象
	 * @return
	 */
	private int getSchoolId(Object schoolObj){
	int id=	((SchoolBean)schoolObj).getId();
		
		
		return id;
	}
	/**
	 * 更新手风琴
	 */
	private void updateAccordion(){
		this.cityAccordion.updateAccordion(service.findAll());
	}
	/**
	 * 更新表格
	 * @param schoolId 学校ID
	 */
	private void updateStudentTable(int schoolId){
		List<StudentBean>list=stu.find(schoolId, null, null, null);
				
		
		//更新表格,插入List集合
		studentTable.updateLovoTable(list);
	}
	
	/**
	 * 初始化表格
	 */
	private void initTable() {
		studentTable = new LovoTable(this,
				new String[]{"学生姓名","性别","班级","状态","联系电话"},
							  
				new String[]{"studentName","sex","className","scondition","tel"},//学生实体属性名数组 new String[]{"studentName","sex"}
				"id");//主键属性名 studentId
		studentTable.setSizeAndLocation(180, 90, 550, 300);
		
	}

	/**
	 * 初始化手风琴组件
	 *
	 */
	private void initAccordion() {
		//第二个参数为城市集合cityList，第三个参数为城市类中学校集合的属性名schoolList
		 cityAccordion = new LovoAccordion(this,service.findAll(),"schoolList"){
				
				/**
				 * 学校列表框点击事件
				 * @param schoolObj 学校对象
				 */
			 @Override
				public void clickEvent(Object schoolObj) {
				 
				 //记录点中学校id
				 schoolId = getSchoolId(schoolObj);

					//显示点中学校学生
				 updateStudentTable(schoolId);
				}
			};
	}
	
	/**
	 * 删除学生
	 * @param studentId 学生ID
	 */
	private void delEmployee(int studentId){
		sservice.del(studentId);
		
//		显示删除结果
		updateStudentTable(schoolId);
	}
	/**
	 * 查找学生
	 * @param schoolId 学校id
	 */
	private void findStudent(int schoolId){
		String str = statusBox.getItem().toString();
		if(statusBox.getItem().toString().equals("全部")){
			 str = null;
		}
		List<StudentBean> list=sservice.find(schoolId, nameTxt.getText(), classTxt.getText(), str);
		

//		更新表格,显示查询结果
		studentTable.updateLovoTable(list);

	}

}
