package encryption.sec05;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import encryption.sec04.DBConnect;

public class MemberLoginKeySalt {
	private static String BytetoString(byte[] temp) {
		StringBuilder sb = new StringBuilder();
		for (byte b : temp) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
	
	// 해시값 생성
	public static String Hashing(byte[] pw, String salt) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		// key-stretching
		// pw + salt 결합해서 digest 생성
		for (int i = 0; i < 10000; i++) {
			String temp = BytetoString(pw) + salt;
			md.update(temp.getBytes());
			pw = md.digest();
		}
		return BytetoString(pw);
	}

	public static void main(String[] args) throws Exception {
		DBConnect dbCon = new DBConnect();
		Connection con = dbCon.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		String dbSalt = "";
		String dbPwd = "";
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("ID 입력 : ");
			String id = sc.nextLine();
			System.out.print("PW 입력 : ");
			String pw = sc.nextLine();
			
			// sql injection에는 아직 취약함
			// 보통 웹사이트에서 id는 유일함 (따라서 id가 유일하다고 가정)
			//해당 id가 있는지 확인 -> 정보 추출
			String sqlString = "select * from member where memid='"+id+"'";
			
			pstmt = con.prepareStatement(sqlString);
			rslt = pstmt.executeQuery();

			if (rslt.next()) {
				dbPwd = rslt.getString(2); // 회원가입시 해시되어 저장된 비밀번호
				dbSalt = rslt.getString(6); // 개인별로 저자한 salt값
				String hashPw = Hashing(pw.getBytes(), dbSalt);
				if (dbPwd.equals(hashPw)) {
					System.out.println("로그인 성공");
				} else {
					System.out.println("로그인 실패"); // id는 존재하는데 비밀번호가 다른 경우
				}
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
