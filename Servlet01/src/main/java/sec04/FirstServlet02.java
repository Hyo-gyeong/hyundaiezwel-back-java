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
@WebServlet("/first02")
public class FirstServlet02 extends HttpServlet {
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
		// 2. 브라우저의 비표준 확장 헤더 사용 redirect
		System.out.println("FirstServlet02에서 Refresh 처리");
		// 광고를 띄우거나 일정시간 후 refresh가 필요한 경우 사용
//		response.addHeader("Refresh", "2;url=second02"); // 초;url?파라미터
		response.addHeader("refresh", "2;url=second02?name=kim"); // Adds a response header with the given name and value.
							// refresh라는 브라우저가 이미 알고있는 정해진 header 넣어줌
							// 표준은 아니고 Netscape 시절 브라우저에서 도입한 "비표준 확장 헤더"
							// + HTTP 헤더 이름은 대소문자를 구분하지 않음. 다만 관례적으로는 첫 글자만 대문자(Refresh) 로 쓰는 경우가 많다.
							// → 가능하면 Location + 상태코드(302, 303 등) 쓰는 게 맞지만 지연하는 기능은 없음.
	}

}
