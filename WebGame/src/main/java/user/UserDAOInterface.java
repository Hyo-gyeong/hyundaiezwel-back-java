package user;

import user.UserDTO;

public interface UserDAOInterface {
  public boolean addUser(UserDTO u) throws Exception;
  public boolean deleteUser(String userId) throws Exception;
  public boolean checkIfUserExists(String id) throws Exception;
  public boolean login(String userId, String pw) throws Exception;
  public boolean logOut(String userPK) throws Exception;
  public String getUserName(String userId) throws Exception;
  boolean checkIfUserLogin(UserDTO dto) throws Exception;
}
