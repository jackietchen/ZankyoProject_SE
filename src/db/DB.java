package db;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import model.*;
public class DB {
	Connection ct;
	PreparedStatement pstmt;
	public DB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/zankyo_db_se","root","123456");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public User checkUser(String username,String password )
	{
		try{
			pstmt=ct.prepareStatement("select * from user where username=? and password=?");
			pstmt.setString(1,username);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			User user=new User();
			while(rs.next()){
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setAuthority(rs.getString(3));
				return user;
			}
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList findAllUser(){
		try{
			pstmt=ct.prepareStatement("select * from user");
			ArrayList al=new ArrayList();
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				User ly=new User();
				ly.setUsername(rs.getString(1));
				ly.setPassword(rs.getString(2));
				ly.setAuthority(rs.getString(3));
				al.add(ly);
			}
			return al;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
