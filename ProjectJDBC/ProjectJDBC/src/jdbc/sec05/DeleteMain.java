package jdbc.sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain {
    public static void main(String[] args) {
        DBConnect dbCon = new DBConnect();
        Connection con = dbCon.getConnection();

        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("삭제할 도서 번호 입력 : ");
            String bookNo = sc.nextLine();

            String sql = "delete from book where bookNo=?";
            pstmt = con.prepareStatement(sql); // delete book 처럼 바인딩이 없는 sql도 들어가도 됨
            pstmt.setString(1, bookNo);

            int result = pstmt.executeUpdate();
            if (result == 0){
                System.out.println("삭제된 도서가 없습니다.");
            } else{
                System.out.println("도서 삭제 성공!");
            }
            DBConnect.close(con, pstmt);
        }catch(SQLException e){
            System.out.println("도서 삭제 실패!");
            e.printStackTrace();
        }

        sc.close();
    }
}
