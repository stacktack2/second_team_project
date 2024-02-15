package admin.dao;

import java.util.ArrayList;
import java.util.List;

import util.DBM;
import vo.ProfessorVO;

public class UserManageDAO {

	public List<ProfessorVO> selectProf() {
		
		List<ProfessorVO> professorList = new ArrayList<>();
		
		String sql = "SELECT pno, pid, pname, pposition, plab, pphone, pemail "
				   + "  FROM professor p " ;
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).select();
		
		while(dbm.next()) {
			ProfessorVO profUser = new ProfessorVO();
			profUser.setPno(dbm.getInt("pno"));
			profUser.setPid(dbm.getString("pid"));
			profUser.setPname(dbm.getString("pname"));
			profUser.setPposition(dbm.getString("pposition"));
			profUser.setPlab(dbm.getString("plab"));
			profUser.setPphone(dbm.getString("pphone"));
			profUser.setPemail(dbm.getString("pemail"));
			
			professorList.add(profUser);
		}
		
		dbm.close();
		
		return professorList;
	}

}
