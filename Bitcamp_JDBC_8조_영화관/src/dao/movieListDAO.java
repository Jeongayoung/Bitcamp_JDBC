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

				System.out.println("[제목:" + movieName + "]");
				System.out.println("[시간:" + mdate+"]");
				System.out.println("[장르:" + section + "]");
				System.out.println("[런타임:" + time + "]");
				System.out.println("[감독:" + director + "]");
				System.out.println("[출연:" + actor + "]");
				System.out.println("★★★★★★★★★★★★★★★★★★");
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
