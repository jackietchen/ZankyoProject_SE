package action;

import java.util.ArrayList;

import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;
import model.*;

import com.opensymphony.xwork2.ActionSupport;
import db.DB;

public class Menu_action extends ActionSupport {
	private Menu menu;
	private int id;
	public String execute() throws Exception 
	{
		return null;
	}
	public String add()
	{
		if(new DB().addMenu(menu))
			return SUCCESS;
		else
			return ERROR;
	}
	public String update()
	{
		if(new DB().updateMenu(id, menu))
			return SUCCESS;
		else
			return ERROR;
	}
	public String delete()
	{
		if(new DB().deleteMenu(id))
			return SUCCESS;
		else
			return ERROR;
	}
}
