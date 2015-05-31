package action;

import java.util.ArrayList;

import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;
import model.*;

import com.opensymphony.xwork2.ActionSupport;
import db.DB;

public class Order_action extends ActionSupport {
	private Order order;
	private int id;
	public String execute() throws Exception 
	{
		return null;
	}
	public String add()
	{
		if(new DB().addOrder(order))
			return SUCCESS;
		else
			return ERROR;
	}
	public String delete()
	{
		if(new DB().deleteOrder(id))
			return SUCCESS;
		else
			return ERROR;
	}
}
