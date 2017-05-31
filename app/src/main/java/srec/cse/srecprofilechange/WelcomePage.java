package srec.cse.srecprofilechange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WelcomePage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        Thread startuppage= new Thread(){ 
        	@Override
        	public void run() {
        		// TODO Auto-generated method stub
        		super.run();
        		try {
					sleep(2000);
					Intent sup=new Intent(WelcomePage.this,LoginPage.class);
					startActivity(sup);
					finish();
					  
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	
        };
        startuppage.start(); 
    }
}
  