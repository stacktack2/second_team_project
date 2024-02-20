package student.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBM;
import vo.StudentVO;

public class AtdGradeDAO {

	public List<Map<String, Object>>  selectgradeAll(String sno){
		List<Map<String, Object>> gradeList = new ArrayList<>();
		
		String sql = "select s.smajor, s.sid, s.sname, s.sgrade, s.sstatus, c.cno, c.cgrade, l.lname, l.lcredit from student s "
				+ "inner join course c on c.sno = s.sno "
				+ "inner join lecture l on l.lno = c.lno "
				+ "where s.sno = ?";
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).setString(sno).select();
		
		while(dbm.next()) {
			Map<String, Object> gradeMap = new HashMap<>();
			
			gradeMap.put("sid", dbm.getString("sid"));
			gradeMap.put("smajor", dbm.getString("smajor"));
			gradeMap.put("sname", dbm.getString("sname"));
			gradeMap.put("sgrade", dbm.getInt("sgrade"));
			gradeMap.put("sstatus", dbm.getInt("sstatus"));
			
			gradeMap.put("cno", dbm.getInt("cno"));
			gradeMap.put("lname", dbm.getString("lname"));
			gradeMap.put("lcredit", dbm.getInt("lcredit"));
			gradeMap.put("cgrade", dbm.getString("cgrade"));

			
			gradeList.add(gradeMap);
		}
		
		dbm.close();
		return gradeList;
	}
	
	public List<Map<String, Object>>  selectCourseAll(String sno){
		List<Map<String, Object>> courseList = new ArrayList<>();
		
		String sql = "SELECT c.cno, l.lname, p.pname, l.ltime, l.lroom, l.lno "
				+"FROM course c "
				+" INNER JOIN lecture l ON c.lno = l.lno "
				+" INNER JOIN professor p ON l.pno = p.pno "
				+" INNER JOIN student s ON c.sno = s.sno "
				+" WHERE s.sno = ? "
				+" ORDER BY c.cno ";
				
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).setString(sno).select();
		
		while(dbm.next()) {
			Map<String, Object> courseMap = new HashMap<>();
			
			courseMap.put("cno", dbm.getInt("cno"));
			courseMap.put("lno", dbm.getInt("lno"));
			courseMap.put("lname", dbm.getString("lname"));
			courseMap.put("ltime", dbm.getInt("ltime"));
			courseMap.put("lroom", dbm.getString("lroom"));
			courseMap.put("pname", dbm.getString("pname"));

			courseList.add(courseMap);
			
		}
		dbm.close();

		return courseList;
	}
	
	public List<Map<String, Object>>  selectAttendAll(String sno){
		List<Map<String, Object>> attendList = new ArrayList<>();
		
		String sql = " select l.*, at.* from lecture l "
				+ " inner join course c on l.lno = c.cno  "
				+ " inner join attendment at on c.cno = at.cno "
				+ " inner join student s on s.sno = c.sno "
				+ "	where s.sno = ?";
				
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).setString(sno).select();
		
		while(dbm.next()) {
			Map<String, Object> attendMap = new HashMap<>();
			
			attendMap.put("lname", dbm.getString("lname"));
			attendMap.put("lyear", dbm.getString("lyear"));
			attendMap.put("lsemester", dbm.getInt("lsemester"));
			attendMap.put("ltime", dbm.getInt("ltime"));
			attendMap.put("lroom", dbm.getString("lroom"));
			attendMap.put("lcredit", dbm.getInt("lcredit"));
			attendMap.put("lmaxpeople", dbm.getInt("lmaxpeople"));

			attendList.add(attendMap);
		}
		
		dbm.close();
		return attendList;
	}
}
