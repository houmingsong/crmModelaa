package com.project.Bean;
/**
 * ����ͳ��ʵ����
 * @author Administrator
 *
 */
public class PlaceNumBean {
	/**��������*/
	private String city;
	/**¼��ѧУ����*/
	private int allSchool;
	/**��Ǣ��ѧУ����*/
	private int talkingSchool;
	/**����ѧУ����*/
	private int waitSchool;
	/**���δͨ��ѧУ����*/
	private int noPassSchool;
	/**�ƹ㿪չѧУ����*/
	private int passSchool;
	
	
	
	public PlaceNumBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PlaceNumBean(String city, int allSchool, int talkingSchool, int waitSchool, int noPassSchool,
			int passSchool) {
		super();
		this.city = city;
		this.allSchool = allSchool;
		this.talkingSchool = talkingSchool;
		this.waitSchool = waitSchool;
		this.noPassSchool = noPassSchool;
		this.passSchool = passSchool;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAllSchool() {
		return allSchool;
	}
	public void setAllSchool(int allSchool) {
		this.allSchool = allSchool;
	}
	public int getTalkingSchool() {
		return talkingSchool;
	}
	public void setTalkingSchool(int talkingSchool) {
		this.talkingSchool = talkingSchool;
	}
	public int getWaitSchool() {
		return waitSchool;
	}
	public void setWaitSchool(int waitSchool) {
		this.waitSchool = waitSchool;
	}
	public int getNoPassSchool() {
		return noPassSchool;
	}
	public void setNoPassSchool(int noPassSchool) {
		this.noPassSchool = noPassSchool;
	}
	public int getPassSchool() {
		return passSchool;
	}
	public void setPassSchool(int passSchool) {
		this.passSchool = passSchool;
	}
	@Override
	public String toString() {
		return "PlaceNumBean [city=" + city + ", allSchool=" + allSchool + ", talkingSchool=" + talkingSchool
				+ ", waitSchool=" + waitSchool + ", noPassSchool=" + noPassSchool + ", passSchool=" + passSchool + "]";
	}
	
	
}
