package com.lovo.netCRM.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoImageLabel;
import com.lovo.netCRM.component.LovoPassWordTxt;
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
 * @description ��½����
 * ��������:2012-10-16
 */
public class LoginFrame extends JFrame{
	/**�û����ı���*/
	private LovoTxt userTxt = new LovoTxt("�û���",100,150,this);
	/**�����ı���*/
	private LovoPassWordTxt pwdTxt = new LovoPassWordTxt("����",100,200,this);
	IEmployeeService  service=new EmployeeServiceImpl();
	
	public LoginFrame(){
		this.setLayout(null);
		LovoImageLabel crmImg = new LovoImageLabel(100,50,246,71,this);
		crmImg.setImage("image/logo_north.jpg");
		
		LovoButton lb = new LovoButton("��½",230,250,this);
		lb.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				login();
			}});
		
		this.setSize(450,330);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
	}
	
	//--------------------
	/**
	 * ��½����
	 */
	private void login(){
		//�ɹ���,����������
		//String userName = this.userTxt.getText();
		String user=userTxt.getText();
		String pwd=pwdTxt.getText();
	
		EmployeeBean em=service.login(user, pwd);
		if(em==null){
			JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ��˺��������");
			return ;
		}
		this.dispose();
		//�����û�ʵ�����[
		new MainFrame(em);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LoginFrame();
	}

}
