package com.lovo.netCRM.student.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoComboBox;
import com.lovo.netCRM.component.LovoLabel;
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
 * @description 学生信息修改对话框
 * 开发日期:2012-10-14
 */
public class StudentUpdateDialog extends JDialog{
	/**学生主面板*/
	private StudentPanel studentPanel;
	/**姓名标签*/
	private LovoLabel nameLabel = new LovoLabel("姓    名",50,50,this);
	/**性别标签*/
	private LovoLabel sexLabel = new LovoLabel("性    别",320,50,this);
	/**出生日期标签*/
	private LovoLabel birthdayLabel = new LovoLabel("出生日期",50,100,this);
	/**所属班级*/
	private LovoComboBox classTxt;
	/**家庭地址标签*/
	private LovoLabel addressLabel = new LovoLabel("家庭地址",50,150,this);
	/**联系电话文本框*/
	private LovoTxt phoneTxt = new LovoTxt("联系电话",320,150,this);
	/**父亲标签*/
	private LovoLabel fatherLabel = new LovoLabel("父    亲",50,200,this);
	/**父亲电话文本框*/
	private LovoTxt fatherPhoneTxt = new LovoTxt("父亲电话",320,200,this);
	/**母亲标签*/
	private LovoLabel mumLabel = new LovoLabel("母    亲",50,250,this);
	/**母亲电话文本框*/
	private LovoTxt mumPhoneTxt = new LovoTxt("母亲电话",320,250,this);
	/**学生状态下拉框*/
	private LovoComboBox<String> stateTxt = new LovoComboBox<String>("学生状态",
			new String[]{"会员",
			"非会员"},50,300,this);
	/**备注文本域*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("备    注",320,300,200,120,this);
	/**学校id*/
	private int schoolId;
	/**学生id*/
	private int studentId;
	IStudentService sservice=new StudentServiceImpl();
	IClassService cservice=new ClassServiceImpl();

	public StudentUpdateDialog(JFrame jf,int schoolId,int studentId,StudentPanel studentPanel){
		super(jf,true);
		this.studentPanel = studentPanel;
		this.studentId = studentId;
		this.schoolId = schoolId;
		this.setLayout(null);
		this.setTitle("修改学生信息");
		
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
		this.initData(studentId);

		LovoButton lbadd = new LovoButton("修改",200,450,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = updateStudent(studentId);
				if(isOk){
				StudentUpdateDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("取消",400,450,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				StudentUpdateDialog.this.dispose();
			}});
	}
	
	//----------------------
	/**
	 * 初始化班级下拉框
	 *
	 */
	private void initComboBox(int schoolId){
//		添加班级集合
		this.classTxt = new LovoComboBox("所属班级",new ArrayList(),320,100,this);
	}
	
	/**
	 * 初始化数据
	 * @param studentId 学生ID
	 */
	private void initData(int studentId){
		StudentBean ban=sservice.findById(studentId);
		nameLabel.setText(ban.getStudentName());
		sexLabel.setText(ban.getSex());
		birthdayLabel.setText(ban.getBirthday().toString());
		classTxt.setItem(ban.getClassName());
		addressLabel.setText(ban.getAddress());
		phoneTxt.setText(ban.getTel());
		fatherLabel.setText(ban.getFatherName());
		fatherPhoneTxt.setText(ban.getFatherTel());
		mumLabel.setText(ban.getMotherName());
		mumPhoneTxt.setText(ban.getMotherTel());
		stateTxt.setItem(ban.getScondition());
		descriptionTxt.setText(ban.getScommment());
		
		
		
	}

	/**
	 * 修改学生
	 * @param studentId 学生ID
	 */
	private boolean updateStudent(int studentId){
		//验证数据,验证失败返回false
		String str = "";
		//验证数据
		if(!this.nameLabel.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str += "姓名称必须为二位以上字母或汉字\n";
		}

		if(str.length() != 0){
			JOptionPane.showMessageDialog(null, str);
			return false;
		}
		//封装实体
		
		sservice.update(studentId,((ClassBean)classTxt.getSelectedItem()).getId() ,phoneTxt.getText(), fatherPhoneTxt.getText(), mumPhoneTxt.getText(), stateTxt.getItem(), descriptionTxt.getText());
		
		
		//更新表格，显示修改结果
		this.studentPanel.initData();
		
		return true;
	}
}
