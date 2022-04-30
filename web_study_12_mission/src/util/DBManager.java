package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	
	public static Connection getConnection() {
		Connection conn=null;
		
		try {
			Context initContext=new InitialContext();
			DataSource ds=(DataSource)initContext.lookup("java:/comp/env/jdbc/Oracle11g");
			conn=ds.getConnection();
		}catch(NamingException e) { //한꺼번에 하지 않고 나눠줄거면  Exception 사용하면 안됨( 최고 조상)
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// select를 수행한 후 리소스 해제를 위한 메서드
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(rs !=null)
				rs.close();
			if(pstmt !=null)
				pstmt.close();
			if(conn !=null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//insert, update,delete

	public static void close(Connection conn,PreparedStatement pstmt) {
		try {
			if(pstmt !=null)
				pstmt.close();
			if(conn !=null)
				conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
}
