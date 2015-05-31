package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.ArrayList;
import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;
import model.*;
import db.DB;

public class Order_action extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO 自动生成的方法存根
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
			String authority=request.getParameter("authority");
			if(authority.equals(user.getAuthority()))   //本处需要修改成判断权限是否符合
			{
				String result=arg0.invoke();
				return result;
			}
			else
				return "error";
		}
		else
		{
			return "error";
		}
	}

}
