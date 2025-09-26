package secure.sec01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.*; // Pattern 클래스 포함됨

public class StudentInjectMainSecure2 {

	public static void main(String[] args) {
		// 입력값 필터링 - 정규식 활용
		// 문자와 숫자를 제외한 나머지 특수 기호 필터링
		// union 삽입 공격에 사용하는 키워드들은 필터링
		DBConnect dbCon = new DBConnect();
		Connection con = dbCon.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
//		Pattern pattern = Pattern.compile("[^0-9a-zA-Z]|select|delete|update|insert|create|alter|drop|all|union"); // 단어 별로 거르고 싶으면
		Pattern pattern = Pattern.compile("[^0-9a-zA-Z]|[select|delete|update|insert|create|alter|drop|all|union]");
		// compile : static function
		Matcher matcher = null;
		
		try {
			System.out.print("학생 번호 입력 : " );
			String studentNo = sc.nextLine();
			System.out.println(studentNo);
			
			// squence로 비교해서 거르고 일반적으로 관련된 단어는 걸러내는것이 좋음
			matcher = pattern.matcher(studentNo.toLowerCase());
			boolean match = true;
//			matcher.find(); // 설정한 정규식 패턴과 전달된 문자열을 매칭시켜서 정규식 패턴에 대한 문자열 확인되면 true 반환
			// 전달된 문자열 시퀀스가 정규식과 맞는지 반복문을 통해서 찾기
			while (matcher.find()) {
				match = false;
				break;
			}
			if (match) {
				// 필터링을 통해서 취약점 제거
				String sql = "select * from student where stdno=?";
				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, studentNo); // 공격시 에러 발생
						// 열 인덱스가 부족하다는 에러 : java.sql.SQLException: ORA-17003: 열 인덱스가 부적합합니다.
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
			} else {
				System.out.println("부적절한 값이 입력되었습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace(); // 개발단계에서 개발자가 확인하기 위한 에러 출력문
		}

	}

}
