package com.example.asim.customlistview;

import android.app.ListActivity;
import android.content.Context;

import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


    public class MainActivity extends ListActivity {
        String[] names = {"Anas","Faizan","Name","Name","Name","Name","Name","Name"};
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
        public class CustomAdapter extends ArrayAdapter<String>{
            View view;

            public CustomAdapter(Context context, int resource, String[] objects) {
                super(context, resource, objects);

            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.single_item,null,false);
                TextView name = (TextView) view.findViewById(R.id.title);
                name.setText(names[position]+" "+position);

                return view;
            }
        }

}



