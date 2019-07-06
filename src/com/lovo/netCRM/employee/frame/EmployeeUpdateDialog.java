package com.lovo.netCRM.employee.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoComboBox;
import com.lovo.netCRM.component.LovoImageLabel;
import com.lovo.netCRM.component.LovoLabel;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTxt;
import com.project.Bean.DepartmentBean;
import com.project.Bean.EmployeeBean;
import com.project.Bean.JobBean;
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
 * @description 员工修改对话框
 * 开发日期:2012-10-6
 */
public class EmployeeUpdateDialog extends JDialog{
	/**员工主面板*/
	private EmployeePanel emPanel;
	/**员工ID*/
	private int employeeId;
	/**姓名标签*/
	private LovoLabel nameLabel = new LovoLabel("姓    名",40,50,this);
	/**性别标签*/
	private LovoLabel sexLabel = new LovoLabel("性    别",320,50,this);
	/**登陆名标签*/
	private LovoLabel loginNameLabel = new LovoLabel("登陆名",40,100,this);
	
	/**出生日期标签*/
	private LovoLabel birthdayLabel = new LovoLabel("出生日期",40,150,this);
	/**文化程度标签*/
	private LovoLabel eduLabel = new LovoLabel("文化程度",320,100,this);
	
	/**所属专业标签*/
	private LovoLabel specialityLabel = new LovoLabel("所属专业",40,200,this);
	/**联系方式文本框*/
	private LovoTxt phoneTxt = new LovoTxt("联系方式",320,150,this);
	/**家庭住址标签*/
	private LovoLabel adressLabel = new LovoLabel("家庭住址",40,250,this);
	/**政治面貌*/
	private LovoComboBox<String> polityFaceTxt = new LovoComboBox<String>("政治面貌",new String[]{"党员","民主党派","群众"},320,200,this);
	/**所在部门*/
	private LovoComboBox deptTxt;
	/**工作职位*/
	private LovoComboBox workTxt;
	/**入职日期标签*/
	private LovoLabel enterJobLabel = new LovoLabel("入职日期",320,300,this);
	/**头像标签*/
	private LovoImageLabel faceLabel = new LovoImageLabel(580, 70, 100, 130,this);
	
	IEmployeeService service=new EmployeeServiceImpl();
	IDepartmentService dm=new DepartmentServiceImpl();
	IJobService js=new JobServiceImpl();
	public EmployeeUpdateDialog(JFrame jf,int employeeId,EmployeePanel emPanel){
		super(jf,true);
		this.emPanel = emPanel;
		this.employeeId = employeeId;
		
		this.setLayout(null);
		this.setTitle("修改员工信息");
		
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
		this.initEmployeeData(this.employeeId);
		
		LovoButton lbupdate = new LovoButton("修改",150,350,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = updateEmployee(employeeId);
				if(isOk){
					EmployeeUpdateDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("取消",400,350,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				EmployeeUpdateDialog.this.dispose();
			}});
	}
	
	
	//-------------------------------------------
	
	/**
	 * 初始化部门和职位下拉框
	 *
	 */
	private void initComboBox(){
		//添加部门List集合
		this.deptTxt = new LovoComboBox("所在部门",dm.findAll(),40,300,this);
		//添加职位List集合
		this.workTxt = new LovoComboBox("工作职位",js.findAll(),320,250,this);
	
	}
	
	/**
	 * 初始化数据
	 * @param employeeId　员工ID
	 */
	private void initEmployeeData(int employeeId){
		EmployeeBean em=service.findById(employeeId);
		nameLabel.setText(em.getEname());
		sexLabel.setText(em.getSex());
		loginNameLabel.setText(em.getCodeName());
		birthdayLabel.setText(em.getBirthday().toString());
		eduLabel.setText(em.getEdu());
		specialityLabel.setText(em.getMajor());	
		adressLabel.setText(em.getAddress());
		enterJobLabel.setText(em.getJobTime().toString());
		faceLabel.setText(em.getImgPath());
		polityFaceTxt.setSelectedItem(em.getParty());
		phoneTxt.setText(em.getTel());
		deptTxt.setSelectedIndex(em.getDepartmentId()-1);
		workTxt.setSelectedItem(em.getJobID()-1);
	}
	
	/**
	 * 修改员工信息
	 * @param employeeId 员工ID
	 */
	private boolean updateEmployee(int employeeId){
		
		
		//验证数据，数据验证失败返回false
		String str = "";
		//验证数据
		if(!this.nameLabel.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str += "姓名称必须为二位以上字母或汉字\n";
		}

		if(str.length() != 0){
			JOptionPane.showMessageDialog(null, str);
			return false;
		}
		service.update(employeeId, phoneTxt.getText(),(String)polityFaceTxt.getSelectedItem(),
				((DepartmentBean)deptTxt.getSelectedItem()).getId(), ((JobBean)workTxt.getSelectedItem()).getId());
		
		//更新数据，显示修改结果
		this.emPanel.initData();
		
		return true;
	}
}
