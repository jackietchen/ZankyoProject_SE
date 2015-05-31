package action;

import java.util.ArrayList;

import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;
import model.*;

import com.opensymphony.xwork2.ActionSupport;
import db.DB;

public class cookieChecker extends ActionSupport {
	
	public String execute() throws Exception 
	{
		return null;
	}
	public String check()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();
		User user=new User();
		if(cookies!=null)     
		{          
		    for (int i = 0; i < cookies.length; i++)      
		    {     
		       Cookie c = cookies[i];          
		       if(c.getName().equalsIgnoreCase("username"))     
		       {     
		          user.setUsername(c.getValue());     
		        }     
		        else if(c.getName().equalsIgnoreCase("password"))     
		        {     
		           user.setPassword(c.getValue());     
		        }     
		        else if(c.getName().equalsIgnoreCase("authority"))     
		        {     
		           user.setAuthority(c.getValue());     
		        }          
		    }      
		}
		ArrayList<User> userlist=new DB().queryUser(user.getUsername(), user.getPassword());
		if(userlist.size()>0)  
		{
			if(user.getAuthority()!=null)   //本处需要修改成判断权限是否符合
				return SUCCESS;
			else
				return ERROR;
		}
		else
		{
			return ERROR;
		}
	}
}
