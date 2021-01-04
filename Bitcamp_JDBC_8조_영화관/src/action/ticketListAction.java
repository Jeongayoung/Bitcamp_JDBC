package action;

import java.util.Scanner;

import svc.TicketListService;
import util.ConsoleUtil;
import vo.Member;
import vo.Ticket;

public class ticketListAction implements Action2 {

	@Override
	public void execute(Scanner sc, Member loginMember) throws Exception {
		//System.out.println("티켓 목록 보기");
		
		ConsoleUtil cu = new ConsoleUtil();

		Ticket newTicket = cu.ticketView(sc);

		TicketListService ticketlistService = new TicketListService();

		boolean isListSuccess = ticketlistService.listTicket(newTicket);

		if (isListSuccess) {
			System.out.println("예매 내역입니다.");
		} else {
			System.out.println("티켓 목록 불러오기 실패");
		}
		
	}

}
