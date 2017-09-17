package com.example.asim.customlistview;

/**
 * Created by hp on 5/5/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Umair on 02/07/2015.
 */
public class FragmentParentTab2 extends Fragment
{
   // FragmentTabHost mTabHost;
   String[] items = {"Counter BalanceForkLift Trucks"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View rootView = inflater.inflate(R.layout.fragmenttab2, container, false);
        ListView listview = (ListView) rootView.findViewById(R.id.listtab2);

        CustomAdapter adapter = new CustomAdapter(getActivity(), android.R.layout.simple_list_item_1,items);
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
            view = inflater.inflate(R.layout.single_load,null,false);
            TextView name = (TextView) view.findViewById(R.id.title);
            name.setText(items[position]);



            Button deleteImageView = (Button)view.findViewById(R.id.button4);
            Button deleteImageView2 = (Button)view.findViewById(R.id.button6);


//            deleteImageView.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    Intent i = new Intent(getActivity(), IMachinerynquiry.class);
//                    getActivity().startActivity(i);
//                }
//            });






//            deleteImageView2.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    Intent i = new Intent(getActivity(), Cart.class);
//                    getActivity().startActivity(i);
//
//                }
//            });


            return view;
        }
    }



/*



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mTabHost = null;
    }

    */
}