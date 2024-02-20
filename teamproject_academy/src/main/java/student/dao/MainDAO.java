package student.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBM;
import vo.BoardVO;
import vo.StudentVO;

public class MainDAO {
	//수강과목
	public List<Map<String, Object>>  selectCourseAll(){

		List<Map<String, Object>> courseList = new ArrayList<>();
		
		String sql = "SELECT c.cno, l.lname, p.pname, l.ltime, l.lroom, l.lno "
				+"FROM course c "
				+" INNER JOIN lecture l ON c.lno = l.lno "
				+" INNER JOIN professor p ON l.pno = p.pno "
				+" INNER JOIN student s ON c.sno = s.sno "
				+" WHERE s.sno = c.sno "
				+" ORDER BY c.cno " 
				+" LIMIT 5";
		
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
	//공지사항
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
