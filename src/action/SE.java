package action;

import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;

import model.*;

import com.opensymphony.xwork2.ActionSupport;

import db.DB;

public class SE extends ActionSupport{
	private String username;
	private String password;
	private String authority;
	public String execute() throws Exception 
	{
		return null;
	}
	public String login()throws Exception{
		HttpServletResponse response= ServletActionContext.getResponse();
		DB db=new DB();
		User user=db.checkUser(username,password);			
		if(user!=null){
			response.addCookie(new Cookie("username",username));
			response.addCookie(new Cookie("password",password));
			response.addCookie(new Cookie("authority",authority));
			return "loginsuccess";
		}
		else{
			return "loginfailed";
		}
	}
	public String insertUser()throws Exception{			
		if(new DB().insertUser(username, password, authority)){
			return "insertsuccess";
		}
		else{
			return "insertfailed";
		}
	}
	public String updateUser()throws Exception{			
		if(new DB().updateUser(username, password, authority)){
			return "updatesuccess";
		}
		else{
			return "updatefailed";
		}
	}
	public String deleteUser()throws Exception{			
		if(new DB().deleteUser(username)){
			return "deletesuccess";
		}
		else{
			return "deleltefailed";
		}
	}
}
