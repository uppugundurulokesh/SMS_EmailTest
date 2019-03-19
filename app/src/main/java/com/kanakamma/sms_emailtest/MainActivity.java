package com.kanakamma.sms_emailtest;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText e1,e2,e3;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        e3=findViewById(R.id.editText3);
        ratingBar=findViewById(R.id.ratingBar);
    }

    public void dosms(View view) {
        String num=e1.getText().toString();
        String msg=e2.getText().toString();

        Intent i=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,i,0);

        SmsManager smsManager=SmsManager.getDefault();
        smsManager.sendTextMessage(num,null,msg,pendingIntent,null);
        Toast.makeText(this, "send successfully", Toast.LENGTH_SHORT).show();
    }

    public void doemail(View view) {

        String to=e1.getText().toString();
        String msg=e2.getText().toString();
        String sub=e3.getText().toString();

        Intent i=new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
        i.putExtra(Intent.EXTRA_SUBJECT,sub);
        i.putExtra(Intent.EXTRA_TEXT,msg);

        i.setType("message/rfc822");
        startActivity(Intent.createChooser(i,"choose an email client"));



    }

    public void dorating(View view) {

        String val=String.valueOf(ratingBar.getRating());
        Toast.makeText(this, val, Toast.LENGTH_SHORT).show();
    }
}
