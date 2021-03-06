package vr.mid.burgerdictionary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class BurgerSearch extends Activity {

	private EditText name;
	private EditText company;
	private EditText calone1;
	private EditText calone2;
	private EditText calset1;
	private EditText calset2;
	private EditText priceone1;
	private EditText priceone2;
	private EditText priceset1;
	private EditText priceset2;
	
	private CheckBox chk_name;
	private CheckBox chk_company;
	private CheckBox chk_calone;
	private CheckBox chk_calset;
	private CheckBox chk_priceone;
	private CheckBox chk_priceset;
	
	private double cone1 =0 ;
	private double cone2 = 99999999;
	private double cset1 = 0;
	private double cset2 = 99999999;
	private int pone1 = 0;
	private int pone2= 99999999;
	private int pset1 = 0;
	private int pset2= 99999999;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.burgersearch);
		name = (EditText)findViewById(R.id.search_name);
		company = (EditText)findViewById(R.id.search_company);
		calone1 = (EditText)findViewById(R.id.search_calone1);
		calone2 = (EditText)findViewById(R.id.search_calone2);
		calset1 = (EditText)findViewById(R.id.search_calset1);
		calset2 = (EditText)findViewById(R.id.search_calset2);
		priceone1 = (EditText)findViewById(R.id.search_priceone1);
		priceone2 = (EditText)findViewById(R.id.search_priceone2);
		priceset1 = (EditText)findViewById(R.id.search_priceset1);
		priceset2 = (EditText)findViewById(R.id.search_priceset2);
		
		chk_name = (CheckBox)findViewById(R.id.search_chk_name);
		chk_company = (CheckBox)findViewById(R.id.search_chk_company);
		chk_calone = (CheckBox)findViewById(R.id.search_chk_calone);
		chk_calset = (CheckBox)findViewById(R.id.search_chk_calset);
		chk_priceone = (CheckBox)findViewById(R.id.search_chk_priceone);
		chk_priceset = (CheckBox)findViewById(R.id.search_chk_priceset);
	}
	
	public void onSearchButton(View v)
	{
		if(chk_calone.isChecked())
		{
			try
			{
				cone1 = Double.parseDouble(calone1.getText().toString());
				cone2 = Double.parseDouble(calone2.getText().toString());
			}
			catch(Exception e)
			{
				
			}
			
		}
		if(chk_calset.isChecked())
		{
			try
			{
				cset1 = Double.parseDouble(calset1.getText().toString());
				cset2 = Double.parseDouble(calset2.getText().toString());
			}
			catch(Exception e)
			{
				
			}
			
			
		}
		if(chk_priceone.isChecked())
		{
			try
			{
				pone1 = Integer.parseInt(priceone1.getText().toString());
				pone2 = Integer.parseInt(priceone2.getText().toString());
			}
			catch(Exception e)
			{
				
			}
			
			
		}
		if(chk_priceset.isChecked())
		{
			try
			{
				pset1 = Integer.parseInt(priceset1.getText().toString());
				pset2 = Integer.parseInt(priceset2.getText().toString());
			}
			catch(Exception e)
			{
				
			}
			
		}

		
		if(!chk_name.isChecked() && !chk_company.isChecked() && !chk_calone.isChecked() && !chk_calset.isChecked() && !chk_priceset.isChecked() && !chk_priceone.isChecked())
		{
			new AlertDialog.Builder(this)
        	.setTitle("Fail")
        	.setMessage("검색 조건을 선택하세요.")
        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();
		}
		else
		{
			
			if((name.getText().toString().length() < 1) && chk_name.isChecked() )
			{
				new AlertDialog.Builder(this)
	        	.setTitle("Fail")
	        	.setMessage("이름을 입력하세요.")
	        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				}).show();
			}
			else if((company.getText().toString().length() < 1) && chk_company.isChecked())
			{
				new AlertDialog.Builder(this)
	        	.setTitle("Fail")
	        	.setMessage("브랜드를 입력하세요.")
	        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				}).show();
			}
			else if((calone1.getText().toString().length() < 1 || calone2.getText().toString().length() < 1|| cone1 > cone2 || cone1 < 0 || cone2 < 1) && chk_calone.isChecked())
			{
				new AlertDialog.Builder(this)
	        	.setTitle("Fail")
	        	.setMessage("단품 칼로리를 올바르게 입력하세요.")
	        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				}).show();
			}
			else if(chk_calset.isChecked() && (calset1.getText().toString().length() < 1 || calset2.getText().toString().length() < 1 || cset1 > cset2 || cset1 < 0 || cset2 < 1))
			{
				new AlertDialog.Builder(this)
	        	.setTitle("Fail")
	        	.setMessage("세트 칼로리를 올바르게 입력하세요.")
	        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				}).show();
			}
			else if((priceone1.getText().toString().length() < 1 || priceone2.getText().toString().length() < 1 || pone1 > pone2|| pone1 < 0 || pone2 < 1)&&chk_priceone.isChecked())
			{
				new AlertDialog.Builder(this)
	        	.setTitle("Fail")
	        	.setMessage("단품 가격을 올바르게 입력하세요.")
	        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				}).show();
			}
			else if(chk_priceset.isChecked() && (priceset1.getText().toString().length() < 1 || priceset2.getText().toString().length() < 1 || pset1 > pset2|| pset1 < 0 || pset2 < 1))
			{
				new AlertDialog.Builder(this)
	        	.setTitle("Fail")
	        	.setMessage("세트 가격을 올바르게 입력하세요.")
	        	.setPositiveButton("확인", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				}).show();
			}
			else
			{
				Intent intent = new Intent(BurgerSearch.this, BurgerList.class);
				intent.putExtra("category","search");
				
				if(chk_name.isChecked())
				{
					intent.putExtra("name", name.getText().toString());
				}
				else
				{
					intent.putExtra("name", "%%");
				}
				if(chk_company.isChecked())
				{
					intent.putExtra("company", company.getText().toString());
				}
				else
				{
					intent.putExtra("company", "%%");
				}
				if(chk_calone.isChecked())
				{
					intent.putExtra("calone1", cone1);
					intent.putExtra("calone2", cone2);
				}
				else
				{
					intent.putExtra("calone1", 0.0);
					intent.putExtra("calone2", 999999.0);
				}
				if(chk_calset.isChecked())
				{
					intent.putExtra("calset1", cset1);
					intent.putExtra("calset2", cset2);
				}
				else
				{
					intent.putExtra("calset1", 0.0);
					intent.putExtra("calset2", 999999.0);
				}
				if(chk_priceone.isChecked())
				{
					intent.putExtra("priceone1", pone1);
					intent.putExtra("priceone2", pone2);
				}
				else
				{
					intent.putExtra("priceone1", 0);
					intent.putExtra("priceone2", 999999);
				}
				if(chk_priceset.isChecked())
				{
					intent.putExtra("priceset1", pset1);
					intent.putExtra("priceset2", pset2);
				}
				else
				{
					intent.putExtra("priceset1", 0);
					intent.putExtra("priceset2", 999999);
				}
	        	startActivity(intent);
			}
			
		}
	}
	
	public void onBackButton(View v)
	{
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.burger_search, menu);
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
