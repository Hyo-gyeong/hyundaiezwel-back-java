package genericCollection.sec10;

public class Product {
  private int prdNo;
  private String prdName;
  private int prdPrice;

  public Product(int prdNo, String prdName, int prdPrice) {
    this.prdNo = prdNo;
    this.prdName = prdName;
    this.prdPrice = prdPrice;
  }

  @Override
  public String toString(){
    return "상품 번호 : " +prdNo + "\n상품명 : " + prdName + "\n상품가격 : " + prdPrice;
  }

  public int getPrdNo() {
    return prdNo;
  }

  public void setPrdNo(int prdNo) {
    this.prdNo = prdNo;
  }

  public String getPrdName() {
    return prdName;
  }

  public void setPrdName(String prdName) {
    this.prdName = prdName;
  }

  public int getPrdPrice() {
    return prdPrice;
  }

  public void setPrdPrice(int prdPrice) {
    this.prdPrice = prdPrice;
  }  
}
