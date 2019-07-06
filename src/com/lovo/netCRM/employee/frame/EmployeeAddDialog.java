package com.lovo.netCRM.employee.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoComboBox;
import com.lovo.netCRM.component.LovoDate;
import com.lovo.netCRM.component.LovoFileChooser;
import com.lovo.netCRM.component.LovoRadioButton;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTxt;
import com.project.Bean.EmployeeBean;
import com.project.Bean.JobBean;
import com.project.Bean.DepartmentBean;
import com.project.service.IDepartmentService;
import com.project.service.IEmployeeService;
import com.project.service.IJobService;
import com.project.serviceImpl.DepartmentServiceImpl;
import com.project.serviceImpl.EmployeeServiceImpl;
import com.project.serviceImpl.JobServiceImpl;
/**
 * 
 * 四川网脉CRM系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 添加员工对话框
 * 开发日期:2012-10-6
 */
public class EmployeeAddDialog extends JDialog{

	private static final String DepartmentBean = null;
	/**姓名文本框*/
	private LovoTxt nameTxt = new LovoTxt("姓    名",40,50,this);
	/**性别单选钮*/
	private LovoRadioButton sexTxt = new LovoRadioButton("性    别",new String[]{"男","女"},320,50,this);
	/**登陆名文本框*/
	private LovoTxt loginNameTxt = new LovoTxt("登陆名",40,100,this);
	/**出生年月*/
	private LovoDate birthdayTxt = new LovoDate("出生年月",40,150,this);
	/**文化程度*/
	private LovoComboBox<String> eduTxt = new LovoComboBox<String>("文化程度",new String[]{"高中","大专","本科","硕士"},320,100,this);
	/**所属专业文本框*/
	private LovoTxt specialityTxt = new LovoTxt("所属专业",40,200,this);
	/**联系方式文本框*/
	private LovoTxt phoneTxt = new LovoTxt("联系方式",320,150,this);
	/**家庭住址文本框*/
	private LovoTxt addressTxt = new LovoTxt("家庭住址",40,250,this);
	/**政治面貌*/
	private LovoComboBox<String> polityFaceTxt = new LovoComboBox<String>("政治面貌",new String[]{"团员","党员","民主党派","无党派人士"},320,200,this);
	/**所在部门*/
	private LovoComboBox deptTxt;
	/**工作职位*/
	private LovoComboBox jobTxt;
	/**头像*/
	private LovoFileChooser faceTxt = new LovoFileChooser(this,"face");
	/**员工主面板*/
	private EmployeePanel emPanel;
	IEmployeeService service=new EmployeeServiceImpl();
	IDepartmentService dm=new DepartmentServiceImpl();
	IJobService js=new JobServiceImpl();
	
	public EmployeeAddDialog(JFrame jf,EmployeePanel emPanel){
		super(jf,true);
		this.emPanel = emPanel;
		this.setLayout(null);
		this.setTitle("添加新员工");
		
		this.init();
		
		this.setBounds(300, 100, 700, 450);
		this.setVisible(true);
	}
	/**
	 * 初始化
	 *
	 */
	private void init(){
		this.initComboBox();
		
		faceTxt.setBounds(580, 70, 100, 150);
		
		LovoButton lbadd = new LovoButton("添加",150,360,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = addEmployee();
				if(isOk){
					EmployeeAddDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("取消",400,360,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				EmployeeAddDialog.this.dispose();
			}});
	}
	
	//--------------------------------------------
	/**
	 * 初始化部门和职位下拉框
	 *
	 */
	private void initComboBox(){
		//添加部门List集合
	this.deptTxt = new LovoComboBox("所属部门",dm.findAll(),40,300,this);	
		
		//添加职位List集合
		this.jobTxt = new LovoComboBox("工作职位",js.findAll(),320,250,this);
	
	
	}
	/**
	 * 添加操作
	 *
	 */
	private boolean addEmployee(){
		String str = "";
		//验证数据
		if(!this.nameTxt.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str += "用户名必须为二位以上字母或汉字\n";
		}
			
		if(!this.loginNameTxt.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str+= "登录名必须为二位以上字母或汉字\n";
		}
		if(!this.birthdayTxt.getText().matches("\\d{4}-\\d{2}-\\d{2}")){
			str+="出生年月日为4-2格式";
		}
	   if(!this.phoneTxt.getText().matches("\\d{11}")){
		   str+="联系方式为11位有效数字";
	   }
		
		
		
		if(str.length() != 0){
			JOptionPane.showMessageDialog(null, str);
			return false;
		}
		
		//封装实体
		EmployeeBean em=new EmployeeBean();
		em.setEname(nameTxt.getText());
		em.setSex(sexTxt.getItem());
		em.setBirthday(Date.valueOf(birthdayTxt.getText()));
		em.setEdu(eduTxt.getItem());
		em.setTel(phoneTxt.getText());
		
		em.setJobID(((JobBean)jobTxt.getItem()).getId());
		em.setDepartmentId(((DepartmentBean)deptTxt.getItem()).getId());
		
		em.setCodeName(loginNameTxt.getText());
		em.setMajor(specialityTxt.getText());
		em.setParty(polityFaceTxt.getItem());
		em.setAddress(addressTxt.getText());
	   em.setImgPath(faceTxt.getFilePath());
		
		//完成添加操作
		service.add(em);
//		更新数据,显示添加结果
		this.emPanel.initData();
		return true;
	}
}
