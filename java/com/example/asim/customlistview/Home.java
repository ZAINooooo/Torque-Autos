package com.example.asim.customlistview;

import android.os.StrictMode;
import android.support.v4.app.FragmentTabHost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

import java.io.IOException;


public class Home extends AppCompatActivity {
    // Declare Variables
    FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the view from main_fragment.xml
        setContentView(R.layout.activity_home);



        mTabHost = new FragmentTabHost(this);

        // Locate android.R.id.tabhost in main_fragment.xml
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        // Create the tabs in main_fragment.xml
        mTabHost.setup(this,  getSupportFragmentManager(),android.R.id.tabcontent);


        final ViewGroup nullParent = null;

        View Firstlabel= LayoutInflater.from(this).inflate(R.layout.tab1 , nullParent , false);
        View Firstlabel2= LayoutInflater.from(this).inflate(R.layout.tab2, nullParent , false);
        View Firstlabel3= LayoutInflater.from(this).inflate(R.layout.tab3, nullParent , false);
        View Firstlabel4= LayoutInflater.from(this).inflate(R.layout.tab4, nullParent , false);


        // Create Parent Tab1
        mTabHost.addTab(mTabHost.newTabSpec("Thailand").setIndicator(Firstlabel),FragmentParentTab1.class, null);
        // Create Parent Tab2
        mTabHost.addTab(mTabHost.newTabSpec("Singapore").setIndicator(Firstlabel2), FragmentParentTab2.class, null);
        // Create Parent Tab3
        mTabHost.addTab(mTabHost.newTabSpec("Japan").setIndicator(Firstlabel3), FragmentParentTab3.class, null);
        // Create Parent Tab4
        mTabHost.addTab(mTabHost.newTabSpec("UK").setIndicator(Firstlabel4), FragmentParentTab4.class, null);

    }
}
