package com.jhj.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.jhj.model.vo.Employee;
import com.jhj.service.EmployeeService;
import com.jhj.view.EmployeeMenu;

public class EmployeeController {
	private EmployeeService es = new EmployeeService(null);
	private Scanner sc = new Scanner(System.in);

	public void inputEmployee() {
		System.out.println("===== 사원 등록 =====");

		System.out.print("사원 번호: ");
		int EmpNo = sc.nextInt();
		sc.nextLine();

		System.out.print("사원 이름: ");
		String EmpName = sc.nextLine();

		System.out.print("사원 부서: ");
		String Dept = sc.nextLine();

		System.out.print("사원 직급: ");
		String Position = sc.nextLine();

		Employee emp = new Employee();

		es.addEmployee(emp);
		System.out.println("사원 등록이 완료되었습니다.");
	}

	public void updateEmployee() {
		System.out.println("===== 등록된 사원 정보 수정 =====");
		System.out.print("수정할 사번: ");
		int EmpNo = sc.nextInt();
		sc.nextLine();

		Employee emp = es.getEmployeeById(EmpNo);
		// 사원 객체가 있으면 수정할 정보를 입력받습니다.
		if (emp != null) {
			System.out.print("사원 이름: ");
			String EmpName = sc.nextLine();

			System.out.print("사원 부서: ");
			String Dept = sc.nextLine();

			System.out.print("사원 직급: ");
			String Position = sc.nextLine();

			emp.setEmpName(EmpName);
			emp.setDept(Dept);
			emp.setPosition(Position);
			es.updateEmployee(emp);

			System.out.println("사원 정보 수정이 완료되었습니다.");
		} else {
			System.out.println("사원 번호가 잘못되었습니다.");
		}
	}

	public void selectList() {
		System.out.println("===== 사원 리스트 보기 =====");
		ArrayList<Employee> list = es.getAllEmployees();
		// 사원 리스트가 비어있으면 메시지를 출력합니다.
		if (list.isEmpty()) {
			System.out.println("등록된 사원이 없습니다.");
		} else {
			System.out.println("사원번호\t사원이름\t사원부서\t사원직급\t출근여부");
			for (Employee e : list) {
				System.out.println(e);
			}
		}
	}
	
	public void deleteEmployee(String empNo) {
	    try {
	        int empNoInt = Integer.parseInt(empNo);

	        int result = es.deleteEmployee(empNoInt);

	        if (result > 0) {
	            System.out.println("성공적으로 회원 정보가 삭제되었습니다.");
	        } else {
	            System.out.println("회원 정보 삭제에 실패하였습니다.");
	        }
	    } catch (NumberFormatException e) {
	        System.out.println("사원 번호 형식이 올바르지 않습니다.");
	    }   
	}

	public void checkIn() {
		System.out.println("===== 출근하기 =====");
		System.out.print("사번 입력: ");
		int EmpNo = sc.nextInt();
		sc.nextLine();


		boolean result = es.checkIn(EmpNo);
		// 결과에 따라 메시지를 출력합니다.
		if (result) {
			System.out.println("출근 처리가 완료되었습니다.");
		} else {
			System.out.println("사원 번호가 잘못되었거나 이미 출근한 사원입니다.");
		}
	}

	public void checkOut() {
		System.out.println("===== 퇴근하기 =====");
		System.out.print("사원 번호: ");
		int EmpNo = sc.nextInt();
		sc.nextLine();
	}
	
	public void checkEmp() {
		ArrayList<Employee> list = es.getAllEmployees();
		
        System.out.println("모든 직원의 출결 상황:");
        for (Employee emp : list) {
            System.out.println(emp.getEmpName() + " 출결 상태: " + (emp.isChecked() ? "출석" : "결석"));
        }
	}
}

