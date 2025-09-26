package controllers;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;
import user.UserDTO;

/**
 * Servlet implementation class loginSevlet
 */
@WebServlet("/User/*")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action : " + action);
		if(action == null || action.equals("/login")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			System.out.println(id+","+pw);
			UserDAO user = new UserDAO();
			try {
				if (user.checkIfUserExists(id) == true) {
					if (user.login(id, pw) == true) {
						request.setAttribute("msg", "로그인 성공");
						String userName = user.getUserName(id);
						session.setAttribute("loginUserId", id);
						session.setAttribute("loginUserName", userName);
					} else {
						request.setAttribute("msg", "비밀번호가 틀립니다");
					}
				} else {
					request.setAttribute("msg", "회원 정보가 없습니다");
				}
			} catch (Exception e) {
				System.out.println("로그인에 예외가 발생했습니다.");
				nextPage = "err/err_500.jsp";
			}
			nextPage = "/main.jsp";
		} else if(action.equals("/logout")){
			String id = request.getParameter("id");
			UserDAO user = new UserDAO();
			try {
				if (user.logOut(id) == true) {
					request.setAttribute("msg", null);
					session.invalidate(); // 세션에 저장된 모든 속성 삭제
				} else {
					request.setAttribute("msg", "로그아웃 실패");
				}
			} catch (Exception e) {
				System.out.println("로그아웃에 예외가 발생했습니다.");
				nextPage = "err/err_500.jsp";
			}
			nextPage = "/main.jsp";
		} else if(action.equals("/signup")){
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			UserDAO user = new UserDAO();
			try {
				if (user.checkIfUserExists(id) == true) {
					request.setAttribute("msg", "이미 존재하는 아이디 입니다.");
					nextPage = "/signup.jsp";
				} else {
					UserDTO newUser = new UserDTO(id, name, pw);
					user.addUser(newUser);
					request.setAttribute("signupSuccess", true);
					nextPage = "/main.jsp";
				}
			} catch (Exception e) {
				System.out.println("회원가입에 예외가 발생했습니다.");
				nextPage = "err/err_500.jsp";
			}
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
