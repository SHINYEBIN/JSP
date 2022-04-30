package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MultiUploadServlet
 */
@WebServlet("/upload2.do")
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiUploadServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();	/* ��°�ü ������ֱ� */
		String savePath="upload"; //upload��� ������ ����� ����.
		int uploadFileSizeLimit = 5 *1024*1024; //5mb	/* 1kb=1024byte */
		String encType="utf-8";
		
		ServletContext context=getServletContext(); // context�� �ǹ̴� project�� ���� �ȴ�.
		String uploadFilePath=context.getRealPath(savePath); //���ε� �� ��� ����
		
		System.out.println("�������� ���� ���丮:");
		System.out.println(uploadFilePath);
		
		try {
			// request:MultipartRequest�� ������ request ��ü
			// �������� ����� ���
			// �ִ� ���� ũ��
			// ������ ���ڵ� ���: ���� �̸��� �ѱ��� ��� �Ű� ���� ���� utf-8
			// ���� �ߺ� ó��
			MultipartRequest multi=new MultipartRequest(request, 
					uploadFilePath, 
					uploadFileSizeLimit, 
					encType, 
					new DefaultFileRenamePolicy());
			// ������ ������ ���ε� �� ��� �� ������ EnumerationŸ������ ����
			Enumeration files=multi.getFileNames(); // �ش�Ǵ� �̹��� ��ü�� �̸�.
			
			while(files.hasMoreElements()) { //�Ѿ�� ��ü�� �ִ��� üũ
				String file=(String)files.nextElement(); //files.nextElement()�� object.
				// ������ ������ ���ε�� ������ �̸��� �ǹ�
				String fileName=multi.getFilesystemName(file);
				String ori_file_name=multi.getOriginalFileName(file);	//������ ����Ǿ� �ִ� ���� ����
				out.print("<br>���ε�� ���ϸ�:"+fileName);
				out.print("<br>���� ���ϸ�:"+ori_file_name);
				out.print("<hr>");
				}
			}catch(Exception e) {
				System.out.println("���� �߻�:"+ e);
			}
	}
}
	
