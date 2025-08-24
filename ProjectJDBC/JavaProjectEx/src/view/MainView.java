package view;

import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        // 메뉴 구성
        Scanner sc = new Scanner(System.in); // System.in은 scanner 객체들끼리 공유해서 사용하는 stream
        int menuNum;

        do {
            System.out.println("===============도서관리 프로그램=============");
            System.out.println("1. 도서정보 등록");
            System.out.println("2. 도서정보 조회");
            System.out.println("3. 도서정보 수정");
            System.out.println("4. 도서정보 삭제");
            System.out.println("5. 종료");
            System.out.println("========================================");
            
            System.out.print("메뉴 번호 입력 : ");
            menuNum = Integer.parseInt(sc.nextLine());

            if (menuNum == 1){
                BookInsertView biv = new BookInsertView();
                biv.insert();
            }
            else if (menuNum == 2){
                BookListView blv = new BookListView();
                blv.getAllBook();
            }
            else if (menuNum == 3){
                BookUpdateView buv = new BookUpdateView();
                buv.updateBook();        
            }
            else if (menuNum == 4){
                BookDeleteView bdv = new BookDeleteView();
                bdv.delete();
            }
            else if (menuNum == 5){
                break;
            } else {   
                System.out.println("잘못 입력하였습니다.");
            }
        } while ((menuNum != 5));
        System.out.println("-------------------------");
        System.out.println("종료합니다");
        System.out.println("-------------------------");
        sc.close();
    }
}
