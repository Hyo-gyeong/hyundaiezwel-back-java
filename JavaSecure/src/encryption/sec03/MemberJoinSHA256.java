package encryption.sec03;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import encryption.sec04.DBConnect;

public class MemberJoinSHA256 {
	public static String sha256(String pass) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(pass.getBytes());
		return bytesToHex(md.digest()); // 16진수 문자열로 변환 필요
	}
	private static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
	public static void main(String[] args) throws Exception {
		// sha256 알고리즘을 활용해서 비밀번호를 해시값으로 변경해서 db에 저장
		DBConnect dbCon = new DBConnect();
		Connection con = dbCon.getConnection();
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("ID 입력 : ");
			String id = sc.nextLine();
			System.out.print("PW 입력 : ");
			String pw = sha256(sc.nextLine()); // static 메서드 sha256 호출, 비밀번호를 sha256형식의 해시값으로 변경
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
