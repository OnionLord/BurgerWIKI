package webContent;

public class UserInfo 
{
	private String id;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public UserInfo(String _id, String _email)
	{
		id = _id;
		email = _email;
	}
	public UserInfo()
	{
		
	}
	
	
}
