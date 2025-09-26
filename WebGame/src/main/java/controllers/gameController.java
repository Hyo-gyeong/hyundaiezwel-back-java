package controllers;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.InputNumberException;

import java.util.Random;

@WebServlet("/Game/*")
public class gameController extends HttpServlet{
	private static int compNum;
	private static int compRSP;
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		initCompRSP();
		initCompNum();
		System.out.println("init finished!");
	}
	
	public void initCompRSP() throws ServletException {
		Random rd = new Random();
		compRSP = rd.nextInt(3);
	}
	
	private void initCompNum() throws ServletException {
		Random rd = new Random();
		compNum = rd.nextInt(10)+1;
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
		String nextPage=null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		String btnAction = request.getParameter("btnAction");
		
		if(action == null || action.equals("/rsp")) {
			String inputRSP = request.getParameter("rsp");
			System.out.println(btnAction);
			if (btnAction.equals("reset")) {
				request.removeAttribute("rslt");
				request.removeAttribute("error");
				initCompRSP();
			} else if (btnAction.equals("submit")) {
				try {
					int pick = Integer.parseInt(inputRSP);
					// 0-가위, 1-바위, 2-보
					if (pick == compRSP) {
						request.setAttribute("rslt", "same");
					} else if (pick == 0 && compRSP == 1 ||
							pick == 1 && compRSP == 2 ||
							pick == 2 && compRSP == 0) {
						request.setAttribute("rslt", "lose");
					} else {
						request.setAttribute("rslt", "win");
					}
				} catch (Exception e) {
					request.setAttribute("error", "가위, 바위, 보 중에서 반드시 하나를 선택해주세요!");
				}
			}
			System.out.println(request.getAttribute("rslt"));
			nextPage = "/rsp.jsp";
		} else if (action.equals("/guess")) {
			String inputNum = request.getParameter("num");
			if (btnAction.equals("reset")) {
				request.removeAttribute("rslt");
				request.removeAttribute("error");
				initCompNum();
			} else if (btnAction.equals("submit")) {
				try {
					InputNumberException.validateNumber(inputNum);
					InputNumberException.validateGuessRange(inputNum);
					int pick = Integer.parseInt(inputNum);
					
					if (pick == compNum) {
						request.setAttribute("rslt", "true");
					} else {
						request.setAttribute("rslt", "false");
					}
				} catch (InputNumberException e) {
					request.setAttribute("error", e.getMessage());
				}
			}
			nextPage = "/guess.jsp";
		} else {
			nextPage = "/main.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
