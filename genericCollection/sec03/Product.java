package genericCollection.sec03;

public class Product<T, M> { // 제네릭 클래스 생성
  private T kind; // 결정은 안된 type
  private M model; // 결정 안된 type

  public T getKind() {
    return this.kind;
  }

  public M getModel(){
    return this.model;
  }

  public void setKind(T kind) {
    this.kind = kind;
  }

  public void setModel(M model) {
    this.model = model;
  }
  
}
