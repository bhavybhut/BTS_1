package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
 
import admin.User;
import admin.ViewFilter;
 
public class ViewUser {
 
    private static List<User> userList = new ArrayList<User>();
    @Wire
    private static Label viewunm;
    private static void initData() {
        if (!userList.isEmpty())
        	userList.clear();
        PreparedStatement stmt;
		Connection conn;
		ResultSet rs;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/BTS?user=root&password=password");
			stmt = conn.prepareStatement("select name,unm,desig,email,pm,dept from user");
			rs = stmt.executeQuery();
			while(rs.next())
			{
				String name = rs.getString(1);
				String unm = rs.getString(2);
				String desig = rs.getString(3);
				String email = rs.getString(4);
				String pm = rs.getString(5);
				String dept = rs.getString(6);
				userList.add(new User(name, unm, desig, email, pm, dept));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
    
    public User getUser(String unm){
    	PreparedStatement stmt;
    	Statement st;
		Connection conn;
		ResultSet r,rs;
		User user = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/BTS?user=root&password=password");
			st = conn.createStatement();
			st.executeQuery("select name,unm,desig,email,pm,dept from user where unm="+unm+";");
			r = st.getResultSet();
			while(r.next()){
				user = new User(r.getString("name"),r.getString("unm"),r.getString("desig"),r.getString("email"),r.getString("pm"),r.getString("dept"));
			}
			/*stmt = conn.prepareStatement("select name,unm,desig,email,pm,dept from user where name="+nm);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				String name = rs.getString(1);
				String unm = rs.getString(2);
				String desig = rs.getString(3);
				String email = rs.getString(4);
				String pm = rs.getString(5);
				String dept = rs.getString(6);
				user = new User(name,unm,desig,email,pm,dept);
			}*/
			r.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
    }
    
    public static List<User> getAllUsers() {
    	initData();
        return new ArrayList<User>(userList);
    }
    public static User[] getAllFoodsArray() {
        return userList.toArray(new User[userList.size()]);
    }
 
    // This Method only used in "Data Filter" Demo
    public static List<User> getFilterUsers(ViewFilter userFilter) {
        List<User> someusers = new ArrayList<User>();
        String name = userFilter.getName().toLowerCase();
        String unm = userFilter.getUsername().toLowerCase();
        String dept = userFilter.getDept().toLowerCase();
         
        for (Iterator<User> i = userList.iterator(); i.hasNext();) {
            User tmp = i.next();
            if (tmp.getName().toLowerCase().contains(name) &&
                tmp.getUsername().toLowerCase().contains(unm)  &&
                tmp.getDept().toLowerCase().contains(dept)) {
                someusers.add(tmp);
            }
        }
        return someusers;
    }
}