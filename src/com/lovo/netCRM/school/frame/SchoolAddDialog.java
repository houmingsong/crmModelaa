package com.lovo.netCRM.school.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoComboBox;

import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTxt;
import com.lovo.netCRM.component.LovoTxtArea;
import com.project.Bean.SchoolBean;
import com.project.service.IDepartmentService;
import com.project.service.ISchoolService;
import com.project.serviceImpl.DepartmentServiceImpl;
import com.project.serviceImpl.SchoolServiceImpl;


/**
 * 
 * 四川网脉CRM系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 添加学校对话框
 * 开发日期:2012-10-11
 */
public class SchoolAddDialog extends JDialog{
	/**学校主面板*/
	private SchoolPanel schoolPanel;
	/**学校名称文本框*/
	private LovoTxt nameTxt = new LovoTxt("学校名称",50,50,this);
	/**地址文本框*/
	private LovoTxt addressTxt = new LovoTxt("学校地址",50,100,this);
	/**校长文本框*/
	private LovoTxt masterTxt = new LovoTxt("校长",320,50,this);
	/**联系电话文本框*/
	private LovoTxt phoneTxt = new LovoTxt("联系电话",50,150,this);
	/**学生人数文本框*/
	private LovoTxt studentNumberTxt = new LovoTxt("学生人数",320,100,this);
	/**老师人数文本框*/
	private LovoTxt teacherNumberTxt = new LovoTxt("老师人数",50,200,this);
	/**ip地址文本框*/
	private LovoTxt ipTxt = new LovoTxt("ip地址",320,150,this);
	/**宽带流量文本框*/
	private LovoTxt netFluxTxt = new LovoTxt("宽带流量",50,250,this);
	
	/**负责部门*/
	private LovoComboBox deptTxt;
	
	/**说明文本域*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("说明",320,200,200,120,this);
	/**城市ID*/
	private int cityId;
	ISchoolService service=new SchoolServiceImpl();
	IDepartmentService dm=new DepartmentServiceImpl();

	
	public SchoolAddDialog(JFrame jf,SchoolPanel schoolPanel,int cityId){
		super(jf,true);
		this.schoolPanel = schoolPanel;
		this.cityId = cityId;

		this.setLayout(null);
		this.setTitle("录入新学校");
		
		this.init();
		
		this.setBounds(300, 150, 650, 500);
		this.setVisible(true);
	}
	/**
	 * 初始化
	 *
	 */
	private void init() {
		this.initComboBox();
		
		LovoButton lbadd = new LovoButton("添加",200,400,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = addSchool(cityId);
				if(isOk){
					SchoolAddDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("取消",400,400,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				SchoolAddDialog.this.dispose();
			}});
	}
	
	//----------------------
	
	/**
	 * 初始化负责部门下拉框
	 *
	 */
	private void initComboBox(){
		//添加部门List集合
		this.deptTxt = new LovoComboBox("负责部门",dm.findAll(),50,300,this);
		
	}
	
	/**
	 * 添加学校
	 */
	private boolean addSchool(int cityId){
		//验证数据，验证失败返回false
		String str = "";
		//验证数据
		if(!this.nameTxt.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str += "学校吧名必须为二位以上字母或汉字\n";
		}
		 if(!this.phoneTxt.getText().matches("\\d{11}")){
			   str+="联系方式为11位有效数字";
		   }
		 if(!this.ipTxt.getText().matches("[1-9]{2,3}.[1-9]{2,3}.[1-9]{2,3}")){
			 str+="ip地址必须61.120.56,55 格式";
		 }
		
		//封装实体
			 SchoolBean s=service.findById(cityId);
			 s.setSchool(nameTxt.getText());
			 s.setPresident(masterTxt.getText());
		     s.setAddress(addressTxt.getText());
		     s.setTel(phoneTxt.getText());
		     s.setStudentAmount(Integer.parseInt(studentNumberTxt.getText()));
		     s.setTeacherAmount(Integer.parseInt(teacherNumberTxt.getText()));
		     s.setIp(ipTxt.getText());
		     s.setTraffic(netFluxTxt.getText());
		     s.setDepartment(deptTxt.getSelectedItem().toString());
		     s.setSchoolDescribe(descriptionTxt.getText());
		 service.addschool(s);
		//更新表格，显示添加结果
		this.schoolPanel.initData();
		
		return true;
	}
}
