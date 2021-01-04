package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import static db.jdbcUtil.*;


import vo.movieList;

public class movieListDAO {

	Connection con;

	public movieListDAO(Connection con) {
		this.con = con;
	}

	public boolean memberListView(movieList newMovieList) {

		boolean isListSuccess = false;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select d.moviename, mdate, section, time, director, actor from moviedate d join movie m on d.moviename = m.moviename";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String movieName = rs.getString(1);
				Timestamp mdate = rs.getTimestamp(2);
				String section = rs.getString(3);
				String time = rs.getString(4);
				String director = rs.getString(5);
				String actor = rs.getString(6);

				System.out.println("[����:" + movieName + "]");
				System.out.println("[�ð�:" + mdate+"]");
				System.out.println("[�帣:" + section + "]");
				System.out.println("[��Ÿ��:" + time + "]");
				System.out.println("[����:" + director + "]");
				System.out.println("[�⿬:" + actor + "]");
				System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�");
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
}
