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
 * 四川网脉CRM系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 修改密码面板
 * 开发日期:2012-10-14
 */
public class UpdatePwdPanel  extends JPanel{
	/**旧密码文本框*/
	private LovoPassWordTxt oldPwdTxt = new LovoPassWordTxt("请输入旧密码",100,100,this);
	/**新密码文本框*/
	private LovoPassWordTxt newPwdTxt = new LovoPassWordTxt("请输入新密码",100,150,this);
	/**确认密码文本框*/
	private LovoPassWordTxt rePwdTxt = new LovoPassWordTxt("请确认密码",100,200,this);
	/**登陆用户对象*/
	private Object userObj;
	IEmployeeService service=new EmployeeServiceImpl();
	
	public UpdatePwdPanel(Object userObj){
		this.userObj = userObj;
		this.setLayout(null);
		
		LovoButton updateButton = new LovoButton("修改",200,250,this);
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updatePwd();
			}
		});
	}
	
	//-------------------
	/**
	 * 修改密码
	 */
	private void updatePwd(){
		//验证原密码是否正确
		EmployeeBean ban= (EmployeeBean)userObj;
		if(!oldPwdTxt.getText().equals(ban.getPwd())){
			return;
		}
		if(!newPwdTxt.getText().equals(rePwdTxt.getText())){
			JOptionPane.showMessageDialog(null, "两次密码不一致");
		}
		service.changePwd(ban.getId(), newPwdTxt.getText());
		//验证两次密码是否一致
		
		JOptionPane.showMessageDialog(null, "密码修改成功");
	}
}
