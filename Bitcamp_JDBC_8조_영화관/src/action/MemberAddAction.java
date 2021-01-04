package action;

import java.util.Scanner;

import svc.MemberAddService;
import ui.MemberUi;
import util.ConsoleUtil;
import vo.Member;

public class MemberAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		// System.out.println("회원 등록");

		ConsoleUtil cu = new ConsoleUtil();

		Member newMember = cu.getNewMember(sc);

		MemberAddService memberAddService = new MemberAddService();

		boolean isAddSuccess = memberAddService.addMember(newMember);

		if (isAddSuccess) {
			System.out.println(newMember.getName() + "회원 정보 추가 [ 성공 ]");
			MemberUi.mainloop();
		} else {
			System.out.println(newMember.getName() + "회원 정보 추가 [ 실패 ]");
			MemberUi.mainloop();
		}

	}

}
