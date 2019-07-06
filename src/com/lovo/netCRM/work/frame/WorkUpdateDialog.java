package com.lovo.netCRM.work.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoCheckBox;
import com.lovo.netCRM.component.LovoLabel;
import com.lovo.netCRM.component.LovoTable;
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
 * @description 修改职位对话框
 * 开发日期:2012-10-6
 */
public class WorkUpdateDialog extends JDialog{
	/**职位主面板*/
	private WorkPanel workPanel;
	/**职位名称文本框*/
	private LovoLabel nameLabel = new LovoLabel("职位名称",50,50,this);
	/**职位描述文本域*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("职位描述",50,100,300,80,this);
	/**权限复选框*/
	private LovoCheckBox gradeTxt = new LovoCheckBox("权限",new String[]{
			"资料管理","学校管理","用户管理","统计信息"},50,200,this);
	IJobService service=new JobServiceImpl();

	/**职位id*/
	private int workId;
	public WorkUpdateDialog(JFrame jf,int workId,WorkPanel workPanel){
		super(jf,true);
		this.workPanel = workPanel;
		this.workId = workId;
		
		this.setLayout(null);
		this.setTitle("修改职位");
		
		this.init();
		
		this.setBounds(350, 150, 550, 400);
		this.setVisible(true);
	}
	/**
	 * 初始化
	 *
	 */
	private void init() {
		descriptionTxt.setEditable(false);
		this.initData(workId);
		LovoButton lbupdate = new LovoButton("修改",150,300,this);
		lbupdate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				updateWork(workId);
				WorkUpdateDialog.this.dispose();
			}});
		
		LovoButton lbcancel = new LovoButton("取消",330,300,this);
		lbcancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				WorkUpdateDialog.this.dispose();
			}});
	}
	
	
	//----------------------

	/**
	 * 初始化数据
	 * @param workId 工作职位ID
	 */
	private void initData(int workId) {
		//设置选中项
		JobBean ba=service.findById(workId);		
		ba.setJob(nameLabel.getText());
		ba.setJobDescribe(descriptionTxt.getText());
		gradeTxt.setItem(new String[]{ba.getIsDataPower(),ba.getIsSchoolPower(),ba.getIsUserPower(),ba.getIsStatisticsPower()});
		
	}
	/**
	 * 修改职位
	 * @param workId 工作职位id
	 */
	private void updateWork(int workId){
		String[] in=gradeTxt.getItem();
		service.update(workId, in[0], in[1], in[2], in[3]);
		
		//更新表格，显示修改职位结果
		this.workPanel.initData();
	}
}
