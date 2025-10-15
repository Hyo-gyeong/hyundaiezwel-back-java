package sec04;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet01
 */
@WebServlet("/first04")
public class FirstServlet04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * redirect 방식으로 다른 서블릿에 데이터 전달
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String name = "홍길동"; // error! 유니코드 문자 [홍]은(는), 0에서 255까지의 허용 범위 바깥에 있으므로 인코딩될 수 없습니다.
		// 조합문자를 url파라미터 값으로 추가할 때는 url 사용가능한 범위의 코드로 변경해야 함
		// 한글데이터 인코딩 : URLEncodier.encode(data, "utf-8");
		String encodeName = URLEncoder.encode(name, "utf-8");
		System.out.println(encodeName); // %ED%99%8D%EA%B8%B8%EB%8F%99
		int age = 30; // int타입도 오류 없이 전달됨
		// 파라미터 추가 : uri?파라미터명=값&파라미터=값...
		response.sendRedirect("second04?name="+encodeName+"&age="+age);
	}

}
