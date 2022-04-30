package kr.co.ezenac;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyOk
 */
@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private Statement stmt;
	private String name,id,pw,phone1,phone2,phone3,gender;
	HttpSession session;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		actionDo(request,response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		session=request.getSession();
		
		name=request.getParameter(name);
		id=request.getParameter(id);
		pw=request.getParameter(pw);
		phone1=request.getParameter(phone1);
		phone2=request.getParameter(phone2);
		phone3=request.getParameter(phone3);
		gender=request.getParameter(gender);
		
		if(pwConfirm()) {
			System.out.println("OK");
			String query="update memberpe set name='"+name+"', phone1='"+phone1+"', phone2='"+phone2+"', phone3='"+phone3+"', gender='"+gender+"'";
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
				stmt=connection.createStatement();
				int i=stmt.executeUpdate(query);
			
				
				if(i == 1) { //이름이라서 1인건가...?
					System.out.println("update success");
					session.setAttribute("name", name);	//이름이 바뀌었을 수도 있기 때문(위에 update 사용했다)
					response.sendRedirect("modifyResult.jsp");
				}else {
					System.out.println("update fail");
					response.sendRedirect("modify.jsp");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(stmt !=null)
						stmt.close();
					if(connection !=null)
						connection.close();
					
				}catch(Exception e) {
					
				}
			}
			
		}else {
			System.out.println("NG");
		}
		
	}

	
	private boolean pwConfirm() { //패스워드가 맞으면 true, 틀리면 false
		boolean rs=false;
		String sessionPw=(String)session.getAttribute("pw");
		if(sessionPw.equals(pw)) {
			rs=true;
		}else {
			rs=false;
		}
		
		return rs;
	}
}
