package com.jhj.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.jhj.controller.EmployeeController;

/*얼추 구현완료*/
public class EmployeeMenu {
	private EmployeeController ec = new EmployeeController();
	private Scanner sc = new Scanner(System.in);

	public void employeeMainMenu() throws IOException {

		while (true) {
			System.out.println("***** 사원 관리 시스템 *****");
			System.out.println("1. 직원 등록");
			System.out.println("2. 직원 수정");
			System.out.println("3. 직원 삭제");
			System.out.println("4. 직원 리스트 보기");
			System.out.println("5. 출근하기");
			System.out.println("6. 퇴근하기");
			System.out.println("7. 출근자 확인");
			System.out.println("0. 종료");

			System.out.print("메뉴를 선택하세요: ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				//직원등록
				ec.inputEmployee();
				return;
			case 2:
				//직원수정
				ec.updateEmployee();
				return;
			case 3:
				//직원삭제
				ec.deleteEmployee(null);
				return;
			case 4:
				//직원 리스트
				ec.selectList();
				return;	
			case 5:
				//출근하기
				ec.checkIn();
				return;
			case 6:
				//퇴근하기
				ec.checkOut();
			case 7:
				ec.checkEmp();
			case 0:
				System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴를 선택하셨습니다.");
				return;
			}
		}
	}
}