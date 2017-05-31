package srec.cse.srecprofilechange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ToggleButton;

public class TrackingPage extends Activity {
	ToggleButton gps;
	Button settings,sps;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trackingpage);
		gps=(ToggleButton) findViewById(R.id.toggleButton1);
		settings=(Button) findViewById(R.id.button1);
		sps=(Button) findViewById(R.id.button);

		settings.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gps.setVisibility(View.VISIBLE);
				
				
			}
		});
		sps.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent start=new Intent(TrackingPage.this, MySMSReciever.class);
				sendBroadcast(start);
			}
		});
		gps.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (gps.getText().toString().equals("ON")){
					
				
				Intent set=new Intent(TrackingPage.this,LocationPage.class);
				startActivity(set);
				}
			}
		});
	}
 
}
