package vr.mid.burgerdictionary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class BurgerTotal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.burgertotal);
	}

	public void onClickButton(View v)
	{
		switch(v.getId())
		{
		case R.id.tot_btn_tot:
			Intent intent = new Intent(BurgerTotal.this, BurgerList.class);
			//intent.putExtra("id",id);
			intent.putExtra("category","total");
        	startActivity(intent);
			break;
		case R.id.tot_btn_mc:
			Intent intent1 = new Intent(BurgerTotal.this, BurgerList.class);
			//intent.putExtra("id",id);
			intent1.putExtra("category","mc");
        	startActivity(intent1);
			break;
		case R.id.tot_btn_ll:
			Intent intent2 = new Intent(BurgerTotal.this, BurgerList.class);
			//intent.putExtra("id",id);
			intent2.putExtra("category","ll");
        	startActivity(intent2);
			break;
		case R.id.tot_btn_kfc:
			Intent intent3 = new Intent(BurgerTotal.this, BurgerList.class);
			//intent.putExtra("id",id);
			intent3.putExtra("category","kfc");
        	startActivity(intent3);
			break;
		case R.id.tot_btn_bk:
			Intent intent4 = new Intent(BurgerTotal.this, BurgerList.class);
			//intent.putExtra("id",id);
			intent4.putExtra("category","bk");
        	startActivity(intent4);
			break;
		case R.id.tot_btn_mt:
			Intent intent5 = new Intent(BurgerTotal.this, BurgerList.class);
			//intent.putExtra("id",id);
			intent5.putExtra("category","mt");
        	startActivity(intent5);
			break;
		case R.id.tot_btn_etc:
			Intent intent6 = new Intent(BurgerTotal.this, BurgerList.class);
			//intent.putExtra("id",id);
			intent6.putExtra("category","etc");
        	startActivity(intent6);
			break;
		case R.id.tot_btn_back:
			finish();
			break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.burger_total, menu);
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
