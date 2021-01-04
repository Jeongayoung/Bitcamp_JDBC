package action;

import java.util.Scanner;

import svc.MemberUpdateService;
import util.ConsoleUtil;
import vo.Member;

public class MemberUpdateAction implements Action2 {

	@Override
	public void execute(Scanner sc, Member loginMember) throws Exception {
		// System.out.println("ȸ�� ���� ����");

		ConsoleUtil cu = new ConsoleUtil();
		String id = cu.UpdateId(sc);

		Member newMember = cu.memberUpdate(sc);

		MemberUpdateService memberUpdateService = new MemberUpdateService();
		
		boolean isUpdateSuccess = memberUpdateService.updateMember(newMember, id);
		
		if (isUpdateSuccess) {
			System.out.println(newMember.getName() + "ȸ�� ���� ���� [ ���� ]");
		} else {
			System.out.println(newMember.getName() + "ȸ�� ���� ���� [ ���� ]");
		}

	}

}
