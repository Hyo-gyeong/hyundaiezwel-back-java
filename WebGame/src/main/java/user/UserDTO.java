package user;

public class UserDTO {
  private String pk;
  private String userId;
  private String name;
  private String pw;
  private int iflogin;

  public UserDTO(){}

  public UserDTO(String id, String name, String pw) {
    this.userId = id;
    this.name = name;
    this.pw = pw;
  }

  public UserDTO(String pk, String id, String name, String pw, int iflogin) {
    this.pk = pk;
    this.userId = id;
    this.name = name;
    this.pw = pw;
    this.iflogin = iflogin;
  }

  public String getPk() {
    return pk;
  }
  public void setPk(String pk) {
    this.pk = pk;
  }
  public String getUserId() {
    return userId;
  }
  public void setUserId(String id) {
    this.userId = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getPw() {
    return pw;
  }
  public void setPw(String pw) {
    this.pw = pw;
  }
  public int getIflogin() {
    return iflogin;
  }
  public void setIflogin(int iflogin) {
    this.iflogin = iflogin;
  }

  @Override
  public String toString(){
    return "사용자 정보:\n이름 : "+this.name+", id : "+this.userId;
  }
}
