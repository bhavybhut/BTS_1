package admin;

public class User {
    private String name;
    private String username;
    private String designation;
    private String email;
    private String pm;
    private String dept;
    private int id;
    
    
 
    public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String username, String designation, String email, String pm, String dept) {
    	setName(name);
    	setUsername(username);
    	setDesignation(designation);
    	setEmail(email);
    	setPm(pm);
    	setDept(dept);
    }
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getDesignation() {
        return designation;
    }
 
    public void setDesignation(String designation) {
        this.designation = designation;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPm() {
        return pm;
    }
 
    public void setPm(String pm) {
        this.pm = pm;
    }
 
    public String getDept() {
        return dept;
    }
 
    public void setDept(String dept) {
        this.dept = dept;
    }
 
}