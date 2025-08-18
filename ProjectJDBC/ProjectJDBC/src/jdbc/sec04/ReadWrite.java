package jdbc.sec04;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReadWrite {
    public static BookDTO readBookInfo(Scanner sc){
        System.out.println("추가할 도서 정보를 입력하세요");
        BookDTO dto = null;
        PublisherDAO pubDAO = new PublisherDAO();
        try {
            System.out.print("도서 번호 입력 : ");
            String bookNo = sc.nextLine();
            
            System.out.print("도서명 입력 : ");
            String bookName = sc.nextLine();

            System.out.print("도서 가격 입력 : ");
            int bookPrice = Integer.parseInt(sc.nextLine());

            System.out.print("도서 출간일 입력 : ");
            String strDate = sc.nextLine();
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-mm-dd");
            Date bookDate = fm.parse(strDate);

            writeAllPublisher(pubDAO.getAllPublisher());
            System.out.print("출판사 번호 입력 : ");
            String pubNo = sc.nextLine();

            dto = new BookDTO(bookNo, bookName, bookPrice, bookDate, pubNo);
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return dto;
    }
    
    public static void writeAllBooks(ArrayList<BookDTO> bookList){
        System.out.println("************전체 도서 정보************");
        for (BookDTO book : bookList){
            String bookNo = book.getBookNo();
            String bookName = book.getBookName();
            int bookPrice = book.getBookPrice();
            Date bookDate = book.getBookDate();
            String pubNo = book.getPubNo(); 
        }
    }
    
    public static BookDTO searchBookById(Scanner sc){
        
    }

    public static ArrayList<BookDTO> searchBookByName(String bookName){
        
    }

    public static BookDTO searchBookByBookNo(String bookNo){
        
    }
    
    private static void writeAllPublisher(ArrayList<PublisherDTO> pubList){
        System.out.println("출판사 목록");
        System.out.println("-------------------------------");
        for (PublisherDTO dto : pubList){
            System.out.println("출판사 번호 : " + dto.getPubNo() + ", 출판사명 : " + dto.getPubName());
        }
        System.out.println("-------------------------------");
    }
    System.out.format("%-3s\t %-20s\t %-10d %10s %10s \t%3d\n",
                                    PRDNO,PRDNAME,PRDPRICE,PRDMAKER,PRDCOLOR,CTGNO);
}
