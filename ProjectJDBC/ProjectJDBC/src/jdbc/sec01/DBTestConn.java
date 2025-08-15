package jdbc.sec01;

import java.sql.Connection; // db연결 클래스
import java.sql.DriverManager; // jdbc driver 사용 클래스

public class DBTestConn {
public static void main(String[] args) {
    // DB연결 test
    Connection con = null;
    // 외부 서버 사용이므로 try-catch로 예외처리 필수 - (외부장치인) sql 대부분의 메소드는 throw처리가 되어있음
    try{
        // 1. Driver 로드 : Runtime시 로드됨 (자동로드 : 생략 가능)
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // db 연결을 위한 주소, 사용자 계정, 비밀번호 - 문자열로 전달
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "USER_SELECT";
        String pwd = "1234";

        // db 연결 시도 후 연결 확립을 위한 객체 생성
        // DriverManager가 클래스를 통해 연결을 위한 Connection객체를 생성해서 반환
        con = DriverManager.getConnection(url, user, pwd);

        // Connection 객체가 생성되면(null이 아니면) db 연결 성공
        if (con != null){
            System.out.println("DB 연결 성공!");
        }else {
            System.out.println("DB 연결 실패!");
        }
    }catch(Exception e){
        e.printStackTrace();
    }
}
}
