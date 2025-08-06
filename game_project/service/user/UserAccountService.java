package game_project.service.user;

import game_project.exception.UserException;
import game_project.interfaces.user.AccountInterface;
import game_project.print.AppPrint;
import game_project.user.UserDAO;
import game_project.user.UserDTO;
import game_project.validator.UserValidator;

// ## 핵심 로직은 service에서 구현 ##
public class UserAccountService implements AccountInterface{

  @Override
  public boolean userLogin(String id, String pw) {
    for (UserDTO user : UserDAO.userMap.values()){
      if (user.getId().equals(id) && user.getPw().equals(pw)){
        AppPrint.loginSueccess();
        return true;
      }
    }
    AppPrint.loginFail();
    return false;
  }
  @Override
  public UserDTO signup(UserDTO newUser) {
    UserDAO userDAO = new UserDAO();
    try{
      UserValidator.validateIfUserAlreadyExist(newUser);
      userDAO.addUser(newUser);
    }catch(UserException e){
      System.out.println(e.getMessage());
      return null;
    }
    return newUser;
  }
  
  @Override
  public void logout() {}
}
