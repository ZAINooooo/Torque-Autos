package com.example.asim.customlistview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
 import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.asim.customlistview.wishlist_work.Shopping;

public class FragmentParentTab1 extends Fragment {String[] items = {"TOYOTA HILUX VIGO"};GridView grid;GridView grid2;


    //Hot Offers
    String[] web = {"MERCEDEZE BENZ ", "TOYOTA HILUX", "TOYOTA DELUX"
    };

    //Latest Offers
    String[] web2 = {"TOYOTA RAVA", "SUZUKI ESCUDO", "TOYOTA COROLLA"
    } ;
    int[] imageId2 = {R.drawable.mercedese, R.drawable.second, R.drawable.third


    };
    int[] imageId = {R.drawable.merced, R.drawable.details, R.drawable.car3

    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
//        fragmentab1-->Main xml

        View rootView = inflater.inflate(R.layout.fragmentab1, container, false);
        final ListView listview = (ListView) rootView.findViewById(R.id.listViewsam);



        //If Thailand , Singapore and Japan Stock is Clicked..!

        RadioButton Thailandbutton;
        RadioButton  SingaporeButton;
        RadioButton JapanButton;



        CustomAdapter adapternew = new CustomAdapter(getActivity(), android.R.layout.simple_list_item_1,items);
        listview.setAdapter(adapternew);

        CustomGrid adapter = new CustomGrid(getActivity(), web2, imageId2);
        grid=(GridView)rootView.findViewById(R.id.gridnew);
        grid.setAdapter(adapter);



        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent i=new Intent(getContext(), Shopping.class);
                startActivity(i);
            }
        });



        CustomGrid adapter2 = new CustomGrid(getActivity(), web, imageId);
        grid2=(GridView)rootView.findViewById(R.id.gridhot);
        grid2.setAdapter(adapter2);




       grid2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id)
           {
               Intent i=new Intent(getContext(), Shopping.class);
               startActivity(i);
           }
       });



        //Hot Offers
        final LinearLayout first = (LinearLayout) rootView.findViewById(R.id.Hotoff);

        //Lastest Offers
        final LinearLayout second = (LinearLayout) rootView.findViewById(R.id.latest);





        Thailandbutton=(RadioButton)rootView.findViewById(R.id.radioAndroid);
        SingaporeButton=(RadioButton)rootView.findViewById(R.id.radioiPhone);
        JapanButton=(RadioButton)rootView.findViewById(R.id.radioWindows);



        Thailandbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                // Intent i = new Intent(getActivity(), Thailand.class);
                //getActivity().startActivity(i);
                if (first.getVisibility() == View.VISIBLE)
                {
                    first.setVisibility(View.GONE);
                    grid.setVisibility(View.GONE);
                    second.setVisibility(View.GONE);
                    grid2.setVisibility(View.GONE);
                    listview.setVisibility(View.VISIBLE);
                }
                if (listview.getVisibility() == View.VISIBLE) {

                    listview.setVisibility(View.VISIBLE);
                }
            }
        });


        SingaporeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Intent i = new Intent(getActivity(), Thailand.class);
                //getActivity().startActivity(i)
                if(first.getVisibility()==View.VISIBLE){
                    first.setVisibility(View.GONE);
                    grid.setVisibility(View.GONE);
                    second.setVisibility(View.GONE);
                    grid2.setVisibility(View.GONE);
                    listview.setVisibility(View.VISIBLE);

                }
                    if(listview.getVisibility()==View.VISIBLE){

                        listview.setVisibility(View.VISIBLE);


                    }



            }
        });
        JapanButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Intent i = new Intent(getActivity(), Thailand.class);
                //getActivity().startActivity(i);
                if(first.getVisibility()==View.VISIBLE){
                    first.setVisibility(View.GONE);
                    grid.setVisibility(View.GONE);
                    second.setVisibility(View.GONE);
                    grid2.setVisibility(View.GONE);
                    listview.setVisibility(View.VISIBLE);

                }

                    if(listview.getVisibility()==View.VISIBLE){

                        listview.setVisibility(View.VISIBLE);


                    }

            }
        });



        return rootView;

    }
    public class CustomAdapter extends ArrayAdapter<String> {
        View view;

        public CustomAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.single_item,null,false);
            TextView name = (TextView) view.findViewById(R.id.title);
            name.setText(items[position]);
            Button deleteImageView = (Button)view.findViewById(R.id.button4);
            deleteImageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(getActivity(),  MoreDetails.class);
                    getActivity().startActivity(i);

                }
            });

            return view;
        }
    }


}