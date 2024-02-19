package student.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBM;
import vo.StudentVO;

public class CorRegDAO {
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
	
	public List<Map<String, Object>> selectCorRegAll(){
		List<Map<String, Object>> corRegList = new ArrayList<>();
		
		String sql = "select l.lname, l.lcredit, l.ltime, l.lroom, l.lno, p.pname , c.cno from lecture l "
				+ " inner join professor p on p.pno = l.pno "
				+ " inner join course c on c.lno = l.lno ";
		
		DBM dbm = DBM.getInstance();
		dbm.prepare(sql).select();
		
		while(dbm.next()){
			Map<String, Object> corRegMap = new HashMap<>();
			
			corRegMap.put("cno",dbm.getInt("cno"));
			corRegMap.put("lno",dbm.getInt("lno"));
			corRegMap.put("ltime",dbm.getInt("ltime"));
			corRegMap.put("lname",dbm.getString("lname"));
			corRegMap.put("lcredit",dbm.getString("lcredit"));
			corRegMap.put("lroom",dbm.getString("lroom"));
			corRegMap.put("pname",dbm.getString("pname"));
		
			corRegList.add(corRegMap);
		}
		dbm.close();
		return corRegList;
	}
}
