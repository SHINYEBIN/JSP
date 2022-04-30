package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


public class MemberDAO {
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String id="scott";
	String pass="tiger";
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public void getcon() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection(url,id,pass);		//connection만 만들어놓은 것(매번 매소드마다 입력하기 귀찮으므로). pstmt랑 rs는 따로 처리하겠다는 뜻.
	}catch(Exception e) {
		e.printStackTrace();
		}
	
	}
	
	public void insertMember(MemberBean mbean) {	//실질적인 db와 소통
		
		try{
			getcon();
			String sql="insert into memberInfo values(?,?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mbean.getId());
			pstmt.setString(2, mbean.getPass1());
			pstmt.setString(3, mbean.getEmail());
			pstmt.setString(4, mbean.getTel());
			pstmt.setString(5, mbean.getHobby());
			pstmt.setString(6, mbean.getJob());
			pstmt.setString(7, mbean.getAge());
			pstmt.setString(8, mbean.getInfo());
		
			pstmt.executeUpdate();	//insert,update,delete 결과를 받는 게 아니라 기존테이블에 변화를 줄때 executeUpdate사용
			conn.close();
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Vector<MemberBean> allSelectMember(){ //vector도 arrayList와 비슷하다. vector는 메소드가 안전하다..?
		// 가변 길이로 데이터를 저장
		Vector<MemberBean> vec=new Vector<MemberBean>();
		
		try {
			getcon();	//getcon 호출(db와 연결)
			String sql="select * from memberInfo";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//db의 내용을 메모리(MemberBean)에 저장...
			while(rs.next()) {	//rs에 데이터가 있느냐없느냐
				MemberBean mbean =new MemberBean();
				mbean.setId(rs.getString(1));
				mbean.setPass1(rs.getString(2));
				mbean.setEmail(rs.getString(3));
				mbean.setTel(rs.getString(4));
				mbean.setHobby(rs.getString(5));
				mbean.setJob(rs.getString(6));
				mbean.setAge(rs.getString(7));
				mbean.setInfo(rs.getString(8));
				vec.add(mbean);	
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return vec;
	}
	
	public MemberBean oneSelectMember(String id) {
		MemberBean mbean =new MemberBean();
		try {
			getcon(); // 이 내용은 매번 메서드마다 써야하니까 만들어놓은것을 간단하게 불러온다.
			String sql="select * from memberInfo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);	//pstmt.setString(인덱스,매개변수);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {	//하나의 아이디 조회하면 row가 다 나와야한다..(ex 아이디 'hong'을 조회하면 hong의 정보가 쭈욱 나옴)
				mbean.setId(rs.getString(1));
				mbean.setPass1(rs.getString(2));
				mbean.setEmail(rs.getString(3));
				mbean.setTel(rs.getString(4));
				mbean.setHobby(rs.getString(5));
				mbean.setJob(rs.getString(6));
				mbean.setAge(rs.getString(7));
				mbean.setInfo(rs.getString(8));
				
			}
			conn.close();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mbean;
	}
	
	public void updateMember(MemberBean bean) {
		try {
			getcon();
			String sql="update memberInfo set email=?, tel=? where id=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getTel());
			pstmt.setString(3, bean.getId());
			
			pstmt.executeUpdate();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getPass1(String id) {
		String pass="";
		try {
			getcon();
			String sql="select pass1 from memberInfo where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {// 전체 돌릴필요 없으니까 다 while문으로 돌릴 필요 없이 if사용..!
				pass=rs.getString(1);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return pass;
	}
	
	public void deleteMember(String id) {
		
		try {
			getcon();
			String sql="delete * from memberInfo where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeQuery();
			
			
			
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
