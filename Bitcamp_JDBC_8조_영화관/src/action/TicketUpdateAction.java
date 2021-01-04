package action;

import java.util.Scanner;

import svc.TicketUpdateService;
import util.ConsoleUtil;
import vo.Member;
import vo.Ticket;

public class TicketUpdateAction implements Action2 {

	@Override
	public void execute(Scanner sc, Member loginMember) throws Exception {
		// System.out.println("Ƽ�� ���� ����");

		ConsoleUtil cu = new ConsoleUtil();
		int ticketnumber = cu.UpdateTN(sc);

		Ticket newTicket = cu.ticketUpdate(sc);

		TicketUpdateService ticketUpdateService = new TicketUpdateService();

		boolean isUpdateSuccess = ticketUpdateService.updateTicket(newTicket,ticketnumber);

		if (isUpdateSuccess) {
			System.out.println("���� ������ �����Ǿ����ϴ�.");
		} else {
			System.out.println("���� ���� ������ �����Ͽ����ϴ�.");
		}

	}

}
