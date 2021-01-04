package action;

import java.util.Scanner;

import dao.MemberDAO;
import vo.Member;

public interface Action2 {
	
	Member login = MemberDAO.login;
	void execute(Scanner sc, Member loginMember) throws Exception;

}
