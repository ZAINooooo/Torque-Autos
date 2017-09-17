package com.example.asim.customlistview;

/**
 * Created by hp on 5/5/2017.
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class FragmentChildtab1 extends Fragment {
    String[] items = {"Counter BalanceForkLift","Counter BalanceForkLift"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragmentchildtab1,
                container, false);
        ListView listview = (ListView) rootView.findViewById(R.id.listView3);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        CustomAdapter adapter = new CustomAdapter(getActivity(),
                android.R.layout.simple_list_item_1,items);
        listview.setAdapter(adapter);
        return rootView;
    }

    public class CustomAdapter extends ArrayAdapter<String>{
        View view;

        public CustomAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.single_load,null,false);
            TextView name = (TextView) view.findViewById(R.id.title);
            name.setText(items[position]+" "+position);
            Button deleteImageView = (Button)view.findViewById(R.id.button4);
            deleteImageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(getActivity(), IMachinerynquiry.class);
                    getActivity().startActivity(i);

                }
            });

            return view;
        }
    }




}