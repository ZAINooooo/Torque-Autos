package com.example.asim.customlistview;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



import android.widget.EditText;
import android.widget.Toast;


public class Register extends Activity
{


    EditText username, email, password , confirmPassword;
    DatabaseHandler db;
    Cursor cursor;

    Button Creatbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);




        username = (EditText) findViewById(R.id.textView);
        email= (EditText) findViewById(R.id.textView2);
        password=(EditText) findViewById(R.id.editText);
        confirmPassword= (EditText) findViewById(R.id.editText2);

//        Button Creatbutton;



        Creatbutton=(Button)findViewById(R.id.button);

        Creatbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                String name=username.getText().toString();
                String pass= password.getText().toString();


                String emails=email.getText().toString();
                String confirm=confirmPassword.getText().toString();


                if(confirm.equals(pass) ){


                    db = new DatabaseHandler(Register.this, null, null, 2);
                    Registerdata reg = new Registerdata();

                    reg.setfirstName(name);
                    reg.setPassword(pass);
                    reg.setEmailId(emails);
                    reg.setConfirm_password(confirm);

                    db.addregister(reg);

                    Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), Login.class));
                }
                else{

                    Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_LONG).show();
                    password.setText("");
                    confirmPassword.setText("");
                }
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
