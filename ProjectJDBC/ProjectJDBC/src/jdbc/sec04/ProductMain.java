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
                                "5. 도서 번호로 도서 삭제\n"+
                                "6. 도서 정보 수정\n"+
                                "7. 프로그램 종료");
            System.out.print("메뉴 선택 : ");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1){ // 전체 도서 정보 조회
                ReadWrite.writeBook(sc);
            } else if (choice == 2){ // 도서 정보 등록
                dao.addBook(ReadWrite.writeBook(sc));
            } else if (choice == 3){ // 도서명으로 도서 정보 조회
                System.out.print("조회할 도서명을 입력하세요 : ");
			    bookName = sc.nextLine();
                ReadWrite.writeStdInfo(dao.findBookByName(bookName));
            } else if (choice == 4){
                System.out.print("삭제할 학생의 학번을 입력하세요 : ");
			    stdNo = sc.nextLine();
                dao.deleteStudent(stdNo);
            } else if (choice == 5){
                System.out.print("수정할 학생의 학번을 입력하세요 : ");
			    stdNo = sc.nextLine();
                dao.updateStudent(ReadWrite.getStdInfo(sc));
            } else if (choice == 6){
                System.out.print("검색할 학생의 학과 이름을 입력하세요 : ");
                dptName = sc.nextLine();
                ReadWrite.writeStdInfo(dao.searchStudent(dptName));
            } else if (choice == 7){
                System.out.println("프로그램이 종료됩니다.");
            } else {
                System.out.println("입력이 잘못되었습니다.");
            }
        } while (choice != 7);

        sc.close();
    }
}
