package oopClass.sec09;

public class Book {
  String title;
  String author;
  int price;

  public Book(){
    // this.title = "자바스크립트"; 이렇게 하지 말고 아래 정의한 생성자 이용
    // this() : 생성자에서 다른 생성자를 호출할 수 있는 메소드
    this("자바스크립트", "이몽룡", 120000); // 아래 Book 메서드 호출, 매개변수로 생성자 구분
  }

  public Book(String t, String au, int p){
    title = t;
    author = au;
    price = p;
  }

  public void show() {
    System.out.println("도서명 : " + title);
    System.out.println("저자명 : " + author);
    System.out.println("가격 : " + price);
  }
}
