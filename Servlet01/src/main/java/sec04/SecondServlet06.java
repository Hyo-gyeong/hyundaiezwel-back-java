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
@WebServlet("/second06")
public class SecondServlet06 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 바인딩으로 전달된 파라미터 출력
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("second06에서 바인딩된 데이터 출력");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//바인딩 된 데이터 추출 - getAttribute() Object 타입 변환
		String name = (String) request.getAttribute("name");
		String address = (String) request.getAttribute("address");
		
		String html = "<html><body>이름: "+name+"<br>주소 : "+address+"<br></body></html>";
		out.println(html);
	}

}
