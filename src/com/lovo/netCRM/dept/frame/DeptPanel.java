package com.lovo.netCRM.dept.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.project.Bean.DepartmentBean;
import com.project.service.IDepartmentService;
import com.project.serviceImpl.DepartmentServiceImpl;
/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description ���Ź������
 * ��������:2012-10-6
 */
public class DeptPanel extends JPanel{
	/**���ű�����*/
	private LovoTable deptTable;
	/**�������*/
	private JFrame jf;
	IDepartmentService service=new DepartmentServiceImpl();

	public DeptPanel(JFrame jf){
		this.jf = jf;
		this.setLayout(null);
		this.init();
	}
	/**
	 * ��ʼ��
	 *
	 */
	private void init() {
		new LovoTitleLabel("�� �� �� ��",this);
		this.initTable();
		this.initButton();
		this.initData();
	}
	/**
	 * ��ʼ������
	 */
	public void initData(){
		this.updateDeptTable();
	}
	/**
	 * ��ʼ����ť
	 *
	 */
	private void initButton() {
		LovoButton lbadd = new LovoButton("����²���",200,500,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				new DeptAddDialog(jf,DeptPanel.this);
			}});
		
		
		LovoButton lbupdate = new LovoButton("�޸Ĳ�����Ϣ",400,500,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = deptTable.getKey();
				if(key == -1){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				new DeptUpdateDialog(jf,key,DeptPanel.this);
			}});
	}
	
	//--------------------------
	
	/**
	 * ��ʼ�����
	 */
	private void initTable() {
		deptTable = new LovoTable(this,
				new String[]{"��������","����ʱ��","��������"},
				new String[]{"department","dtime","departmentDescribe"},//����ʵ������������ new String[]{"deptName","time"}
				"id");//���������� deptId
		deptTable.setSizeAndLocation(20, 90, 700, 300);
		
	}
	/**
	 * ���²��ű��
	 */
	private void updateDeptTable(){
		//���±��,���벿��List����
		List<DepartmentBean>list=service.findAll();
		deptTable.updateLovoTable(list);
	}
}
