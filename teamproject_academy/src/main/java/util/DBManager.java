package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
	
	String url = "jdbc:mysql://localhost:3306/board";
	String user = "tester";
	String pass ="1234";
	
	Connection conn = null;
	PreparedStatement psmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	//1. DB메소드
	//(1) DB 연결 메소드
	public boolean DBOpen() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//(2) DB 종료 메소드
	public boolean DBClose() {
		try {
			this.conn.close();
			return true;	
		}catch(Exception e) {
			return false;
		}
	}
	
	//2. SQL메소드
	//(1) SQL 실행 메소드
	// - insert, update, delete
	public boolean RunSql(String sql) {
		try {
			
			this.stmt = this.conn.createStatement();
			this.psmt.executeUpdate(sql);
			
			this.psmt.close();
			return true;
		}catch(Exception e) {
			return false;
		}

	}
	// - select.
	public boolean OpenQuery(String sql) {
		try {
			
			this.stmt=this.conn.createStatement();
			this.rs=this.psmt.executeQuery(sql);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	//(2) SQL 종료 메소드
	public boolean CloseQuery() {
		try {
			if (conn != null) conn.close();
			if (psmt != null) psmt.close();
			if (rs != null) rs.close();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	// - result next()를 실행할 메소드
	public boolean GetNext() {
		try {
			return this.rs.next();
		}catch(Exception e) {
			return false;
		}
	}
	// -- 반환값 String일 때
	public String GetValue(String colName) {
		try {
			String str = this.rs.getString(colName);
			return str;
		}catch(Exception e) {
			return null;
		}
	}
	// -- 반환값 int일 때
	public int GetInt(String colName) {
		try {
			return this.rs.getInt(colName);
		}catch(Exception e) {
			return 0;
		}
	}

}
