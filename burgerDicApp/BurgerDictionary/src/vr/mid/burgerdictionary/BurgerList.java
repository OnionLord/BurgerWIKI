package vr.mid.burgerdictionary;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class BurgerList extends Activity {
	
	private String sname;
	private String scompany;
	private double scalone1;
	private double scalone2;
	private double scalset1;
	private double scalset2;

	private int spriceone1;
	private int spriceone2;
	private int spriceset1;
	private int spriceset2;
	
	ArrayList<BurgerInfo> info;
	private String category;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.burgerlist);
		info = new ArrayList<BurgerInfo>();
		Intent intent = getIntent();
		category = intent.getExtras().getString("category");
		
		if(category.equals("search"))
		{
			sname = intent.getExtras().getString("name");
		Log.i("name", sname);
		scompany = intent.getExtras().getString("company");
		Log.i("name1",scompany);
		scalone1 = intent.getExtras().getDouble("calone1");
		Log.i("name2", Double.toString(scalone1));
		scalone2 = intent.getExtras().getDouble("calone2");
		Log.i("name3", Double.toString(scalone2));
		scalset1 = intent.getExtras().getDouble("calset1");
		Log.i("name4", Double.toString(scalset1));
		scalset2 = intent.getExtras().getDouble("calset2");
		Log.i("name5", Double.toString(scalset2));
		spriceone1 = intent.getExtras().getInt("priceone1");
		Log.i("name6", Integer.toString(spriceone1));
		spriceone2 = intent.getExtras().getInt("priceone2");
		Log.i("name7", Integer.toString(spriceone2));
		spriceset1 = intent.getExtras().getInt("priceset1");
		Log.i("name8", Integer.toString(spriceset1));
		spriceset2 = intent.getExtras().getInt("priceset2");
		Log.i("name9", Integer.toString(spriceset2));
		}
		
		//(int no, String name, String company, float calone, float calset,
		//		int priceone, int priceset, String image)
		
		
		getDataFromDB();
		
		BurgerAdapter bAdap = new BurgerAdapter(this, R.layout.burgeritem, info);
		
		ListView bList;
		bList = (ListView)findViewById(R.id.list_total);
		bList.setAdapter(bAdap);
	}
	
	private void getDataFromDB()
	{
		//String url = "jdbc:mysql://192.168.0.5:3306/mid";
	   // String user = "knumobile";
	    //String pass = "knumobile";
		
		NetInfo db = new NetInfo();
		String url = db.DBURL;
		String user = db.DBID;
		String pass = db.DBPW;
	
	    try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            /* System.out.println("Database connection success"); */

            PreparedStatement stmt = null;
            Statement st = con.createStatement();
            ResultSet rs = null;
            //if(rb_name.)
            //Log.i("category", category);
            if(category.equals("etc"))
            {
                rs = st.executeQuery("select no, name, company, calone, calset, priceone, priceset, image from burger_content where company not in ('�Ƶ�����','�Ե�����','KFC','����ŷ','������ġ') order by name");
            }
            else if(category.equals("mc"))
            {
                rs = st.executeQuery("select no, name, company, calone, calset, priceone, priceset, image from burger_content where company='�Ƶ�����' order by name");
            }
            else if(category.equals("ll"))
            {
                rs = st.executeQuery("select no, name, company, calone, calset, priceone, priceset, image from burger_content where company='�Ե�����' order by name");
            }
            else if(category.equals("kfc"))
            {
                rs = st.executeQuery("select no, name, company, calone, calset, priceone, priceset, image from burger_content where company='KFC' order by name");
            }
            else if(category.equals("bk"))
            {
                rs = st.executeQuery("select no, name, company, calone, calset, priceone, priceset, image from burger_content where company='����ŷ' order by name");
            }
            else if(category.equals("mt"))
            {
                rs = st.executeQuery("select no, name, company, calone, calset, priceone, priceset, image from burger_content where company='������ġ' order by name");
            }
            else if(category.equals("search"))
            {
            	String search_name = "";
            	String search_company = "";
            	StringTokenizer token1 = new StringTokenizer(sname);
            	while(token1.hasMoreTokens())
            	{
            		search_name += "%";
            		search_name += token1.nextToken();
            		search_name += "%";
            	}
            	StringTokenizer token2 = new StringTokenizer(scompany);
            	while(token2.hasMoreTokens())
            	{
            		search_company += "%";
            		search_company += token2.nextToken();
            		search_company += "%";
            	}
            	 stmt = con.prepareStatement("select no, name, company, calone, calset, priceone, priceset, image, content from burger_content where name like ? and company like ? and calone >= ? and calone <= ? and calset >= ? and calset <= ? and priceone >= ? and priceone <= ? and priceset >= ? and priceset <= ?");
                 stmt.setString(1, search_name);
                 stmt.setString(2, search_company);
                 stmt.setDouble(3, scalone1);
                 stmt.setDouble(4, scalone2);
                 stmt.setDouble(5, scalset1);
                 stmt.setDouble(6, scalset2);
                 stmt.setInt(7, spriceone1);
                 stmt.setInt(8, spriceone2);
                 stmt.setInt(9, spriceset1);
                 stmt.setInt(10, spriceset2);
                 
                 rs = stmt.executeQuery();
               // rs = st.executeQuery("select no, name, company, calone, calset, priceone, priceset, image from burger_content where name like ? and company like ?");
                
            }
            else
            {
                rs = st.executeQuery("select no, name, company, calone, calset, priceone, priceset, image from burger_content order by name");
            }
            //ResultSetMetaData rsmd = rs.getMetaData();
            /*BurgerInfo b = 
    				new BurgerInfo(1, "���̹���","������ġ",437.8,882.8,3200,5400,
    						"http://cfile28.uf.tistory.com/image/17173C3650625BBC06ED33", 
    						"���̹���<br>���� ���̿ʹ� ���� ����<br>�ߴٸ��� ��Ƽ");
    		info.add(b);*/
            while(rs.next()) {
            	BurgerInfo b = new BurgerInfo(rs.getInt("no"), rs.getString("name"), 
            			rs.getString("company"), rs.getDouble("calone"), 
            			rs.getDouble("calset"), rs.getInt("priceone"), 
            			rs.getInt("priceset"), rs.getString("image"));
            	info.add(b);
            }
            st.close();
            rs.close();
            con.close();
            
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
	}
	
	
	public void onClickButton(View v)
	{
		switch(v.getId())
		{
		case R.id.list_btn_back:
			finish();
			break;
		}
	}

	class BurgerAdapter extends BaseAdapter
	{
		Context maincon;
		LayoutInflater Inflater;
		ArrayList<BurgerInfo> blist;
		int layout;
		
		public BurgerAdapter(Context context, int alayout, ArrayList<BurgerInfo> b)
		{
			maincon = context;
			Inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = alayout;
			blist = b;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return blist.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return blist.get(arg0).getName();
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			final int pos = position;
			
			if(convertView == null)
			{
				convertView = Inflater.inflate(layout, parent, false);
			}
			TextView txt = (TextView)convertView.findViewById(R.id.item_txt);
			ImageView iv = (ImageView)convertView.findViewById(R.id.item_image);
			
			try
			{
				URL url = new URL(blist.get(position).getImage());
				URLConnection conn = url.openConnection();
				BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
				Bitmap bm = BitmapFactory.decodeStream(bis);
				bis.close();
				iv.setImageBitmap(bm);
			}
			catch(Exception e)
			{
				iv.setImageAlpha(R.drawable.ic_launcher);
			}
			
			String btxt = blist.get(position).getName() + "("+blist.get(position).getCompany()+")";
			//String btxt =String.format("%-30s(%s)", blist.get(position).getName(),blist.get(position).getCompany());
			txt.setText(btxt);
			
			Button btn = (Button)convertView.findViewById(R.id.item_btn_view);
			
			btn.setOnClickListener(new Button.OnClickListener()
			{
				public void onClick(View v)
				{
					Intent intent = new Intent(BurgerList.this, BurgerView.class);
					intent.putExtra("no",blist.get(pos).getNo());
	            	startActivity(intent);

				}
			});
			
			return convertView;
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.burger_list, menu);
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
