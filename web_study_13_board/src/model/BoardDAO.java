package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	ResultSet rs;
	Connection conn;
	PreparedStatement pstmt;
	
	public void getCon() {
		
		try {
			Context initctx=new InitialContext();
			Context envctx=(Context)initctx.lookup("java:comp:env");
			DataSource ds=(DataSource)envctx.lookup("jdbc:Oracle11g");
			conn=ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
					//rs.close();
					//pstmt.close();
					//conn.close();				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// 하나의 새로운 게시글이 넘어와서 DB에 저장되는 메서드
	public void insertBoard(BoardBean bean) {
		String sql="insert * from BoardBean values(?,?,?,?..?)";
	}
	
	// 모든 게시글을 리턴해주는 메서드
	public Vector<BoardBean> getAllBoard(int start,int end){
		Vector<BoardBean>
	}
	
	// BoardInfo 일 때: 하나의 게시글을 리턴하는 메서드
	public BoardBean getOneBoard(int num) {
		
	}
	
	// 답변글이 저장되는 메서드
	public void reWriteBoard(BoardBean bean) {
		
	}
	
	//Boardupdate용 하나의 게시글을 리턴
	//Boardupdate용 delete시 하나의 게시글을 리턴
	public BoardBean getOneUpdateBoard(int num) {
		
	} 
	
	// update와 delete시 필요한 패스워드 값을 리턴해주는 메서드
	public 	String getPass(int num) {
		String pass="";
		getCon();
		
		try {
			// 쿼리준비
			String sql="select password from board where num=?";
			// 쿼리 실행할 객체 선언
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			// 쿼리 실행 후 결과를 리턴
			rs=pstmt.executeQuery();
			//패스워드 값을 저장
			if(rs.next()) {
				pass=rs.getString(1);
			}
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pass;
	}
	
	// 하나의 게시글을 수정하는 메서드
	public void updateBoard(BoardBean bean) {
		
	}
	
	// 하나의 게시글을 삭제하는 메서드
	public void deleteBoard(int num) {
		
	}
	
	// 전체 글의 개수를 리턴하는 메서드
	public int getAllCount() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
