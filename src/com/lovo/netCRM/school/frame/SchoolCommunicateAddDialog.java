package com.lovo.netCRM.school.frame;

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
import com.project.Bean.CommunicationBean;
import com.project.Bean.EmployeeBean;
import com.project.Bean.SchoolBean;
import com.project.service.ICommunicationService;
import com.project.service.IEmployeeService;
import com.project.service.ISchoolService;
import com.project.serviceImpl.CommunicationServiceImpl;
import com.project.serviceImpl.EmployeeServiceImpl;
import com.project.serviceImpl.SchoolServiceImpl;

/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ��ӹ�ͨ��¼�Ի���
 * ��������:2012-10-12
 */
public class SchoolCommunicateAddDialog extends JDialog{
	/**ѧУid*/
	private int schoolId;
	/**��ͨʱ���ı���*/
	private LovoDate timeTxt = new LovoDate("��ͨʱ��",50,50,this);
	/**У����ϵ���ı���*/
	private LovoTxt connectorTxt = new LovoTxt("У����ϵ��",50,100,this);
	/**ְ���ı���*/
	private LovoTxt jobTxt = new LovoTxt("ְ��",50,150,this);
	/**��ϵ��*/
	private LovoComboBox employeeTxt;
	/**��ͨ����*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("��ͨ����",50,250,120,60,this);
	IEmployeeService emservice=new EmployeeServiceImpl();
	ICommunicationService cmservice=new CommunicationServiceImpl();
	ISchoolService sservice=new SchoolServiceImpl();

	public SchoolCommunicateAddDialog(JFrame jf,int schoolId){
		super(jf,true);
		this.schoolId = schoolId;
		this.setLayout(null);
		this.setTitle("��ӹ�ͨ��¼");
		
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
				boolean isOk = addCommunicate(schoolId);
				if(isOk){
					SchoolCommunicateAddDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("ȡ��",180,340,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				SchoolCommunicateAddDialog.this.dispose();
			}});
	}
	
	//----------------------
	
	/**
	 * ��ʼ��������������
	 *
	 */
	private void initComboBox(int schoolId){
		SchoolBean sb=sservice.findById(schoolId);
		//��Ӹ����˼���
		this.employeeTxt = new LovoComboBox("������",emservice.findByDepartment(sb.getDepartmentId()),50,200,this);
		
	}
	/**
	 * ��ӹ�ͨ��¼
	 * @param schoolId ѧУID
	 */
	private boolean addCommunicate(int schoolId){
		//��֤���ݣ���֤ʧ�ܣ�����false
		
		//��װʵ��
		CommunicationBean cb=new CommunicationBean();
		cb.setSchoolID(schoolId);
		cb.setcTime(Date.valueOf(timeTxt.getText()));
		cb.setSchoolLinked(connectorTxt.getText());
		cb.setjob(jobTxt.getText());
		cb.setEmployeeID(((EmployeeBean)employeeTxt.getSelectedItem()).getId());
		cb.setDetails(descriptionTxt.getText());
		cmservice.add(cb);
		
		return true;
		
	}
}
