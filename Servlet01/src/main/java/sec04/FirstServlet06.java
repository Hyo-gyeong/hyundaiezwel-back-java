package sec04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet01
 */
@WebServlet("/first06")
public class FirstServlet06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 바인딩 방식으로 데이터를 새성하고 redirect 방식으로 데이터 전달 (불가능)
	 * dispatch 방식으로 데이터 포워딩
	 * request.setAttribute()
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("second06으로 바인딩된 데이터 포워딩 : redirect가 binding 데이터 활용 가능?");
		System.out.println("redirect 요청될 때는 새로운 요청 객체가 생성되고 기존 request객체는 삭제되기 때문에 사용 불가능");
		request.setCharacterEncoding("utf-8"); // 한글 데이터 저장 대비
		response.setContentType("text/html;charset=utf-8");
		
		// 데이터 바인딩
		request.setAttribute("name", "홍길동"); // value 홍길동은 Object 타입 객체
												// - 최상위 클래스이므로 어떤 값이든 전달 가능하지만 사용할 땐 타입캐스팅(형변환)필요
		request.setAttribute("address", "서울시 강남구");
		
//		response.sendRedirect("second06"); //request객체 삭제됨 -> 포워딩시 바인딩 data전달 불가
		// redirect는 데이터 처리가 다 끝나고 다른 페이지를 호출만 하는 용으로 사용 ex) 로그인
		// 데이터 전송용으로는 사용 x -> request 객체가 유지되는 dispatch 사용
		
		RequestDispatcher dispatch = request.getRequestDispatcher("second06");
		dispatch.forward(request, response); // second06으로 전송되는 request객체에 바인딩된 데이터가 저장되어있음.
	}

}
