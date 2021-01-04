package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static db.jdbcUtil.*;
import vo.Member;

public class MemberDAO {

	Connection con;
	static String logid = null;
	public static Member login = new Member();

	public MemberDAO(Connection con) {
		this.con = con;
	}

	public int insertNewMember(Member newMember) {

		int insertCount = 0;

		PreparedStatement pstmt = null;

		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?,?,?)";

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newMember.getId());
			pstmt.setString(2, newMember.getPw());
			pstmt.setString(3, newMember.getName());
			pstmt.setString(4, newMember.getSex());
			pstmt.setInt(5, newMember.getAge());
			pstmt.setString(6, newMember.getPhone());
			pstmt.setString(7, newMember.getAddr());
			pstmt.setString(8, null);
			insertCount = pstmt.executeUpdate();

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

		return insertCount;
	}

	public boolean memberListView(Member newMember) {

		boolean isListSuccess = false;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM member";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String sex = rs.getString(4);
				int age = rs.getInt(5);
				String phone = rs.getString(6);
				String addr = rs.getString(7);

				System.out.println("id: " + id);
				System.out.println("pw: " + pw);
				System.out.println("이름: " + name);
				System.out.println("성별: " + sex);
				System.out.println("나이: " + age);
				System.out.println("번호: " + phone);
				System.out.println("주소: " + addr);
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

	public int updateMember(Member newMember, String id) {

		int updateCount = 0;

		PreparedStatement pstmt = null;

		String sql = "UPDATE member SET id=?, pw =?, mname = ?, sex = ?, age = ?, phone = ?, addr = ? WHERE id = ?";

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newMember.getId());
			pstmt.setString(2, newMember.getPw());
			pstmt.setString(3, newMember.getName());
			pstmt.setString(4, newMember.getSex());
			pstmt.setInt(5, newMember.getAge());
			pstmt.setString(6, newMember.getPhone());
			pstmt.setString(7, newMember.getAddr());
			pstmt.setString(8, id);
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

	public int deleteMember(Member newMember) {

		int updateCount = 0;

		PreparedStatement pstmt = null;

		String sql = "DELETE member WHERE id = ?";

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newMember.getId());
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

	public boolean loginCheck(Member loginmember) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM member WHERE id =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginmember.getId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getString(1).equals(loginmember.getId()) && rs.getString(2).equals(loginmember.getPw())) {
					Member loginMember = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8));

					login = loginMember;
					System.out.println("로그인되었습니다.");
					logid = rs.getString(1);
					return true;
				} else {
					System.out.println("정보가 일치하지 않습니다.");
					return false;
				}
			}

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
		return false;
	}

}
