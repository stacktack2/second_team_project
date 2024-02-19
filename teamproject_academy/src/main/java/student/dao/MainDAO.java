package student.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBM;
import vo.BoardVO;
import vo.StudentVO;

public class MainDAO {
	public StudentVO selectSnameByOne(int sno) {
		StudentVO student = new StudentVO();
		
		String sql = "select sname from student "
				+"where sno = ?";
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).setInt(sno).select();
		
		while(dbm.next()) {
			student.setSname(dbm.getString("sname"));
		}
		//System.out.println(student.getSname());
		dbm.close();
		return student;
	}

	public List<Map<String, Object>>  selectCourseAll(){
		// 1. list 생성
		List<Map<String, Object>> courseList = new ArrayList<>();
		
		String sql = "SELECT c.cno, l.lname, p.pname, l.ltime, l.lroom, l.lno "
				+"FROM course c "
				+" INNER JOIN lecture l ON c.lno = l.lno "
				+" INNER JOIN professor p ON l.pno = p.pno "
				+" INNER JOIN student s ON c.sno = s.sno "
				+" WHERE s.sno = c.sno "
				+" ORDER BY c.cno " 
				+" LIMIT 5";
		
		//dbm 객체생성
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).select();
		
		while(dbm.next()) {
			//2.  map 생성
			Map<String, Object> courseMap = new HashMap<>();
			/*
			 * CourseVO course = new CourseVO(); 
			 * LectureVO lecture = new LectureVO();
			 * ProfessorVO professor =new ProfessorVO();
			 */			
			/*
			 * course.setCno(dbm.getInt("cno")); 
			 * lecture.setLno(dbm.getInt("lno"));
			 * lecture.setLname(dbm.getString("lname"));
			 * lecture.setLtime(dbm.getInt("ltime"));
			 * lecture.setLroom(dbm.getString("lroom"));
			 * professor.setPname(dbm.getString("pname"));
			 */		
			
			//3. map에 원소추가(put)
			courseMap.put("cno", dbm.getInt("cno"));
			courseMap.put("lno", dbm.getInt("lno"));
			courseMap.put("lname", dbm.getString("lname"));
			courseMap.put("ltime", dbm.getString("ltime"));
			courseMap.put("lroom", dbm.getString("lroom"));
			courseMap.put("pname", dbm.getString("pname"));

			//4. list에 map 추가(담기)
			courseList.add(courseMap);
			
		}
		//닫기
		dbm.close();
		
		//5. list에는 map들이 담겨있음, list리턴
		return courseList;
	}
	
	public List<BoardVO> selectNoticeAll(){
		List<BoardVO> noticeList = new ArrayList<>();
		
		String sql = "SELECT * FROM board "
				+ "ORDER BY bno desc "
				+ "LIMIT 5";
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).select();
		
		while(dbm.next()) {
			BoardVO board = new BoardVO();
			
			board.setBno(dbm.getInt("bno"));
			board.setBtitle(dbm.getString("btitle"));
			board.setBhit(dbm.getInt("bhit"));
			board.setBrdate(dbm.getString("brdate"));
			
			noticeList.add(board);
		}
		dbm.close();
		
		return noticeList;
	}
}
