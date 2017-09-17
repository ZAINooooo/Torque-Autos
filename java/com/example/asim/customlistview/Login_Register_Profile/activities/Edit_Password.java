package com.example.asim.customlistview.Login_Register_Profile.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.asim.customlistview.DatabaseHandler;
import com.example.asim.customlistview.Home;
import com.example.asim.customlistview.Login_Register_Profile.sql.DatabaseHelper;
import com.example.asim.customlistview.R;


import com.example.asim.customlistview.Login_Register_Profile.model.User;

/**
 * Created by zain on 7/22/2017.
 */

public class Edit_Password  extends AppCompatActivity
{
    private TextInputLayout textInputLayoutold_password;
    private TextInputLayout textInputLayout_changed_password;
    private TextInputEditText old_password;
    private TextInputEditText changed_password;
    Button submit;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);

        db = new DatabaseHelper(this);
        db = db.open();

        final User user = new User();

        old_password = (TextInputEditText) findViewById(R.id.old_password);
        changed_password = (TextInputEditText) findViewById(R.id.changed_password);
        submit = (Button) findViewById(R.id.submit);



        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String strEmailOld = old_password.getText().toString().trim();
                String strEmailNew = changed_password.getText().toString().trim();


                db = new DatabaseHelper(getApplicationContext());

                Boolean storedNewData=db.updatePasswords(strEmailOld ,strEmailNew);

                    if (storedNewData)
                    {
                        Toast.makeText(Edit_Password.this, "Changed", Toast.LENGTH_SHORT).show();

                        // Create object of SharedPreferences.
                        SharedPreferences sharedPrefe = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        //now get Editor
                        SharedPreferences.Editor editorD = sharedPrefe.edit();
                        //put your value
                        editorD.putString("PASSWORD", strEmailNew);
                        //commits your edits
                        editorD.apply();

                        Toast.makeText(Edit_Password.this, "move", Toast.LENGTH_SHORT).show();

                        Intent intentRegister = new Intent(getApplicationContext(), UsersListActivity.class);
                        startActivity(intentRegister);
                    }

                else
                {
                    //if the updatePassword Query is not right then..!!
                    Toast.makeText(Edit_Password.this, "Failed to update", Toast.LENGTH_LONG).show();
                }


                // check if any of the fields are vaccant
                if (strEmailOld.equals("") || strEmailNew.equals(""))
                {
                    Toast.makeText(Edit_Password.this, "Field Vaccant", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        // Close The Database
        db.close();
    }
}
