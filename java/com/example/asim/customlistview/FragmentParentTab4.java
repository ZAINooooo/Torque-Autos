package com.example.asim.customlistview;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.asim.customlistview.Login_Register_Profile.activities.UsersListActivity;
import com.example.asim.customlistview.wishlist_work.Wish;


/**
 * Created by Umair on 02/07/2015.
 */
public class FragmentParentTab4 extends Fragment
{
    String[] web = {"My Profile","My Wish","Mail Us","Settings","My Cart","Live Chat","Logout"};
    ListView listview;
    int[] imageId =
            {

            R.drawable.profilepic, R.drawable.wish,R.drawable.mail, R.drawable.setng, R.drawable.shop, R.drawable.chatnew, R.drawable.logut
    };



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View rootView = inflater.inflate(R.layout.fragmenttab4, container, false);

         CustomLists adapterlists = new CustomLists(getActivity(), web, imageId);
        listview = (ListView) rootView.findViewById(R.id.listView5);
        listview.setAdapter(adapterlists);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
                long arg3)
                {
                    if(pos == 0)
                    {
                        Intent intent = new Intent(getActivity() , UsersListActivity.class);
                        startActivity(intent);
                    }
                    if(pos == 1)
                    {
                        Intent intent = new Intent(getActivity() , Wish.class);
                        startActivity(intent);
                    }
                    if(pos == 2)
                    {
                        Intent intent = new Intent(getActivity() , com.example.asim.customlistview.Email.MainActivity.class);
                        startActivity(intent);
                    }
                    if(pos == 3)
                    {
                        Intent intent = new Intent(getActivity() , Settings.class);
                        startActivity(intent);
                    }
                    if(pos == 4)
                    {
                        Intent intent = new Intent(getActivity() , com.example.asim.customlistview.cart.cartlist.class);
                        startActivity(intent);
                    }
                    else if(pos == 5)
                    {
                        Intent intent = new Intent(getActivity() , com.example.asim.customlistview.FireBaseChatApplication.MainActivity.class);
                        startActivity(intent);
                    }


                    else if(pos == 6)
                    {
                        Intent intent = new Intent(getActivity() , Login.class);
                        startActivity(intent);
                    }

                }
            });

        return rootView;
    }

}
    /*public class CustomAdapter extends ArrayAdapter<String>{
        View view;

        public CustomAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.single_itemtab4,null,false);
            TextView name = (TextView) view.findViewById(R.id.title);
          //  ImageView set =(ImageView)view.findViewById(R.id.list_image);
            name.setText(web[position]);
            //set.setImageResource(imageId[position]);

            return view;
        }
    }*/
