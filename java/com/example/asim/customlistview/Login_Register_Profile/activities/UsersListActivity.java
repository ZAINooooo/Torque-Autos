package com.example.asim.customlistview.Login_Register_Profile.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.asim.customlistview.Home;
import com.example.asim.customlistview.R;
//import com.example.asim.customlistview.Login_Register_Profile.adapters.UsersRecyclerAdapter;
import com.example.asim.customlistview.Login_Register_Profile.model.User;
import com.example.asim.customlistview.Login_Register_Profile.sql.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zain on 16/7/2016.
 */

public class UsersListActivity extends AppCompatActivity {

    private AppCompatActivity activity = UsersListActivity.this;

    public AppCompatTextView textViewName, text4, text5;
    //private RecyclerView recyclerViewUsers;
    private List<User> listUsers;
    //private UsersRecyclerAdapter usersRecyclerAdapter;
    private DatabaseHelper databaseHelper;


    ImageView image3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }

        initViews();
        initObjects();

    }

    /**
     * This method is to initialize views
     */
    private void initViews()
    {
        textViewName = (AppCompatTextView) findViewById(R.id.textViewName);
        text4 = (AppCompatTextView) findViewById(R.id.Text4);
        text5 = (AppCompatTextView) findViewById(R.id.Text5);
        image3 = (ImageView) findViewById(R.id.image_3);


        image3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               Intent intent = new Intent(UsersListActivity.this , Home.class);
                startActivity(intent);
            }
        });
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        listUsers = new ArrayList<>();

        databaseHelper = new DatabaseHelper(activity);


//        String emailFromIntent = getIntent().getStringExtra("NAME");
//        textViewName.setText(emailFromIntent);




        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String userName = sharedPref.getString("NAME", "");

        textViewName.setText(userName);



        SharedPreferences sharedPrefg = PreferenceManager.getDefaultSharedPreferences(this);
        String userNames = sharedPrefg.getString("EMAIL", "");
        text4.setText(userNames);



        SharedPreferences sharedPrefe = PreferenceManager.getDefaultSharedPreferences(this);
        String userNamee = sharedPrefe.getString("PASSWORD", "");
        text5.setText(userNamee);





//        String nameFromIntent = getIntent().getStringExtra("EMAIL");
//        text4.setText(nameFromIntent);
//
//        String passwordFromIntent = getIntent().getStringExtra("PASSWORD");
//        text5.setText(passwordFromIntent);
//
//        String  str3=text4.getText().toString();

        getDataFromSQLite();
    }

    /**
     * This method is to fetch all user records from SQLite
     */
    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params)
            {
                listUsers.clear();
                listUsers.addAll(databaseHelper.getAllUser());

                return null;
            }

//            @Override
//            protected void onPostExecute(Void aVoid)
//            {
//                super.onPostExecute(aVoid);
//                usersRecyclerAdapter.notifyDataSetChanged();
//            }
//        }
//        .execute();
//    }
        };
    }
}
