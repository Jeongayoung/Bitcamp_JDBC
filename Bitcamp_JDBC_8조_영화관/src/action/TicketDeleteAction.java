package action;

import java.util.Scanner;

import svc.TicketDeleteService;
import util.ConsoleUtil;
import vo.Member;
import vo.Ticket;

public class TicketDeleteAction implements Action2 {

	@Override
	public void execute(Scanner sc, Member loginMember) throws Exception {
		// System.out.println("회원 정보 삭제");

		ConsoleUtil cu = new ConsoleUtil();

		Ticket newMember = cu.ticketDelete(sc);

		TicketDeleteService ticketDeleteService = new TicketDeleteService();

		boolean isDeleteSuccess = ticketDeleteService.deleteTicket(newMember);

		if (isDeleteSuccess) {
			System.out.println("티켓 정보 삭제 [ 성공 ]");
		} else {
			System.out.println("티켓 정보 삭제 [ 실패 ]");
		}

	}

}
