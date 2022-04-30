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
	
	// �ϳ��� ���ο� �Խñ��� �Ѿ�ͼ� DB�� ����Ǵ� �޼���
	public void insertBoard(BoardBean bean) {
		String sql="insert * from BoardBean values(?,?,?,?..?)";
	}
	
	// ��� �Խñ��� �������ִ� �޼���
	public Vector<BoardBean> getAllBoard(int start,int end){
		Vector<BoardBean>
	}
	
	// BoardInfo �� ��: �ϳ��� �Խñ��� �����ϴ� �޼���
	public BoardBean getOneBoard(int num) {
		
	}
	
	// �亯���� ����Ǵ� �޼���
	public void reWriteBoard(BoardBean bean) {
		
	}
	
	//Boardupdate�� �ϳ��� �Խñ��� ����
	//Boardupdate�� delete�� �ϳ��� �Խñ��� ����
	public BoardBean getOneUpdateBoard(int num) {
		
	} 
	
	// update�� delete�� �ʿ��� �н����� ���� �������ִ� �޼���
	public 	String getPass(int num) {
		String pass="";
		getCon();
		
		try {
			// �����غ�
			String sql="select password from board where num=?";
			// ���� ������ ��ü ����
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			// ���� ���� �� ����� ����
			rs=pstmt.executeQuery();
			//�н����� ���� ����
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
	
	// �ϳ��� �Խñ��� �����ϴ� �޼���
	public void updateBoard(BoardBean bean) {
		
	}
	
	// �ϳ��� �Խñ��� �����ϴ� �޼���
	public void deleteBoard(int num) {
		
	}
	
	// ��ü ���� ������ �����ϴ� �޼���
	public int getAllCount() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
