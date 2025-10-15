package sec04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet01
 */
@WebServlet("/first01")
public class FirstServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		System.out.println("firstservlet 시작");
    }
	
	public void destroy() {
		System.out.println("firstservlet 종료");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. response 자체의 redirect
		System.out.println("firstservlet doget, redirect 처리");
		response.sendRedirect("second01"); // 웹브라우저에서 second01 서블릿으로 포워딩(브라우저에게 응답되면 브라우저가 바로 재요청, resp, req 전부 새로 생성됨)
	}

}
