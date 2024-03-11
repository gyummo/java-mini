package com.jhj.model.dao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.jhj.common.JDBCTemplate;
import com.jhj.model.vo.Employee;

public class EmpDao {
	private Properties prop = new Properties();

	public void EmployeeDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int insertEmployee(Connection conn, Employee emp) throws SQLException {
		String sql = prop.getProperty("insertEmployee");
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getPosition());
			pstmt.setString(4, emp.getDept());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public int updateEmployee(Connection conn, Employee emp) throws SQLException {
		String sql = prop.getProperty("updateEmployee");
		PreparedStatement pstmt = null;
		int rowsAffected = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getDept());
			pstmt.setString(3, emp.getPosition());
			pstmt.setInt(4, emp.getEmpNo());

			rowsAffected = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return rowsAffected;
	}

	public ArrayList<Employee> getAllEmployees(Connection conn) throws SQLException {
		ArrayList<Employee> list = new ArrayList<>();
		String sql = prop.getProperty("getAllEmployees");
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpNo(rs.getInt("emp_no"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setDept(rs.getString("dept"));
				emp.setPosition(rs.getString("position"));
				emp.setChecked(rs.getBoolean("check_in"));
				list.add(emp);
			}
		} finally {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
		}

		return list;
	}

	// 사원 정보 삭제
	public int deleteEmployee(Connection conn, int empNo) throws SQLException {
		String sql = prop.getProperty("deleteEmployee");
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			return pstmt.executeUpdate();
		} finally {
			if (pstmt != null) { pstmt.close(); }
		}
	}

	// 사원 출근 처리
	public boolean checkIn(Connection conn, int empNo) throws SQLException {
		String sql = prop.getProperty("checkIn");
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			int rowsUpdated = pstmt.executeUpdate();
			return rowsUpdated > 0; // 변동된 행이 있으면 true, 없으면 false를 반환합니다.
		} finally {
			if (pstmt != null) { pstmt.close(); }
		}
	}

	// 추가로, 사원의 퇴근 처리도 비슷한 방식으로 구현할 수 있습니다.
	public boolean checkOut(Connection conn, int empNo) throws SQLException {
		String sql = prop.getProperty("checkOut");
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			int rowsUpdated = pstmt.executeUpdate();
			return rowsUpdated > 0; // 변동된 행이 있으면 true, 없으면 false를 반환합니다.
		} finally {
			if (pstmt != null) { pstmt.close(); }
		}
	}


}








