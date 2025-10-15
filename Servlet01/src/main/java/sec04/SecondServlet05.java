package sec04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/second05")
public class SecondServlet05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * FirstServlet05에서 dispatch 방식으로 포워딩 요청된 서블릿 - 최종 응답 진행
	 * 빠르다는 특징이 있음 (클라이언트로 가지 않으니까)
	 * first05에 요청하고 url은 변하지 않음. 내부적으로는 second05가 응답을 했지만 클라이언트 브라우저의 url은 최초 요청된 first05에서 변하지 않음.
	 * 한 번 생성한 객체를 계속해서 사용하고 있고 클라이언트를 거치지 않고 그대로 이동하기 때문에 url은 처음 요청한 url로 고정됨 - dispatch의 가장 큰 특징
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String html = "<html><body>이름: "+name+"<br>나이 : "+age+"<br></body></html>";
		out.println(html); // second05가 최종 응답 url이지만 클라이언트는 처음 요청한 url만 확인 가능
	}

}
