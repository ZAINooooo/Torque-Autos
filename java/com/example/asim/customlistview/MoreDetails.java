package com.example.asim.customlistview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MoreDetails extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);

        Button Creatbutton;

        Button Creatbutton2;

        Creatbutton=(Button)findViewById(R.id.Addtocart);

        Creatbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(MoreDetails.this,Cart.class);
                startActivity(i);
            }
        });
        Creatbutton2=(Button)findViewById(R.id.inquiry);

        Creatbutton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Intent i = new Intent(MoreDetails.this,IMachinerynquiry.class);
                //startActivity(i);
            }
        });



    }



}
