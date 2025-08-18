package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import interfaces.user.UserDAOInterface;
import util.DBConnect;

// ## DAO에서는 DB관련 작업만 수행 ##
public class UserDAO implements UserDAOInterface{
  Connection connection = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  @Override
  public boolean addUser(UserDTO u) throws Exception {
    try {
      connection = DBConnect.getConnection();
      String sql = "insert into account (userid, name, userpw) values (?,?,?)";
      pstmt = connection.prepareStatement(sql);
      pstmt.setString(1, u.getId());
      pstmt.setString(2, u.getName());
      pstmt.setString(3, u.getPw());
      int rslt = pstmt.executeUpdate();
      if (rslt >= 0){
        return true;
      }
    } catch (Exception e){
      throw e;
    }
    return false;
  }

  @Override
  public String getUserPK(String userId) throws Exception{
    try {
      connection = DBConnect.getConnection();
      String sql = "select * from account where userid=?";
      pstmt = connection.prepareStatement(sql);
      pstmt.setString(1, userId);
      rs = pstmt.executeQuery();
      if (rs.next()){
        return rs.getString("id");
      }
    } catch (Exception e){
      throw e;
    }
    return "";
  }

  @Override
  public boolean deleteUser(String userPK) throws Exception{
     try {
      connection = DBConnect.getConnection();
      String sql = "delete from account where id=?";
      pstmt = connection.prepareStatement(sql);
      pstmt.setString(1, userPK);
      int rslt = pstmt.executeUpdate();
      if (rslt > 0){
        return true;
      }
     } catch (Exception e){
      throw e;
    } finally {
      DBConnect.close(connection, pstmt, rs);
    }
    return false;
  }

  @Override
  public boolean checkIfUserExists(UserDTO dto) throws Exception{
    try {
      connection = DBConnect.getConnection();
      String sql = "select * from account where userid=? and userpw=?";
      pstmt = connection.prepareStatement(sql);
      pstmt.setString(1, dto.getId());
      pstmt.setString(2, dto.getPw());
      rs = pstmt.executeQuery();
      if (rs.next()){
        return true;
      }
    } catch (Exception e){
      throw e;
    } finally {
      DBConnect.close(connection, pstmt, rs);
    }
    return false;
  }

  @Override
  public boolean login(String userId, int ifLogin) throws Exception{
    try {
      connection = DBConnect.getConnection();
      String sql = "update account set iflogin=? where userid=?";
      pstmt = connection.prepareStatement(sql);
      if (ifLogin == 0){
        pstmt.setInt(1, 1);
      } else {
        pstmt.setInt(1, 0);
      }
      pstmt.setString(2, userId);
      int rslt = pstmt.executeUpdate();
      if (rslt > 0){
        return true;
      }
    } catch (Exception e){
      throw e;
    }
    return false;
  }
  
  @Override
  public boolean logOut(String userPK, int ifLogin) throws Exception{
    try {
      connection = DBConnect.getConnection();
      String sql = "update account set iflogin=? where id=?";
      pstmt = connection.prepareStatement(sql);
      if (ifLogin == 0){
        pstmt.setInt(1, 1);
      } else {
        pstmt.setInt(1, 0);
      }
      pstmt.setString(2, userPK);
      int rslt = pstmt.executeUpdate();
      if (rslt > 0){
        return true;
      }
    } catch (Exception e){
      throw e;
    }
    return false;
  }
  
}
