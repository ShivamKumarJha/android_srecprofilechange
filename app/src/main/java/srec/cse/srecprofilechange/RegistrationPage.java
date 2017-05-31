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
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegistrationPage extends Activity {
	EditText username,pwd,cpwd,email,phone,address;
	Button submit,cancel;
	RadioGroup gender;
	SharedPreferences sp;
	Editor ed;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registrationpage);
		sp=(SharedPreferences)getSharedPreferences("profile", Context.MODE_PRIVATE);
		username=(EditText) findViewById(R.id.editText1);
		pwd=(EditText) findViewById(R.id.editText3);
		cpwd=(EditText) findViewById(R.id.editText4);
		email=(EditText) findViewById(R.id.editText5);
		phone=(EditText) findViewById(R.id.editText6);
		address=(EditText) findViewById(R.id.editText7);
		gender=(RadioGroup) findViewById(R.id.radioGroup1);
		submit=(Button) findViewById(R.id.button1);
 		cancel=(Button) findViewById(R.id.button2);
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!TextUtils.isEmpty(username.getText().toString())&& !TextUtils.isEmpty(pwd.getText().toString())&& !TextUtils.isEmpty(cpwd.getText().toString())&& !TextUtils.isEmpty(email.getText().toString())&& !TextUtils.isEmpty(phone.getText().toString())&& !TextUtils.isEmpty(address.getText().toString()))
				{
					if(pwd.getText().toString().equals(cpwd.getText().toString())&&email.getText().toString().contains("@")&&phone.getText().toString().length()==10)
					{
						//Intent code here8
						ed=sp.edit();
						ed.putString("username", username.getText().toString());
						ed.putString("password", pwd.getText().toString());
						ed.putString("phone", phone.getText().toString());
						ed.putString("email", email.getText().toString());
                        ed.commit();
						startActivity(new Intent(RegistrationPage.this,LoginPage.class));
					Toast.makeText(RegistrationPage.this,"Registered Successfully",Toast.LENGTH_LONG).show();
						finish();
					}
				} 
				
				else
				{
					
					
					Toast.makeText(RegistrationPage.this,"your feild should not be empty", Toast.LENGTH_LONG).show();

				}
				
			}
		});
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				username.setText("");
				pwd.setText("");
				cpwd.setText("");
				email.setText("");
				phone.setText("");
				address.setText("");
			}
		});
	}

}
 