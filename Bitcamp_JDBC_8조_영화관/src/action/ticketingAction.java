package action;

import java.util.Scanner;

import svc.TicketingService;
import util.ConsoleUtil;
import vo.Member;
import vo.Ticket;

public class ticketingAction implements Action2 {

	@Override
	public void execute(Scanner sc, Member loginMember) throws Exception {

		ConsoleUtil cu = new ConsoleUtil();
		
		Ticket newTicket = cu.ticketing(sc);
		
		TicketingService ticketingService = new TicketingService();
		
		ticketingService.addTicket(newTicket);
		
		
	}

}
