package com.example.asim.customlistview;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends Activity
{

    EditText uname , password;
    DatabaseHandler db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button Creatbutton;


        Creatbutton=(Button)findViewById(R.id.button);

        uname = (EditText) findViewById(R.id.textView);
        password =(EditText) findViewById(R.id.textView2);


        Creatbutton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
               // db=new DatabaseHandler(Login.this, null, null, 2);

                db=new DatabaseHandler(Login.this, null, null, 2);

                String username=uname.getText().toString();
                String passwords= password.getText().toString();

                String StoredPassword =db.getregister(username);

                if(passwords.equals(StoredPassword))
                {

                    Toast.makeText(getApplicationContext(),  "Login Successfully", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), Home.class));
                }

                else{
                    Toast.makeText(getApplicationContext(), "Username/Password incorrect", Toast.LENGTH_LONG).show();
                    uname.setText("");
                    password.setText("");
                }




            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
