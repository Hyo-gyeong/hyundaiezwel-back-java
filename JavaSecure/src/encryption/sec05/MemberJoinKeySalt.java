package encryption.sec05;

import java.security.MessageDigest;
//import java.util.random.*; // 암호학적으로 충분한 난수를 추출하지 않음. 암호화에 사용 제한
import java.security.SecureRandom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


import encryption.sec04.DBConnect;

public class MemberJoinKeySalt {
	// salt크기 설정
	private static final int SALT_SIZE = 16;
	
	// salt값 생성 매서드
	public static String getSalt() throws Exception{
		SecureRandom rnd = new SecureRandom();
		byte[] temp = new byte[SALT_SIZE];
		rnd.nextBytes(temp); // 배열 크기만큼의 난수를 발생시켜서 배열에 저장
		// salt 사용하려면 문자열로 사용하는게 일반적(회원마다 다른 salt 사용 -> db에 저장할 예정)
		
		return BytetoString(temp); // 문자열 salt반환
	}

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
		// sha256으로 비밀번호 해시, 스트레칭 + salt 추가
		DBConnect dbCon = new DBConnect();
		Connection con = dbCon.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		String dbPwd = null;
		String dbSalt = null;
		
		try {
			System.out.print("ID 입력 : ");
			String id = sc.nextLine();
			System.out.print("PW 입력 : ");
			String pw = sc.nextLine();
			String salt = getSalt(); // salt값을 얻어왔으면 db에 저장해야 함
			pw = Hashing(pw.getBytes(), salt);
			System.out.println(pw);
			
			System.out.print("Name 입력 : ");
			String name = sc.nextLine();
			System.out.print("email 입력 : ");
			String email = sc.nextLine();
			
			// 회원 가입 시간
			LocalDate now = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			String joinDate = now.format(formatter);
			
			String sql = "insert into member values (?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw); // 바인딩 되는 패스워드는 plain text
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, joinDate);
			pstmt.setString(6, salt);
			
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
