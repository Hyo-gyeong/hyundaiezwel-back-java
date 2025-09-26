package encryption.sec02;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentInjectMain {

	public static void main(String[] args) {
		// 취약점이 있는 잘못 개발된 코드
		DBConnect dbCon = new DBConnect();
		Connection con = dbCon.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("학생 번호 입력 : " );
			String studentNo = sc.nextLine();
			System.out.println(studentNo);
			
			// sql 쿼리문 작성 - 플레이스홀더(?으로 작성 후 set으로 매칭) 사용하지 않고 변수 이용해서 코딩(전체 컬럼 추출)
			// prepareStatement사용하지만 바인딩하고있지 않아서 취약함
			String sql = "select * from student where stdno='"+studentNo+"'";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql); // 하드코딩된 쿼리 구문 그대로 적용 가능 (문자열이기만 하면 실행됨)
											   // prepareStatement라고 반드시 플레이스 홀더가 있어야 하는게 아님
			rs = pstmt.executeQuery();
			
			// 제목 출력
			System.out.println("----------------학생 정보 조회----------------");
			System.out.println("학생번호 \t 학생이름 \t\t\t\t학년");
			
			// 필요한 내용만 추출
			while (rs.next()) {
				String stdNo = rs.getString(1);
				String stdName = rs.getString(2);
				int stdYear = rs.getInt(3);
				
				// 한 행씩 출력
				System.out.format("%-10s\t %-20s\t %6d\n", stdNo, stdName, stdYear);
			}
			
			// 리소스 해제
			rs.close();
			pstmt.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace(); // 개발단계에서 개발자가 확인하기 위한 에러 출력문
		}
	}

}
