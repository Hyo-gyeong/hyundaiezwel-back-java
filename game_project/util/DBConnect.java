package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
    // 데이터베이스 연결 후
    // connection 객체 반환하는 메소드
    public static Connection getConnection(){
        Connection con = null; // connection객체 초기화

        try{
            // Class.forName("oracle.jdbc.driver.OracleDriver"); //  JDBC 4.0 이상에서는 DriverManager가 자동 로드 하므로 생략 가능
            String url = "jdbc:oracle:thin:@localhost:1521:xe"; // db 연결 주소
            String user = "C##SQL_USER"; // db 연결 계정
            String pwd = "1234"; // db 연결 비번

            con = DriverManager.getConnection(url, user, pwd); // 계정 정보를 이용해서 connection 객체 생성

            if (con != null){ // connection 객체가 null값이 아니어야 성공
                System.out.println("DB 연결 성공!");
            } else {
                System.out.println("DB 연결 실패!");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return con; // connection 객체 반환
    }

    public static void close(Connection con, PreparedStatement pstmt){
        try{
            if (con != null){
                con.close();
            }
            if (pstmt != null){
                pstmt.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(Connection con, PreparedStatement pstmt, ResultSet rs){
        try{
            if (con != null){
                con.close();
            }
            if (pstmt != null){
                pstmt.close();
            }
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement pstmt, ResultSet rs){
        try{
            if (pstmt != null){
                pstmt.close();
            }
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement pstmt){
        try{
            if (pstmt != null){
                pstmt.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
