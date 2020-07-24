package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import dto.UserDTO;

public class UserDAO {
	// 유저 전체 보기
	public static void select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DB.conn();

			String sql = "SELECT * FROM signup_tb";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("＋－－－－－－－－－－－－－－＋");
				System.out.println("회원번호 : " + rs.getInt("usernum"));
				System.out.println("아이디 : " + rs.getString("id"));
				System.out.println("비밀번호 : " + rs.getString("pw"));
				System.out.println("이름 : " + rs.getString("name"));
				System.out.println("이메일 : " + rs.getString("email"));
				System.out.println("전화번호 : " + rs.getString("phone"));
				System.out.println("＋－－－－－－－－－－－－－－＋");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러: " + e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 선택 보기
	public static void unum_select(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DB.conn();

			String sql = "SELECT * FROM signup_tb WHERE usernum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("＋－－－－－－－－－－－－－－＋");
				System.out.println("회원번호 : " + rs.getInt("usernum"));
				System.out.println("아이디 : " + rs.getString("id"));
				System.out.println("비밀번호 : " + rs.getString("pw"));
				System.out.println("이름 : " + rs.getString("name"));
				System.out.println("이메일 : " + rs.getString("email"));
				System.out.println("전화번호 : " + rs.getString("phone"));
				System.out.println("＋－－－－－－－－－－－－－－＋");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러: " + e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// 같은 이메일 찾기
	public static boolean email_select(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DB.conn();

			String sql = "SELECT * FROM signup_tb WHERE email LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러: " + e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (rs.equals(email)) {
			System.out.println("사용할수 없는 이메일 입니다.");
			return true;

		} else {
			return false;

		}

	}

	// 데이터 넣기
	public static void insert(UserDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = DB.conn();

			String sql = "INSERT INTO signup_tb ( id, pw, name, email, phone) VALUES ( ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPhone());

			int rs = pstmt.executeUpdate();
			if (rs == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러: " + e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
