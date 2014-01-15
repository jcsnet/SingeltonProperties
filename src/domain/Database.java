package domain;

public class Database {
	
	private String name;
	private String user;
	private String password;
	private String url;
	private String port;
	private String driver;
	
	public Database(){
	}
	
	public Database(String name, String user, String password, String url,
			String port, String driver) {
		this.name = name;
		this.user = user;
		this.password = password;
		this.url = url;
		this.port = port;
		this.driver = driver;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getPort() {
		return port;
	}
	
	public void setPort(String port) {
		this.port = port;
	}
	
	public String getDriver() {
		return driver;
	}
	
	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	@Override
	public String toString() {
		return "\ndb.name = "+name+"\n"
				+"db.user = "+user+"\n"
				+"db.password = "+password+"\n"
				+"db.url = "+url+"\n"
				+"db.port = "+port+"\n"
				+"db.driver = "+driver;
	}
}
