package game_project.interfaces.user;

import game_project.user.UserDTO;

public interface AccountInterface {
  public boolean userLogin(String id, String pw);
  public void logout();
  public UserDTO signup(UserDTO newUser);  
}
