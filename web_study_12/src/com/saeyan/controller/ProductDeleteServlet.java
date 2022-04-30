package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

/**
 * Servlet implementation class ProductDeleteServlet
 */
@WebServlet("/productDelete.do")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// 해당되는 코드값을 가지고 디비에 가져와서request에 저장해주고  저장된 값을 product.jsp로 보낸다.
		String code=request.getParameter("code");
		ProductDAO pDao=ProductDAO.getInstance();
		ProductVO pVo=pDao.selectProductByCode(code);
		request.setAttribute("product", pVo);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("product/productDelete.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		// 지우는 건 productDAO가 함.
		// 여기서는 코드값을 넘겨주면 된다.
		String code=request.getParameter("code");
		ProductDAO pDao=ProductDAO.getInstance();
		pDao.deleteProduct(code);
		response.sendRedirect("productList.do");
		
		
	}

}
