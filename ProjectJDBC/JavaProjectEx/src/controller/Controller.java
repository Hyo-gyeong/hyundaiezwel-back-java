package controller;

import model.IBookDAO;
import view.BookListView;
import view.ResultView;

import java.util.Vector;

import model.BookDAO;
import model.BookDTO;

// View별로 컨트롤러 각각 구성해서 사용하면 DAO 접근 통로가 많아지고 DB 사용 제어가 불가능함
// 싱글톤으로 구성 : 단 하나만 객체 생성 - 공유해서 사용
public class Controller {
    // 본인 객체 인스턴스를 본인이 제공 - private static으로 객체 구성
    private static Controller instance = new Controller();

    private Controller(){
        // new 연산자로 기본 생성자 호출 불가능 하게 막음
    }

    // 외부 호출 가능
    // 클래스명으로 바로 호출 가능
    public static Controller getInstance(){
        return instance; // 호출되면 공유 instance의 참조값을 반환
    }

    // ************** 데이터 처리 method **************
    private BookDAO dao = new BookDAO(); // BookDAO가 가지고 있는 모든 메서드 사용 가능 - DB접근의 통로가 너무 많아질 수 있으므로
    private IBookDAO iDao = (IBookDAO) new BookDAO(); // IBookDAO의 메서드만 사용 가능
    // DAO의 메서드들은 에외를 호출하는 쪽으로 throw - controller가 예외처리 해줘야 함
    public void insert(BookDTO newDto){
        try {
            // 웹 상에서는 사용자의 입력값을 검수 및 DTO로 변환하는 작업이 들어감
            // newDto를 사용해도 똑같지만 위 작업을 표현해 놓음
            BookDTO dto = new BookDTO();
            dto.setBookNo(newDto.getBookNo());
            dto.setBookName(newDto.getBookName());
            dto.setBookAuthor(newDto.getBookAuthor());
            dto.setBookPrice(newDto.getBookPrice());
            dto.setBookDate(newDto.getBookDate());
            dto.setBookStock(newDto.getBookStock());
            dto.setPubNo(newDto.getPubNo());
            
            // dao의 insert()호출
                // iDao.insert(dto); // 사용할 메서드 한정
            if(dao.insert(dto)){
                ResultView.successMsg("도서 정보가 등록되었습니다.");
            }
        } catch (Exception e){
            e.printStackTrace();
            ResultView.errorMsg("도서 정보 등록 오류");
        }
    }

    public void getAllBook(){
        try {
            Vector<BookDTO> dataSet = dao.getAllBook();

            if (dataSet.size() != 0){ // 반환된 레코드가 있으면
                BookListView.showAllBook(dataSet);
            } else {
                ResultView.successMsg("검색된 결과가 없습니다.");
            }
        } catch (Exception e){ // 연결 오류
            e.printStackTrace();
            ResultView.successMsg("잠시 후에 재요청 바랍니다.");
        }
    }

    public void update(BookDTO newDto){
        try{
            BookDTO dto = new BookDTO();
            dto.setBookNo(newDto.getBookNo());
            dto.setBookName(newDto.getBookName());
            dto.setBookAuthor(newDto.getBookAuthor());
            dto.setBookPrice(newDto.getBookPrice());
            dto.setBookDate(newDto.getBookDate());
            dto.setBookStock(newDto.getBookStock());
            dto.setPubNo(newDto.getPubNo());

            if (dao.update(dto)){
                ResultView.successMsg("도서 정보가 수정되었습니다.");
            }
        } catch (Exception e){
            e.printStackTrace();
            ResultView.successMsg(null);
        }
    }

    public void delete(String bookNo){
        try {
            BookDTO dto = new BookDTO();
            dto.setBookNo(bookNo); // 필드값이 bookNo만 지정된 dto구현

            if (dao.delete(dto)){
                ResultView.successMsg(bookNo + "도서를 삭제하였습니다. 결과는 도서정보 조회에서 확인하세요.");
            }
            dao.delete(dto);
        } catch(Exception e){
            e.printStackTrace();
            ResultView.errorMsg("도서 정보 삭제 오류");
        }
    }
}
