package com.jhj.run;
import java.io.IOException;

import com.jhj.view.EmployeeMenu;
/*얼추 구현완료*/
public class Run {
	public static void main(String[] args) {
		EmployeeMenu am = new EmployeeMenu();
		try {
			am.employeeMainMenu();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}


