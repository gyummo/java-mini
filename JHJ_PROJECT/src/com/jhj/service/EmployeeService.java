package com.jhj.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.jhj.common.JDBCTemplate;
import com.jhj.model.dao.EmpDao;
import com.jhj.model.vo.Employee;


import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private List<Employee> employees;

    public EmployeeService(List<Employee> employees) {
        if (employees == null) {
            this.employees = new ArrayList<>();
        } else {
            this.employees = employees;
        }
    }

    // 사원 추가 메서드
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    // ID로 사원 찾는 메서드
    public Employee getEmployeeById(int empNo) {
        for (Employee emp : employees) {
            if (emp.getEmpNo() == empNo) {
                return emp;
            }
        }
        return null;
    }

    // 사원 업데이트 메서드
    public void updateEmployee(Employee empToUpdate) {
        int index = employees.indexOf(empToUpdate);
        if (index != -1) {
            employees.set(index, empToUpdate); // 리스트에서 해당 index의 Employee 객체 업데이트
        }
    }

    // 모든 사원의 리스트를 반환하는 메서드
    public ArrayList<Employee> getAllEmployees() {
        return new ArrayList<>(employees); // 기존 리스트의 복사본을 반환
    }

    // 사원 삭제 메서드; 반환 타입은 예시로 int를 사용하며 삭제된 사원 수를 의미합니다.
    public int deleteEmployee(int empNo) {
        Employee emp = getEmployeeById(empNo);
        if (emp != null) {
            employees.remove(emp);
            return 1; // 삭제 성공
        }
        return 0; // 삭제 실패
    }

    // 출근 처리 메서드
    public boolean checkIn(int empNo) {
        Employee emp = getEmployeeById(empNo);
        if (emp != null && !emp.isChecked()) {
            emp.setChecked(true);
            return true; // 출근 처리 성공
        }
        return false; // 출근 처리 실패
    }
    
    // 퇴근 처리 메서드
    public boolean checkOut(int empNo) {
        Employee emp = getEmployeeById(empNo);
        if (emp != null && emp.isChecked()) {
            emp.setChecked(false);
            return true; // 퇴근 처리 성공
        }
        return false; // 퇴근 처리 실패
    }
}