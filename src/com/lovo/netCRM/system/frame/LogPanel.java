package com.lovo.netCRM.system.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoDate;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.lovo.netCRM.component.LovoTitlePanel;
import com.project.Bean.LogBean;
import com.project.service.ILogService;
import com.project.serviceImpl.LogServiceImpl;
import com.project.util.DateChange;
/**
 * 
 * 四川网脉CRM系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 日志面板
 * 开发日期:2012-10-14
 */
public class LogPanel  extends JPanel{
	
	ILogService service=new LogServiceImpl();
	
	/**日志表格组件*/
	private LovoTable logTable;
	public LogPanel(){
		this.setLayout(null);
		this.init();
	}
	private void init() {
		new LovoTitleLabel("日志一览",this);
		this.initTable();
		this.initData();
		
		LovoTitlePanel jp = new LovoTitlePanel("按录入时间查询",400, 430, 320, 180,this);
		
		final LovoDate startDate = new LovoDate("起始日期",20,30,jp);
		
		final LovoDate endDate = new LovoDate("结束日期",20,80,jp);
		
		LovoButton lb = new LovoButton("查找",180,130,jp);
		lb.setSize(60, 20);
		
		lb.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				findLog(startDate.getText(),endDate.getText());
				
			}});
	}
	

	//------------------
	/**
	 * 初始化表格
	 */
	private void initTable() {
		logTable = new LovoTable(this,
				new String[]{"日期","日志内容"},                                                
				new String[]{"logTime","logDescribe"},//统计实体属性名数组 new String[]{"logDate","logInfo"}
				"id");//主键属性名 countId
		logTable.setSizeAndLocation(20, 90, 700, 300);
	}
	
	/**
	 * 初始化数据
	 */
	private void initData() {
						
		logTable.updateLovoTable(service.findByDate(null, null));
	}
	/**
	 * 按日期查询日志
	 * @param startDateTxt
	 * @param endDateTxt
	 */
	private void findLog(String startDateTxt,String endDateTxt){
		List<LogBean>list=service.findByDate(DateChange.getDate(startDateTxt),DateChange.getDate(endDateTxt));
		logTable.updateLovoTable(list);
	}
}
