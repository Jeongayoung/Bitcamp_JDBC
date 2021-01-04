package action;

import java.util.Scanner;

import svc.TicketDeleteService;
import util.ConsoleUtil;
import vo.Member;
import vo.Ticket;

public class TicketDeleteAction implements Action2 {

	@Override
	public void execute(Scanner sc, Member loginMember) throws Exception {
		// System.out.println("ȸ�� ���� ����");

		ConsoleUtil cu = new ConsoleUtil();

		Ticket newMember = cu.ticketDelete(sc);

		TicketDeleteService ticketDeleteService = new TicketDeleteService();

		boolean isDeleteSuccess = ticketDeleteService.deleteTicket(newMember);

		if (isDeleteSuccess) {
			System.out.println("Ƽ�� ���� ���� [ ���� ]");
		} else {
			System.out.println("Ƽ�� ���� ���� [ ���� ]");
		}

	}

}
