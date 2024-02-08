package admin.dao;

import java.util.List;

import util.DBM;
import vo.BoardVO;

public class NoticeDAO {

	public List<BoardVO> selectAll() {
		
		String sql = "SELECT bno, btitle, brdate, bhit "
				   + "  FROM board b      ";
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).select();
		
		while(dbm.next()) {
			BoardVO board = new BoardVO();
			board.setBno(dbm.getInt("bno"));
			board.setBtitle(dbm.getString("btitle"));
			board.setBrdate(dbm.getString("brdate"));
			board.setBhit(dbm.getInt("bhit"));
			
		}
		
		dbm.close();
		
		
		
		return null;
	}

}
