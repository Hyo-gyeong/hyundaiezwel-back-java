

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.InputNumberException;

import java.util.Random;

@WebServlet("/guessServlet")
public class guessServlet extends HttpServlet{
	private static int computer;
	private static final long serialVersionUID = 1L;
	
	private void initCompNum() throws ServletException {
		Random rd = new Random();
		computer = rd.nextInt(10)+1;
		System.out.println("초기화 됨. 새 번호 : "+computer);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
		request.setCharacterEncoding("UTF-8");
		String input = request.getParameter("num");
		String action = request.getParameter("action");
		
		if (action.equals("reset")) {
			request.setAttribute("rslt", null);
			request.setAttribute("error", null);
			initCompNum();
		} else if (action.equals("submit")) {
			try {
				InputNumberException.validateNumber(input);
				InputNumberException.validateGuessRange(input);
				int pick = Integer.parseInt(input);
				
				if (pick == computer) {
					request.setAttribute("rslt", "true");
				} else {
					request.setAttribute("rslt", "false");
				}
			} catch (InputNumberException e) {
				request.setAttribute("error", e.getMessage());
			}
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher("guess.jsp");
		dispatch.forward(request, response);
	}

}
