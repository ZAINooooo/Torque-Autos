package com.example.asim.customlistview;

import android.app.Activity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by zain on 7/17/2017.
 */

public class Change_Password extends Activity {

    EditText Old_Password;
    EditText New_Password;
    Button Btn_Submit;

    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);



//        Intent intent2=getIntent();
//        final String name1=intent2.getStringExtra("val");
//        Log.e("zain",name1);



        Old_Password = (EditText) findViewById(R.id.old_password);
        New_Password = (EditText) findViewById(R.id.new_password);
        Btn_Submit = (Button) findViewById(R.id.button);


        db = new DatabaseHandler(this);
        db.open();




        Btn_Submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view)
            {

//                String olderPassword = Old_Password.getText().toString();
//                String newPassword = New_Password.getText().toString();





                 String olderPassword = Old_Password.getText().toString();
                 String newPassword = New_Password.getText().toString();


               // String storedPassword = String.valueOf(db.updateEntry(olderPassword , newPassword));

                String StoredPassword = db.update(olderPassword , newPassword);

               // String storedPassword=db.getAllTags(olderPassword);

                if (olderPassword.equals(StoredPassword))
                {
                    Intent intent= new Intent(Change_Password.this , Login.class);
                    startActivity(intent);

                    String header = "Passwords Updated";
                    Toast.makeText(getApplicationContext(),header, Toast.LENGTH_SHORT).show();


                }



                if("".equalsIgnoreCase(olderPassword)){
                    String header = "OLD PASSWORD REQUIRE";

                    Toast.makeText(getApplicationContext(),header, Toast.LENGTH_SHORT).show();
                }

                else if("".equalsIgnoreCase(newPassword)){
                    String header = "NEW PASSWORD IS REQUIRE";
                    Toast.makeText(getApplicationContext(), header, Toast.LENGTH_SHORT).show();
                }


//                else if(!newPassword.equalsIgnoreCase(olderPassword))
//                {
//                    String header = "PASSWORD DOES NOT MATCH";
//                    Toast.makeText(getApplicationContext(), header, Toast.LENGTH_SHORT).show();
//                }

                else
               {
//                    db = new DatabaseHandler(getApplicationContext());
//
//                    db.updateEntry(newPassword , name1);
                }




//
//                if(olderPassword.equals(""))
//                {
//                    Toast.makeText(getApplicationContext(), "Please enter your securityhint", Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    String storedPassword=db.getAllTags(olderPassword);
//                    if(storedPassword==null)
//                    {
//                        Toast.makeText(getApplicationContext(), "Please enter correct securityhint", Toast.LENGTH_SHORT).show();
//                    }else{
//                        Log.d("GET PASSWORD",storedPassword);
//                        //newPassword.setText(storedPassword);
//            }
//        };
    }
});
}

    @Override
    protected void onDestroy() {
        super.onDestroy();
// Close The Database
        db.close();
    }

}

