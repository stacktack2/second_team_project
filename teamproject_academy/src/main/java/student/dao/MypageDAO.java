package student.dao;

import util.DBM;
import vo.StudentVO;

public class MypageDAO {

	public StudentVO selectSid(int sno) {
		StudentVO student = new StudentVO();
		
		String sql = "select sid from student "
				+"where sno = ?";
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).setInt(sno).select();
		
		dbm.close();
		return student;
	}

}
