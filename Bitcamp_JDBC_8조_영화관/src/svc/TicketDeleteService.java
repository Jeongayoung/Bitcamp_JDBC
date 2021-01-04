package svc;

import java.sql.Connection;
import static db.jdbcUtil.*;
import dao.TicketDAO;
import vo.Ticket;

public class TicketDeleteService {

	public boolean deleteTicket(Ticket newTicket) {

		boolean isDeleteSuccess = false;

		Connection con = getConnection();

		TicketDAO ticketDAO = new TicketDAO(con);

		int deleteCount = ticketDAO.deleteTicket(newTicket);

		if (deleteCount > 0) {
			commit(con);
			isDeleteSuccess = true;
		} else {
			rollback(con);
		}

		return isDeleteSuccess;
	}

}
