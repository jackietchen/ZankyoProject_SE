package action;
import java.util.ArrayList;

import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;
import model.*;

import com.opensymphony.xwork2.ActionSupport;
import db.DB;

public class User_action extends ActionSupport {
	private User user;
	private String username;
	public String execute() throws Exception 
	{
		return null;
	}
	public String add()
	{
		if(new DB().addUser(user)){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	public String update()
	{
		if(new DB().updateUser(user)){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	public String delete()
	{
		if(new DB().deleteUser(username)){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	public String login()
	{
		HttpServletResponse response= ServletActionContext.getResponse();
		DB db=new DB();
		ArrayList<User> userlist=db.queryUser(user.getUsername(),user.getPassword());			
		if(userlist.size()>0){
			response.addCookie(new Cookie("username",user.getUsername()));
			response.addCookie(new Cookie("password",user.getPassword()));
			response.addCookie(new Cookie("authority",user.getAuthority()));
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
}
