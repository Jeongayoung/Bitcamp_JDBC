package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static db.jdbcUtil.*;
import vo.Ticket;

public class TicketDAO {

	Connection con;

	public TicketDAO(Connection con) {
		this.con = con;
	}

	public int addNewTicket(Ticket newTicket) {

		int ticketingCount = 0;

		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;

		String sql = "INSERT INTO ticket values(ticket_ticketnumber_seq.nextVal,"
				+ "(select id from member where id = ?), "
				+ "(select datenumber from moviedate where datenumber = ?))";

		String sql2 = "select ticketnumber, mname, moviename, mdate from ticket "
				+ "natural join member natural join moviedate where id = ?";

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newTicket.getId());
			pstmt.setInt(2, newTicket.getDatenumber());

			ticketingCount = pstmt.executeUpdate();

			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1, newTicket.getId());
			rs = pstmt2.executeQuery();

			System.out.println("영화 예매가 완료되었습니다. 티켓을 출력하겠습니다.");
			while (rs.next()) {

				int ticketnumber = rs.getInt(1);
				String mname = rs.getString(2);
				String moviename = rs.getString(3);
				String mdate = rs.getString(4);
				
				System.out.println("─────────────────────────────────────────────");
				System.out.println("  " + ticketnumber + "번 티켓입니다.");
				System.out.println("  " + mname + "회원님 " + moviename + "영화를 예매하셨습니다.");
				System.out.println("  " + "상영 시작 시간은 " + mdate + " 입니다.");
				System.out.println("       " + "즐거운 관람 되세요!");
				System.out.println("─────────────────────────────────────────────");

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstmt != null)
					close(pstmt);
				if (rs != null)
					close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return ticketingCount;
	}
	
	public boolean memberticketListView(Ticket newTicket) {

		boolean isListSuccess = false;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select ticketnumber, mname, moviename, mdate from ticket"
				+ " natural join member natural join moviedate where id = ?";

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newTicket.getId());
			
			rs = pstmt.executeQuery();

			while (rs.next()) {

				int ticketnumber = rs.getInt(1);
				String mname = rs.getString(2);
				String moviename = rs.getString(3);
				String mdate = rs.getString(4);

				System.out.println("─────────────────────────────────────────────");
				System.out.println("  " + ticketnumber + "번 티켓입니다.");
				System.out.println("  " + mname + "회원님 " + moviename + "영화를 예매하셨습니다.");
				System.out.println("  " + "상영 시작 시간은 " + mdate + " 입니다.");
				System.out.println("       " + "즐거운 관람 되세요!");
				System.out.println("─────────────────────────────────────────────");

			}

			isListSuccess = pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstmt != null)
					close(pstmt);
				if (rs != null)
					close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return isListSuccess;
	}
	
	public boolean ticketListView(Ticket newTicket) {

		boolean isListSuccess = false;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select ticketnumber, mname, moviename, mdate from ticket natural join member natural join moviedate";

		try {

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				int ticketnumber = rs.getInt(1);
				String mname = rs.getString(2);
				String moviename = rs.getString(3);
				String mdate = rs.getString(4);

				System.out.println("─────────────────────────────────────────────");
				System.out.println("  " + ticketnumber + "번 티켓입니다.");
				System.out.println("  " + mname + "회원님 " + moviename + "영화를 예매하셨습니다.");
				System.out.println("  " + "상영 시작 시간은 " + mdate + " 입니다.");
				System.out.println("       " + "즐거운 관람 되세요!");
				System.out.println("─────────────────────────────────────────────");

			}

			isListSuccess = pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstmt != null)
					close(pstmt);
				if (rs != null)
					close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return isListSuccess;
	}

	public void dateView(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM moviedate";

		try {

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "번 " + rs.getString(2) + " " + rs.getString(3));
				System.out.println("────────────────────────────────────");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					close(pstmt);
				if (rs != null)
					close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public int updateTicket(Ticket newTicket, int ticketnumber) {

		int updateCount = 0;

		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;

		ResultSet rs = null;

		String sql = "UPDATE ticket SET datenumber = ? WHERE ticketnumber = ?";

		String sql2 = "select ticketnumber, mname, moviename, mdate from ticket "
				+ "natural join member natural join moviedate where ticketnumber = ?";

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, newTicket.getDatenumber());
			pstmt.setInt(2, ticketnumber);
			updateCount = pstmt.executeUpdate();

			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, ticketnumber);
			rs = pstmt2.executeQuery();

			while (rs.next()) {

				ticketnumber = rs.getInt(1);
				String mname = rs.getString(2);
				String moviename = rs.getString(3);
				String mdate = rs.getString(4);

				System.out.println("수정된 티켓을 출력하겠습니다.");
				System.out.println("─────────────────────────────────────────────");
				System.out.println("  " + ticketnumber + "번 티켓입니다.");
				System.out.println("  " + mname + "회원님 " + moviename + "영화를 예매하셨습니다.");
				System.out.println("  " + "상영 시작 시간은 " + mdate + " 입니다.");
				System.out.println("       " + "즐거운 관람 되세요!");
				System.out.println("─────────────────────────────────────────────");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstmt != null)
					close(pstmt);
				if (rs != null)
					close(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return updateCount;
	}

	public int deleteTicket(Ticket newTicket) {

		int updateCount = 0;

		PreparedStatement pstmt = null;

		String sql = "DELETE ticket WHERE ticketNUMBER = ?";

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, newTicket.getTicketnumber());
			updateCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstmt != null)
					close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return updateCount;
	}

}
