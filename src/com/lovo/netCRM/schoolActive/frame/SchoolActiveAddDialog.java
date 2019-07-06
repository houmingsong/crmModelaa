package com.lovo.netCRM.schoolActive.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoComboBox;
import com.lovo.netCRM.component.LovoDate;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTxt;
import com.project.Bean.ActivityBean;
import com.project.Bean.DepartmentBean;
import com.project.Bean.EmployeeBean;
import com.project.service.IActivityService;
import com.project.service.IDepartmentService;
import com.project.service.IEmployeeService;
import com.project.service.ISchoolService;
import com.project.serviceImpl.ActivityServiceImpl;
import com.project.serviceImpl.DepartmentServiceImpl;
import com.project.serviceImpl.EmployeeServiceImpl;
import com.project.serviceImpl.SchoolServiceImpl;
/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ���ѧУ��Ի���
 * ��������:2012-10-8
 */
public class SchoolActiveAddDialog extends JDialog{
	/**ѧУId*/
	private int schoolId;
	/**������ı���*/
	private LovoTxt nameTxt = new LovoTxt("�����",50,50,this);
	/**�ʱ���ı���*/
	private LovoDate timeTxt = new LovoDate("�ʱ��",50,100,this);
	/**��ص��ı���*/
	private LovoTxt addressTxt = new LovoTxt("��ص�",50,150,this);
	/**������ı���*/
	private LovoTxt titleTxt = new LovoTxt("�����",50,200,this);
	/**������*/
	private LovoComboBox deptTxt;
	/**������*/
	private LovoComboBox employeeTxt = new LovoComboBox("������",new ArrayList(),50,300,this);
	IEmployeeService service=new EmployeeServiceImpl();
	IDepartmentService dm=new DepartmentServiceImpl();
	IActivityService ser=new ActivityServiceImpl();
	ISchoolService sservice=new SchoolServiceImpl();

	/**
	 * ��ӻ�Ի���
	 * @param jf �������
	 * @param schoolTable ѧУ���
	 * @param cityObj ���г���
	 */
	public SchoolActiveAddDialog(JFrame jf,int schoolId){
		super(jf,true);
		this.schoolId = schoolId;
		this.setLayout(null);
		this.setTitle("����»");
		
		this.init();
		
		this.setBounds(400, 150, 350, 450);
		this.setVisible(true);
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		this.initComboBox();
		
		LovoButton lbadd = new LovoButton("���",50,350,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = addActive(schoolId);
				if(isOk){
					SchoolActiveAddDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("ȡ��",180,350,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				SchoolActiveAddDialog.this.dispose();
			}});
	}
	
	//----------------------
	
	/**
	 * ��ʼ��������������
	 *
	 */
	private void initComboBox(){
		//��Ӳ���List����
		this.deptTxt = new LovoComboBox("������",dm.findAll(),50,250,this){
			/**
			 * ���ݲ���ID��ʾԱ������
			 * @param deptObj ���Ŷ���
			 */
			public void onchange(Object object){
				DepartmentBean d=(DepartmentBean)object;
				//����Ա������
				employeeTxt.setList(service.findByDepartment(d.getId()));
				
			}
		};

	
	}
	
	/**
	 * ��ӻ
	 */
	private boolean addActive(int schoolId){
		//��֤����,��֤ʧ�ܷ���false
		String str = "";
		//��֤����
		if(!this.nameTxt.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str += "�������Ʊ���Ϊ��λ������ĸ����\n";
		}

		if(str.length() != 0){
			JOptionPane.showMessageDialog(null, str);
			return false;
		}
		//��װʵ��
		ActivityBean da=new ActivityBean();
		da.setActivity(nameTxt.getText());
		da.setActivityTime(Date.valueOf(timeTxt.getText()));
		da.setPlace(addressTxt.getText());
		da.setTheme(titleTxt.getText());
		da.setDepartment(((DepartmentBean)deptTxt.getSelectedItem()).getDepartment());
		da.setEmployee(((EmployeeBean)employeeTxt.getSelectedItem()).getEname());
		da.setSchoolId(schoolId);
		ser.add(da);	
		
		return true;
	}
}
