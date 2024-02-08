package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBM {
	
	// [싱글톤]
	private DBM() {}
	
	private static DBM dbm = new DBM();
	
	public static DBM getInstance() {
		return dbm;
	}
	
	
	
	// [필드] *동시성 문제 주의 : 클라이언트에 의존할 수 있는 필드 or 싱글톤 객체를 사용하는 메소드가 있으면 동시성 문제가 발생한다.
	private String url = "jdbc:mysql://localhost:3306/board";
	private String user = "tester";
	private String pass = "1234";
	
	private Connection conn=null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	
	
	
	
	// [게터세터]
	public String getUrl() {return url;}
	public void setUrl(String url) {this.url = url;}
	public String getUser() {return user;}
	public void setUser(String user) {this.user = user;}
	public String getPass() {return pass;}
	public void setPass(String pass) {this.pass = pass;}


	// 내부 카운터 : psmt 숫자++
	private int orderCount = 1; 
	
	public DBM prepare(String sql) {
		orderCount =1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pass);
			psmt = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		return this;
	}
	
	public DBM setString(String value) {
		try {
			psmt.setString(orderCount, value);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		orderCount++;
		return this;
	}
	public DBM setInt(int value) {
		try {
			psmt.setInt(orderCount, value);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		orderCount++;
		return this;
	}
	
	public int update() {
		int result = 0;
		try {
			result = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void select(){
		try {
			 rs = psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean next() {
		try {
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int getInt(String column) {
		try {
			return rs.getInt(column);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public String getString(String column) {
		try {
			return rs.getString(column);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public boolean close() {
		try {
			if(conn != null) conn.close();
			if(psmt != null) psmt.close();
			if(rs != null) rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
		return true;
	}
	
}