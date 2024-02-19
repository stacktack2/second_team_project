package student.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBM;
import vo.CourseVO;
import vo.StudentVO;

public class CorRegDAO {
	//헤더네비에 sname 출력
	public StudentVO selectSnameByOne(int sno) {
		StudentVO student = new StudentVO();
		
		String sql = "select sname from student "
				+"where sno = ?";
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).setInt(sno).select();
		
		while(dbm.next()) {
			student.setSname(dbm.getString("sname"));
		}

		dbm.close();
		return student;
	}
	//수강신청 강의 전체 조회
	public List<Map<String, Object>> selectCorRegAll(String searchType, String searchValue){
		List<Map<String, Object>> corRegList = new ArrayList<>();
		
		String sql = " SELECT l.*, s.sno, p.pname from lecture l "
				+ " INNER JOIN course c ON c.lno = l.lno "
				+ " INNER JOIN professor p ON p.pno = l.pno "
				+ " INNER JOIN student s ON c.sno = s.sno "
				+ " WHERE l.lstatus=2 ";
		//[검색]
		if(searchType != null && searchType.equals("")){
			if(searchType.equals("1")){
				sql += " AND l.lname LIKE CONCAT('%',?,'%')";
			}else if(searchType.equals("2")){
				sql += " AND p.pname LIKE CONCAT('%',?,'%')";
			}
		}
		DBM dbm = DBM.getInstance();
		
		if(searchType != null  && searchType.equals("")) {
			dbm.prepare(sql).setString(searchValue).select();
		}else {
			dbm.prepare(sql).select();
		}
		
		while(dbm.next()){
			Map<String, Object> corRegMap = new HashMap<>();
			
			corRegMap.put("cno",dbm.getInt("cno"));
			corRegMap.put("lno",dbm.getInt("lno"));
			corRegMap.put("ltime",dbm.getInt("ltime"));
			corRegMap.put("lname",dbm.getString("lname"));
			corRegMap.put("lcredit",dbm.getString("lcredit"));
			corRegMap.put("lroom",dbm.getString("lroom"));
			corRegMap.put("pname",dbm.getString("pname"));
		
			corRegList.add(corRegMap);
		}
		dbm.close();
		return corRegList;
	}

	
	
	//내가 수강신청한 강의 course에 담기
	public List<CourseVO> updateReg(int lno, int sno) {
		List<CourseVO> selectRegAll = new ArrayList<>();
		
		String sql = "Insert into course(cyn, cgrade, lno,sno) "
					+" values ('0','N',?,?)";
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).setInt(lno).setInt(sno).update();
		
		return selectRegAll;
	}
	//내가 수강신청한 강의 조회
	public List<CourseVO> selectRegAll(int lno, int sno) {
		List<CourseVO> selectRegAll = new ArrayList<>();
		
		String sql ="SELECT l.*, s.sno, p.pname from lecture l "
				+ " INNER JOIN course c on c.lno = l.lno "
				+ " INNER JOIN professor p on p.pno = l.pno "
				+ " INNER JOIN student s on c.sno = s.sno "
				+ " WHERE l.lstatus=2 and l.lno =? and s.sno =?";
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).setInt(lno).setInt(sno).select();
		
		
		
		return null;
	}	
	
	
}
