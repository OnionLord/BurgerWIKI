package vr.mid.burgerdictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class BurgerLogin extends Activity {

	NetInfo db = new NetInfo();
	String url = db.DBURL;
	String user = db.DBID;
	String pass = db.DBPW;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.burgerlogin);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.burger_login, menu);
		return true;
	}
	
	private void check()
	{
		EditText chk_id = (EditText)findViewById(R.id.login_id);
		EditText chk_pw = (EditText)findViewById(R.id.login_pw);
		final String id = chk_id.getText().toString();
		String pw = chk_pw.getText().toString();
		int cnt = 0;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            /* System.out.println("Database connection success"); */
            PreparedStatement stmt = null;
       
            ResultSet rs;
            
            stmt = con.prepareStatement("select count(*) from account where id=? and pw=?");
            stmt.setString(1, id);
            stmt.setString(2, pw);
            
            rs = stmt.executeQuery();
        
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
		{
			new AlertDialog.Builder(this)
        	.setTitle("Success")
        	.setMessage("로그인 성공.")
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					SharedPreferences prefs = getSharedPreferences( "login" , MODE_PRIVATE);
					SharedPreferences.Editor ed = prefs.edit();
					ed.putString( "id" , id );  
					ed.commit(); 
					
					
					finish();
					
				}
			}).show();
			
		}
		else
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("로그인 실패.")
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();
		}
		
	}
	
	
	public void onClickButton(View v)
	{
		switch(v.getId())
		{
		case R.id.login_btn1:
			check();
			break;
		case R.id.login_btn2:
			finish();
			break;
		}
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
