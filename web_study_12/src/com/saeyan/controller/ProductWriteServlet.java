package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

/**
 * Servlet implementation class ProductWriteServlet
 */
@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productWrite.jsp"); 	/* ��ǰ ����ϴµ��� �����°� */
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		ServletContext context=getServletContext();
		String path=context.getRealPath("upload");
		String encType="utf-8";
		int sizeLimit=20*1024*1024;
		MultipartRequest multi=new MultipartRequest(request,path,sizeLimit,encType,new DefaultFileRenamePolicy());
		String name=multi.getParameter("name");
		int price=Integer.parseInt(multi.getParameter("price"));
		/* input �±׿��� �ԷµǴ� type�� text��. ���ڰ� �ƴϰ� ���ڿ��� ������ ���� �Ǳ� ������ String���� �Ǿ��ִ�. int�� casting*/
		String description=multi.getParameter("description");
		String pictureUrl=multi.getFilesystemName("pictureUrl");
		
		ProductVO pVo=new ProductVO();
		
		pVo.setName(name);
		pVo.setPrice(price);
		pVo.setDescription(description);
		pVo.setPictureUrl(pictureUrl);
		
		ProductDAO pDao=ProductDAO.getInstance();
		pDao.insertProduct(pVo);
		
		response.sendRedirect("productList.do"); 		/* ������ productlist.do(survlet)�� �����ϱ�. ���⿡ ����Ǿ� �ִ� �� �����ͼ� productList.do���� �۾�. */
		
		
		
		
		
	}

}