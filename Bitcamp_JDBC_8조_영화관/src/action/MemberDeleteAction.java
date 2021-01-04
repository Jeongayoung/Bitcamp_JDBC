package action;

import java.util.Scanner;

import svc.MemberDeleteService;
import ui.MemberUi;
import util.ConsoleUtil;
import vo.Member;

public class MemberDeleteAction implements Action2 {

	@Override
	public void execute(Scanner sc, Member loginMember) throws Exception {
		// System.out.println("È¸¿ø Á¤º¸ »èÁ¦");

		ConsoleUtil cu = new ConsoleUtil();

		Member newMember = cu.memberDelete(sc);

		MemberDeleteService memberDeleteService = new MemberDeleteService();

		boolean isDeleteSuccess = memberDeleteService.deleteMember(newMember);
		
		if (isDeleteSuccess) {
			System.out.println("È¸¿ø Å»Åð [¼º°ø]");
			MemberUi.mainloop();
		} else {
			System.out.println("È¸¿ø Å»Åð [½ÇÆÐ]");
			MemberUi.mainloop();
		}

	}

}
