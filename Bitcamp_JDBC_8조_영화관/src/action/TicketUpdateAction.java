package action;

import java.util.Scanner;

import svc.TicketUpdateService;
import util.ConsoleUtil;
import vo.Member;
import vo.Ticket;

public class TicketUpdateAction implements Action2 {

	@Override
	public void execute(Scanner sc, Member loginMember) throws Exception {
		// System.out.println("티켓 정보 수정");

		ConsoleUtil cu = new ConsoleUtil();
		int ticketnumber = cu.UpdateTN(sc);

		Ticket newTicket = cu.ticketUpdate(sc);

		TicketUpdateService ticketUpdateService = new TicketUpdateService();

		boolean isUpdateSuccess = ticketUpdateService.updateTicket(newTicket,ticketnumber);

		if (isUpdateSuccess) {
			System.out.println("예매 내역이 수정되었습니다.");
		} else {
			System.out.println("예매 내역 수정이 실패하였습니다.");
		}

	}

}
