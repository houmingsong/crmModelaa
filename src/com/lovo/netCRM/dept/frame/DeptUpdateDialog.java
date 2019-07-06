package com.lovo.netCRM.dept.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoLabel;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTxtArea;
import com.project.Bean.DepartmentBean;
import com.project.service.IDepartmentService;
import com.project.serviceImpl.DepartmentServiceImpl;
/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description �����޸ĶԻ���
 * ��������:2012-10-15
 */
public class DeptUpdateDialog extends JDialog{
	/**���ű��*/
	private DeptPanel deptPanel;
	/**����id*/
	private int deptId;
	/**�������Ʊ�ǩ*/
	private LovoLabel nameLabel = new LovoLabel("��������",50,50,this);
	/**����ʱ���ǩ*/
	private LovoLabel timeLabel = new LovoLabel("����ʱ��",50,100,this);
	/**���������ı���*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("��������",50,150,120,60,this);
	IDepartmentService service=new DepartmentServiceImpl();

	public DeptUpdateDialog(JFrame jf,int deptId,DeptPanel deptPanel){
		super(jf,true);
		this.deptPanel = deptPanel;
		this.deptId = deptId;
		this.setLayout(null);
		this.setTitle("�޸Ĳ�����Ϣ");
		
		this.init();
		
		this.setBounds(400, 150, 350, 350);
		this.setVisible(true);
	}
	/**
	 * ��ʼ������
	 *
	 */
	private void init() {
		this.initData(this.deptId);
		
		LovoButton lbupdate = new LovoButton("�޸�",50,250,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = updateDept(deptId);
				if(isOk){
				DeptUpdateDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("ȡ��",180,250,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				DeptUpdateDialog.this.dispose();
			}});
	}
	//---------------------------------------
	/**
	 * ��ʼ����Ϣ
	 */
	private void initData(int deptId) {
		DepartmentBean db=service.findById(deptId);
		System.out.println(db);
		nameLabel.setText(db.getDepartment());
		timeLabel.setText(db.getDtime().toString());
		descriptionTxt.setText(db.getDepartmentDescribe());
	}
	/**
	 * �޸Ĳ�����Ϣ
	 * @param deptId
	 */
	private boolean updateDept(int deptId){
		service.updateDepartment(deptId, descriptionTxt.getText());
		//���±����ʾ�޸Ľ��
		this.deptPanel.initData();
		
		return true;
	}
}
