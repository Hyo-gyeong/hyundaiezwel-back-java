package interfaces.user;

import user.UserDTO;

public interface AccountInterface {
  public String login(String id, String pw);
  public boolean logout(String userPK);
  public void signup(UserDTO newUser);  
  public boolean unregister(String userId);
}
