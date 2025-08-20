package controller.user;

import interfaces.user.AccountInterface;
import user.UserDAO;
import user.UserDTO;

// ## 핵심 로직은 service에서 구현 ##
public class AccountController implements AccountInterface{
  private UserDAO dao = new UserDAO();
  @Override
  public String login(String id, String pw) {
    try {
      UserDTO dto = new UserDTO(null, id, null, pw, 0);
      boolean rslt = dao.checkIfUserExists(dto); // 사용자 존재 확인
      if (rslt){ 
        if (dao.login(dto.getId(), dto.getIflogin())){ // 로그인 상태로 변경
          System.out.println("로그인 되었습니다.");
          return dao.getUserPK(id);
        } else {
          System.out.println("로그인에 실패했습니다.");
        }
      } else {
        System.out.println("존재하지 않는 사용자입니다.");
      }
    } catch (Exception e){
      e.printStackTrace();
    }
    return "";
  }
  
  @Override
  public boolean logout(String userPK) {
    try {
      boolean rslt = dao.logOut(userPK, 1);
      return rslt;
    } catch (Exception e){
      e.printStackTrace();
      System.out.println("로그아웃 실패");
    }
    return false;
  }

  @Override
  public void signup(UserDTO inputUser) {
    try {
      UserDTO newUser = new UserDTO();
      newUser.setId(inputUser.getId());
      newUser.setName(inputUser.getName());
      newUser.setPw(inputUser.getPw());
      boolean rslt = dao.addUser(newUser);
    } catch (Exception e){
      e.printStackTrace();
      System.out.println("중복된 아이디입니다.");
    }
  }

  @Override
  public boolean unregister(String userPK){
    try {
      boolean rslt = dao.deleteUser(userPK);
      return rslt;
    } catch (Exception e){
      e.printStackTrace();
      System.out.println("회원 탈퇴에 실패했습니다.");
    }
    return false;
  }
}
