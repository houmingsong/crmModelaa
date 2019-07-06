package com.lovo.netCRM.system.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoPassWordTxt;
import com.project.Bean.EmployeeBean;
import com.project.service.IEmployeeService;
import com.project.serviceImpl.EmployeeServiceImpl;

import sun.print.resources.serviceui;
/**
 * 
 * �Ĵ�����CRMϵͳ
 * @author �ųɷ�
 * @version 1.0
 * @see  
 * @description �޸��������
 * ��������:2012-10-14
 */
public class UpdatePwdPanel  extends JPanel{
	/**�������ı���*/
	private LovoPassWordTxt oldPwdTxt = new LovoPassWordTxt("�����������",100,100,this);
	/**�������ı���*/
	private LovoPassWordTxt newPwdTxt = new LovoPassWordTxt("������������",100,150,this);
	/**ȷ�������ı���*/
	private LovoPassWordTxt rePwdTxt = new LovoPassWordTxt("��ȷ������",100,200,this);
	/**��½�û�����*/
	private Object userObj;
	IEmployeeService service=new EmployeeServiceImpl();
	
	public UpdatePwdPanel(Object userObj){
		this.userObj = userObj;
		this.setLayout(null);
		
		LovoButton updateButton = new LovoButton("�޸�",200,250,this);
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updatePwd();
			}
		});
	}
	
	//-------------------
	/**
	 * �޸�����
	 */
	private void updatePwd(){
		//��֤ԭ�����Ƿ���ȷ
		EmployeeBean ban= (EmployeeBean)userObj;
		if(!oldPwdTxt.getText().equals(ban.getPwd())){
			return;
		}
		if(!newPwdTxt.getText().equals(rePwdTxt.getText())){
			JOptionPane.showMessageDialog(null, "�������벻һ��");
		}
		service.changePwd(ban.getId(), newPwdTxt.getText());
		//��֤���������Ƿ�һ��
		
		JOptionPane.showMessageDialog(null, "�����޸ĳɹ�");
	}
}
