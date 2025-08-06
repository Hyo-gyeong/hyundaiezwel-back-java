package game_project.user;

import java.util.HashMap;

import game_project.interfaces.user.UserDAOInterface;

// ## DAO에서는 DB관련 작업만 수행 ##
public class UserDAO implements UserDAOInterface{
  public static final HashMap<Integer, UserDTO> userMap = new HashMap<>();
  private static int pk;
  static {
    userMap.put(1, new UserDTO("user1", "hong", "hong123"));
    userMap.put(2, new UserDTO("user2", "kim", "kim123"));
    userMap.put(3, new UserDTO("user3", "lee", "lee123"));
    pk = 4;
  }

  public static int getPk() {
    return pk;
  }

  public static void setPk(int pk) {
    UserDAO.pk = pk;
  }
  
  @Override
  public void addUser(UserDTO newUser) {
    userMap.put(pk, newUser);
    setPk(pk+1);
  }

  @Override
  public void deleteUserByPK(int pk) {
    userMap.remove(pk);
  }

  @Override
  public UserDTO getUserByPK(int pk) {
    return userMap.get(pk);
  }

  @Override
  public void updateUser(int pk, UserDTO newUser) {
    userMap.remove(pk);
    userMap.put(pk, newUser);
  }
}
