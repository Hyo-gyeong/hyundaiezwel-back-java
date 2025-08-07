package oopClass.sec10;

public class Reservation {
  private String airplane;
  private String person;
  private String departure;
  private String destination;
  private int price;
  private String seatNum;

  public Reservation(){
    this("unkown", "unkown", "unkown", "unkown", 0, "unkown");
  }

  public Reservation(String airplane, String person, String departure, String destination, int price, String seatNum){
    this.airplane = airplane;
    this.person = person;
    this.departure = departure;
    this.destination = destination;
    this.price = price;
    this.seatNum = seatNum;
  }

  public void showResvInfo(){
    System.out.println("**항공권 예약 정보**");
    String rsvInfo = "항공기 : " + this.airplane + "\n" +
                      "예약자 : " + this.person + "\n" +
                      "출발지 : " + this.departure + "\n" +
                      "도착지 : " + this.destination + "\n" +
                      "금액 : " + this.price + "\n" +
                      "좌석번호 : " + this.seatNum;
    System.out.println(rsvInfo);
  }
}
