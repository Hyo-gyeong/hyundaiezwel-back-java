package sec02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/bookInsert")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    		System.out.println("init 메서드 호출");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bookNo = request.getParameter("bookNo");
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		String bookPrice = request.getParameter("bookPrice");
		String bookStock = request.getParameter("bookStock");
		String bookYear = request.getParameter("bookYear");
		String bookMonth = request.getParameter("bookMonth");
		String bookDate = request.getParameter("bookDate");
		String pubNo = request.getParameter("pubNo");
		StringBuilder sb = new StringBuilder();
		sb.append("도서번호 : "+ bookNo+"\n")
		  .append("도서명 : "+ bookName+"\n")
		  .append("저자 : "+bookAuthor+"\n")
		  .append("가격 : "+ bookPrice+"\n")
		  .append("재고 : "+bookStock+"\n")
		  .append("발행일 : "+bookYear).append("-")
							  .append(bookMonth+"-")
							  .append(bookDate+"\n")
		  .append("출판사번호 : "+pubNo);
		System.out.println(sb.toString());
	}

}
