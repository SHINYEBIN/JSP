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
		response.setContentType("text/html;charset=utf-8"); //브라우저로 다시 보내기 위한 설정 해주기
		/* setContentType: 응답을 하는데 형식을 지정해준다 */
		PrintWriter out=response.getWriter();	/* 출력객체 만들어주기 */
		String savePath="upload"; //upload라는 파일이 저장될 공간.
		int uploadFileSizeLimit = 5 *1024*1024; //5mb	/* 1kb=1024byte */
		String encType="utf-8";
		ServletContext context=getServletContext(); // context의 의미는 project로 봐도 된다.
		String uploadFilePath=context.getRealPath(savePath); //업로드 될 경로 지정
		System.out.println("서버상의 실제 디렉토리:");
		System.out.println(uploadFilePath);
		
		try {
			MultipartRequest multi=new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			//DefaultFileRenamePolicy() : 동일파일이 있는 경우 자동으로 이름을 바꿔 줌
			/*MultipartRequest : 파일을 업로드할 때 사용하는 클래스*/
			String fileName=multi.getFilesystemName("uploadFile");
			if(fileName == null) {
				System.out.print("파일 업로드 되지 않았습니다.");
			}else{
				out.println("<br>글쓴이:"+multi.getParameter("name"));
				out.println("<br>제&nbsp;목:"+multi.getParameter("title"));
				out.println("<br>파일명:"+fileName); //line 60에서 이미 가지고 왔다.
				
			}
		}catch(Exception e) {
			System.out.println("예외 발생:"+ e);
		}
	
	}

}
