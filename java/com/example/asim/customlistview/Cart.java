package com.example.asim.customlistview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class Cart extends Activity {

    String[] names = {"Toyota Hilux 2010"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ListView listview = (ListView) findViewById(R.id.listCart);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
              //  android.R.layout.simple_list_item_1,values);
        //listview.setAdapter(adapter);

        CustomAdapter adapter = new CustomAdapter(this,
                android.R.layout.simple_list_item_1,names);
        listview.setAdapter(adapter);


    }

    public class CustomAdapter extends ArrayAdapter<String> {
        View view;

        public CustomAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view  = inflater.inflate(R.layout.cartlist,null,false);
            TextView name = (TextView) view.findViewById(R.id.title);
            name.setText(names[position]);
            return view;
        }
    }






}