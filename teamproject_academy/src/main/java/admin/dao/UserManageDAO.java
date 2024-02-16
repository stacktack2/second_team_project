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

	public List<ProfessorVO> searchProf(String searchValue) {
		
		List<ProfessorVO> searchResults = new ArrayList<>();
		
		String searchSql = "SELECT pno, pid, pname, pposition, plab, pphone, pemail "
						 + "  FROM professor p " ;
		
		if(searchValue != null && !searchValue.isEmpty()) {
			searchSql += " WHERE pname LIKE CONCAT('%', ?, '%')";
		}
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(searchSql);
		
		if(searchValue != null && !searchValue.isEmpty()) {
			dbm.setString(searchValue);
		}
		
		dbm.select();
		
		while(dbm.next()) {
			ProfessorVO searchProf = new ProfessorVO();
			searchProf.setPno(dbm.getInt("pno"));
			searchProf.setPid(dbm.getString("pid"));
			searchProf.setPname(dbm.getString("pname"));
			searchProf.setPposition(dbm.getString("pposition"));
			searchProf.setPlab(dbm.getString("plab"));
			searchProf.setPphone(dbm.getString("pphone"));
			searchProf.setPemail(dbm.getString("pemail"));
			
			searchResults.add(searchProf);
		}
		
		dbm.close();
		
		return searchResults;
	}

	public List<ProfessorVO> searchPaging() {
		
		
		
		return null;
	}

	
}
