package svc;

import java.sql.Connection;
import static db.jdbcUtil.*;
import dao.MemberDAO;
import vo.Member;

public class MemberAddService {

	public boolean addMember(Member newMember) {
		
		boolean isInsertSuccess = false;
		
		Connection con = getConnection();
		
		MemberDAO memberDAO = new MemberDAO(con);
		
		int insertCount = memberDAO.insertNewMember(newMember);
		
		if(insertCount > 0) {
			commit(con);
			isInsertSuccess = true;
		} else {
			rollback(con);
		}
		
		return isInsertSuccess;
	}
	
}
