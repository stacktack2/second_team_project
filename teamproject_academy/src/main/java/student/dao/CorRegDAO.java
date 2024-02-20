package student.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBM;
import vo.CourseVO;
import vo.StudentVO;

public class CorRegDAO {

	//수강신청 강의 전체 조회
	public List<Map<String, Object>> selectCorRegAll(String searchType, String searchValue){
		List<Map<String, Object>> corRegList = new ArrayList<>();
		
		String sql = " SELECT l.*, p.pname from lecture l "
				+ " INNER JOIN professor p ON p.pno = l.pno "
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

	//[ajax:INSERT]
	public int insertReg(int lno, String sno) {
		int insertRs = 0;
		
		String sql = "INSERT INTO course(cyn, cgrade, lno,sno) "
					+" VALUES ('0','N',?,?)";
		DBM dbm = DBM.getInstance();
		insertRs = dbm.prepare(sql).setInt(lno).setString(sno).update();
		dbm.close();
		
		return insertRs;
	}
	
	//---------------------------------------------------------------
	//내가 수강신청한 강의 조회
	public List<Map<String, Object>> selectRegAll( String sno) {
		List<Map<String, Object>> regList = new ArrayList<>();
		
		String sql ="SELECT l.*,p.pname,c.cno from lecture l "
				+ " INNER JOIN course c on c.lno = l.lno "
				+ " INNER JOIN professor p on p.pno = l.pno "
				+ " INNER JOIN student s on c.sno = s.sno "
				+ " WHERE l.lstatus=2  and s.sno =? "
				+ " ORDER BY cno ";
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).setString(sno).select();
		
		while(dbm.next()) {
			Map<String, Object> regMap = new HashMap<>();
			
			regMap.put("cno",dbm.getInt("cno"));
			regMap.put("ltime",dbm.getInt("ltime"));
			regMap.put("lname",dbm.getString("lname"));
			regMap.put("lcredit",dbm.getInt("lcredit"));
			regMap.put("lroom", dbm.getString("lroom"));
			regMap.put("pname", dbm.getString("pname"));
			
			regList.add(regMap);
		}
		dbm.close();
		return regList;
	}
	//[ajax: DELETE]
	public int deleteReg(int cno, String sno) {
		int delRs =0;
		String sql = "Update FROM course WHERE cno=? and sno =? ";
		DBM dbm = DBM.getInstance();
		delRs = dbm.prepare(sql).setInt(cno).setString(sno).update();
		dbm.close();
		System.out.println(cno);
		System.out.println(delRs);
		return delRs;
	}	
	
	
}
