package com.project.Bean;

import java.sql.Date;
/**
 * ��־��
 * @author Administrator
 *
 */
public class LogBean {
	/**��־���*/
	private int id;
	/**��־����*/
	private Date logTime=new Date(System.currentTimeMillis());;
	/**����*/
	private String logDescribe;
	
	
	
	public LogBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LogBean(Date logTime, String logDescribe) {
		super();
		this.logTime = logTime;
		this.logDescribe = logDescribe;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	public String getlogDescribe() {
		return logDescribe;
	}
	public void setlogDescribe(String logDescribe) {
		this.logDescribe = logDescribe;
	}
	@Override
	public String toString() {
		return "LogBean [id=" + id + ", logTime=" + logTime + ", logDescribe=" + logDescribe + "]";
	}
	
	
	
}
