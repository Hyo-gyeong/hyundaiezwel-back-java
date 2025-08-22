package jdbc.sec04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class BookDAO implements IBookDAO{
    Connection connection = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    BookDTO bookDTO = null;
    ArrayList<BookDTO> bookList = new ArrayList<>();

    public BookDAO(){
        connection = DBConnect.getConnection(); 
    }

    @Override
    public ArrayList<BookDTO> getAllBooks() {
        try {
            String sql = "select * from book";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                String bookNo = rs.getString(1);
                String bookName = rs.getString(2);
                String bookAuthor = rs.getString(3);
                int bookPrice = rs.getInt(4);
                Date bookDate = rs.getDate(5);
                int bookStock = rs.getInt(6);
                String pubNo = rs.getString(7);
                bookDTO = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
                bookList.add(bookDTO);
            }
            DBConnect.close(pstmt, rs);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public ArrayList<BookDTO> findBookByName(String bookName) {
        try {
            String sql = "select b.bookno, b.bookname, b.bookauthor, b.bookprice, b.bookdate, b.bookstock, p.pubno, p.pubname "+
                            "from book b, publisher p "+
                            "where bookName=? and b.pubno=p.pubno";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, bookName);
            rs = pstmt.executeQuery();
            while (rs.next()){
                String bookNo = rs.getString(1);
                bookName = rs.getString(2);
                String bookAuthor = rs.getString(3);
                int bookPrice = rs.getInt(4);
                Date bookDate = rs.getDate(5);
                int bookStock = rs.getInt(6);
                String pubNo = rs.getString(7);
                String publisher = rs.getString(8);
                bookDTO = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo, publisher);
                bookList.add(bookDTO);
            }
            DBConnect.close(pstmt, rs);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public BookDTO findBookById(String bookNo) {
        try {
            String sql = "select b.bookno, b.bookname, b.bookauthor, b.bookprice, b.bookdate, b.bookstock, p.pubno, p.pubname "+
                            "from book b, publisher p "+
                            "where b.bookno=? and b.pubno=p.pubno";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, bookNo);
            rs = pstmt.executeQuery();
            if (rs.next()){
                bookNo = rs.getString(1);
                String bookName = rs.getString(2);
                String bookAuthor = rs.getString(3);
                int bookPrice = rs.getInt(4);
                Date bookDate = rs.getDate(5);
                int bookStock = rs.getInt(6);
                String pubNo = rs.getString(7);
                String publisher = rs.getString(8);
                bookDTO = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo, publisher);
            }
            DBConnect.close(pstmt, rs);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return bookDTO;
    }

    @Override
    public void updateBook(BookDTO bookDTO) {
        try {
            String sql = "update book set bookName=?, bookPrice=?, bookDate=?, pubNo=?, bookauthor=?, bookstock=? where bookNo=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, bookDTO.getBookName());
            pstmt.setInt(2, bookDTO.getBookPrice());
            pstmt.setDate(3, new java.sql.Date(bookDTO.getBookDate().getTime()));
            pstmt.setString(4, bookDTO.getPubNo());
            pstmt.setString(5, bookDTO.getBookAuthor());
            pstmt.setInt(6, bookDTO.getBookStock());
            pstmt.setString(7, bookDTO.getBookNo());
            int rslt = pstmt.executeUpdate();
            if (rslt == 0){
                System.out.println("수정된 도서가 없습니다.");
            } else {
                System.out.println("수정되었습니다.");
            }
            DBConnect.close(pstmt, rs);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBookByName(String bookName) {
        try {
            String sql = "delete from book where bookName=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, bookName);
            int rslt = pstmt.executeUpdate();
            if (rslt == 0){
                System.out.println("삭제할 도서가 없습니다.");
            } else {
                System.out.println(rslt+"권의 도서가 삭제되었습니다.");
            }
            DBConnect.close(pstmt, rs);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBookById(String bookNo) {
        try {
            String sql = "delete from book where bookNo=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, bookNo);
            pstmt.executeUpdate();
            DBConnect.close(pstmt, rs);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void addBook(BookDTO bookDTO) {
        try {
            String sql = "insert into book values (?,?,?,?,?,?,?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, bookDTO.getBookNo());
            pstmt.setString(2, bookDTO.getBookName());
            pstmt.setString(3, bookDTO.getBookAuthor());
            pstmt.setInt(4, bookDTO.getBookPrice());
            pstmt.setDate(5, new java.sql.Date(bookDTO.getBookDate().getTime()));
            pstmt.setInt(6, bookDTO.getBookStock());
            pstmt.setString(7, bookDTO.getPubNo());
            int rslt = pstmt.executeUpdate();
            if (rslt > 0){
                System.out.println("도서가 추가되었습니다.");
            }
            DBConnect.close(pstmt, rs);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
