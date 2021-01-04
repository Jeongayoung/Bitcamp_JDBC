package svc;

import java.sql.Connection;
import static db.jdbcUtil.*;
import dao.MemberDAO;
import vo.Member;

public class MemberDeleteService {

	public boolean deleteMember(Member newMember) {

		boolean isDeleteSuccess = false;

		Connection con = getConnection();

		MemberDAO memberDAO = new MemberDAO(con);

		int deleteCount = memberDAO.deleteMember(newMember);

		if (deleteCount > 0) {
			commit(con);
			isDeleteSuccess = true;
		} else {
			rollback(con);
		}

		return isDeleteSuccess;
	}

}
