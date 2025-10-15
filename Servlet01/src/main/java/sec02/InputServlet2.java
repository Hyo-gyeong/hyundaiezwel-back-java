package sec02;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet2
 */
@WebServlet("/Input2")
public class InputServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Thread 시작");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Thread 종료");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> enu = request.getParameterNames(); // 클라이언트로부터 전달된 파라미터명 추출
		
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			String[] values = request.getParameterValues(name); // 값이 여러 개인지, 한 개인지 모르니까
			
			for (String value : values) {
				System.out.println("name = "+name+", value = "+value);
			}
		}
	}

}
