package sec04;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet01
 */
@WebServlet("/first05")
public class FirstServlet05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Dispatcher 활용한 포워딩 -> 현재 서블릿이 다른 서블릿을 '요청' : 관련 메서드는 Request 객체에 포함되어 있음
	 * request.getRequestDispatcher(url location에 대한 정보)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "홍길동";
		String encodeName = URLEncoder.encode(name, "utf-8");
		int age = 20;
		RequestDispatcher dispatch = request.getRequestDispatcher("second05?name="+encodeName+"&age="+age);
		// 목적지는 위에서 dispatch 인스턴스 생성 시 결정했음
		dispatch.forward(request, response); // dispatch 메서드 forward(현재 메서드의 request, response 객체를 요구함)
											// 요청에 대한 응답을 떠넘기고 있으므로 요청 응답 객체가 필요
	}

}
