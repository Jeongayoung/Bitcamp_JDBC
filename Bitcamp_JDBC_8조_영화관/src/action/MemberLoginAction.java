package action;

import java.util.Scanner;

import dao.MemberDAO;
import svc.MemberLoginService;
import util.ConsoleUtil;
import vo.Member;

public class MemberLoginAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {

		ConsoleUtil cu = new ConsoleUtil();

		Member loginmember = cu.login(sc);

		MemberLoginService memberLoginService = new MemberLoginService();

		boolean isloginSuccess = memberLoginService.loginMember(loginmember);

		loginmember = MemberDAO.login;
		
		if (isloginSuccess) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}

	}

}
