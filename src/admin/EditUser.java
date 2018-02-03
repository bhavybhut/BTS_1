package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class EditUser extends SelectorComposer<Window>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StoreComponent combo = new StoreComponent();
	@Wire
	private Textbox name;
	@Wire
	private Textbox unm;
	@Wire
	private Combobox desig;
	@Wire
	private Textbox email;
	@Wire
	private Textbox pm;
	@Wire
	private Textbox dept;
	@Listen("onClick=button")
	public void initData()
	{
		PreparedStatement stmt,s;
		Connection conn;
		ResultSet rs;
		int id;
		try{
			combo.doAfterCompose(desig);
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/BTS?user=root&password=password");
			s = conn.prepareStatement("select id from user");
			rs = s.executeQuery();
			id = rs.getInt(1);
			stmt = conn.prepareStatement("update table user set name=?,unm=?,desig=?,email=?,pm=?,dept=? where u_id=?");
			stmt.setString(1, name.getValue());
			stmt.setString(2, unm.getValue());
			stmt.setString(3, String.valueOf(desig.getSelectedItem().getValue()));
			stmt.setString(4, email.getValue());
			stmt.setString(5, pm.getValue());
			stmt.setString(6, dept.getValue());
			stmt.setInt(7, id);
			stmt.executeUpdate();
			rs.close();
			conn.close();
		}catch(Exception e){}
	}
	
}
