package student.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBM;
import vo.StudentVO;


public class AcdCourseDAO {
	//네비헤더에 sname 출력
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
	//강의계획서 조회
	public Map<String, Object> selectCurriByOne(int lno){
		Map<String, Object> curriMap = new HashMap<>();
		String sql = "SELECT l.* , p.pname, p.pphone, p.pemail from lecture l "
				+ "INNER JOIN professor p  ON p.pno = l.pno "
				+ "WHERE l.lno = ?";
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).setInt(lno).select();

		if(dbm.next()) {
			curriMap.put("lname", dbm.getString("lname"));
			curriMap.put("lyear", dbm.getString("lyear"));
			curriMap.put("lsemester", dbm.getInt("lsemester"));
			curriMap.put("ltime", dbm.getInt("ltime"));
			curriMap.put("lroom", dbm.getString("lroom"));
			curriMap.put("lcredit", dbm.getInt("lcredit"));
			curriMap.put("lintro", dbm.getString("lintro"));
			curriMap.put("lfocus", dbm.getString("lfocus"));
			curriMap.put("lstatus", dbm.getInt("lstatus"));
			curriMap.put("pname", dbm.getString("pname"));
			curriMap.put("pphone", dbm.getString("pphone"));
			curriMap.put("pemail", dbm.getString("pemail"));
		}
		dbm.close();
		
		return curriMap;
	}
	
	//교과목 조회
	public List<Map<String, Object>>  selectCourseAll(){
		List<Map<String, Object>> courseList = new ArrayList<>();
		
		String sql = "SELECT c.cno, l.lname, p.pname, l.ltime, l.lroom, l.lno "
				+"FROM course c "
				+" INNER JOIN lecture l ON c.lno = l.lno "
				+" INNER JOIN professor p ON l.pno = p.pno "
				+" INNER JOIN student s ON c.sno = s.sno "
				+" WHERE s.sno = c.sno "
				+" ORDER BY c.cno ";
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).select();
		
		while(dbm.next()) {
			Map<String, Object> courseMap = new HashMap<>();

			courseMap.put("cno", dbm.getInt("cno"));
			courseMap.put("lno", dbm.getInt("lno"));
			courseMap.put("lname", dbm.getString("lname"));
			courseMap.put("ltime", dbm.getString("ltime"));
			courseMap.put("lroom", dbm.getString("lroom"));
			courseMap.put("pname", dbm.getString("pname"));

			courseList.add(courseMap);
		}

		dbm.close();
		return courseList;
	}
	
	//학적사항조회
	public Map<String, Object> selectsscheckByOne(int sno){
		Map<String, Object> sscheckMap = new HashMap<>();
		
		String sql = "SELECT s.* , f.* from student s "
				+ "inner join studentBridgeFile sb on s.sno=sb.sno "
				+ "inner join file f on f.fno=sb.fno "
				+ "where s.sno = ?";
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).setInt(sno).select();
		
		while(dbm.next()) {
			sscheckMap.put("sid", dbm.getString("sid"));
			sscheckMap.put("sname", dbm.getString("sname"));
			sscheckMap.put("sregNo1", dbm.getString("sregNo1"));
			sscheckMap.put("sregNo2", dbm.getString("sregNo2"));
			sscheckMap.put("sbirth",dbm.getString("sbirth") );
			sscheckMap.put("sgender", dbm.getString("sgender"));
			sscheckMap.put("sstatus", dbm.getString("sstatus"));
			sscheckMap.put("suniv", dbm.getString("suniv") );
			sscheckMap.put("sfaculty", dbm.getString("sfaculty"));
			sscheckMap.put("smajor", dbm.getString("smajor"));
			sscheckMap.put("sgrade", dbm.getInt("sgrade"));			
			sscheckMap.put("srank", dbm.getInt("srank") );
			sscheckMap.put("scomeDate", dbm.getString("scomeDate"));
			sscheckMap.put("soutDate", dbm.getString("soutDate"));
			sscheckMap.put("scompletionDate", dbm.getString("scompletionDate"));
			sscheckMap.put("sgradDate", dbm.getString("sgradDate"));
			sscheckMap.put("semail",dbm.getString("semail") );
			sscheckMap.put("sphone",dbm.getString("sphone") );
			sscheckMap.put("scall",dbm.getString("scall") );
			sscheckMap.put("saddr",dbm.getString("saddr") );
			sscheckMap.put("szipCode", dbm.getString("szipCode"));
			
			sscheckMap.put("fno", dbm.getInt("fno"));	
			sscheckMap.put("foriginnm", dbm.getString("foriginnm"));
			sscheckMap.put("frealnm", dbm.getString("frealnm"));
			sscheckMap.put("", dbm.getString("szipCode"));			
		}
		dbm.close();
		return sscheckMap;
	}
	//휴복학신청 조회
	public List<Map<String, Object>>  selectAbsenseAll(int sno){

		List<Map<String, Object>> absenseList = new ArrayList<>();
		
		String sql = "select ab.*, s.sstatus from absense ab "
				+ "inner join student s on s.sno = ab.sno "
				+ "where s.sno = ?;";
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).setInt(sno).select();
		
		while(dbm.next()) {
			Map<String, Object> absenseMap = new HashMap<>();

			absenseMap.put("abseno", dbm.getInt("abseno"));
			absenseMap.put("abseinfo", dbm.getString("abseinfo"));
			absenseMap.put("abserdate", dbm.getString("abserdate"));
			absenseMap.put("absestatus", dbm.getString("absestatus"));
			absenseMap.put("absepdate", dbm.getString("absepdate"));
			
			absenseMap.put("sstatus", dbm.getInt("sstatus"));

			absenseList.add(absenseMap);
			
		}

		dbm.close();
		return absenseList;
	}

	public List<Map<String, Object>> selectAttendAll() {
		
		return null;
	}
	
	public List<Map<String, Object>> selectScheduleAll(int sno){
		List<Map<String, Object>> scheduleList = new ArrayList<>();
		
		String sql = "select l.lname, l.json_data, p.pname, l.lroom from lecture l "
				+" inner join professor p on l.pno = p.pno "
				+" inner join course c on c.lno = l.lno "
				+" inner join student s on c.sno = s.sno "
				+" where s.sno = ?";
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).setInt(sno).select();
		
		while(dbm.next()) {
			Map<String, Object> scheduleMap = new HashMap<>();
			
			scheduleMap.put("lname", dbm.getString("lname"));
			scheduleMap.put("json_data", dbm.getString("json_data"));
			scheduleMap.put("lroom", dbm.getString("lroom"));
			scheduleMap.put("pname", dbm.getString("pname"));
			
			scheduleList.add(scheduleMap);
		}
		dbm.close();
		return scheduleList;
		
	}
}
