package util;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;
import java.util.Scanner;

import dao.TicketDAO;
import vo.Member;
import vo.Ticket;
import vo.movieList;

public class ConsoleUtil {

	Connection con = getConnection();

	public Member getNewMember(Scanner sc) {

		System.out.println("정보를 입력하세요.");
		System.out.print("id: ");
		String id = sc.next();

		System.out.print("pw: ");
		String pw = sc.next();

		System.out.print("이름: ");
		String name = sc.next();

		System.out.print("성별: ");
		String sex = sc.next();

		System.out.print("나이: ");
		int age = sc.nextInt();

		System.out.print("번호: ");
		String phone = sc.next();

		System.out.print("주소: ");
		String addr = sc.next();

		return new Member(id, pw, name, sex, age, phone, addr);
	}

	public Member getMemberList(Scanner sc) {

		System.out.println("회원 목록과 정보입니다.");
		System.out.println("★★★★★★★★★★★★★★★★★★");

		return new Member();
	}

	public Member memberUpdate(Scanner sc) {

		System.out.println("수정할 회원의 [새로운 정보]를 입력하세요.");
		System.out.print("id: ");
		String id = sc.next();

		System.out.print("pw: ");
		String pw = sc.next();

		System.out.print("이름: ");
		String name = sc.next();

		System.out.print("성별: ");
		String sex = sc.next();

		System.out.print("나이: ");
		int age = sc.nextInt();

		System.out.print("번호: ");
		String phone = sc.next();

		System.out.print("주소: ");
		String addr = sc.next();

		return new Member(id, pw, name, sex, age, phone, addr);
	}

	public String UpdateId(Scanner sc) {
		System.out.println("수정할 회원의 [ID]를 입력하세요.");

		System.out.print(">> ");
		String id = sc.next();
		sc.nextLine();

		return id;

	}

	public Member memberDelete(Scanner sc) {
		System.out.println("삭제할 회원의 [ID]를 입력하세요.");
		System.out.println();
		System.out.print(">> ");

		String id = sc.next();
		return new Member(id);
	}

	public Ticket ticketing(Scanner sc) {

		System.out.println("예매하시는 분의 아이디를 입력해주세요.");
		String id = sc.next();

		System.out.println("예매하실 영화의 상영번호를 입력해주세요.");
		int datenumber = sc.nextInt();

		return new Ticket(id, datenumber);
	}

	public Ticket ticketView(Scanner sc) {
		return new Ticket();
	}
	
	public Ticket memberticket(Scanner sc) {
		System.out.println("회원의 [ID]를 입력하셔야 티켓이 조회됩니다.");
		System.out.print(">> ");

		String id = sc.next();
		return new Ticket(id);
	}

	public int UpdateTN(Scanner sc) {

		System.out.println("수정할 티켓의 [티켓 번호]를 입력하세요");
		System.out.println(">> ");
		int ticketnumber = sc.nextInt();

		return ticketnumber;
	}

	public Ticket ticketUpdate(Scanner sc) {
		TicketDAO ticketdao = new TicketDAO(con);

		System.out.println("상영 영화와 날짜의 번호를 선택 해 주세요.");
		System.out.println("────────────────────────────────────");
		ticketdao.dateView(con);
		System.out.println(">> ");
		int datenumber = sc.nextInt();

		return new Ticket(0,datenumber);
	}

	public Ticket ticketDelete(Scanner sc) {
		
		System.out.println("삭제할 티켓의 [티켓 번호]를 입력하세요");
		System.out.println();
		System.out.println(">> ");
		int ticketnumber = sc.nextInt();
		
		return new Ticket(ticketnumber,0);

	}

	public movieList getMovieList(Scanner sc) {

		System.out.println("상영 정보입니다.");
		System.out.println("★★★★★★★★★★★★★★★★★★");
		// 여따가 함수넣고 그 함수가 스위치 1. 전체보기 2. 검색
		// 1하면 걍 나오고 2.는 영화 제목 받아서
		return new movieList();
	}

	public Member login(Scanner sc) {
		System.out.print("id: ");
		String id = sc.next();

		System.out.print("pw: ");
		String pw = sc.next();

		return new Member(id, pw);
	}

}
