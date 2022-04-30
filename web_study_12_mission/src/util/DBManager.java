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
		}catch(NamingException e) { //�Ѳ����� ���� �ʰ� �����ٰŸ�  Exception ����ϸ� �ȵ�( �ְ� ����)
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// select�� ������ �� ���ҽ� ������ ���� �޼���
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
