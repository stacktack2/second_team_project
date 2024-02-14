package common.dao;

import util.DBM;

public class indexDAO {
	
	
	
	String sql = "select * from member where id = ?";
	
	DBM dbm = DBM.getInstance();
	
	dbm.select(sql).
	
}
