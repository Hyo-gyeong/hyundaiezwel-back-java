package InterfacePackage.sec06;

public class MemberMain {
  public static void main(String[] args) {
    // DAO, DTO 활용 예제
    // 회원가입을 위한 데이터가 전달되었다고 가정
    MemberDTO mDto = new MemberDTO("abcd", "1234", "김절수", "010-1234-1234", "서울");

    // DAO에게 전달해서 회원가입 메서드가 실행되어야 함
    // 인터페이스를 이용할 수도 있고 - 더 많이 사용
    IMemberDAO iDao = new MemberDAO();
    // 직접 접근도 가능
    MemberDAO mDao = new MemberDAO();

    iDao.insertMember(mDto);
    mDao.insertMember(mDto);

    // 회원검색
    MemberDTO getDTO = iDao.selectMember("123");
    // 검색 결과를 view로 넘겨서 클라이언트에게 전달
  }
}
