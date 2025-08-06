package game_project.validator;

import game_project.exception.UserException;
import game_project.user.UserDAO;
import game_project.user.UserDTO;

// ## validator에서는 오직 간단한 검증만 수행 ##
public class UserValidator {
  public static void validateIfUserAlreadyExist(UserDTO newUser) throws UserException{
    for (UserDTO user : UserDAO.userMap.values()){
      if (user.getId().equals(newUser.getId()) && user.getName().equals(newUser.getName())){
        throw new UserException("이미 존재하는 id와 name의 사용자입니다.");
      }
    }
  }
}
