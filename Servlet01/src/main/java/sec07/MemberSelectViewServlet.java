package sec07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * member2 테이블의 데이터 조회된 결과를 받아서 view 출력 진행
 */
@WebServlet("/MemberSelectViewServlet")
public class MemberSelectViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSelectViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// (1) 요청 받음
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// (2) 비지니스 로직 처리하는 DAO 호출하고 결과 받아옴
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> memList = dao.memberSelect();
		
		// (3) 응답처리 : 클라이언트에게 결과 전송
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td>" 
		       + "<td>이메일</td><td>가입일</td><td>삭제</td></tr>");
		
		for (MemberVO vo : memList) { // 한 행 구성
			out.print("<tr><td>" + vo.getMemId()+ "</td>");
			out.print("<td>" + vo.getMemPw() + "</td>");
			out.print("<td>" + vo.getMemName() + "</td>");
			out.print("<td>" + vo.getMemMail() + "</td>");
			out.print("<td>" + vo.getMemJoinDate() + "</td>");
			out.print("<td><a href='/Servlet01/memDelete?memId=" + vo.getMemId() + "'>삭제</a></td></tr>");
		}
		out.println("</table></body></html>");
		// out 객체 I/O 스트림 객체는 계속 자원을 활용하고 있기 때문에 다 쓰면 닫아줘야함
		out.close();
	}

}
