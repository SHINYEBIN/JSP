package com.ezenac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ezenac.dto.MemberVO;


public class MemberDAO {
	
	private MemberDAO() {
		
	}
	
	private static MemberDAO instance=new MemberDAO();
	
	public static MemberDAO getInstance() {
		
		return instance;
	}
	

	public Connection getConnection() throws Exception {
		Connection conn=null;
		Context initContext=new InitialContext();
		Context envContext=(Context)initContext.lookup("java:/comp/env");
		DataSource ds=(DataSource)envContext.lookup("jdbc/Oracle11g");
		conn=ds.getConnection();
		
		return conn;
	}
	
	//����� ����
	public int UserCheck(String userid,String pwd) {
		int result=-1;
		String sql="select pwd from member where userid=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pwd") !=null && rs.getString("pwd").equals(pwd)) {
					result=1; //���̵� �н����� ��ġ
				}else {
					result=0; //���̵� �н����� ����ġ
				}
			}else {
				result=-1;	//���̵� ����.
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
		
		return result;
	}
	
	// ���̵�� ȸ������ ��������
	public MemberVO getMember(String id){
		MemberVO mvo=null;
		String sql="select * from member where id=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				mvo=new MemberVO();
				mvo.setName(rs.getString("name"));
				mvo.setUserid(rs.getString("userid"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setEmail(rs.getString("email"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setAdmin(rs.getInt("admin"));	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
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
		return mvo;
		
	}
	
	public int confirmID(String userid) {
		int result=-1;
		String sql="select userid from member where userid=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=1; //���̵� �н����� ��ġ
			}else {
				result=-1;	//���̵� ����.
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
		
		return result;
	}
	
	public int insertMember(MemberVO mvo) {
		int result=-1;
		String sql="insert into member values(?,?,?,?,?,?)";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mvo.getName());
			pstmt.setString(2, mvo.getUserid());
			pstmt.setString(3, mvo.getPwd());
			pstmt.setString(4, mvo.getEmail());
			pstmt.setString(5, mvo.getPhone());
			pstmt.setInt(6, mvo.getAdmin());
			
			result=pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null)
					pstmt.close();
				if(conn !=null)
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateMember(MemberVO mvo) {
		int result=-1;
		String sql="update member set pwd=?,email=?,phone=?,admin=? where id=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, mvo.getPwd());
			pstmt.setString(2, mvo.getEmail());
			pstmt.setString(3, mvo.getPhone());
			pstmt.setInt(4, mvo.getAdmin());
			pstmt.setString(5, mvo.getUserid());
			
			result=pstmt.executeUpdate();
			System.out.println("result"+result);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null)
					pstmt.close();
				if(conn !=null)
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
		
}
