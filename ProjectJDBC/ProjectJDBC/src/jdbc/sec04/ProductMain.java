package jdbc.sec04;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductMain {
    public static void main(String[] args) {
        DBConnect dbCon = new DBConnect(); // 원하는 DB에 연결한 DB Connection 객체 생성해서 가져오기
        Connection con = dbCon.getConnection(); // DB에 연결
        Statement stmt = null; // 질의를 처리하고 응답을 받아주는 객체
        ResultSet rslt = null;
        try {
            stmt = con.createStatement(); // 연결한 db에 statement 객체의 인스턴스 생성
            String sql = "select * from product"; // 실행할 sql문 작성
            rslt = stmt.executeQuery(sql); // 조회(SELECT) 전용 메서드, sql문을 실행하도록 Statement에 전달하면 ResultSet반환
            System.out.println("---------------전체 상품 정보 조회---------------");
            while (rslt.next()){ // 행이 존재할 때까지 반복 수행
                // 테이블에 정의된 타입, 명칭 이용해서 데이터 가져오기
                String PRDNO = rslt.getString("PRDNO");
                String PRDNAME = rslt.getString("PRDNAME");
                int PRDPRICE = rslt.getInt("PRDPRICE");
                String PRDMAKER = rslt.getString("PRDMAKER");
                String PRDCOLOR = rslt.getString("PRDCOLOR");
                int CTGNO = rslt.getInt("CTGNO");
                // 데이터 출력
                System.out.format("%-3s\t %-20s\t %-10d %10s %10s \t%3d\n",
                                    PRDNO,PRDNAME,PRDPRICE,PRDMAKER,PRDCOLOR,CTGNO);
            }
            // 사용한 객체 삭제 - 역순으로
            rslt.close();
            stmt.close();
            con.close();
        } catch (SQLException e){ // 예외 처리
            System.err.println("오류 발생 " + e.getMessage());
            e.printStackTrace();
        }
    }
}
