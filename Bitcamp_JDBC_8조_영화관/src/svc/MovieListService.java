package svc;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;

import dao.movieListDAO;
import vo.movieList;

public class MovieListService {
	public boolean listMovieList(movieList newMovieList) {
		
		boolean isListSuccess = false;
		
		Connection con = getConnection();
		
		movieListDAO movieDAO = new movieListDAO(con);
		
		isListSuccess = movieDAO.memberListView(newMovieList);
		
		return isListSuccess;
	}
	
}

