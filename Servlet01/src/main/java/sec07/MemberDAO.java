package sec07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
	
	private Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 연결할 DBMS 타입 명시, 사용할 클래스도 명시
																// DBMS에 따라 다른게 명시
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DBMS와 내부적으로도 통신해야하는데 이때 내부적인 표준 명시
			// jdbc:oracle:thin = os와 내부적으로 통신하는 규칙
			// @localhost:1521:xe = 서버 주소+포트+객체ID
			String user = "C##SQL_USER"; // 오라클에서는 계정명이면서도 DB에 해당
			String pwd = "1234";
			con = DriverManager.getConnection(url, user, pwd);
			
			if (con != null) {
				System.out.println("DB 연결 성공");
			}
		} catch (Exception e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		return con;
	}
	
	// 전체 회원 정보 반환 : select
	public ArrayList<MemberVO> memberSelect(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<MemberVO> memList = new ArrayList<>();
		
		try {
			con = getConnection();
			String query = "select * from member2";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMemId(rs.getString("memid"));
				vo.setMemPw(rs.getString("mempwd"));
				vo.setMemName(rs.getString("memname"));
				vo.setMemMail(rs.getString("mememail"));
				vo.setMemJoinDate(rs.getDate("memjoindate"));
				
				memList.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("회원 조회 실패");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memList;
	}
}
