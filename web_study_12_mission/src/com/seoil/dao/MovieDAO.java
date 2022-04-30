package com.seoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.seoil.dto.MovieVO;

import util.DBManager;

public class MovieDAO {

	private MovieDAO() {
		super(); // 내부적으로는 object 부모생성자 호출하고 있다.
	}
	
	public static void setInstance(MovieDAO instance) {//setInstance: 외부로부터 넘어온 객체를 대입하는 메서드
		MovieDAO.instance=instance;
	
	}
	
	private static MovieDAO instance=new MovieDAO();
	
	public static MovieDAO getInstance() {//instance에 만들어진 객체를 반환...
		return instance;
	}
	
	public ArrayList<MovieVO> selectAllMovie(){
		String sql="select * from movie order by code desc";
		ArrayList<MovieVO> productList=new ArrayList<MovieVO>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MovieVO mVo=new MovieVO();
				mVo.setCode(rs.getInt("code"));
				mVo.setPrice(rs.getInt("price"));
				mVo.setTitle(rs.getString("title"));
				mVo.setDirector(rs.getString("director"));
				mVo.setActor(rs.getString("actor"));
				mVo.setPoster(rs.getString("poster"));
				mVo.setSynopsis(rs.getString("synopsis"));
				productList.add(mVo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.DBManager.close(conn, pstmt, rs);
		}
		
		return productList;
	}
	
	public void insertMovie(MovieVO mVO) {
		String sql="insert into movie values(movie_seq.nextval,?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(2, mVO.getPrice());
			pstmt.setString(3, mVO.getTitle());
			pstmt.setString(4, mVO.getDirector());
			pstmt.setString(5, mVO.getActor());
			pstmt.setString(6,mVO.getPoster());
			pstmt.setString(7, mVO.getSynopsis());			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			util.DBManager.close(conn, pstmt);
		}
	}
	
	public MovieVO selectProductByCode(int code) {
		MovieVO mvo=null;
		String sql="select * from movie where code=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,code);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				mvo=new MovieVO();
				mvo.setCode(rs.getInt("code"));
				mvo.setPrice(rs.getInt("price"));
				mvo.setTitle(rs.getString("title"));
				mvo.setDirector(rs.getString("director"));
				mvo.setActor(rs.getString("actor"));
				mvo.setPoster(rs.getString("poster"));
				mvo.setSynopsis(rs.getString("synopsis"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.DBManager.close(conn, pstmt, rs);
		}
		
		return mvo;
	}
	
	public void deleteMovie(int code) {
		String sql="delete from movie where code=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.DBManager.close(conn, pstmt);
		}
	}
	
	public void updateProduct(MovieVO mVO) {
		String sql="update movie set price=?,title=?,actor=?,director=?,poster=?,synopsis=? where code=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try{
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, mVO.getPrice());
			pstmt.setString(2, mVO.getTitle());
			pstmt.setString(3, mVO.getActor());
			pstmt.setString(4, mVO.getDirector());
			pstmt.setString(5, mVO.getPoster());
			pstmt.setString(6, mVO.getSynopsis());
			pstmt.setInt(7, mVO.getCode());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.DBManager.close(conn, pstmt);
		}
	}
	
}
