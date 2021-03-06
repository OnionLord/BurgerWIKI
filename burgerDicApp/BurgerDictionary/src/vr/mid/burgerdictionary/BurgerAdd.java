package vr.mid.burgerdictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class BurgerAdd extends Activity {

	private EditText name;
	private EditText company;
	private EditText calone;
	private EditText calset;
	private EditText priceone;
	private EditText priceset;
	private EditText image;
	private EditText content;
	//private int no;
	private BurgerInfo b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Intent intent = getIntent();
		//no = intent.getExtras().getInt("no");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.burgeradd);
		
		name = (EditText)findViewById(R.id.add_name);
		company = (EditText)findViewById(R.id.add_company);
		calone = (EditText)findViewById(R.id.add_calone);
		calset = (EditText)findViewById(R.id.add_calset);
		priceone = (EditText)findViewById(R.id.add_priceone);
		priceset = (EditText)findViewById(R.id.add_priceset);
		image = (EditText)findViewById(R.id.add_image);
		content = (EditText)findViewById(R.id.add_content);
		
		
	}
	
	public void onClickButton(View v)
	{
		switch(v.getId())
		{
		case R.id.add_commit:
			updateDB();
			break;
		case R.id.add_cancel:
			finish();
			break;
		}
	}
	
	private void updateDB()
	{
		if(name.getText().toString() == null || name.getText().toString() == ""|| name.getText().toString().length() < 1)
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("이름을 적어 주세요.")
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();

		}
		else if(company.getText().toString() == null || company.getText().toString() == ""|| company.getText().toString().length() < 1)
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("브랜드를 적어 주세요.")
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();
		}
		else if(calone.getText().toString() == null || calone.getText().toString() == ""|| calone.getText().toString().length() < 1)
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("칼로리(단품)를 적어 주세요.")
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();
		}
		else if(calset.getText().toString() == null || calset.getText().toString() == "" || calset.getText().toString().length() < 1)
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("칼로리(세트)를 적어 주세요.")
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();
		}
		else if(priceone.getText().toString() == null || priceone.getText().toString() == "" || priceone.getText().toString().length() < 1)
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("가격(단품)을 적어 주세요.")
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();
		}
		else if(priceset.getText().toString() == null || priceset.getText().toString() == "" || priceset.getText().toString().length() < 1 )
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("가격(세트)을 적어 주세요.")
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();
		}
		else if(image.getText().toString() == null || image.getText().toString() == ""|| image.getText().toString().length() < 1)
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("그림의 URL을 적어 주세요.")
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();
		}
		else if(content.getText().toString() == null || content.getText().toString() == ""|| company.getText().toString().length() < 1)
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("내용을 적어 주세요.")
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
	    	NetInfo db = new NetInfo();
			String url = db.DBURL;
			String user = db.DBID;
			String pass = db.DBPW;
			SharedPreferences prefs = getSharedPreferences( "login" ,MODE_PRIVATE);
			String login_user = prefs.getString( "id",  "admin" );
			int max_no = 0;
			
			try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con1 = DriverManager.getConnection(url, user, pass);
	            /* System.out.println("Database connection success"); */
	            PreparedStatement stmt1 = null;
	       
	            ResultSet rs1;
	            
	            stmt1 = con1.prepareStatement("select max(no) from burger_content");

	            
	            rs1 = stmt1.executeQuery();
	        
	            rs1.next();
	            max_no = rs1.getInt(1)+1;
	            
	            stmt1.close();
	            rs1.close();
	            con1.close();
	            
	        }
	        catch(Exception e) {
	            e.printStackTrace();
	            System.out.println(e.toString());
	        }
			
			try {
				

	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(url, user, pass);
	            
	            
	            stmt = conn.prepareStatement
	            		("insert into burger_content"
	            				+ " (no, name, company, calone, calset, priceone, priceset, image,content,modified,moduser)"
	            				+ " values(?,?,?,?,?,?,?,?,?,sysdate(),?)");
	            stmt.setInt(1, max_no);
	            stmt.setString(2, name.getText().toString());
	            stmt.setString(3, company.getText().toString());
	            stmt.setDouble(4, Double.parseDouble(calone.getText().toString()));
	            stmt.setDouble(5, Double.parseDouble(calset.getText().toString()));
	            stmt.setInt(6, Integer.parseInt(priceone.getText().toString()));
	            stmt.setInt(7, Integer.parseInt(priceset.getText().toString()));
	            stmt.setString(8, image.getText().toString());
	            stmt.setString(9, content.getText().toString());
	            stmt.setString(10, login_user);
	           /* stmt.setString(1, name.getText().toString());
	            stmt.setString(2, company.getText().toString());
	            stmt.setDouble(3, Double.parseDouble(calone.getText().toString()));
	            stmt.setDouble(4, Double.parseDouble(calset.getText().toString()));
	            stmt.setInt(5, Integer.parseInt(priceone.getText().toString()));
	            stmt.setInt(6, Integer.parseInt(priceset.getText().toString()));
	            stmt.setString(7, image.getText().toString());
	            stmt.setString(8, content.getText().toString());*/

	            stmt.executeUpdate();
	            
	            new AlertDialog.Builder(this)
	        	.setTitle("Complete")
	        	.setMessage("작성 성공.")
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
		getMenuInflater().inflate(R.menu.burger_add, menu);
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
