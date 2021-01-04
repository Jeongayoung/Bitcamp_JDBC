package action;

import java.util.Scanner;

import svc.TicketListService;
import util.ConsoleUtil;
import vo.Member;
import vo.Ticket;

public class ticketListAction implements Action2 {

	@Override
	public void execute(Scanner sc, Member loginMember) throws Exception {
		//System.out.println("Ƽ�� ��� ����");
		
		ConsoleUtil cu = new ConsoleUtil();

		Ticket newTicket = cu.ticketView(sc);

		TicketListService ticketlistService = new TicketListService();

		boolean isListSuccess = ticketlistService.listTicket(newTicket);

		if (isListSuccess) {
			System.out.println("���� �����Դϴ�.");
		} else {
			System.out.println("Ƽ�� ��� �ҷ����� ����");
		}
		
	}

}
