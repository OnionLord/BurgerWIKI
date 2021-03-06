package vr.mid.burgerdictionary;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class BurgerMainLogin extends Activity {

	public void onClickButton(View v)
	{
		switch(v.getId())
		{
		case R.id.main1_btn_list:
			//Intent intent = new Intent(BurgerMainLogin.this, BurgerList.class);
			//intent.putExtra("id",id);
			//intent.putExtra("name",name);
        	//startActivity(intent);
        	Intent intent = new Intent(BurgerMainLogin.this, BurgerTotal.class);
			//intent.putExtra("id",id);
			//intent.putExtra("name",name);
        	startActivity(intent);
			break;
		case R.id.main1_btn_add:
			Intent intent1 = new Intent(BurgerMainLogin.this, BurgerAdd.class);
			//intent.putExtra("id",id);
			//intent.putExtra("name",name);
        	startActivity(intent1);
			break;
		case R.id.main1_btn_search:
			Intent intent2 = new Intent(BurgerMainLogin.this, BurgerSearch.class);
			//intent.putExtra("id",id);
			//intent.putExtra("name",name);
        	startActivity(intent2);
			break;
		case R.id.main1_btn_logout:
			logout();
			break;
		}
	}
	
	public void logout()
	{
		SharedPreferences prefs = getSharedPreferences( "login" , MODE_PRIVATE);
		SharedPreferences.Editor ed = prefs.edit();
		ed.putString( "id" , "null" );  
		ed.commit(); 

		Intent intent5 = new Intent(BurgerMainLogin.this, BurgerMain.class);
    	startActivity(intent5);
    	finish();
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.burgermainlogin);
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
		String id = null;

		

    }
    
    @Override
    protected void onResume()
    {
    	super.onResume();
    	logincheck();
    }
    
    public void logincheck()
    {
    	SharedPreferences prefs = getSharedPreferences( "login" ,MODE_PRIVATE);
		String id = prefs.getString( "id",  "null" );
		if(id.equals("null"))
		{
			Intent intent5 = new Intent(BurgerMainLogin.this, BurgerMain.class);
        	startActivity(intent5);
        	finish();
		}
		TextView t = (TextView)findViewById(R.id.main1_test);
		t.setText(id+"�� ȯ���մϴ�!");
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.burger_main_login, menu);
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
