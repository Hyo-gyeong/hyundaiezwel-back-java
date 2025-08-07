package oopClass.sec10;

public class ReservationEx {
  public static void main(String[] args) {
    Reservation rsv = new Reservation();
    rsv.showResvInfo();
    
    Reservation rsv1 = new Reservation("JE1928J", "이몽룡", "인천", "홍콩", 1200000, "B12");
    rsv1.showResvInfo();
  }
}
