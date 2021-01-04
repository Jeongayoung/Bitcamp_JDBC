package action;

import java.util.Scanner;

import svc.MemberTicketListService;
import util.ConsoleUtil;
import vo.Member;
import vo.Ticket;

public class MemberticketListAction implements Action2 {

	@Override
	public void execute(Scanner sc, Member loginMember) throws Exception {
		//System.out.println("Ƽ�� ��� ����");
		
		ConsoleUtil cu = new ConsoleUtil();

		Ticket newTicket = cu.memberticket(sc);

		MemberTicketListService memberticketlistService = new MemberTicketListService();

		boolean isListSuccess = memberticketlistService.memberlistTicket(newTicket);

		if (isListSuccess) {
			System.out.println("���� �����Դϴ�.");
		} else {
			System.out.println("Ƽ�� ��� �ҷ����� ����");
		}
		
	}

}
