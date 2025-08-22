package jdbc.sec04;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();
        String bookName;
        String bookNo;
        int choice;
        do {
            System.out.println("---------------메뉴---------------");
            System.out.println("1. 전체 도서 정보 조회\n" + 
                                "2. 도서 정보 등록\n" +
                                "3. 도서명으로 도서 정보 조회\n" +
                                "4. 도서명으로 도서 삭제\n" +
                                "5. 도서 정보 수정\n"+
                                "6. 프로그램 종료");
            System.out.print("메뉴 선택 : ");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1){ // 전체 도서 정보 조회
                ReadWrite.writeAllBooks(dao.getAllBooks());
            } else if (choice == 2){ // 도서 정보 등록
                dao.addBook(ReadWrite.readBookInfo(sc));
            } else if (choice == 3){ // 도서명으로 도서 정보 조회
                System.out.print("조회할 도서명을 입력하세요 : ");
			    bookName = sc.nextLine();
                ReadWrite.writeAllBookDetail(dao.findBookByName(bookName));
            } else if (choice == 4){
                System.out.print("삭제할 도서명을 입력하세요 : ");
			    bookName = sc.nextLine();
                dao.deleteBookByName(bookName);
            } else if (choice == 5){
                ReadWrite.writeAllBooks(dao.getAllBooks());
                System.out.print("수정할 도서의 번호를 입력하세요 : ");
                bookNo = sc.nextLine();
                dao.updateBook(ReadWrite.readBookInfo(sc));
            } else if (choice == 6){
                System.out.println("프로그램이 종료됩니다.");
                break;
            } else {
                System.out.println("입력이 잘못되었습니다.");
            }
        } while (choice != 7);

        sc.close();
    }
}
