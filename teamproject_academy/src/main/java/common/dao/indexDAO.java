package common.dao;

import util.DBM;

public class indexDAO {
	
	public String[] selectPw(String id) {
	String sql = "select * from member where id = ?";
	
	DBM dbm = DBM.getInstance();
	
	
	
	dbm.prepare(sql).setString(id).select();
	
	String pw=null, type =null;
	while(dbm.next()) {
		pw = dbm.getString("pw");
		type = dbm.getString("type");
	}
	String[] result = {pw,type};
	
	dbm.close();
	
	return result; 
	}
}
