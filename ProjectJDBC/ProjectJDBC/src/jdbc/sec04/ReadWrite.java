package jdbc.sec04;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReadWrite {
    public static BookDTO readBookInfo(Scanner sc){
        System.out.println("도서 정보를 입력하세요");
        BookDTO dto = null;
        PublisherDAO pubDAO = new PublisherDAO();
        try {
            System.out.print("도서 번호 입력 : ");
            String bookNo = sc.nextLine();
            
            System.out.print("도서명 입력 : ");
            String bookName = sc.nextLine();

            System.out.print("저자명 입력 : ");
            String bookAuthor = sc.nextLine();

            System.out.print("도서 가격 입력 : ");
            int bookPrice = Integer.parseInt(sc.nextLine());

            System.out.print("도서 재고 수량 입력 : ");
            int bookStock = Integer.parseInt(sc.nextLine());

            System.out.print("도서 출간일 입력 : ");
            String strDate = sc.nextLine();
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-mm-dd");
            Date bookDate = fm.parse(strDate);

            writeAllPublisher(pubDAO.getAllPublisher());
            System.out.print("출판사 번호 입력 : ");
            String pubNo = sc.nextLine();

            dto = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return dto;
    }
    
    public static void writeAllBooks(ArrayList<BookDTO> bookList){
        System.out.println("************전체 도서 정보************");
        // 헤더
        System.out.printf("%-8s %-15s %-15s %8s %-10s %8s %-8s%n",
            "BOOKNO", "BOOKNAME", "BOOKAUTHOR", "BOOKPRICE", "BOOKDATE", "BOOKSTOCK", "PUBNO");

        for (BookDTO book : bookList){
            String bookNo = book.getBookNo();
            String bookName = book.getBookName();
            int bookPrice = book.getBookPrice();
            Date bookDate = book.getBookDate();
            String pubNo = book.getPubNo(); 
            String bookAuthor = book.getBookAuthor();
            int bookStock = book.getBookStock();
            // 데이터
            System.out.printf("%-8s %-15s %-15s %8d %-10s %8d %-8s%n",
                bookNo, bookName, bookAuthor, bookPrice, bookDate.toString(), bookStock, pubNo);
        }
    }
    
    public static void writeBookDetail(BookDTO book){
        System.out.println("************검색한 도서 정보************");
        // 헤더
        System.out.printf("%-8s %-15s %-15s %8s %-10s %8s %-8s%n %-8s",
            "BOOKNO", "BOOKNAME", "BOOKAUTHOR", "BOOKPRICE", "BOOKDATE", "BOOKSTOCK", "PUBNO", "PUBNAME");

        String bookNo = book.getBookNo();
        String bookName = book.getBookName();
        int bookPrice = book.getBookPrice();
        Date bookDate = book.getBookDate();
        String pubNo = book.getPubNo(); 
        String bookAuthor = book.getBookAuthor();
        int bookStock = book.getBookStock();
        String publisher = book.getPublisher();
        // 데이터
        System.out.printf("%-8s %-15s %-15s %8d %-10s %8d %-8s%n %-8s",
            bookNo, bookName, bookAuthor, bookPrice, bookDate.toString(), bookStock, pubNo, publisher);
    }
    
    public static void writeAllBookDetail(ArrayList<BookDTO> bookList){
        System.out.println("************검색한 도서 정보************");
        // 헤더
        System.out.printf("%-8s %-15s %-15s %8s %-10s %8s %-8s%n %-8s",
            "BOOKNO", "BOOKNAME", "BOOKAUTHOR", "BOOKPRICE", "BOOKDATE", "BOOKSTOCK", "PUBNO", "PUBNAME");
        for (BookDTO book : bookList){
            String bookNo = book.getBookNo();
            String bookName = book.getBookName();
            int bookPrice = book.getBookPrice();
            Date bookDate = book.getBookDate();
            String pubNo = book.getPubNo(); 
            String bookAuthor = book.getBookAuthor();
            int bookStock = book.getBookStock();
            String publisher = book.getPublisher();
            // 데이터
            System.out.printf("%-8s %-15s %-15s %8d %-10s %8d %-8s%n %-8s",
                bookNo, bookName, bookAuthor, bookPrice, bookDate.toString(), bookStock, pubNo, publisher);
        }
    }
    
    private static void writeAllPublisher(ArrayList<PublisherDTO> pubList){
        System.out.println("출판사 목록");
        System.out.println("-------------------------------");
        for (PublisherDTO dto : pubList){
            System.out.println("출판사 번호 : " + dto.getPubNo() + ", 출판사명 : " + dto.getPubName());
        }
        System.out.println("-------------------------------");
    }
    
}
