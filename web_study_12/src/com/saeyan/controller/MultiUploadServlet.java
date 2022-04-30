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
		PrintWriter out=response.getWriter();	/* 출력객체 만들어주기 */
		String savePath="upload"; //upload라는 파일이 저장될 공간.
		int uploadFileSizeLimit = 5 *1024*1024; //5mb	/* 1kb=1024byte */
		String encType="utf-8";
		
		ServletContext context=getServletContext(); // context의 의미는 project로 봐도 된다.
		String uploadFilePath=context.getRealPath(savePath); //업로드 될 경로 지정
		
		System.out.println("서버상의 실제 디렉토리:");
		System.out.println(uploadFilePath);
		
		try {
			// request:MultipartRequest와 연결할 request 객체
			// 서버측에 저장될 경로
			// 최대 파일 크기
			// 파일의 인코딩 방식: 파일 이름이 한글일 경우 매개 변수 값을 utf-8
			// 파일 중복 처리
			MultipartRequest multi=new MultipartRequest(request, 
					uploadFilePath, 
					uploadFileSizeLimit, 
					encType, 
					new DefaultFileRenamePolicy());
			// 파일을 여러개 업로드 할 경우 그 값들을 Enumeration타입으로 리턴
			Enumeration files=multi.getFileNames(); // 해당되는 이미지 객체의 이름.
			
			while(files.hasMoreElements()) { //넘어온 객체가 있는지 체크
				String file=(String)files.nextElement(); //files.nextElement()는 object.
				// 서버에 실제로 업로드된 파일의 이름을 의미
				String fileName=multi.getFilesystemName(file);
				String ori_file_name=multi.getOriginalFileName(file);	//서버에 저장되어 있는 원본 파일
				out.print("<br>업로드된 파일명:"+fileName);
				out.print("<br>원본 파일명:"+ori_file_name);
				out.print("<hr>");
				}
			}catch(Exception e) {
				System.out.println("예외 발생:"+ e);
			}
	}
}
	
