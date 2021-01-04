package action;

import java.util.Scanner;

import svc.MemberListService;
import util.ConsoleUtil;
import vo.Member;

public class MemberListAction implements Action2 {

	@Override
	public void execute(Scanner sc, Member loginMember) throws Exception {
		//System.out.println("ȸ�� ��� ����");
		
		ConsoleUtil cu = new ConsoleUtil();

		Member newMember = cu.getMemberList(sc);

		MemberListService memberListService = new MemberListService();

		boolean isListSuccess = memberListService.listMember(newMember);

		if (isListSuccess) {
			System.out.println("ȸ�� ��� �ҷ����� ����");
		} else {
			System.out.println("ȸ�� ��� �ҷ����� ����");
		}
		
	}

}
