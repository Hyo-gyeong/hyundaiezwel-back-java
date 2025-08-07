package InterfacePackage.sec06;

// 데이터 교환에 사용될 클래스
// 회원관리에 사용할 예정 - 회원 한 명을 표현하는 클래스
// 필요 필드 : 회원가입시 받아야 할 정보 결정해서 생성
public class MemberDTO {
  // DTO의 멤버 필드명은 DB 테이블의 컬럼명과 일치시키는게 좋음
  // 가정 : Member table에 memId 구성
  private String memId;
  private String memPass;
  private String memName;
  private String memPhone;
  private String memAddress;

  // DTO는 대부분 생성자를 명시함
  public MemberDTO(String memId, String memPass, String memName, String memPhone, String memAddress) {
    this.memId = memId;
    this.memPass = memPass;
    this.memName = memName;
    this.memPhone = memPhone;
    this.memAddress = memAddress;
  }

  public String getMemId() {
    return memId;
  }

  public void setMemId(String memId) {
    this.memId = memId;
  }

  public String getMemPass() {
    return memPass;
  }

  public void setMemPass(String memPass) {
    this.memPass = memPass;
  }

  public String getMemName() {
    return memName;
  }

  public void setMemName(String memName) {
    this.memName = memName;
  }

  public String getMemPhone() {
    return memPhone;
  }

  public void setMemPhone(String memPhone) {
    this.memPhone = memPhone;
  }

  public String getMemAddress() {
    return memAddress;
  }

  public void setMemAddress(String memAddress) {
    this.memAddress = memAddress;
  }
  
}
