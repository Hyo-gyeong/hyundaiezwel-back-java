package encryption.sec02;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MemberLoginMD5 {
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
		// 회원가입 시 md5 알고리즘을 사용해서 비밀번호 저장
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
			String pw = md5(sc.nextLine());
			
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
