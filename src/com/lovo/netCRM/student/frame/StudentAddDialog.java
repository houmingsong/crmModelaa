package com.lovo.netCRM.student.frame;

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
import com.lovo.netCRM.component.LovoRadioButton;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTxt;
import com.lovo.netCRM.component.LovoTxtArea;
import com.project.Bean.ClassBean;
import com.project.Bean.StudentBean;
import com.project.service.IClassService;
import com.project.service.IStudentService;
import com.project.serviceImpl.ClassServiceImpl;
import com.project.serviceImpl.StudentServiceImpl;

/**
 * 
 * 四川网脉CRM系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 添加学生面板
 * 开发日期:2012-10-14
 */
public class StudentAddDialog extends JDialog{
	/**学生主面板*/
	private StudentPanel studentPanel;
	/**学校id*/
	private int schoolId;
	/**姓名文本框*/
	private LovoTxt nameTxt = new LovoTxt("姓    名",50,50,this);
	/**性别单选钮*/
	private LovoRadioButton sexTxt = new LovoRadioButton("性    别",new String[]{"男","女"},320,50,this);
	/**出生日期文本框*/
	private LovoDate birthdayTxt = new LovoDate("出生日期",50,100,this);
	/**所属班级*/
	private LovoComboBox classTxt;
	/**家庭地址文本框*/
	private LovoTxt addressTxt = new LovoTxt("家庭地址",50,150,this);
	/**联系电话文本框*/
	private LovoTxt phoneTxt = new LovoTxt("联系电话",320,150,this);
	/**父亲文本框*/
	private LovoTxt fatherTxt = new LovoTxt("父    亲",50,200,this);
	/**父亲电话文本框*/
	private LovoTxt fatherPhoneTxt = new LovoTxt("父亲电话",320,200,this);
	/**母亲文本框*/
	private LovoTxt mumTxt = new LovoTxt("母    亲",50,250,this);
	/**母亲电话文本框*/
	private LovoTxt mumPhoneTxt = new LovoTxt("母亲电话",320,250,this);
	
	/**备注文本域*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("备    注",50,300,400,120,this);
	
	IStudentService service=new StudentServiceImpl();
	IClassService cservice=new ClassServiceImpl();
	
	
	public StudentAddDialog(JFrame jf,int schoolId,StudentPanel studentPanel){
		super(jf,true);
		this.studentPanel = studentPanel;
		this.schoolId = schoolId;
		this.setLayout(null);
		this.setTitle("添加学生信息");
		
		this.init();
		
		this.setBounds(300, 150, 650, 530);
		this.setVisible(true);
	}
	/**
	 * 初始化
	 *
	 */
	private void init() {
		this.initComboBox(schoolId);
		
		LovoButton lbadd = new LovoButton("添加",200,450,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = addStudent();
				if(isOk){
					StudentAddDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("取消",400,450,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				StudentAddDialog.this.dispose();
			}});
	}
	
	//----------------------
	
	/**
	 * 初始化班级下拉框
	 *
	 */
	private void initComboBox(int schoolId){
//		添加班级 集合
		this.classTxt = new LovoComboBox("所属班级",cservice.findBySchool(schoolId),320,100,this);
	}
	
	/**
	 * 添加学生
	 */
	private boolean addStudent(){
		//验证数据，验证失败返回false
		String str = "";
		//验证数据
		if(!this.nameTxt.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str += "用户名必须为二位以上字母或汉字\n";
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
		StudentBean ban=new StudentBean();
		ban.setStudentName(nameTxt.getText());
		ban.setSex(sexTxt.getItem());
		ban.setBirthday(Date.valueOf(birthdayTxt.getText()));
		ban.setClassNameID(((ClassBean)classTxt.getItem()).getId());
		ban.setAddress(addressTxt.getText());
		ban.setTel(phoneTxt.getText());
		ban.setFatherName(fatherTxt.getText());
		ban.setFatherTel(fatherPhoneTxt.getText());
		ban.setMotherName(mumTxt.getText());
		ban.setMotherTel(mumPhoneTxt.getText());
		ban.setScommment(descriptionTxt.getText());
		
		
		
		service.add(ban);
		//更新表格，显示添加结果
		this.studentPanel.initData();
		
		return true;
	}
}
