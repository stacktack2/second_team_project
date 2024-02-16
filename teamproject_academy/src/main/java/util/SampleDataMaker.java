package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;


public class SampleDataMaker {

	public static void main(String[] args) {
		
		Connection conn = null;	
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/ezenuniv";
		String user = "dteam";
		String pass ="ezen";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			String password = "";
			for(int i =0; i<10 ; i++) {
				
				password = BCrypt.hashpw("stupw"+i, BCrypt.gensalt());
				
				
				String sql = "        INSERT INTO student(sid, spw, sname, sregNo1, sregNo2, sbirth, sgender, "
						+ "			 semail, sphone, saddr, szipCode, sstatus, suniv, sfaculty, smajor, sgrade, srank, scomeDate, smaxgrade) "
						+ "          VALUES(concat('stuid',"+i+"),?,'학생', '060101', '3333333' , DATE_FORMAT('2006-01-01', '%Y%m%d'), 'M', "
						+ "           'stacktack.2@gmail.com','0101111222"+i+"', '전주시 덕진구', '54930', '0', '공과대학', '컴퓨터공학부', '컴퓨터공학과','1', "+i+", current_date(), '18') "
						+ "           ";
						
						
				
			
				
					psmt=conn.prepareStatement(sql);
					psmt.setString(1, password);
					psmt.executeUpdate();
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
			try {
				if(conn != null) conn.close();
				if(psmt != null) psmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
