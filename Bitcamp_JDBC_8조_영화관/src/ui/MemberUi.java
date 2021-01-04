package ui;

import java.util.Scanner;

import action.Action;
import action.Action2;
import action.MemberAddAction;
import action.MemberDeleteAction;
import action.MemberListAction;
import action.MemberLoginAction;
import action.MemberUpdateAction;
import action.MemberticketListAction;
import action.MovieListAction;
import action.TicketDeleteAction;
import action.TicketUpdateAction;
import action.ticketListAction;
import action.ticketingAction;
import controller.MemberController;
import dao.MemberDAO;
import util.ConsoleUtil;
import vo.Member;

public class MemberUi {

	static Scanner sc = new Scanner(System.in);
	static MemberController memberController = new MemberController();
	static ConsoleUtil cu = new ConsoleUtil();

	public static void main(String[] args) {

		mainloop();

	}

	public static void mainloop() {
		
		while (true) {
			homeMenu();
			Member login = MemberDAO.login;
			if (login.getMgcode() == null) {
				memberMenu(login);
			} else {
				managerMenu(login);
			}
		}
		
	}

	public static void homeMenu() {

		Action action = null;

		System.out.println(">> 안녕하세요 ~ [♡도도♡ 시네마]입니다.");
		System.out.println(">> 원하시는 서비스 번호를 선택해주세요!");
		System.out.println("─────────────────────────────────────");
		System.out.println("       =====<Home Menu>=====");
		System.out.println();
		System.out.println("           [1. 회원 가입       ]");
		System.out.println("           [2. 회원 로그인    ]");
		System.out.println("           [3. 관리자 로그인 ]");
		System.out.println("           [4. 상영영화        ]");
		System.out.println("           [5. 종료하기        ]");
		System.out.println();
		System.out.println("─────────────────────────────────────");
		System.out.print(">> ");

		int menu = sc.nextInt();
		sc.nextLine();
		switch (menu) {
		case 1:
			action = new MemberAddAction();
			break;
		case 2:
			action = new MemberLoginAction();
			break;
		case 3:
			action = new MemberLoginAction();
			break;
		case 4:
			action = new MovieListAction();
			break;
		case 5:
			System.out.println("프로그램이 종료됩니다.");
			programExit();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			return;
		}

		if (action != null) {
			memberController.processRequest(action, sc);
		}

	}

	public static void memberMenu(Member loginMember) {
		Action2 action = null;
		while (loginMember != null) {

			System.out.println(">> 원하시는 서비스 번호를 선택해주세요!");
			System.out.println("─────────────────────────────────────");
			System.out.println("      =====<Member Menu>=====");
			System.out.println();
			System.out.println("          [1. 영화 예매        ]");
			System.out.println("          [2. 예매 내역        ]");
			System.out.println("          [3. 예매 수정        ]");
			System.out.println("          [4. 예매 취소        ]");
			System.out.println("          [5. 회원 정보 수정 ]");
			System.out.println("          [6. 회원 탈퇴        ]");
			System.out.println("          [7. 로그아웃         ]");
			System.out.println("          [8. 프로그램 종료  ]");
			System.out.println();
			System.out.println("─────────────────────────────────────");
			System.out.print(">> ");

			int menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1:
				action = new ticketingAction();
				break;
			case 2:
				action = new MemberticketListAction();
				break;
			case 3:
				action = new TicketUpdateAction();
				break;
			case 4:
				action = new TicketDeleteAction();
				break;
			case 5:
				action = new MemberUpdateAction();
				break;
			case 6:
				action = new MemberDeleteAction();
				break;
			case 7:
				System.out.println("로그아웃 하고 처음 화면으로 돌아갑니다.");
				mainloop();
				break;
			case 8:
				System.out.println("프로그램이 종료됩니다.");
				programExit();
				break;
			default:
				System.out.println("잘못 입력되었습니다.");
				return;
			}

			if (action != null) {
				memberController.processRequest(action, sc, loginMember);
			}
		}

	}

	public static void managerMenu(Member loginMember) {
		Action2 action = null;
		while (loginMember != null) {
			System.out.println(">> 원하시는 서비스 번호를 선택해주세요!");
			System.out.println("─────────────────────────────────────");
			System.out.println("     =====<Manager Menu>=====");
			System.out.println();
			System.out.println("          [1. 영화 예매        ]");
			System.out.println("          [2. 예매 내역        ]");
			System.out.println("          [3. 예매 수정        ]");
			System.out.println("          [4. 예매 취소        ]");
			System.out.println("          [5. 회원 목록 보기 ]");
			System.out.println("          [6. 회원 정보 수정 ]");
			System.out.println("          [7. 회원 정보 삭제 ]");
			System.out.println("          [8. 로그아웃         ]");
			System.out.println("          [9. 프로그램 종료  ]");
			System.out.println();
			System.out.println("─────────────────────────────────────");
			System.out.print(">> ");

			int menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1:
				action = new ticketingAction();
				break;
			case 2:
				action = new ticketListAction();
				break;
			case 3:
				action = new TicketUpdateAction();
				break;
			case 4:
				action = new TicketDeleteAction();
				break;
			case 5:
				action = new MemberListAction();
				break;
			case 6:
				action = new MemberUpdateAction();
				break;
			case 7:
				action = new MemberDeleteAction();
				break;
			case 8:
				System.out.println("로그아웃 하고 처음 화면으로 돌아갑니다.");
				mainloop();
				break;
			case 9:
				System.out.println("프로그램이 종료됩니다.");
				programExit();
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				return;
			}

			if (action != null) {
				memberController.processRequest(action, sc, loginMember);
			}
		}
	}

	public static void programExit() {
		System.out.println("종료되었습니다.");
		System.exit(0);
	}

}
