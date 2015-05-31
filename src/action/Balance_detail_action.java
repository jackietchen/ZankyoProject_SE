package action;

import java.util.ArrayList;

import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;
import model.*;

import com.opensymphony.xwork2.ActionSupport;
import db.DB;

public class Balance_detail_action extends ActionSupport {
	private Balance_detail balance_detail;
	private int id;
	public String execute() throws Exception 
	{
		return null;
	}
	public String add()
	{
		if(new DB().addBalanceDetail(balance_detail))
			return SUCCESS;
		else
			return ERROR;
	}
	public String update()
	{
		if(new DB().updateBalanceDetail(id, balance_detail))
			return SUCCESS;
		else
			return ERROR;
	}
	public String delete()
	{
		if(new DB().deleteBalanceDetail(id))
			return SUCCESS;
		else
			return ERROR;
	}
}
