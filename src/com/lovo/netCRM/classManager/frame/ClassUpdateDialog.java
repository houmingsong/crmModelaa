package com.lovo.netCRM.classManager.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoLabel;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTxt;
import com.project.Bean.ClassBean;
import com.project.service.IClassService;
import com.project.serviceImpl.ClassServiceImpl;

/**
 * 
 * 四川网脉CRM系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 修改班级对话框
 * 开发日期:2012-10-14
 */
public class ClassUpdateDialog extends JDialog{

	/**班级名称文本框*/
	private LovoLabel nameLabel = new LovoLabel("班级名称",50,60,this);
	/**带班老师文本框*/
	private LovoTxt teacherTxt = new LovoTxt("带班老师",50,140,this);
	/**班级id*/
	private int classId;
	/**班级面板*/
	private ClassManagerPanel classManagerPanel;
	IClassService service=new ClassServiceImpl();

	public ClassUpdateDialog(JFrame jf,int classId,ClassManagerPanel classManagerPanel){
		super(jf,true);
		this.classId = classId;
		this.classManagerPanel = classManagerPanel;
		
		this.setLayout(null);
		this.setTitle("修改班级");
		
		this.init();
		
		this.setBounds(400, 200, 350, 300);
		this.setVisible(true);
	}
	
	/**
	 * 初始化
	 *
	 */
	private void init() {
		this.initClassData(classId);
		
		LovoButton lbupdate = new LovoButton("修改",60,220,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = updateClass(classId);
				if(isOk){
				ClassUpdateDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("取消",200,220,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				ClassUpdateDialog.this.dispose();
			}});
	}
	
	//---------------------
	/**
	 * 初始化数据
	 * @param classId 班级ID
	 */
	private void initClassData(int classId){
		ClassBean ban=new ClassBean();
		nameLabel.setText(ban.getClassName());
		teacherTxt.setText(ban.getTeacher());
		
		
	}
	/**
	 * 修改班级
	 * @param classId 班级ID
	 */
	private boolean updateClass(int classId){
		//验证失败，返回false
		String str = "";
		//验证数据
		if(!this.teacherTxt.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str += "姓名称必须为二位以上字母或汉字\n";
		}

		if(str.length() != 0){
			JOptionPane.showMessageDialog(null, str);
			return false;
		}
//		更新表格，显示修改结果
		
		service.update(classId, teacherTxt.getText());
		
		this.classManagerPanel.initData();
		
		return true;
	}
}
