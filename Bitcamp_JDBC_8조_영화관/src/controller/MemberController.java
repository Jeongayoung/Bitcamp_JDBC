package controller;

import java.util.Scanner;

import action.Action;
import action.Action2;
import vo.Member;

public class MemberController {

	public void processRequest(Action action, Scanner sc) {
		
		try {
			action.execute(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void processRequest(Action2 action, Scanner sc, Member loginMember) {
		
		try {
			action.execute(sc, loginMember);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
