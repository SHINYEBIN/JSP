package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); //�������� �ٽ� ������ ���� ���� ���ֱ�
		/* setContentType: ������ �ϴµ� ������ �������ش� */
		PrintWriter out=response.getWriter();	/* ��°�ü ������ֱ� */
		String savePath="upload"; //upload��� ������ ����� ����.
		int uploadFileSizeLimit = 5 *1024*1024; //5mb	/* 1kb=1024byte */
		String encType="utf-8";
		ServletContext context=getServletContext(); // context�� �ǹ̴� project�� ���� �ȴ�.
		String uploadFilePath=context.getRealPath(savePath); //���ε� �� ��� ����
		System.out.println("�������� ���� ���丮:");
		System.out.println(uploadFilePath);
		
		try {
			MultipartRequest multi=new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			//DefaultFileRenamePolicy() : ���������� �ִ� ��� �ڵ����� �̸��� �ٲ� ��
			/*MultipartRequest : ������ ���ε��� �� ����ϴ� Ŭ����*/
			String fileName=multi.getFilesystemName("uploadFile");
			if(fileName == null) {
				System.out.print("���� ���ε� ���� �ʾҽ��ϴ�.");
			}else{
				out.println("<br>�۾���:"+multi.getParameter("name"));
				out.println("<br>��&nbsp;��:"+multi.getParameter("title"));
				out.println("<br>���ϸ�:"+fileName); //line 60���� �̹� ������ �Դ�.
				
			}
		}catch(Exception e) {
			System.out.println("���� �߻�:"+ e);
		}
	
	}

}
