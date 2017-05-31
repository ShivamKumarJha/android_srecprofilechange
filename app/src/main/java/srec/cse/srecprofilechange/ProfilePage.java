package srec.cse.srecprofilechange;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.IBinder;

public class ProfilePage extends Service {
LocationManager lm;
LocationListener ll;
SharedPreferences sp;
AudioManager am;

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		lm=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
		sp=(SharedPreferences)getSharedPreferences("profile",Context.MODE_PRIVATE);
	am=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		lm.removeUpdates(ll);
	}

	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
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
				double lat=Double.parseDouble(sp.getString("lat",null));
			double long1=Double.parseDouble(sp.getString("long", null));
			Location loc1=new Location("src");
			loc1.setLatitude(lat);
			loc1.setLongitude(long1);
			Location loc2=new Location("dest");
			loc2.setLatitude(location.getLatitude());
			loc2.setLongitude(location.getLongitude());
			int dist=(int) loc1.distanceTo(loc2);
			
			if(dist<=20)
			{
				am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			}
			else
			{
				am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
			}
			}
		};
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,ll);
	
	}

}
