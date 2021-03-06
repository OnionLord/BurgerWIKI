package vr.mid.burgerdictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BurgerRegister extends Activity {

	EditText id;
	EditText pw;
	EditText confirm;
	EditText email;
	Button submit;
	Button cancel;
	NetInfo db = new NetInfo();
	String url = db.DBURL;
	String user = db.DBID;
	String pass = db.DBPW;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.burgerregister);
		id = (EditText)findViewById(R.id.reg_id);
		pw = (EditText)findViewById(R.id.reg_pw);
		confirm = (EditText)findViewById(R.id.reg_confirm);
		email = (EditText)findViewById(R.id.reg_mail);
		
	}
	
	public void onClickButton(View v)
	{
		switch(v.getId())
		{
		case R.id.reg_btn1:
			register();
			break;
		case R.id.reg_btn2:
			finish();
			break;
		}
	}

	
	private boolean duplicate(String id)
	{
		int cnt = 0;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            /* System.out.println("Database connection success"); */
            PreparedStatement stmt = null;
       
            ResultSet rs;
            
            stmt = con.prepareStatement("select count(*) from account where id=?");
            stmt.setString(1, id);
            
            rs = stmt.executeQuery();
            /*BurgerInfo b = 
    				new BurgerInfo(1, "싸이버거","맘스터치",437.8,882.8,3200,5400,
    						"http://cfile28.uf.tistory.com/image/17173C3650625BBC06ED33", 
    						"싸이버거<br>가수 싸이와는 관련 없다<br>닭다리살 패티");
    		info.add(b);*/
            rs.next();
            cnt = rs.getInt(1);
            
            stmt.close();
            rs.close();
            con.close();
            
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
		if(cnt == 1)
			return false;
		else
			return true;
	}
	
	private void register()
	{
		String rid = id.getText().toString();
		String rpw = pw.getText().toString();
		String rconfirm = confirm.getText().toString();
		String rmail = email.getText().toString();
		
		if(!rpw.equals(rconfirm))
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("비밀번호와 확인 비밀번호가 다릅니다.")
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();
		}
		else if(rid.length() < 8)
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("ID는 8자 이상입니다.")
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();
		}
		else if(rpw.length() < 8)
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("비밀번호 는 8자 이상입니다.")
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();
		}
		else if(rmail.length() < 4)
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("이메일 주소를 입력하세요.")
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();
		}
		else if(!duplicate(rid))
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("중복된 아이디 입니다.")
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();
		}
		else
		{
			Connection conn = null;
	    	PreparedStatement stmt = null;
	    	ResultSet rs = null;

			try {
				

	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(url, user, pass);
	            
	            
	            stmt = conn.prepareStatement
	            		("insert into account (id,pw,email) values(?,?,?)");
	            stmt.setString(1, rid);
	            stmt.setString(2, rpw);
	            stmt.setString(3, rmail);
	            
	            stmt.executeUpdate();
	            
	            new AlertDialog.Builder(this)
	        	.setTitle("Complete")
	        	.setMessage("계정 등록 성공.")
	        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
						
					}
				}).show();
	            
	        }
	        catch(Exception e) {
	            e.printStackTrace();
	            new AlertDialog.Builder(this)
	        	.setTitle("Error")
	        	.setMessage("에러발생. 연결을 다시 확인해 주세요.")
	        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				}).show();
	            //tv.setText(e.toString());
	        } 
	        finally
	        {
	        	if(stmt != null) try{ stmt.close(); }catch(SQLException ex){}
	        	 if(conn != null) try{ conn.close(); }catch(SQLException ex){}
	        	 if(rs != null) try{ rs.close();} catch(SQLException ex){}
	        }
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.burger_register, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
