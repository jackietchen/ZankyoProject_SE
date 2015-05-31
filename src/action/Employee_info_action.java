package action;
import java.util.ArrayList;

import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;
import model.*;

import com.opensymphony.xwork2.ActionSupport;
import db.DB;

public class Employee_info_action extends ActionSupport {
	private Employee_info employee_info;
	private int id;
	public String execute() throws Exception 
	{
		return null;
	}
	public String add()
	{
		if(new DB().addEmployeeInfo(employee_info))
		{
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
	public String update()
	{
		if(new DB().updateEmployeeInfo(id, employee_info))
		{
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
	public String delete()
	{
		if(new DB().deleteEmployeeInfo(id))
		{
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}

}
