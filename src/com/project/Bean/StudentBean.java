package com.project.Bean;
/**
 * ѧ����
 * @author Administrator
 *
 */

import java.sql.Date;
import java.util.List;

public class StudentBean {
	/**ѧ�����*/
	private int id;
	/**ѧ������*/
	private String studentName;
	/**�Ա�*/
	private String sex;
	/**����*/
	private Date birthday;
	/**�༶ID*/
	private int classNameID;
	/**�༶*/
	private String className;
	/**��ͥסַ*/
	private String address;
	/**״̬*/
	private String scondition="�ǻ�Ա";
	/**�绰*/
	private String tel;
	/**��������*/
	private String fatherName;
	/**���׵绰*/
	private String fatherTel;
	/**ĸ������*/
	private String motherName;
	/**ĸ�׵绰*/
	private String motherTel;
	/**��ע*/
	private String scommment;
	/**�طü�¼����*/
	private List<VisitBean>  visitList;
	
	
	
	
	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentBean(String studentName, String sex, Date birthday, int classNameID,  String address,
			String scondition, String tel, String fatherName, String fatherTel, String motherName, String motherTel,
			String scommment) {
		super();
		this.studentName = studentName;
		this.sex = sex;
		this.birthday = birthday;
		this.classNameID = classNameID;
		this.address = address;
		this.scondition = scondition;
		this.tel = tel;
		this.fatherName = fatherName;
		this.fatherTel = fatherTel;
		this.motherName = motherName;
		this.motherTel = motherTel;
		this.scommment = scommment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getClassNameID() {
		return classNameID;
	}
	public void setClassNameID(int classNameID) {
		this.classNameID = classNameID;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getScondition() {
		return scondition;
	}
	public void setScondition(String scondition) {
		this.scondition = scondition;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getFatherTel() {
		return fatherTel;
	}
	public void setFatherTel(String fatherTel) {
		this.fatherTel = fatherTel;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getMotherTel() {
		return motherTel;
	}
	public void setMotherTel(String motherTel) {
		this.motherTel = motherTel;
	}
	public String getScommment() {
		return scommment;
	}
	public void setScommment(String scommment) {
		this.scommment = scommment;
	}
	public List<VisitBean> getVisitList() {
		return visitList;
	}
	public void setVisitList(List<VisitBean> visitList) {
		this.visitList = visitList;
	}
	@Override
	public String toString() {
		return "StudentBean [id=" + id + ", studentName=" + studentName + ", sex=" + sex + ", birthday=" + birthday
				+ ", classNameID=" + classNameID + ", className=" + className + ", address=" + address + ", scondition="
				+ scondition + ", tel=" + tel + ", fatherName=" + fatherName + ", fatherTel=" + fatherTel
				+ ", motherName=" + motherName + ", motherTel=" + motherTel + ", scommment=" + scommment + ", visitList="
				+ visitList + "]";
	}
	
	
}
