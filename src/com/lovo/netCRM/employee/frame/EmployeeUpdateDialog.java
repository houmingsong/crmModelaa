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
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description Ա���޸ĶԻ���
 * ��������:2012-10-6
 */
public class EmployeeUpdateDialog extends JDialog{
	/**Ա�������*/
	private EmployeePanel emPanel;
	/**Ա��ID*/
	private int employeeId;
	/**������ǩ*/
	private LovoLabel nameLabel = new LovoLabel("��    ��",40,50,this);
	/**�Ա��ǩ*/
	private LovoLabel sexLabel = new LovoLabel("��    ��",320,50,this);
	/**��½����ǩ*/
	private LovoLabel loginNameLabel = new LovoLabel("��½��",40,100,this);
	
	/**�������ڱ�ǩ*/
	private LovoLabel birthdayLabel = new LovoLabel("��������",40,150,this);
	/**�Ļ��̶ȱ�ǩ*/
	private LovoLabel eduLabel = new LovoLabel("�Ļ��̶�",320,100,this);
	
	/**����רҵ��ǩ*/
	private LovoLabel specialityLabel = new LovoLabel("����רҵ",40,200,this);
	/**��ϵ��ʽ�ı���*/
	private LovoTxt phoneTxt = new LovoTxt("��ϵ��ʽ",320,150,this);
	/**��ͥסַ��ǩ*/
	private LovoLabel adressLabel = new LovoLabel("��ͥסַ",40,250,this);
	/**������ò*/
	private LovoComboBox<String> polityFaceTxt = new LovoComboBox<String>("������ò",new String[]{"��Ա","��������","Ⱥ��"},320,200,this);
	/**���ڲ���*/
	private LovoComboBox deptTxt;
	/**����ְλ*/
	private LovoComboBox workTxt;
	/**��ְ���ڱ�ǩ*/
	private LovoLabel enterJobLabel = new LovoLabel("��ְ����",320,300,this);
	/**ͷ���ǩ*/
	private LovoImageLabel faceLabel = new LovoImageLabel(580, 70, 100, 130,this);
	
	IEmployeeService service=new EmployeeServiceImpl();
	IDepartmentService dm=new DepartmentServiceImpl();
	IJobService js=new JobServiceImpl();
	public EmployeeUpdateDialog(JFrame jf,int employeeId,EmployeePanel emPanel){
		super(jf,true);
		this.emPanel = emPanel;
		this.employeeId = employeeId;
		
		this.setLayout(null);
		this.setTitle("�޸�Ա����Ϣ");
		
		this.init();
		
		this.setBounds(300, 100, 700, 450);
		this.setVisible(true);
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init(){
		this.initComboBox();
		this.initEmployeeData(this.employeeId);
		
		LovoButton lbupdate = new LovoButton("�޸�",150,350,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = updateEmployee(employeeId);
				if(isOk){
					EmployeeUpdateDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("ȡ��",400,350,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				EmployeeUpdateDialog.this.dispose();
			}});
	}
	
	
	//-------------------------------------------
	
	/**
	 * ��ʼ�����ź�ְλ������
	 *
	 */
	private void initComboBox(){
		//��Ӳ���List����
		this.deptTxt = new LovoComboBox("���ڲ���",dm.findAll(),40,300,this);
		//���ְλList����
		this.workTxt = new LovoComboBox("����ְλ",js.findAll(),320,250,this);
	
	}
	
	/**
	 * ��ʼ������
	 * @param employeeId��Ա��ID
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
	 * �޸�Ա����Ϣ
	 * @param employeeId Ա��ID
	 */
	private boolean updateEmployee(int employeeId){
		
		
		//��֤���ݣ�������֤ʧ�ܷ���false
		String str = "";
		//��֤����
		if(!this.nameLabel.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str += "�����Ʊ���Ϊ��λ������ĸ����\n";
		}

		if(str.length() != 0){
			JOptionPane.showMessageDialog(null, str);
			return false;
		}
		service.update(employeeId, phoneTxt.getText(),(String)polityFaceTxt.getSelectedItem(),
				((DepartmentBean)deptTxt.getSelectedItem()).getId(), ((JobBean)workTxt.getSelectedItem()).getId());
		
		//�������ݣ���ʾ�޸Ľ��
		this.emPanel.initData();
		
		return true;
	}
}
