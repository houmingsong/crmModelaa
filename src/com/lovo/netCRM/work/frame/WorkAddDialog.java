package com.lovo.netCRM.work.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoCheckBox;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTxt;
import com.lovo.netCRM.component.LovoTxtArea;
import com.project.Bean.JobBean;
import com.project.service.IJobService;
import com.project.serviceImpl.JobServiceImpl;
/**
 * 
 * 四川网脉CRM系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 添加职位对话框
 * 开发日期:2012-10-6
 */
public class WorkAddDialog extends JDialog{
	/**职位主面板*/
	private WorkPanel workPanel;
	/**职位名称文本框*/
	private LovoTxt nameTxt = new LovoTxt("职位名称",50,50,this);
	/**职位描述文本域*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("职位描述",50,100,300,80,this);
	IJobService service=new JobServiceImpl();
	/**权限复选框*/
	private LovoCheckBox gradeTxt = new LovoCheckBox("权限",
			new String[]{"资料管理","学校管理","用户管理","统计信息"},50,200,this);
	
	public WorkAddDialog(JFrame jf,WorkPanel workPanel){
		super(jf,true);
		this.workPanel = workPanel;
		this.setLayout(null);
		this.setTitle("添加新职位");
		
		this.init();
		
		this.setBounds(350, 150, 550, 400);
		this.setVisible(true);
	}
	/**
	 * 初始化
	 *
	 */
	private void init() {
		LovoButton lbadd = new LovoButton("添加",150,300,this);
		lbadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = addWork();
				if(isOk){
					WorkAddDialog.this.dispose();
				}
			}});
		
		LovoButton lbcancel = new LovoButton("取消",330,300,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				WorkAddDialog.this.dispose();
			}});
	}
	
	//----------------------
	/**
	 * 添加职位
	 */
	private boolean addWork(){
		//验证数据，数据验证失败返回false
		String str = "";
		//验证数据
		if(!this.nameTxt.getText().matches("[a-zA-Z\\u4e00-\\u9fa5]{2,20}")){
			str += "职位名称必须为二位以上字母或汉字\n";
		}

		if(str.length() != 0){
			JOptionPane.showMessageDialog(null, str);
			return false;
		}
		//封装实体
		JobBean ba=new JobBean();
		ba.setJob(nameTxt.getText());
		ba.setJobDescribe(descriptionTxt.getText());		 		 						
		//得到选中项数组
		String[] items = gradeTxt.getItem();
		ba.setIsDataPower(items[0]);
		ba.setIsSchoolPower(items[1]);
		ba.setIsUserPower(items[2]);
		ba.setIsStatisticsPower(items[3]);				
		service.addJob(ba);
		//更新表格，显示添加职位结果
		workPanel.initData();
		return true;
	}
}
