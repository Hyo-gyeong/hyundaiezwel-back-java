package oopClass.sec04;

import java.text.DecimalFormat;

public class Product {
  private String prdName;
  private int prdPrice;
  private int prdSold;
  private int prdStock;

  public void inputPrdInfo(String name, int price, int sold, int stock){
    this.prdName = name;
    this.prdPrice = price;
    this.prdSold = sold;
    this.prdStock = stock;
  }

  public void showSalesAmount(){
    DecimalFormat df = new DecimalFormat("#,###");
    System.out.println("매출액 : " + df.format(this.prdPrice * this.prdSold));
  }

  public void showStockAmount(){
    DecimalFormat df = new DecimalFormat("#,###");
    System.out.println("재고액 : " + df.format(this.prdPrice * this.prdStock));
  }

  public void showPrdInfo(){
    System.out.println("****상품 정보 출력****");
    String prdInfo = "상품명 : " + this.prdName + "\n" +
                      "가격 : " + this.prdPrice + "\n" +
                      "판매 수량 : " + this.prdSold + "\n" +
                      "재고 수량 : " + this.prdStock;
    System.out.println(prdInfo);
    showSalesAmount();
    showStockAmount();
  }
}
