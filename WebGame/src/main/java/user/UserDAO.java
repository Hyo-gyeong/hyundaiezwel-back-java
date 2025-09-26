package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO implements UserDAOInterface {
	private DataSource dataFactory;
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
    public UserDAO(){
        try{
            Context context = new InitialContext();
            Context envContext = (Context) context.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
            System.out.println("DB 연결 성공!");
           
        } catch (Exception e){
        		System.out.println("DB 연결 실패!");
            e.printStackTrace();
        }
    }

	@Override
	public boolean addUser(UserDTO u) throws Exception {
		try {
			connection = dataFactory.getConnection();
			// id가 문자열 타입이어서 10 < 9 인 경우가 생기므로 TO_NUMBER로 타입 변환
			String sql = "select MAX(TO_NUMBER(id)) AS maxId from account";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int maxId = 0;
			if (rs.next()) {  // 커서를 첫 행으로 이동
			    maxId = rs.getInt("maxId")+1; 
			}
			System.out.println(maxId);
			
			sql = "insert into account (id, userid, userpw, name) values (?,?,?,?)"; // iflogin은 0
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(maxId));
			pstmt.setString(2, u.getUserId());
			pstmt.setString(3, u.getName());
			pstmt.setString(4, u.getPw());
			int rslt = pstmt.executeUpdate();
			if (rslt >= 0) {
				System.out.println("insert 성공");
				return true;
			}
		} catch (Exception e) {
			throw e;
		}
		return false;
	}

	@Override
	public String getUserName(String userId) throws Exception {
		try {
			connection = dataFactory.getConnection();
			String sql = "select name from account where userid=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("name");
			}
		} catch (Exception e) {
			throw e;
		}
		return "";
	}

	@Override
	public boolean deleteUser(String userPK) throws Exception {
		try {
			connection = dataFactory.getConnection();
			String sql = "delete from account where id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userPK);
			int rslt = pstmt.executeUpdate();
			if (rslt > 0) {
				return true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(connection, pstmt, rs);
		}
		return false;
	}

	@Override
	public boolean checkIfUserExists(String id) throws Exception {
		try {
			connection = dataFactory.getConnection();
			String sql = "select * from account where userid=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(connection, pstmt, rs);
		}
		return false;
	}
	
	@Override
	public boolean checkIfUserLogin(UserDTO dto) throws Exception {
		try {
			connection = dataFactory.getConnection();
			String sql = "select * from account where iflogin=1";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(connection, pstmt, rs);
		}
		return false;
	}

	@Override
	public boolean login(String userId, String pw) throws Exception {
		try {
			connection = dataFactory.getConnection();
			String sql = "update account set iflogin=1 where userid=? and userpw=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, pw);
			int rslt = pstmt.executeUpdate();
			if (rslt > 0) {
				return true;
			}
		} catch (Exception e) {
			throw e;
		}
		return false;
	}

	@Override
	public boolean logOut(String userPK) throws Exception {
		try {
			connection = dataFactory.getConnection();
			String sql = "update account set iflogin=0 where userid=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userPK);
			int rslt = pstmt.executeUpdate();
			if (rslt > 0) {
				return true;
			}
		} catch (Exception e) {
			throw e;
		}
		return false;
	}
	
	public static void close(PreparedStatement pstmt, ResultSet rs){
        try{
            if (pstmt != null){
                pstmt.close();
            }
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs){
        try{
            if (con != null){
                con.close();
            }
            if (pstmt != null){
                pstmt.close();
            }
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
