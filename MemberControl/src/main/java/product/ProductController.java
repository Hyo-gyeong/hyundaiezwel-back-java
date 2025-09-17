package product;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import javax.servlet.RequestDispatcher;

@WebServlet("/product/*")
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ProductDAO productDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = null;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String action = request.getPathInfo();
        System.out.println("action : " + action);

        if (action == null || action.equals("/listProducts.do")) {
            System.out.println("상품 정보 페이지");
            List<ProductVO> prdList = productDAO.listProducts();
            request.setAttribute("productList", prdList);
            nextPage = "/listProducts.jsp";

        } else if (action.equals("/productForm.do")) {
            nextPage = "/productForm.jsp";

        } else if (action.equals("/addProduct.do")) {
            String prdNo = request.getParameter("prdNo");
            String prdName = request.getParameter("prdName");
            int prdPrice = Integer.parseInt(request.getParameter("prdPrice"));
            String prdMaker = request.getParameter("prdMaker");
            String prdColor = request.getParameter("prdColor");
            int ctgNo = Integer.parseInt(request.getParameter("ctgNo"));

            ProductVO productVO = new ProductVO(prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
            productDAO.addProduct(productVO);

            request.setAttribute("msg", "addProduct");
            nextPage = "listProducts.do";

        } else if (action.equals("/modProductForm.do")) {
            String prdNo = request.getParameter("prdNo");
            ProductVO prdInfo = productDAO.findProduct(prdNo);
            request.setAttribute("prdInfo", prdInfo);
            nextPage = "/modProductForm.jsp";

        } else if (action.equals("/modProduct.do")) {
            String prdNo = request.getParameter("prdNo");
            String prdName = request.getParameter("prdName");
            int prdPrice = Integer.parseInt(request.getParameter("prdPrice"));
            String prdMaker = request.getParameter("prdMaker");
            String prdColor = request.getParameter("prdColor");
            int ctgNo = Integer.parseInt(request.getParameter("ctgNo"));

            ProductVO productVO = new ProductVO(prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
            productDAO.modProduct(productVO);

            request.setAttribute("msg", "modProduct");
            nextPage = "listProducts.do";

        } else if (action.equals("/delProduct.do")) {
            String prdNo = request.getParameter("prdNo");
            productDAO.delProduct(prdNo);
            request.setAttribute("msg", "deleted");
            nextPage = "listProducts.do";

        } else {
            List<ProductVO> prdList = productDAO.listProducts();
            request.setAttribute("productList", prdList);
            nextPage = "/listProducts.jsp";
        }

        RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
        dispatch.forward(request, response);
    }
}
