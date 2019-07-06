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
 * 四川网脉CRM系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 登陆窗体
 * 开发日期:2012-10-16
 */
public class LoginFrame extends JFrame{
	/**用户名文本框*/
	private LovoTxt userTxt = new LovoTxt("用户名",100,150,this);
	/**密码文本框*/
	private LovoPassWordTxt pwdTxt = new LovoPassWordTxt("密码",100,200,this);
	IEmployeeService  service=new EmployeeServiceImpl();
	
	public LoginFrame(){
		this.setLayout(null);
		LovoImageLabel crmImg = new LovoImageLabel(100,50,246,71,this);
		crmImg.setImage("image/logo_north.jpg");
		
		LovoButton lb = new LovoButton("登陆",230,250,this);
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
	 * 登陆方法
	 */
	private void login(){
		//成功后,进入主界面
		//String userName = this.userTxt.getText();
		String user=userTxt.getText();
		String pwd=pwdTxt.getText();
	
		EmployeeBean em=service.login(user, pwd);
		if(em==null){
			JOptionPane.showMessageDialog(null, "登录失败，账号密码错误");
			return ;
		}
		this.dispose();
		//传入用户实体对象[
		new MainFrame(em);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LoginFrame();
	}

}
