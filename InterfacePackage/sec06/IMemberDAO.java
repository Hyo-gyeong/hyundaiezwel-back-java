package InterfacePackage.sec06;

import java.util.ArrayList;

// 쇼핑몰에서 회원관리를 위한 DAO 인터페이스

// ## 회원관리 기능
// 1. 회원가입 : 한 명의 회원 정보를 받아서 DB에 저장. return x
// 2. 회원탈퇴 : 한 명의 회원 memId를 전달받아서 DB에서 해당 회원을 찾아서 삭제하고 종료. return x
// 3. 회원정보검색 : 한 명의 회원 id를 받아서 DB에서 해당 회원 정보를 검색하고 검색된 결과 반환. return o
// 4. 회원정보 수정 : 한 명의 회원 수정정보를 포함해서 모든 정보를 전달 받아 DB에서 해당 회원 id를 이용해 수정. return x
// ## 관리자 기능
// 1. 회원전체조회 : DB 회원 테이블에서 전체 회원 정보 검색 및 반환. 매개변수 x, return o
// 2. 회원이름으로 조회 : 이름을 전달받아 DB 회원 테이블에서 일치하는 회원 정보 검색 및 반환. 매개변수 o, return o
public interface IMemberDAO {

  // 1. 회원가입
  public void insertMember(MemberDTO memberDTO);
  
  // 2. 회원탈퇴 - id필요
  public void deleteMember(String id);

  // 3. 회원정보 검색
  public MemberDTO selectMember(String id);

  // 4. 회원정보 수정 - 일부만 변경하는건 비효율적, 모든 정보를 전달받아서 통째로 업데이트
  public void updateMember(MemberDTO memberDTO);

  // 5. 전체 회원 정보 검색 - Collection에 담아서 반환
  public ArrayList<MemberDTO> getAllMember();

  // 6. 이름의 일부 문자열과 이름이 매칭되는 회원들을 검색해서 반환 - 0~n -> n을 대비, 0이면 return null
  public ArrayList<MemberDTO> getNameMember(String name);
}
