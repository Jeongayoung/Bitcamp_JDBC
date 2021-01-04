package svc;

import java.sql.Connection;
import static db.jdbcUtil.*;
import dao.TicketDAO;
import vo.Ticket;

public class MemberTicketListService {

	public boolean memberlistTicket(Ticket newTicket) {
		
		boolean isListSuccess = false;
		
		Connection con = getConnection();
		
		TicketDAO ticketDAO = new TicketDAO(con);
		
		isListSuccess = ticketDAO.memberticketListView(newTicket);
		
		return isListSuccess;
	}
	
}
