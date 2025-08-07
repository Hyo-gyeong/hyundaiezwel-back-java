package oopClass.sec09;

public class BookMain {
  public static void main(String[] args) {
    // 객체 인스턴스 생성
    Book book = new Book("Java", "홍길동", 20000);
    Book book1 = new Book();
    
    book.show();
    book1.show();
  }
}
