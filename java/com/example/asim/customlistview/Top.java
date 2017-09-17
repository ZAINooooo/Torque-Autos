package com.example.asim.customlistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.asim.customlistview.Login_Register_Profile.activities.LoginActivity;
import com.example.asim.customlistview.Login_Register_Profile.activities.RegisterActivity;


public class Top extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        Button Loginbutton;
        Button RegisterButton;
        Loginbutton=(Button)findViewById(R.id.Button9);
        RegisterButton=(Button)findViewById(R.id.Button11);


        Loginbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(Top.this,LoginActivity.class);
                startActivity(i);
            }
        });

        RegisterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(Top.this,RegisterActivity.class);
                startActivity(i);
            }
        });


    }

}
