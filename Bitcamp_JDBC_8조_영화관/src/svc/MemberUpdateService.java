package svc;

import java.sql.Connection;
import static db.jdbcUtil.*;
import dao.MemberDAO;
import vo.Member;

public class MemberUpdateService {

	public boolean updateMember(Member newMember, String id) {

		boolean isUpdateSuccess = false;

		Connection con = getConnection();

		MemberDAO memberDAO = new MemberDAO(con);
	
		int updateCount = memberDAO.updateMember(newMember,id);
	
		if (updateCount > 0) {
			commit(con);
			isUpdateSuccess = true;
		} else {
			
			rollback(con);
		}

		return isUpdateSuccess;
	}

}
