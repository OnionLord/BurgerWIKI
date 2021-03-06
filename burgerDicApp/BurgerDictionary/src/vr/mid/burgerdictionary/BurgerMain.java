package vr.mid.burgerdictionary;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;


public class BurgerMain extends Activity {

	public void onClickButton(View v)
	{
		switch(v.getId())
		{
		case R.id.main_btn_list:
			//Intent intent = new Intent(BurgerMain.this, BurgerList.class);
			//intent.putExtra("id",id);
			//intent.putExtra("name",name);
        	//startActivity(intent);
			Intent intent = new Intent(BurgerMain.this, BurgerTotal.class);
			//intent.putExtra("id",id);
			//intent.putExtra("name",name);
        	startActivity(intent);
			
			break;
		case R.id.main_btn_reg:
			Intent intent3 = new Intent(BurgerMain.this, BurgerRegister.class);
			//intent.putExtra("id",id);
			//intent.putExtra("name",name);
        	startActivity(intent3);
			break;
		case R.id.main_btn_login:
			Intent intent4 = new Intent(BurgerMain.this, BurgerLogin.class);
			//intent.putExtra("id",id);
			//intent.putExtra("name",name);
        	startActivity(intent4);
			break;
		case R.id.main_btn_search:
			Intent intent5 = new Intent(BurgerMain.this, BurgerSearch.class);
			//intent.putExtra("id",id);
			//intent.putExtra("name",name);
        	startActivity(intent5);
			break;
			
		}
	}
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
		
		
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
		if(!id.equals("null"))
		{
			Intent intent5 = new Intent(BurgerMain.this, BurgerMainLogin.class);
        	startActivity(intent5);
        	finish();
		}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.burger_main, menu);
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
