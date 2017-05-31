      package srec.cse.srecprofilechange;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

	  public class LocationPage extends Activity {
	EditText lan,lat;
	Button save,off;
	LocationManager lm;
	LocationListener ll;
	SharedPreferences sp;
	Editor ed;
	double mylat,mylong;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location);
		lan=(EditText) findViewById(R.id.editText1);
		lat=(EditText) findViewById(R.id.editText2);
		save=(Button) findViewById(R.id.button1);
		off=(Button) findViewById(R.id.button2);

		sp=(SharedPreferences)getSharedPreferences("profile",Context.MODE_PRIVATE);
		lm=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
		ll=new LocationListener() {
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				mylat=location.getLatitude();
				mylong=location.getLongitude();
				lan.setText(mylat+"");
				lat.setText(mylong+"");
			}
		};
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,ll);
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ed=sp.edit();
				ed.putString("lat", mylat+"");
				ed.putString("long", mylong+"");
				ed.commit();
				lm.removeUpdates(ll);
	  			Intent pp=new Intent(LocationPage.this,ProfilePage.class);
				startService(pp);
				Toast.makeText(LocationPage.this, "Profile mode started", Toast.LENGTH_SHORT).show();
			}
		});
off.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
	  			Intent pp=new Intent(LocationPage.this,ProfilePage.class);
				stopService(pp);
				Toast.makeText(LocationPage.this, "Profile mode stopped", Toast.LENGTH_SHORT).show();

			}
		});
	}

}
