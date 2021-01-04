package action;

import java.util.Scanner;


import svc.MovieListService;
import util.ConsoleUtil;
import vo.movieList;

public class MovieListAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		//System.out.println("�� ��� ����");
		
		ConsoleUtil cu = new ConsoleUtil();

		movieList newMovieList = cu.getMovieList(sc);

		MovieListService MovieListService = new MovieListService();

		boolean isListSuccess = MovieListService.listMovieList(newMovieList);

		if (isListSuccess) {
			System.out.println("�󿵸���Ʈ �ҷ����� ����");
		} else {
			System.out.println("�󿵸���Ʈ �ҷ����� ����");
		}
		
	}

}