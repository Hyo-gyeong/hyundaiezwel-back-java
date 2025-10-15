package sec06;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prdBinding")
public class ProductBindingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * 요청을 doProcess로 넘김
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * 요청을 doProcess로 넘김
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductVO vo1 = new ProductVO("1", "food", "만두", 10000);
		ProductVO vo2 = new ProductVO("2", "bread", "바게트", 5000);
		ProductVO vo3 = new ProductVO("3", "drink", "포카리스웨트", 3000);
		
		ArrayList<ProductVO> prdList = new ArrayList<>();
		prdList.add(vo1);
		prdList.add(vo2);
		prdList.add(vo3);
		
		// 데이터 바인딩
		request.setAttribute("prdList", prdList);
		
		// 포워딩
		// prdList 요청할 때 request와 response가 전달됨
		RequestDispatcher dispatch = request.getRequestDispatcher("prdView");
		dispatch.forward(request, response);
	}

}
