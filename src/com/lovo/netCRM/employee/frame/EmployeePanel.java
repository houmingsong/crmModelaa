package com.lovo.netCRM.employee.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.lovo.netCRM.component.LovoTitlePanel;
import com.lovo.netCRM.component.LovoTxt;
import com.project.Bean.EmployeeBean;
import com.project.service.IEmployeeService;
import com.project.serviceImpl.EmployeeServiceImpl;
/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description Ա���������
 * ��������:2012-10-5
 */
public class EmployeePanel extends JPanel{
	/**Ա��������*/
	private LovoTable employeeTable;
	/**�������*/
	private JFrame jf;
	/**Ա�������ı���*/
	private LovoTxt nameTxt;
	/**�Ļ��̶��ı���*/
	private LovoTxt eduTxt;
	/**�����ı���*/
	private LovoTxt deptTxt;
	/**ְλ�ı���*/
	private LovoTxt jobTxt;
	IEmployeeService service=new EmployeeServiceImpl();

	
	
	public EmployeePanel(JFrame jf){
		this.jf = jf;
		this.setLayout(null);
		this.init();
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		new LovoTitleLabel("Ա �� �� ��",this);
		this.initTable();
		this.initButton();
		this.initFindPanel();
		this.initData();
	}
	/**
	 * ��ʼ������
	 */
	public void initData(){
		this.updateEmployeeTable();
	}
	/**
	 * ��ʼ����ť
	 *
	 */
	private void initButton() {
		LovoButton lbadd = new LovoButton("�����Ա��",50,500,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new EmployeeAddDialog(jf,EmployeePanel.this);
			}});
		
		LovoButton lbdel = new LovoButton("ɾ��Ա��",250,500,this);
		lbdel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = employeeTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				delEmployee(key);
			}});
		
		
		LovoButton lbupdate = new LovoButton("�޸�Ա����Ϣ",50,570,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = employeeTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				new EmployeeUpdateDialog(jf,key,EmployeePanel.this);
			}});
		
		
		LovoButton lbshow = new LovoButton("�鿴Ա����Ϣ",250,570,this);
		lbshow.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = employeeTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				new EmployeeShowDialog(jf,key);
			}});
	}
	/**
	 * ��ʼ����ѯ��ť
	 *
	 */
	private void initFindPanel(){

		LovoTitlePanel jp = new LovoTitlePanel("��ѯԱ��",400, 400, 320, 250,this);
		this.nameTxt = new LovoTxt("Ա������",30,30,jp);
		this.eduTxt = new LovoTxt("�Ļ��̶�",30,70,jp);
		this.deptTxt = new LovoTxt("���ڲ���",30,110,jp);
		this.jobTxt = new LovoTxt("����ְλ",30,150,jp);
		
		LovoButton lb = new LovoButton("����",180,200,jp);
		lb.setSize(60, 20);
		
		lb.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				findEmployee();
				
			}});
		
	}

	
	//-------------------------------------------------
	/**
	 * ��ʼ�����
	 *
	 */
	private void initTable() {
		employeeTable = new LovoTable(this,
				new String[]{"����","�Ա�","��������","�Ļ��̶�","��ϵ��ʽ","���ڲ���", "����ְλ"},
				new String[]{"ename","sex","birthday","edu","tel","department","job"},//Ա��ʵ������������ new String[]{"employeeName","sex"}
				"id");//���������� employeeId
		employeeTable.setSizeAndLocation(20, 90, 700, 300);
		
	}
	/**
	 * ���±������
	 */
	private void updateEmployeeTable(){
		List<EmployeeBean> list=service.findByItem(null, null, null, null);
		//���±��,��������Ա��List����
		employeeTable.updateLovoTable(list);
	}
	

	/**
	 * ɾ��Ա��
	 * @param id Ա��ID
	 */
	private void delEmployee(int employeeId){
		
		service.del(employeeId);
		
		//���±��,��ʾɾ�����
		this.updateEmployeeTable();
	}
	/**
	 * ����Ա��
	 */
	private void findEmployee(){
		List<EmployeeBean> list=service.findByItem(nameTxt.getText(), eduTxt.getText(), eduTxt.getText(), jobTxt.getText());

		
		//���±��,��ʾ��ѯ���
		employeeTable.updateLovoTable(list);
	}
}
