package com.project.Bean;
/**
 * ѧУͳ��ʵ����
 * @author Administrator
 *
 */
public class SchoolNumBean {
	private int id;
	/**ѧУ����*/
	private String schoolName;
	/**�����༶����*/
	private int classNum;
	/**��Ա����*/
	private int Vip;
	/**�ǻ�Ա����*/
	private int notVip;
	public SchoolNumBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SchoolNumBean(String schoolName, int classNum, int vip, int notVip) {
		super();
		this.schoolName = schoolName;
		this.classNum = classNum;
		Vip = vip;
		this.notVip = notVip;
	}
	@Override
	public String toString() {
		return "SchoolNumBean [id=" + id + ", schoolName=" + schoolName + ", classNum=" + classNum + ", Vip=" + Vip
				+ ", notVip=" + notVip + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getVip() {
		return Vip;
	}
	public void setVip(int vip) {
		Vip = vip;
	}
	public int getNotVip() {
		return notVip;
	}
	public void setNotVip(int notVip) {
		this.notVip = notVip;
	}

	
}
