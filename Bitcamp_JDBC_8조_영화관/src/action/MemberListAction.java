package action;

import java.util.Scanner;

import svc.MemberListService;
import util.ConsoleUtil;
import vo.Member;

public class MemberListAction implements Action2 {

	@Override
	public void execute(Scanner sc, Member loginMember) throws Exception {
		//System.out.println("회원 목록 보기");
		
		ConsoleUtil cu = new ConsoleUtil();

		Member newMember = cu.getMemberList(sc);

		MemberListService memberListService = new MemberListService();

		boolean isListSuccess = memberListService.listMember(newMember);

		if (isListSuccess) {
			System.out.println("회원 목록 불러오기 성공");
		} else {
			System.out.println("회원 목록 불러오기 실패");
		}
		
	}

}
