package model;

import java.util.Vector; // List 인터페이스를 상속받는 컬렉션 프레임워크

// DAO 오류 발생 시 controller에게 예외 throw
public interface IBookDAO {
    public Vector<BookDTO> getAllBook() throws Exception; // 전체 도서 정보 조회
    public boolean insert(BookDTO dto) throws Exception;
    public boolean update(BookDTO dto) throws Exception;
    public boolean delete(BookDTO dto) throws Exception;
}
