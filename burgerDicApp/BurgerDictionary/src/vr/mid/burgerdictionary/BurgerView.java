package vr.mid.burgerdictionary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class BurgerView extends Activity {
	
	private int no;
	private WebView wb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.burgerview);
		NetInfo info = new NetInfo();
		Intent intent = getIntent();
		no = intent.getExtras().getInt("no");

		wb = (WebView)findViewById(R.id.view_web);
	        wb.setWebViewClient(new WebViewClient());
	        WebSettings set = wb.getSettings();

	        
	        wb.loadUrl(info.webURL+no);
	        
	}
	@Override
	protected void onResume()
	{
		super.onResume();
		wb.reload();
	}
	
	public void onButtonClick(View v)
	{
		switch(v.getId())
		{
		case R.id.view_btn_back:
			finish();
			break;
		case R.id.view_btn_mod:
			logincheck();
			break;
		}
	}
	public void logincheck()
    {
    	SharedPreferences prefs = getSharedPreferences( "login" ,MODE_PRIVATE);
		String id = prefs.getString( "id",  "null" );
		if(!id.equals("null"))
		{
        	Intent intent = new Intent(BurgerView.this, BurgerMod.class);
			intent.putExtra("no",no);
        	startActivity(intent);
		}
		else
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("로그인 해주세요.")
        	.setNegativeButton("취소", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
				}
			})
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(BurgerView.this, BurgerLogin.class);
		        	startActivity(intent);
					
				}
			}).show();
		}
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.burger_view, menu);
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
