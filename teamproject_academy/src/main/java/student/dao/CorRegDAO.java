package student.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBM;
import vo.CourseVO;
import vo.LectureVO;

public class CorRegDAO {
	//totalCnt
	//totalCnt
		public int FindTotalCnt(String searchType, String searchValue){
			String sql = "select count(*) as cnt from course ";
			if(searchType.equals("lname")) {
				sql += " where lname like concat('%',?,'%') ";
			}else if(searchType.equals("pname")) {
				sql += " where pname like concat('%',?,'%') ";
			}	
			
			DBM dbm = DBM.getInstance();
			dbm.prepare(sql);
			
			if(searchType.equals("title") || searchType.equals("content")) {
				dbm.setString(searchValue);
			}
			
			dbm.select();
			int totalCnt = 0;
			
			if(dbm.next()) {			
				totalCnt = dbm.getInt("cnt");
			}
			
			dbm.close();
			
			return totalCnt;
		}
	//수강신청 강의 전체 조회
	public List<LectureVO> selectCorRegAll( String searchType, String searchValue){
		List<LectureVO> corRegList = new ArrayList<>();
		
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
		
		if(searchType != null  && !searchType.equals("")) {
			dbm.prepare(sql).setString(searchValue).select();
		}else {
			dbm.prepare(sql).select();
		}
		
		while(dbm.next()){
			LectureVO corReg = new LectureVO();
			corReg.setLno(dbm.getInt("lno"));
			corReg.setLtime(dbm.getInt("lno"));
			corReg.setLname(dbm.getString("lname"));
			corReg.setLcredit(dbm.getInt("lcredit"));
			corReg.setLroom(dbm.getString("lroom"));
			corReg.setPname(dbm.getString("pname"));
			
			corRegList.add(corReg);
		}
		dbm.close();
		return corRegList;
	}
	// 수강신청 중복배제를 위한 courseList 조회
	public List<CourseVO> selectCourseAll(String sno) {
		List<CourseVO> courseList = new ArrayList<>();
		
		String sql = "SELECT * from course where sno = ?";
		//[검색]
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).setString(sno).select();
		
		while(dbm.next()) {
			CourseVO course = new CourseVO();
			course.setCdelyn(dbm.getInt("cdelyn"));
			course.setLno(dbm.getInt("lno"));
			course.setCno(dbm.getInt("cno"));
			
			courseList.add(course);
			
		}
		dbm.close();
		return courseList;
	}	
	//---------------------------------------------------------------
	//[ajax:INSERT 신청버튼 클릭시]
	public int insertReg(int lno, String sno) {
		int insertRs = 0;
		
		String sql = "INSERT INTO course(cyn, cgrade, lno,sno) "
					+" VALUES ('0','N',?,?)";
		DBM dbm = DBM.getInstance();
		insertRs = dbm.prepare(sql).setInt(lno).setString(sno).update();
		dbm.close();
		
		return insertRs;
	}
	
	//내가 수강신청한 강의 조회
	public List<Map<String, Object>> selectRegAll() {
		List<Map<String, Object>> regList = new ArrayList<>();
		
		String sql ="SELECT l.*,p.pname,c.cno from lecture l "
				+ " INNER JOIN course c on c.lno = l.lno "
				+ " INNER JOIN professor p on p.pno = l.pno "
				+ " WHERE l.lstatus=2 and c.cdelyn=0"
				+ " ORDER BY cno ";
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).select();
		
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
	//[ajax: DELETE 취소버튼 클릭시-> cdelyn=1]
	public int deleteReg(int cno) {
		int delRs =0;
		String sql = "UPDATE course SET cdelyn= 1 WHERE cno=?";
		DBM dbm = DBM.getInstance();
		delRs = dbm.prepare(sql).setInt(cno).update();
		dbm.close();

		return delRs;
	}
	//재신청시 변경
	/*
	 * public int updateReg(int cno) { int updateRs =0; String sql =
	 * "UPDATE course SET cdelyn = 0 WHERE cno = ?"; DBM dbm = DBM.getInstance();
	 * updateRs = dbm.prepare(sql).setInt(cno).update(); dbm.close(); return
	 * updateRs; }
	 */
}
