package srec.cse.srecprofilechange;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends Activity {
	EditText uname,upwd;
	Button submit,cancel,regis;
	Editor ed;
	SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginpage);
		sp=(SharedPreferences)getSharedPreferences("profile", Context.MODE_PRIVATE);
		uname=(EditText) findViewById(R.id.editText1);
		upwd=(EditText) findViewById(R.id.editText2);
		submit=(Button) findViewById(R.id.button1);
		cancel=(Button) findViewById(R.id.button2);
		regis=(Button) findViewById(R.id.button3);
		if(!sp.contains("flag"))
		{

		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!TextUtils.isEmpty(uname.getText().toString())&& !TextUtils.isEmpty(upwd.getText().toString()))
				{
				if(sp.contains("username")&&sp.contains("password"))
				{
					if(sp.getString("username", null).equalsIgnoreCase(uname.getText().toString())&&sp.getString("password", null).equalsIgnoreCase(upwd.getText().toString()))
					{
						ed=sp.edit();
						ed.putInt("flag", 1);
						ed.commit();
					Intent pa=new Intent(LoginPage.this,TrackingPage.class);
					startActivity(pa);
						finish();
					}
					
				}
				else 
				{
					Toast.makeText(LoginPage.this,"invalid username or password", Toast.LENGTH_LONG).show();

				}
				}
				else
				{
					Toast.makeText(LoginPage.this,"your feild should not be empty", Toast.LENGTH_LONG).show();

				}
			}
		});
		cancel.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View v) {
				// T  ODO Auto-generated method stub
				uname.setText("");
				upwd.setText("");
				finish();
				
			}
		});
		regis.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent pa=new Intent(LoginPage.this,RegistrationPage.class);
				startActivity(pa);
				finish();
				
			}
		});
		}
		else
		
		{
			Intent pa=new Intent(LoginPage.this,TrackingPage.class);
			startActivity(pa);
			finish();
		}
	}

}
