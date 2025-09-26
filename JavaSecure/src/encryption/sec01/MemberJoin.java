package encryption.sec01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import encryption.sec04.DBConnect;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MemberJoin {

	public static void main(String[] args) {
		// 취약한 패스워드 저장 1 : plain text 그대로 저장
		DBConnect dbCon = new DBConnect();
		Connection con = dbCon.getConnection();
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("ID 입력 : ");
			String id = sc.nextLine();
			System.out.print("PW 입력 : ");
			String pw = sc.nextLine();
			System.out.print("Name 입력 : ");
			String name = sc.nextLine();
			System.out.print("email 입력 : ");
			String email = sc.nextLine();
			// 회원 가입 시간
			LocalDate now = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/mm/dd");
			String joinDate = now.format(formatter);
			
			String sql = "insert into member values (?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw); // 바인딩 되는 패스워드는 plain text
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, joinDate);
			
			int rslt = pstmt.executeUpdate();
			if (rslt > 0) {
				System.out.println("회원가입 성공!");
			} else {
				System.out.println("회원가입 실패!");
			}
		} catch (SQLException e) {
			DBConnect.close(con,pstmt);
			e.printStackTrace();
		}
	}

}
