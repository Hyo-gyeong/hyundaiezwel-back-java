package interfaces.user;

import user.UserDTO;

public interface UserDAOInterface {
  public boolean addUser(UserDTO u) throws Exception;
  public boolean deleteUser(String userId) throws Exception;
  public boolean checkIfUserExists(UserDTO dto) throws Exception;
  public boolean login(String userId, int ifLogin) throws Exception;
  public boolean logOut(String userPK, int ifLogin) throws Exception;
  public String getUserPK(String userId) throws Exception;
}
