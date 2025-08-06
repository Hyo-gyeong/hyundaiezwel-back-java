package game_project.user;

import java.util.HashMap;

public interface UserDAOInterface {
  public static final HashMap<Integer, UserDTO> userMap = new HashMap<>();
  public void addUser(UserDTO u);
  public void deleteUserByPK(int pk);
  public UserDTO getUserByPK(int pk);
  public void updateUser(int pk, UserDTO u);
}
