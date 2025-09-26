package encryption.sec01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MemberLogin {

	public static void main(String[] args) {
		// DB에 저장된 비밀번호가 plain text이기 때문에 
		// sql 쿼리를 문자열을 결합해서 동적으로 생성하고 있음 : sql 삽입공격에 노출됨
		DBConnect dbCon = new DBConnect();
		Connection con = dbCon.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rslt = null; // select 구문
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("ID 입력 : ");
			String id = sc.nextLine();
			System.out.print("PW 입력 : ");
			String pw = sc.nextLine();
			
			// select 쿼리문 작성
			// pstmt.setString(1, id);
			// pstmt.setString(2, pw); // 이렇게 사용하지 않고 취약하게 문자열로 sql쿼리문을 구성함
			String sqlString = "select * from member where memid='"+id+"' and mempwd = '"+pw+"'";
					// id에 ' or 1=1 --를 넣으면 비밀번호 입력값까지 전부 무력화되어 로그인이 됨
			
			pstmt = con.prepareStatement(sqlString);
			rslt = pstmt.executeQuery();
			// 회원가입 진행 시 중복 아이디 허용하지 않았다고 가정
			// 위 쿼리가 진행되었다면 한명에 대한 정보가 나오거나 정보가 추출되지 않았을 것임
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
