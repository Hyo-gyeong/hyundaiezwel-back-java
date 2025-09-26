package encryption.sec03;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MemberLoginSHA256 {
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
//		System.out.println(sb.toString());
		return sb.toString();
	}
	public static void main(String[] args) throws Exception{
		// 회원가입 시 sha256 알리즘을 사용해서 비밀번호 저장
		// 로그인 진행 할 때는 평문 비밀번호 받아서 저장된 해시값과 같은지 확인
		// 해시값은 역연산이 불가능하므로 로그인로직에서는 입력된 비밀번호를 해시값으로 변경해서
		// 저장된 비밀번호 해시값과 일치하는지 확인
		DBConnect dbCon = new DBConnect();
		Connection con = dbCon.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("ID 입력 : ");
			String id = sc.nextLine();
			System.out.print("PW 입력 : ");
			String pw = sha256(sc.nextLine());
			
			// sql injection에는 아직 취약함
			String sqlString = "select * from member where memid='"+id+"' and mempwd = '"+pw+"'";
			
			pstmt = con.prepareStatement(sqlString);
			rslt = pstmt.executeQuery();
			// 회원가입 진행 시 중복 아이디 허용하지 않았다고 가정
			if (rslt.next()) {
				System.out.println("로그인 되었습니다.");
				// 웹에서는 로그인 되었다면 자격증명을 포함해서 클라이언트에게 전달
			} else {
				System.out.println("로그인 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(con, pstmt, rslt);
			sc.close();
		}

	}

}
