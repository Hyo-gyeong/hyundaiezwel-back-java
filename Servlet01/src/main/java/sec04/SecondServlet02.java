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
@WebServlet("/second02")
public class SecondServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("secondServlet 종료");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("secondServlet02 doGet");
		// 응답처리
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		String html = "<html><body>refresh를 이용한 포워딩된 출력입니다. name : "+name+"<br></body></html>";
		out.println(html);
	}

}
