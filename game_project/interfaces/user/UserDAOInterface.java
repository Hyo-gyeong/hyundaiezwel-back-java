package game_project.interfaces.user;

import game_project.user.UserDTO;

public interface UserDAOInterface {
  public void addUser(UserDTO u);
  public void deleteUserByPK(int pk);
  public UserDTO getUserByPK(int pk);
  public void updateUser(int pk, UserDTO u);
}
