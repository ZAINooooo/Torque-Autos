package com.example.asim.customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentParentTab3 extends Fragment
{
    String[] items = {"TOYOTA HILUX VIGO"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View rootView = inflater.inflate(R.layout.fragmenttab3, container, false);
        ListView listview = (ListView) rootView.findViewById(R.id.listViewSetting);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        CustomAdapter adapter = new CustomAdapter(getActivity(),android.R.layout.simple_list_item_1,items);
        listview.setAdapter(adapter);
        return rootView;
    }

    public class CustomAdapter extends ArrayAdapter<String>
    {
        View view;

        public CustomAdapter(Context context, int resource, String[] objects)
        {
            super(context, resource, objects);

        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent)
        {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.settting_list,null,false);
            TextView name = (TextView) view.findViewById(R.id.title);
            name.setText(items[position]);

            return view;
        }
    }



}
