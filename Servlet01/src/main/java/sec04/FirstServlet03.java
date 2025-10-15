package sec04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet01
 */
@WebServlet("/first03")
public class FirstServlet03 extends HttpServlet {
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
		// 3. script 출력을 이용한 redirect (가장 덜 사용하는 방식)
		System.out.println("location script를 활용한 포워딩 : FirstServelt처리");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		String script = "<script type='text/javascript'>location.href='second03';</script>";
		String script = "<script type='text/javascript'>location.href='second03?name=kim';</script>";
		out.println(script);
	}

}
