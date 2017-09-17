package com.example.asim.customlistview.Email;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asim.customlistview.Login_Register_Profile.activities.LoginActivity;
import com.example.asim.customlistview.Login_Register_Profile.activities.UsersListActivity;
import com.example.asim.customlistview.R;

public class MainActivity extends Activity {

    Button buttonSend;
    EditText textTo;
    EditText textSubject;
    EditText textMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_us);

        buttonSend = (Button) findViewById(R.id.buttonSend);
        textTo = (EditText) findViewById(R.id.editTextTo);
        textSubject = (EditText) findViewById(R.id.editTextSubject);
        textMessage = (EditText) findViewById(R.id.editTextMessage);


        buttonSend.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String to = textTo.getText().toString();
                String subject = textSubject.getText().toString();
                String message = textMessage.getText().toString();



//                Intent emailSelectorIntent = new Intent(Intent.ACTION_SENDTO);
//                emailSelectorIntent.setData(Uri.parse("mailto:"));


                Intent email = new Intent(Intent.ACTION_SEND);


                email.setType("message/rfc822");

                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"duskysolution2@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, Html.fromHtml("<b>Welcome to our Gmil Account.</b>"));
                email.putExtra(Intent.EXTRA_TEXT, Html.fromHtml("<b>This is our sample Torque Autos Application.</b>"));
//                startActivity(email);

                try
                {
                    startActivity(Intent.createChooser(email, "Send mail"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There are no email applications installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }





    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode == 0)
        {
            finishActivity(0);

            Intent intent =  new Intent(MainActivity.this , UsersListActivity.class);
            startActivity(intent);
        }

        else
        {
            Toast.makeText(MainActivity.this, "Stay here", Toast.LENGTH_SHORT).show();
        }
    }
}