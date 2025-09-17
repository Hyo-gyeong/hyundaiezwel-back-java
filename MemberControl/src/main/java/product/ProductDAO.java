package product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public ProductDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			System.out.println("DB연결");
		} catch (Exception e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
		}
	}
	
	// 전체 물품 정보 반환 : select
	public ArrayList<ProductVO> listProducts(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ProductVO> prdList = new ArrayList<>();
		
		try {
			con = dataFactory.getConnection();
			String query = "select * from product";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
			    ProductVO vo = new ProductVO();
			    vo.setPrdNo(rs.getString("prdno"));
			    vo.setPrdName(rs.getString("prdname"));
			    vo.setPrdPrice(rs.getInt("prdprice"));
			    vo.setPrdMaker(rs.getString("prdmaker"));
			    vo.setPrdColor(rs.getString("prdcolor"));
			    vo.setCtgNo(rs.getInt("ctgno"));
			    
			    prdList.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("물품 조회 실패");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return prdList;
	}
	
	// 물품 등록 : insert
    public void addProduct(ProductVO p) {
        try {
            conn = dataFactory.getConnection();
            String query = "INSERT INTO product (prdno, prdname, prdprice, prdmaker, prdcolor, ctgno) VALUES (?, ?, ?, ?, ?, ?)";
            System.out.println(query);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, p.getPrdNo());
            pstmt.setString(2, p.getPrdName());
            pstmt.setInt(3, p.getPrdPrice());
            pstmt.setString(4, p.getPrdMaker());
            pstmt.setString(5, p.getPrdColor());
            pstmt.setInt(6, p.getCtgNo());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 물품 정보 검색 : select where 
    public ProductVO findProduct(String prdNo) {
        ProductVO prdInfo = null;
        try {
            conn = dataFactory.getConnection();
            String query = "SELECT * FROM product WHERE prdno = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, prdNo);
            System.out.println(query);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String no = rs.getString("prdno");
                String name = rs.getString("prdname");
                int price = rs.getInt("prdprice");
                String maker = rs.getString("prdmaker");
                String color = rs.getString("prdcolor");
                int ctgNo = rs.getInt("ctgno");

                prdInfo = new ProductVO(no, name, price, maker, color, ctgNo);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prdInfo;
    }

    // 물품 정보 수정 : update
    public void modProduct(ProductVO p) {
        try {
            conn = dataFactory.getConnection();
            String query = "UPDATE product SET prdname=?, prdprice=?, prdmaker=?, prdcolor=?, ctgno=? WHERE prdno=?";
            System.out.println(query);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, p.getPrdName());
            pstmt.setInt(2, p.getPrdPrice());
            pstmt.setString(3, p.getPrdMaker());
            pstmt.setString(4, p.getPrdColor());
            pstmt.setInt(5, p.getCtgNo());
            pstmt.setString(6, p.getPrdNo());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 물품 정보 삭제 : delete
    public void delProduct(String prdNo) {
        try {
            conn = dataFactory.getConnection();
            String query = "DELETE FROM product WHERE prdno = ?";
            System.out.println(query);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, prdNo);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
