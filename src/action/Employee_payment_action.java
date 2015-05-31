package action;
import java.util.ArrayList;

import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;
import model.*;

import com.opensymphony.xwork2.ActionSupport;
import db.DB;

public class Employee_payment_action extends ActionSupport {
	private Employee_payment employee_payment;
	private int id;
	public String execute() throws Exception 
	{
		return null;
	}
	public String add()
	{
		if(new DB().addEmployeePayment(employee_payment))
			return SUCCESS;
		else
			return ERROR;
	}
	public String delete()
	{
		if(new DB().deleteEmployeePayment(id))
			return SUCCESS;
		else
			return ERROR;
	}
	
}
