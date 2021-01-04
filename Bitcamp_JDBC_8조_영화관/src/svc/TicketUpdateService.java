package svc;

import java.sql.Connection;
import static db.jdbcUtil.*;
import dao.TicketDAO;
import vo.Ticket;

public class TicketUpdateService {

	public boolean updateTicket(Ticket newTicket, int ticketnumber) {

		boolean isUpdateSuccess = false;

		Connection con = getConnection();

		TicketDAO ticketDAO = new TicketDAO(con);

		int updateCount = ticketDAO.updateTicket(newTicket, ticketnumber);

		if (updateCount > 0) {
			commit(con);
			isUpdateSuccess = true;
		} else {
			rollback(con);
		}

		return isUpdateSuccess;
	}

}
