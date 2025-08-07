package oopClass.sec08;

public class Car {
  private String carNo; // 자량번호
  private String carName; // 차종
  private String carMaker; // 제조사
  private int carYear; // 연식
  private int carCC; // 배기량

  // 생성자 오버로딩
  public Car() {}
  
  public Car(String no, String name, String maker){
    // this : 현재 클래스
    this.carNo = no;
    this.carName = name;
    this.carMaker = maker;
  }

  public void setCarInfo(String carNo, String carName, String carMaker, int year, int cc){
    this.carNo = carNo;
    this.carName = carName;
    this.carMaker = carMaker;
    this.carYear = year;
    this.carCC = cc;
  }

  // (2) 멤버 변수 값 출력
  public void showCarInfo(){
    System.out.println("차량 번호 " + carNo);
    System.out.println("차종 " + carName);
    System.out.println("제조사 " + carMaker);
  }

}
