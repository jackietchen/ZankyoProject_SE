package db;
import java.sql.*;
import java.util.ArrayList;
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
	public ArrayList<User> queryUser()
	{
		try{
			ArrayList<User> userlist=new ArrayList<User>();
			pstmt=ct.prepareStatement("select * from user");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				User user=new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setAuthority(rs.getString(3));
				userlist.add(user);
			}
			return userlist;
		}catch(Exception e){
			e.printStackTrace();
			return null;
			}
	}
	public ArrayList<User> queryUser(String username, String password)
	{
		try{
			ArrayList<User> userlist=new ArrayList<User>();
			pstmt=ct.prepareStatement("select * from user where username=? and password=?");
			pstmt.setString(1,username);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			User user=new User();
			while(rs.next())
			{
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setAuthority(rs.getString(3));
				userlist.add(user);
				return userlist;
			}
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
			}
	}
	public ArrayList<Order> queryOrder()
	{
		try
		{
			ArrayList<Order> orderlist=new ArrayList<Order>();
			pstmt=ct.prepareStatement("select * from order");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Order order=new Order();
				order.setId(rs.getInt(1));
				order.setTable(rs.getString(2));
				order.setTime(rs.getDate(3));
				orderlist.add(order);
			}
			return orderlist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Order> queryOrder(int id)
	{
		try
		{
			ArrayList<Order> orderlist=new ArrayList<Order>();
			pstmt=ct.prepareStatement("select * from order where id = ?");
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Order order=new Order();
				order.setId(rs.getInt(1));
				order.setTable(rs.getString(2));
				order.setTime(rs.getDate(3));
				orderlist.add(order);
			}
			return orderlist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Menu> queryMenu()
	{
		try {
			ArrayList<Menu> menulist=new ArrayList<Menu>();
			pstmt=ct.prepareStatement("select * from menu");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Menu menu=new Menu();
				menu.setId(rs.getInt(1));
				menu.setImg(rs.getString(2));
				menu.setName(rs.getString(3));
				menu.setPrice(rs.getFloat(4));
				menu.setUnit(rs.getString(5));
				menulist.add(menu);
			}
			return menulist;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Menu> queryMenu(int id)
	{
		try 
		{
			ArrayList<Menu> menulist=new ArrayList<Menu>();
			pstmt=ct.prepareStatement("select * from menu where id = ?");
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Menu menu=new Menu();
				menu.setId(rs.getInt(1));
				menu.setImg(rs.getString(2));
				menu.setName(rs.getString(3));
				menu.setPrice(rs.getFloat(4));
				menu.setUnit(rs.getString(5));
				menulist.add(menu);
			}
			return menulist;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Cook> queryCook()
	{
		try {
			ArrayList<Cook> cooklist=new ArrayList<Cook>();
			pstmt=ct.prepareStatement("select * from cook");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Cook cook=new Cook();
				cook.setOrder_id(rs.getInt(1));
				cook.setMenu_id(rs.getInt(2));
				cook.setAmount(rs.getInt(3));
				cook.setStatus(rs.getString(4));
				cooklist.add(cook);
			}
			return cooklist;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Cook> queryCook(int order_id)
	{
		try {
			ArrayList<Cook> cooklist=new ArrayList<Cook>();
			pstmt=ct.prepareStatement("select * from cook where order_id = ?");
			pstmt.setInt(1, order_id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Cook cook=new Cook();
				cook.setOrder_id(rs.getInt(1));
				cook.setMenu_id(rs.getInt(2));
				cook.setAmount(rs.getInt(3));
				cook.setStatus(rs.getString(4));
				cooklist.add(cook);
			}
			return cooklist;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Employee_payment> queryEmployeePayment()
	{
		try {
			ArrayList<Employee_payment> employee_paymentlist=new ArrayList<Employee_payment>();
			pstmt=ct.prepareStatement("select * from employee_payment");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Employee_payment employee_payment=new Employee_payment();
				employee_payment.setId(rs.getInt(1));
				employee_payment.setEmployee_id(rs.getInt(2));
				employee_payment.setDate(rs.getDate(3));
				employee_payment.setPayment(rs.getFloat(4));
				employee_paymentlist.add(employee_payment);
			}
			return employee_paymentlist;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Employee_payment> queryEmployeePayment(int employee_id)
	{
		try {
			ArrayList<Employee_payment> employee_paymentlist=new ArrayList<Employee_payment>();
			pstmt=ct.prepareStatement("select * from employee_payment where employee_id = ?");
			pstmt.setInt(1, employee_id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Employee_payment employee_payment=new Employee_payment();
				employee_payment.setId(rs.getInt(1));
				employee_payment.setEmployee_id(rs.getInt(2));
				employee_payment.setDate(rs.getDate(3));
				employee_payment.setPayment(rs.getFloat(4));
				employee_paymentlist.add(employee_payment);
			}
			return employee_paymentlist;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Employee_info> queryEmployeeInfo()
	{
		try {
			ArrayList<Employee_info> employee_infolist=new ArrayList<Employee_info>();
			pstmt=ct.prepareStatement("select * from employee_info");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Employee_info employee_info=new Employee_info();
				employee_info.setId(rs.getInt(1));
				employee_info.setName(rs.getString(2));
				employee_info.setPosition(rs.getString(3));
				employee_info.setPayment(rs.getFloat(4));
				employee_infolist.add(employee_info);
			}
			return employee_infolist;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Employee_info> queryEmployeeInfo(int id, String name)
	{
		try {
			ArrayList<Employee_info> employee_infolist=new ArrayList<Employee_info>();
			pstmt=ct.prepareStatement("select * from employee_info where id = ?");
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Employee_info employee_info=new Employee_info();
				employee_info.setId(rs.getInt(1));
				employee_info.setName(rs.getString(2));
				employee_info.setPosition(rs.getString(3));
				employee_info.setPayment(rs.getFloat(4));
				employee_infolist.add(employee_info);
			}
			return employee_infolist;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Balance_daily> queryBalanceDaily()
	{
		try {
			ArrayList<Balance_daily> balance_dailylist=new ArrayList<Balance_daily>();
			pstmt=ct.prepareStatement("select * from balance_daily");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Balance_daily balance_daily=new Balance_daily();
				balance_daily.setTime(rs.getDate(1));
				balance_daily.setBalance(rs.getFloat(2));
				balance_dailylist.add(balance_daily);
			}
			return balance_dailylist;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Balance_detail> queryBalanceDetail()
	{
		try {
			ArrayList<Balance_detail> balance_detaillist=new ArrayList<Balance_detail>();
			pstmt=ct.prepareStatement("select * from balance_detail");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Balance_detail balance_detail=new Balance_detail();
				balance_detail.setId(rs.getInt(1));
				balance_detail.setTime(rs.getDate(2));
				balance_detail.setName(rs.getString(3));
				balance_detail.setAmount(rs.getInt(4));
				balance_detail.setBalance(rs.getFloat(5));
				balance_detaillist.add(balance_detail);
			}
			return balance_detaillist;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public boolean addUser(User user)
	{
		try{
			pstmt=ct.prepareStatement("insert into user (username, password,authority) values(?,?,?)");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getAuthority());
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean addOrder(Order order)
	{
		try {
			pstmt=ct.prepareStatement("insert into order (id, time, table) values(?, ?, ?)");
			pstmt.setInt(1, order.getId());
			pstmt.setDate(2, order.getTime());
			pstmt.setString(3, order.getTable());
			pstmt.executeQuery();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public boolean addMenu(Menu menu)
	{
		try {
			pstmt=ct.prepareStatement("insert into menu (id, name, price, unit, img) values(?, ?, ?, ?, ?)");
			pstmt.setInt(1,menu.getId());
			pstmt.setString(2, menu.getName());
			pstmt.setFloat(3, menu.getPrice());
			pstmt.setString(4, menu.getUnit());
			pstmt.setString(5, menu.getImg());
			pstmt.executeQuery();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public boolean addEmployeePayment(Employee_payment employee_payment)
	{
		try {
			pstmt=ct.prepareStatement("insert into employee_payment (id, employee_id, date, payment) values(?, ?, ?, ?)");
			pstmt.setInt(1,employee_payment.getId());
			pstmt.setInt(2, employee_payment.getEmployee_id());
			pstmt.setDate(3, employee_payment.getDate());
			pstmt.setFloat(4, employee_payment.getPayment());
			pstmt.executeQuery();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public boolean addEmployeeInfo(Employee_info employee_info)
	{
		try {
			pstmt=ct.prepareStatement("insert into employee_info (id, name, position, payment) values(?, ?, ?, ?)");
			pstmt.setInt(1,employee_info.getId());
			pstmt.setString(2, employee_info.getName());
			pstmt.setString(3, employee_info.getPosition());
			pstmt.setFloat(4, employee_info.getPayment());
			pstmt.executeQuery();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public boolean addBalanceDaily(Balance_daily balance_daily)
	{
		try {
			pstmt=ct.prepareStatement("insert into balance_daily (time, balance) values(?, ?)");
			pstmt.setDate(1,balance_daily.getTime());
			pstmt.setFloat(2, balance_daily.getBalance());
			pstmt.executeQuery();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public boolean addBalanceDetail(Balance_detail balance_detail)
	{
		try {
			pstmt=ct.prepareStatement("insert into balance_detail (id, time, name, amount, balance) values(?, ?, ?, ?, ?)");
			pstmt.setInt(1, balance_detail.getId());
			pstmt.setDate(2,balance_detail.getTime());
			pstmt.setString(3, balance_detail.getName());
			pstmt.setInt(4, balance_detail.getAmount());
			pstmt.setFloat(5, balance_detail.getBalance());
			pstmt.executeQuery();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateUser(User user)
	{
		try{
			pstmt=ct.prepareStatement("update user set password= ?, authority = ? where username = ?");
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getAuthority());
			pstmt.setString(3, user.getUsername());
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateMenu(int id, Menu menu)
	{
		try{
			pstmt=ct.prepareStatement("update menu set name= ?, price = ?, unit = ?, img = ? where id = ?");
			pstmt.setString(1, menu.getName());
			pstmt.setFloat(2, menu.getPrice());
			pstmt.setString(3, menu.getUnit());
			pstmt.setString(4, menu.getImg());
			pstmt.setInt(5, id);
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateCook(int order_id, String status)
	{
		try{
			pstmt=ct.prepareStatement("update cook set status= ? where order_id = ?");
			pstmt.setString(1, status);
			pstmt.setInt(2, order_id);
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateEmployeeInfo(int id, Employee_info employee_info)
	{
		try{
			pstmt=ct.prepareStatement("update employee_info set name= ?, position = ?, payment = ? where id = ?");
			pstmt.setString(1, employee_info.getName());
			pstmt.setString(2, employee_info.getPosition());
			pstmt.setFloat(3, employee_info.getPayment());
			pstmt.setInt(4, id);
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateBalanceDetail(int id, Balance_detail balance_detail)
	{
		try{
			pstmt=ct.prepareStatement("update balance_detail set time= ?, name = ?, amount = ?, balance = ? where id = ?");
			pstmt.setDate(1, balance_detail.getTime());
			pstmt.setString(2, balance_detail.getName());
			pstmt.setInt(3, balance_detail.getAmount());
			pstmt.setFloat(4, balance_detail.getBalance());
			pstmt.setInt(5, id);
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteUser(String username)
	{
		try{
			pstmt=ct.prepareStatement("delete from user where username = ?");
			pstmt.setString(1, username);
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteOrder(int id)
	{
		try{
			pstmt=ct.prepareStatement("delete from order where id = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteMenu(int id)
	{
		try{
			pstmt=ct.prepareStatement("delete from menu where id = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteCook(int order_id)
	{
		try{
			pstmt=ct.prepareStatement("delete from cook where order_id = ?");
			pstmt.setInt(1, order_id);
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteEmployeePayment(int id)
	{
		try{
			pstmt=ct.prepareStatement("delete from employee_payment where id = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteEmployeeInfo(int id)
	{
		try{
			pstmt=ct.prepareStatement("delete from employee_info where id = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteBalanceDaily(Date time)
	{
		try{
			pstmt=ct.prepareStatement("delete from balance_daily where time = ?");
			pstmt.setDate(1, time);
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteBalanceDetail(int id)
	{
		try{
			pstmt=ct.prepareStatement("delete from balance_detail where id = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
