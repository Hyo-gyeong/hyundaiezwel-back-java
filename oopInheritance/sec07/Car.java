package oopInheritance.sec07;

public class Car {
  private String carNo;
  private String carName;
  private String carMaker;
  private int carYear;

  public Car(String no, String name, String maker, int year){
    this.carNo = no;
    this.carName = name;
    this.carMaker = maker;
    this.carYear = year;
  }

  @Override
  public String toString(){
    return "차량 번호 : " + this.carNo + "\n" +
            "차종 : " + this.carName + "\n" +
            "제조사 : " + this.carMaker + "\n" +
            "연식 : " + this.carYear;
  }
}
