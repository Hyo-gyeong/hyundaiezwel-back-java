package encryption.sec02;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import encryption.sec04.DBConnect;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MemberJoinMD5 {
	public static String md5(String pass) {
		String encData = "";
		try {
			// md5 해시알고리즘으로 password 변경 후 반환
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytes = pass.getBytes(); // 해시처리를 위해서 전달된 문자열을 byte타입으로 변경
			md.update(bytes); // byte input값(해시로 변경할 message)을 파라미터로 전달
			
			// password 해시값으로 변경
			byte[] digest = md.digest();
			System.out.println(digest);
			// 16진수로 출력
			for (int i = 0; i < digest.length; i++) {
				encData += Integer.toHexString(digest[i] & 0xff); // 비트연산
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encData;
	}
	public static void main(String[] args) {
		// MD5 알고리즘을 활용해서 비밀번호를 해시값으로 변경해서 db에 저장
		DBConnect dbCon = new DBConnect();
		Connection con = dbCon.getConnection();
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("ID 입력 : ");
			String id = sc.nextLine();
			System.out.print("PW 입력 : ");
			String pw = md5(sc.nextLine()); // static 메서드 md5 호출, 비밀번호를 md5형식의 해시값으로 변경
			System.out.print("Name 입력 : ");
			String name = sc.nextLine();
			System.out.print("email 입력 : ");
			String email = sc.nextLine();
			// 회원 가입 시간
			LocalDate now = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
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
