package com.example.asim.customlistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.asim.customlistview.Login_Register_Profile.activities.Edit_Password;
import com.example.asim.customlistview.Login_Register_Profile.activities.UsersListActivity;


public class Settings extends Activity
{
    String[] values = {"Edit Profile","Change Passward"};

    ImageView image3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ListView listview = (ListView) findViewById(R.id.listSetting);

        image3 = (ImageView) findViewById(R.id.image_3);

        image3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               finish();
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,values);
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3)
            {
                if(pos == 0)
                {
                    Intent intent = new Intent(Settings.this, UsersListActivity.class);
                    startActivity(intent);
                }

                if(pos == 1)
                {
                    Intent intent = new Intent(Settings.this , Edit_Password.class);
                    startActivity(intent);
                }

            }
        });




    }




}
