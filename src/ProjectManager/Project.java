package ProjectManager;

import java.sql.Date;



public class Project {

	private String name;
	private Date stdate;
	private Date edate;
	
	public Project(String name, Date sdate, Date edate) {
		// TODO Auto-generated constructor stub
		setName(name);
		setStdate(sdate);
		setEdate(edate);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStdate() {
		return stdate;
	}

	public void setStdate(Date stdate) {
		this.stdate = stdate;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	
}
