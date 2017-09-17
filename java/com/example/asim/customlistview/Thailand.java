package com.example.asim.customlistview;


import android.app.ListActivity;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


public class Thailand extends ListActivity {

    String[] names = {"Toyota Hilux 2010","Toyota Hilux 2010","Toyota Hilux 2010","Toyota Hilux 2010","Toyota Hilux 2010"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,names);
        CustomAdapter adapter = new CustomAdapter(this,
                android.R.layout.simple_list_item_1,names);
        setListAdapter(adapter);
    }
    public class CustomAdapter extends ArrayAdapter<String> {
        View view;

        public CustomAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view  = inflater.inflate(R.layout.single_item,null,false);
            TextView name = (TextView) view.findViewById(R.id.title);
            name.setText(names[position]);
            Button deleteImageView = (Button)view.findViewById(R.id.button4);
            deleteImageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                   Intent i = new Intent(Thailand.this, MoreDetails.class);
                    startActivity(i);

                }
            });
            return view;
        }
    }

}
