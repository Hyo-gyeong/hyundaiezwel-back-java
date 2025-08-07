package oopClass.sec01;

// 사용자 정의 클래스 생성 : 개발자가 필요한 변수(필드/속성), 함수(메서드) 정의
// 데이터를 다루기 위한 변수 : 멤버변수
// 데이터를 조작하기 위한, 기능을 수행하기 위한 멤버 함수 : 멤버 메소드
public class Car {
  // 멤버변수, 데이터
  // private : 접근 제한자, 클래스 외부에서 변수가 있는지 모르게 숨겨놓는 것(데이터 은닉)
  private String carNo; // 자량번호
  private String carName; // 차종
  private String carMaker; // 제조사
  private int carYear; // 연식
  private int carCC; // 배기량

  // 멤버 메소드
  // (1) 직접 저장
  public void setCarInfo(String carNo, String carName, String carMaker){
    this.carNo = carNo;
    this.carName = carName;
    this.carMaker = carMaker;
  }

  // (2) 멤버 변수 값 출력
  public void showCarInfo(){
    System.out.println("차량 번호 " + carNo);
    System.out.println("차종 " + carName);
    System.out.println("제조사 " + carMaker);
  }

}
