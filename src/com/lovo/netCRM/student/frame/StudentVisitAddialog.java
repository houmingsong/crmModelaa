package com.lovo.netCRM.student.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoComboBox;
import com.lovo.netCRM.component.LovoDate;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTxt;
import com.lovo.netCRM.component.LovoTxtArea;
import com.project.Bean.EmployeeBean;
import com.project.Bean.VisitBean;
import com.project.service.IEmployeeService;
import com.project.service.IStudentService;
import com.project.service.IVisitService;
import com.project.serviceImpl.EmployeeServiceImpl;
import com.project.serviceImpl.StudentServiceImpl;
import com.project.serviceImpl.VisitServiceImpl;

/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ���ѧ���طü�¼
 * ��������:2012-10-14
 */
public class StudentVisitAddialog extends JDialog{
	/**ѧ��id*/
	private int studentId;
	/**�ط�ʱ���ı���*/
	private LovoDate timeTxt = new LovoDate("�ط�ʱ��",50,50,this);
	/**������*/
	private LovoComboBox employeeTxt;
	/**�ط����ı���*/
	private LovoTxt connectorTxt = new LovoTxt("�ط���",50,150,this);
	/**�ط������ı���*/
	private LovoTxt titleTxt = new LovoTxt("�ط�����",50,200,this);
	/**�ط�����*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("�ط�����",50,250,120,60,this);
	
	IEmployeeService service=new EmployeeServiceImpl();
	IStudentService sservice=new StudentServiceImpl();
	IVisitService lservice=new VisitServiceImpl();

	
	/**ѧУid*/
	private int schoolId;
	public StudentVisitAddialog(JFrame jf,int studentId,int schoolId){
		super(jf,true);
		this.studentId =  studentId;
		this.schoolId =  schoolId;
		this.setLayout(null);
		this.setTitle("��ӻطü�¼");
		
		this.init();
		
		this.setBounds(400, 130, 350, 420);
		this.setVisible(true);
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		this.initComboBox(schoolId);
		LovoButton lbadd = new LovoButton("���",50,340,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				addVisit( studentId);
				StudentVisitAddialog.this.dispose();
			}});
		
		LovoButton lbcancel = new LovoButton("ȡ��",180,340,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				StudentVisitAddialog.this.dispose();
			}});
	}
	
	//----------------------
	
	/**
	 * ��ʼ��������������
	 * @param schoolObj ѧУ����
	 */
	private void initComboBox(int schoolId){

		//��Ӹ����˼���
		this.employeeTxt = new LovoComboBox("������",service.findBySchool(schoolId),50,100,this);
		
	}
	/**
	 * ��ӻطü�¼
	 * @param studentId ѧ��ID
	 */
	private void addVisit(int studentId){
		//��֤����
		VisitBean ban=new VisitBean();
		ban.setVisitTime(Date.valueOf(timeTxt.getText()));
		ban.setEmployee(((EmployeeBean)employeeTxt.getSelectedItem()).getEname());
		ban.setPatriarch(connectorTxt.getText());
		ban.setTheme(titleTxt.getText());
           ban.setDetails(descriptionTxt.getText());
           ban.setStudentID(studentId);
		
		
		
		
		
		
		//��װʵ��
		
	}
}
