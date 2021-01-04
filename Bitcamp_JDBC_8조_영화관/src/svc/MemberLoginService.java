package svc;

import java.sql.Connection;
import static db.jdbcUtil.*;
import dao.MemberDAO;
import vo.Member;

public class MemberLoginService {

	public boolean loginMember(Member loginmember) {
		
		boolean isloginSuccess = false;
		
		Connection con = getConnection();
		
		MemberDAO memberDAO = new MemberDAO(con);
		
		boolean loginCount = memberDAO.loginCheck(loginmember);
		
		if(loginCount) {
			commit(con);
			isloginSuccess = true;
		} else {
			rollback(con);
		}
		
		return isloginSuccess;
	}
	
}
