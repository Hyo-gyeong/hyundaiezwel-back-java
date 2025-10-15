package sec02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ResponseCache;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/insertMember")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html><head></head><body>");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		String phonF = req.getParameter("phonF");
		String phonS = req.getParameter("phonS");
		String phonT = req.getParameter("phonT");

		String grade = req.getParameter("grade");
		String[] interests = req.getParameterValues("interests");
		String department = req.getParameter("department");

		out.println("<h3>회원 가입 내용</h3>");
		out.println("성명 : " + name+"<br>");
		out.println("ID : " + id+"<br>");
		out.println("비밀번호 : " + pw+"<br>");
		out.println("휴대폰 번호 : " + phonF + "-" + phonS + "-" + phonT+"<br>");
		out.println("학년 : " + grade+"<br>");

		out.print("관심분야 : ");
		if (interests != null) {
		    for (String i : interests) {
		        out.println(i+" ");
		    }
		}
		out.println("<br>");
		out.println("학과 : " + department+"<br>");
		out.println("</body></html>");
	}
}
