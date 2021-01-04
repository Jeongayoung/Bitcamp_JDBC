package action;

import java.util.Scanner;


import svc.MovieListService;
import util.ConsoleUtil;
import vo.movieList;

public class MovieListAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		//System.out.println("상영 목록 보기");
		
		ConsoleUtil cu = new ConsoleUtil();

		movieList newMovieList = cu.getMovieList(sc);

		MovieListService MovieListService = new MovieListService();

		boolean isListSuccess = MovieListService.listMovieList(newMovieList);

		if (isListSuccess) {
			System.out.println("상영리스트 불러오기 성공");
		} else {
			System.out.println("상영리스트 불러오기 실패");
		}
		
	}

}