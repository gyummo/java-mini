package com.jhj.model.vo;
import java.sql.Date;

public class Employee {

	private int EmpNo;
	private String EmpName;
	private String Dept;
	private String Position;
	private boolean Checked;

	public Employee() {
		super();
	}

	public Employee(int empNo, String empName, String dept, String position, boolean checked) {
		super();
		EmpNo = empNo;
		EmpName = empName;
		Dept = dept;
		Position = position;
		Checked = checked;
	}

	public int getEmpNo() {
		return EmpNo;
	}

	public void setEmpNo(int empNo) {
		EmpNo = empNo;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getDept() {
		return Dept;
	}

	public void setDept(String dept) {
		Dept = dept;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public boolean isChecked() {
		return Checked;
	}

	public void setChecked(boolean checked) {
		Checked = checked;
	}

	@Override
	public String toString() {
		return "Employee [EmpNo=" + EmpNo + ", EmpName=" + EmpName + ", Dept=" + Dept + ", Position=" + Position
				+ ", Checked=" + Checked + "]";
	}
	
	
	
	
}