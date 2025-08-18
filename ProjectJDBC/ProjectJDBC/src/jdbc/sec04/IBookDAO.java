package jdbc.sec04;

import java.util.ArrayList;

public interface IBookDAO {
    // 1. book list 조회
    public ArrayList<BookDTO> getAllBooks();
    // 2. book 이름으로 detail 조회
    public BookDTO findBookByName(String bookName);
    // 3. update book
    public void updateBook(BookDTO bookDTO);
    // 4. delete book by name
    public void deleteBookByName(String bookName);
    // 5. delete book by bookno
    public void deleteBookById(String bookNo);
    // 6. add book
    public void addBook(BookDTO bookDTO);
}
