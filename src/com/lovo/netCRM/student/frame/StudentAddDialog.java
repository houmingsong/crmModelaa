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
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ���ѧ�����
 * ��������:2012-10-14
 */
public class StudentAddDialog extends JDialog{
	/**ѧ�������*/
	private StudentPanel studentPanel;
	/**ѧУid*/
	private int schoolId;
	/**�����ı���*/
	private LovoTxt nameTxt = new LovoTxt("��    ��",50,50,this);
	/**�Ա�ѡť*/
	private LovoRadioButton sexTxt = new LovoRadioButton("��    ��",new String[]{"��","Ů"},320,50,this);
	/**���������ı���*/
	private LovoDate birthdayTxt = new LovoDate("��������",50,100,this);
	/**�����༶*/
	private LovoComboBox classTxt;
	/**��ͥ��ַ�ı���*/
	private LovoTxt addressTxt = new LovoTxt("��ͥ��ַ",50,150,this);
	/**��ϵ�绰�ı���*/
	private LovoTxt phoneTxt = new LovoTxt("��ϵ�绰",320,150,this);
	/**�����ı���*/
	private LovoTxt fatherTxt = new LovoTxt("��    ��",50,200,this);
	/**���׵绰�ı���*/
	private LovoTxt fatherPhoneTxt = new LovoTxt("���׵绰",320,200,this);
	/**ĸ���ı���*/
	private LovoTxt mumTxt = new LovoTxt("ĸ    ��",50,250,this);
	/**ĸ�׵绰�ı���*/
	private LovoTxt mumPhoneTxt = new LovoTxt("ĸ�׵绰",320,250,this);
	
	/**��ע�ı���*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("��    ע",50,300,400,120,this);
	
	IStudentService service=new StudentServiceImpl();
	IClassService cservice=new ClassServiceImpl();
	
	
	public StudentAddDialog(JFrame jf,int schoolId,StudentPanel studentPanel){
		super(jf,true);
		this.studentPanel = studentPanel;
		this.schoolId = schoolId;
		this.setLayout(null);
		this.setTitle("���ѧ����Ϣ");
		
		this.init();
		
		this.setBounds(300, 150, 650, 530);
		this.setVisible(true);
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		this.initComboBox(schoolId);
		
		LovoButton lbadd = new LovoButton("���",200,450,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = addStudent();
				if(isOk){
					StudentAddDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("ȡ��",400,450,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				StudentAddDialog.this.dispose();
			}});
	}
	
	//----------------------
	
	/**
	 * ��ʼ���༶������
	 *
	 */
	private void initComboBox(int schoolId){
//		��Ӱ༶ ����
		this.classTxt = new LovoComboBox("�����༶",cservice.findBySchool(schoolId),320,100,this);
	}
	
	/**
	 * ���ѧ��
	 */
	private boolean addStudent(){
		//��֤���ݣ���֤ʧ�ܷ���false
		String str = "";
		//��֤����
		if(!this.nameTxt.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str += "�û�������Ϊ��λ������ĸ����\n";
		}
					
		if(!this.birthdayTxt.getText().matches("\\d{4}-\\d{2}-\\d{2}")){
			str+="����������Ϊ4-2��ʽ";
		}
	   if(!this.phoneTxt.getText().matches("\\d{11}")){
		   str+="��ϵ��ʽΪ11λ��Ч����";
	   }
		
		
		
		if(str.length() != 0){
			JOptionPane.showMessageDialog(null, str);
			return false;
		}
		
		
		//��װʵ��
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
		//���±����ʾ��ӽ��
		this.studentPanel.initData();
		
		return true;
	}
}
