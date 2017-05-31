package srec.cse.srecprofilechange;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MySMSReciever extends BroadcastReceiver {

	   // Get the object of SmsManager
    final SmsManager sms = SmsManager.getDefault();

     
    public void onReceive(Context context, Intent intent) {

        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();
 
        try {
             
            if (bundle != null) {
                 
                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                 
                for (int i = 0; i < pdusObj.length; i++) {
                     
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                     
                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();
                    AudioManager am=(AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
                    if(message.equalsIgnoreCase("silent"))
                    {
                        am.setRingerMode(AudioManager.RINGER_MODE_SILENT);

                    }
                    else if(message.equalsIgnoreCase("normal"))
                    {
                        am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);

                    }
                    else
                    {
                        Toast.makeText(context, "Code is invalid", Toast.LENGTH_SHORT).show();
                    }



                } // end for loop
              } // bundle is null
 
        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);
             
        }
	}

}
