package com.example.asim.customlistview.Login_Register_Profile.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.SupportActivity;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.asim.customlistview.Home;
import com.example.asim.customlistview.Login;
import com.example.asim.customlistview.R;
import com.example.asim.customlistview.Login_Register_Profile.helpers.InputValidation;
import com.example.asim.customlistview.Login_Register_Profile.sql.DatabaseHelper;
import com.example.asim.customlistview.Settings;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;

import java.util.Map;


/**
 * Created by zain on 16/7/2016.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{
    private final AppCompatActivity activity = LoginActivity.this;

    private NestedScrollView nestedScrollView;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutName;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText  textInputEditTextName;
    private AppCompatButton appCompatButtonLogin;
    private AppCompatTextView textViewLinkRegister;
    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        if(getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }

        initViews();
        initListeners();
        initObjects();
    }

    /**
     * This method is to initialize views
     */
    private void initViews()
    {

        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutName = (TextInputLayout) findViewById(R.id.textInputLayoutName);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        appCompatButtonLogin = (AppCompatButton) findViewById(R.id.appCompatButtonLogin);
        textViewLinkRegister = (AppCompatTextView) findViewById(R.id.textViewLinkRegister);
        textInputEditTextName = (TextInputEditText) findViewById(R.id.textInputEditTextName);

    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners()
    {
        appCompatButtonLogin.setOnClickListener(this);
        textViewLinkRegister.setOnClickListener(this);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects()
    {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.appCompatButtonLogin:

                   verifyFromSQLite();
                         break;

            case R.id.textViewLinkRegister:
                // Navigate to RegisterActivity
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */
    private void verifyFromSQLite()
    {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email)))
        {
            return;
        }

        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email)))
        {
            return;
        }

        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword,  textInputLayoutPassword, getString(R.string.error_message_email)))
        {
            return;
        }

        if (!inputValidation.isInputEditTextFilled(textInputEditTextName,  textInputLayoutName, getString(R.string.error_message_email)))
        {
            return;
        }




        if (databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim(),  textInputEditTextName.getText().toString().trim() ,textInputEditTextPassword.getText().toString().trim()))
        {
            // Create object of SharedPreferences.
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            //now get Editor
            SharedPreferences.Editor editor = sharedPref.edit();
            //put your value
            editor.putString("NAME", textInputEditTextName.getText().toString().trim());
            //commits your edits
            editor.apply();


            // Create object of SharedPreferences.
            SharedPreferences sharedPrefg = PreferenceManager.getDefaultSharedPreferences(this);
            //now get Editor
            SharedPreferences.Editor editorS = sharedPrefg.edit();
            //put your value
            editorS.putString("EMAIL", textInputEditTextEmail.getText().toString().trim());
            //commits your edits
            editorS.apply();


            // Create object of SharedPreferences.
            SharedPreferences sharedPrefe = PreferenceManager.getDefaultSharedPreferences(this);
            //now get Editor
            SharedPreferences.Editor editorD = sharedPrefe.edit();
            //put your value
            editorD.putString("PASSWORD", textInputEditTextPassword.getText().toString().trim());
            //commits your edits
            editorD.apply();


            Toast.makeText(activity, "Welcome to Home Screen", Toast.LENGTH_SHORT).show();


            Intent intentRegister = new Intent(getApplicationContext(), Home.class);
            startActivity(intentRegister);

            emptyInputEditText();
        }

        else
            {
            // Snack Bar to show success message that record is wrong
            Snackbar.make(nestedScrollView, getString(R.string.error_email_does_not_exist), Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText()
    {
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
        textInputEditTextName.setText(null);

    }
}
