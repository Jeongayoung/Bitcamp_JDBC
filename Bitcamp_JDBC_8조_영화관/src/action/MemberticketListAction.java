package action;

import java.util.Scanner;

import svc.MemberTicketListService;
import util.ConsoleUtil;
import vo.Member;
import vo.Ticket;

public class MemberticketListAction implements Action2 {

	@Override
	public void execute(Scanner sc, Member loginMember) throws Exception {
		//System.out.println("티켓 목록 보기");
		
		ConsoleUtil cu = new ConsoleUtil();

		Ticket newTicket = cu.memberticket(sc);

		MemberTicketListService memberticketlistService = new MemberTicketListService();

		boolean isListSuccess = memberticketlistService.memberlistTicket(newTicket);

		if (isListSuccess) {
			System.out.println("예매 내역입니다.");
		} else {
			System.out.println("티켓 목록 불러오기 실패");
		}
		
	}

}
