package svc;

import java.sql.Connection;
import static db.jdbcUtil.*;
import dao.MemberDAO;
import vo.Member;

public class MemberListService {

	public boolean listMember(Member newMember) {
		
		boolean isListSuccess = false;
		
		Connection con = getConnection();
		
		MemberDAO memberDAO = new MemberDAO(con);
		
		isListSuccess = memberDAO.memberListView(newMember);
		
		return isListSuccess;
	}
	
}
