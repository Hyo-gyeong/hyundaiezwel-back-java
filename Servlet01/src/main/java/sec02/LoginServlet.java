package sec02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@SuppressWarnings("serial") // 직렬화에대한 워닝메시지 무시코드
@WebServlet("/login") //login.html에서 action="login"
public class LoginServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 데이터를 추출하는 코드 -> 출력은 콘솔에 출력
		// 웹상에서 파라미터로 전달되는 데이터는 기본 문자열로 전달됨
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println("get 아이디 : "+user_id);
		System.out.println("get 비밀번호 : "+user_pw);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		System.out.println("post 아이디 : "+user_id);
		System.out.println("post 비밀번호 : "+user_pw);
	}

}
