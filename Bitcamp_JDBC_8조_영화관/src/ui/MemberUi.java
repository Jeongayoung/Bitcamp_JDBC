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

		System.out.println(">> �ȳ��ϼ��� ~ [�������� �ó׸�]�Դϴ�.");
		System.out.println(">> ���Ͻô� ���� ��ȣ�� �������ּ���!");
		System.out.println("��������������������������������������������������������������������������");
		System.out.println("       =====<Home Menu>=====");
		System.out.println();
		System.out.println("           [1. ȸ�� ����       ]");
		System.out.println("           [2. ȸ�� �α���    ]");
		System.out.println("           [3. ������ �α��� ]");
		System.out.println("           [4. �󿵿�ȭ        ]");
		System.out.println("           [5. �����ϱ�        ]");
		System.out.println();
		System.out.println("��������������������������������������������������������������������������");
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
			System.out.println("���α׷��� ����˴ϴ�.");
			programExit();
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			return;
		}

		if (action != null) {
			memberController.processRequest(action, sc);
		}

	}

	public static void memberMenu(Member loginMember) {
		Action2 action = null;
		while (loginMember != null) {

			System.out.println(">> ���Ͻô� ���� ��ȣ�� �������ּ���!");
			System.out.println("��������������������������������������������������������������������������");
			System.out.println("      =====<Member Menu>=====");
			System.out.println();
			System.out.println("          [1. ��ȭ ����        ]");
			System.out.println("          [2. ���� ����        ]");
			System.out.println("          [3. ���� ����        ]");
			System.out.println("          [4. ���� ���        ]");
			System.out.println("          [5. ȸ�� ���� ���� ]");
			System.out.println("          [6. ȸ�� Ż��        ]");
			System.out.println("          [7. �α׾ƿ�         ]");
			System.out.println("          [8. ���α׷� ����  ]");
			System.out.println();
			System.out.println("��������������������������������������������������������������������������");
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
				System.out.println("�α׾ƿ� �ϰ� ó�� ȭ������ ���ư��ϴ�.");
				mainloop();
				break;
			case 8:
				System.out.println("���α׷��� ����˴ϴ�.");
				programExit();
				break;
			default:
				System.out.println("�߸� �ԷµǾ����ϴ�.");
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
			System.out.println(">> ���Ͻô� ���� ��ȣ�� �������ּ���!");
			System.out.println("��������������������������������������������������������������������������");
			System.out.println("     =====<Manager Menu>=====");
			System.out.println();
			System.out.println("          [1. ��ȭ ����        ]");
			System.out.println("          [2. ���� ����        ]");
			System.out.println("          [3. ���� ����        ]");
			System.out.println("          [4. ���� ���        ]");
			System.out.println("          [5. ȸ�� ��� ���� ]");
			System.out.println("          [6. ȸ�� ���� ���� ]");
			System.out.println("          [7. ȸ�� ���� ���� ]");
			System.out.println("          [8. �α׾ƿ�         ]");
			System.out.println("          [9. ���α׷� ����  ]");
			System.out.println();
			System.out.println("��������������������������������������������������������������������������");
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
				System.out.println("�α׾ƿ� �ϰ� ó�� ȭ������ ���ư��ϴ�.");
				mainloop();
				break;
			case 9:
				System.out.println("���α׷��� ����˴ϴ�.");
				programExit();
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				return;
			}

			if (action != null) {
				memberController.processRequest(action, sc, loginMember);
			}
		}
	}

	public static void programExit() {
		System.out.println("����Ǿ����ϴ�.");
		System.exit(0);
	}

}
