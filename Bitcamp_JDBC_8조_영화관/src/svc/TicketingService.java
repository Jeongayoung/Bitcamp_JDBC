package svc;

import static db.jdbcUtil.commit;
import static db.jdbcUtil.getConnection;
import static db.jdbcUtil.rollback;

import java.sql.Connection;

import dao.TicketDAO;
import vo.Ticket;

public class TicketingService {

	public boolean addTicket(Ticket newTicket) {
		
		boolean isTicketingSuccess = false;
		
		Connection con = getConnection();
		
		TicketDAO ticketDAO = new TicketDAO(con);
		
		int ticketingCount = ticketDAO.addNewTicket(newTicket);
		
		if(ticketingCount > 0) {
			commit(con);
			isTicketingSuccess = true;
		} else {
			rollback(con);
		}
		
		return isTicketingSuccess;
	}
	
}
