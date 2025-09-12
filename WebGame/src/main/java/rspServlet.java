

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Random;

@WebServlet("/rspServlet")
public class rspServlet extends HttpServlet {
	private static int computer;
	private static final long serialVersionUID = 1L;
	
	public void initComputer() throws ServletException {
		Random rd = new Random();
		computer = rd.nextInt(3);
		// 0-가위, 1-바위, 2-보
		System.out.println("초기화. 새 번호 : "+computer);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String input = request.getParameter("rsp");
		String action = request.getParameter("action");
		
		if (action.equals("reset")) {
			request.setAttribute("rslt", null);
			request.setAttribute("error", null);
			initComputer();
		} else if (action.equals("submit")) {
			try {
				int pick = Integer.parseInt(input);
				// 0-가위, 1-바위, 2-보
				if (pick == computer) {
					request.setAttribute("rslt", "same");
				} else if (pick == 0 && computer == 1 ||
						pick == 1 && computer == 2 ||
						pick == 2 && computer == 0) {
					request.setAttribute("rslt", "lose");
				} else {
					request.setAttribute("rslt", "win");
				}
			} catch (Exception e) {
				request.setAttribute("error", "가위, 바위, 보 중에서 반드시 하나를 선택해주세요!");
			}
		}
		RequestDispatcher dispatch = request.getRequestDispatcher("rsp.jsp");
		dispatch.forward(request, response);
	}

}
