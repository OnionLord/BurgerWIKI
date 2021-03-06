package webContent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class contentDAO 
{
	private int viewNo;
	private static final String url = "jdbc:mysql://localhost:3306/mid";
    private static final String user = "knumobile";
    private static final String pass = "knumobile";
    private BurgerInfo binfo;
    private UserInfo uinfo;
    
    public contentDAO(int n)
    {
    	viewNo = n;
    }
    
    public BurgerInfo getBurgerInfo()
    {
    	return binfo;
    }
    
    public UserInfo getUserInfo()
    {
    	return uinfo;
    }
    
	public void conn() 
	{
		
		 
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement stmt = null;
            
            ResultSet rs;
            
            stmt = con.prepareStatement("select no, name, company, calone, calset, priceone, priceset, image, content, moduser,modified from burger_content where no=?");
            stmt.setInt(1, viewNo);
            
            rs = stmt.executeQuery();
            

           rs.next();
           binfo = new BurgerInfo(rs.getInt("no"), rs.getString("name"), 
       			rs.getString("company"), rs.getDouble("calone"), 
       			rs.getDouble("calset"), rs.getInt("priceone"), 
       			rs.getInt("priceset"), rs.getString("image"), rs.getString("content"),rs.getString("moduser"),rs.getTimestamp("modified"));
           
           stmt.close();
           rs.close();
           con.close();
           
		}
        catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }   
		
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement stmt = null;
            
            ResultSet rs;
            
            stmt = con.prepareStatement("select id,email from account where id=?");
            stmt.setString(1, binfo.getModuser());
            
            rs = stmt.executeQuery();
            

           rs.next();
           uinfo = new UserInfo(rs.getString("id"), rs.getString("email"));
           
           stmt.close();
           rs.close();
           con.close();
           
		}
        catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }  
	}
}
