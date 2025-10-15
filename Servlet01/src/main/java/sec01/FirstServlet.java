package sec01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; // url mapping에 활용
import javax.servlet.http.HttpServlet; // 상속
import javax.servlet.http.HttpServletRequest; // http 요청
import javax.servlet.http.HttpServletResponse; // http 응답 관련

/**
 * Servlet implementation class FirstServlet
 * 어노테이션 사용시 extends HttpServlet 필수
 */
@WebServlet("/FirstServlet") // uri mapping 1. @WebServlet활용 2. web.xml활용
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see Servlet#init(ServletConfig)
	 * 객체가 생성될 때 한 번만 생성됨. 페이지 새로고침해도 호출되지 않음
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출 소스코드 변경");
		// 변경후 저장 버튼을 누르면 서버에 반영이 되고 변경사항이 확인되면 (신호가 전달됨) servlet에 동작하는 thread를 없애서
		// destroy()가 실행되고 서버를 실행하면 새롭게 객체를 생성
		// 재요청을 하면 그때부터 init부터 실행
	}

	/**
	 * @see Servlet#destroy()
	 * 생명주기 마지막에 호출되는 메서드
	 * 소스코드 변경, 재컴파일, 서버가 재시작(서버종료)시 
	 */
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 클라이언트 폼에서 메서드가 get일 때 호출되는 메서드
	 * 폼태그 상관없이 url에 의한 효청은 method get 방식의 요청임
	 * servlet 기반의 프레임에서는 url의 요청은 일단 get으로 받아들임
	 * http 프로토콜의 규칙은 url요청에 대해서는 get으로 진행
	 * 	- 세부적인 전송에 따라 post가 동작
	 * url, 브라우저 개수에 따라 매번 객체 새로생성하지 안긍미
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메서드 호출");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
