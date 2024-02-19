package student.dao;

import util.DBM;
import vo.StudentVO;

public class MypageDAO {

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

}
