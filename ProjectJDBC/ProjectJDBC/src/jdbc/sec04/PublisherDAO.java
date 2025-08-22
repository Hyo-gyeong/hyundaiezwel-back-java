package jdbc.sec04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PublisherDAO {
    Connection connection = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    PublisherDTO pubDTO = null;
    ArrayList<PublisherDTO> pubList = new ArrayList<>();

    public ArrayList<PublisherDTO> getAllPublisher(){
        try {
            connection = DBConnect.getConnection();
            String sql = "select * from publisher";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                String pubNo = rs.getString(1);
                String pubName = rs.getString(2);
                pubDTO = new PublisherDTO(pubNo, pubName);
                pubList.add(pubDTO);
            }
            DBConnect.close(pstmt, rs);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return pubList;
    }
}
