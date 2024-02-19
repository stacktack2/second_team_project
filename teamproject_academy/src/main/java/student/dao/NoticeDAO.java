package student.dao;

import java.util.ArrayList;
import java.util.List;

import util.DBM;
import vo.BoardVO;
import vo.StudentVO;


public class NoticeDAO {
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
	
	public List<BoardVO> selectBoardAll(){
		List<BoardVO> noticeList = new ArrayList<>();
		
		String sql = "SELECT * FROM board "
				+ "ORDER BY bno desc ";
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).select();
		
		while(dbm.next()) {
			BoardVO board = new BoardVO();
			
			board.setBno(dbm.getInt("bno"));
			board.setBhit(dbm.getInt("bhit"));
			board.setBtitle(dbm.getString("btitle"));
			board.setBrdate(dbm.getString("brdate"));
			
			noticeList.add(board);
			
		}
		dbm.close();
		
		return noticeList;
	}
	
	public BoardVO selectBoardByOne(int bno) {
		BoardVO board = new BoardVO();
		
		String sql = "select * from board "
				+ " WHERE bno = ?";
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).setInt(bno).select();
		
		if(dbm.next()) {
			//board.setBno(dbm.getInt("bno"));
			board.setBhit(dbm.getInt("bhit"));
			board.setBtitle(dbm.getString("btitle"));
			board.setBcontent(dbm.getString("bcontent"));
			board.setBrdate(dbm.getString("brdate"));
		}
		
		dbm.close();
		return board;
	}
	

}
