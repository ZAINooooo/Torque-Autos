package com.example.asim.customlistview.wishlist_work;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.asim.customlistview.wishlist_work.C;
import com.example.asim.customlistview.R;
import com.example.asim.customlistview.wishlist_work.Constantsdialoque;
import com.example.asim.customlistview.wishlist_work.api.Requestwithparams;
import com.example.asim.customlistview.wishlist_work.model.Addtocart;
import com.example.asim.customlistview.wishlist_work.model.Addtowhishlist;
import com.example.asim.customlistview.wishlist_work.model.Fetch;
import com.example.asim.customlistview.wishlist_work.model.FetchAll;
import com.example.asim.customlistview.wishlist_work.model.WhishAll;


import com.example.asim.customlistview.wishlist_work.view.TextViewExpandableAnimation;
import com.example.asim.customlistview.wishlist_work.model.update;
import com.example.asim.customlistview.wishlist_work.model.whish;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Zahoor on 7/24/2017.
 */

public class whishlistadapter  extends  RecyclerView.Adapter<whishlistadapter.ViewHolder> {
    public static whish whish;
    Activity activity;
    Context cotext;
    public whishlistadapter(Wish shopping, whish getspeakers, Context context) {
        whish=getspeakers;
        activity=shopping;
        cotext=context;
    }
    @Override
    public whishlistadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_whishlist, parent, false);
        return new ViewHolder(v);
    }
    public static WhishAll getItem(int position) {
        return whish.getFetchAll().get(position);
    }
    @Override
    public void onBindViewHolder(whishlistadapter.ViewHolder holder, final int position) {
        if(position % 2 == 1){
            holder.rowItem.setBackgroundColor(Color.parseColor("#ECECEC"));

        }else{
            holder.rowItem.setBackgroundColor(Color.parseColor("#A2DED0"));
        }

        holder.expand.resetState(true);
        holder.expand.setText("listid : "+getItem(position).getListID()+"\n"+"vehicalid   : "+getItem(position).getVehicleID()
                +"\n"+"status  : "+getItem(position)
        );
        holder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtowhishlist(getItem(position).getVehicleID(),"1");
            }
        });
    }

    @Override
    public int getItemCount() {
        return whish.getFetchAll().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout rowItem;
        CircleImageView userimage;
        TextViewExpandableAnimation expand;
        Button cancel,submit;
        public ViewHolder(View itemView) {
            super(itemView);
            rowItem = (LinearLayout)itemView.findViewById(R.id.rowItem);
            userimage = (CircleImageView)itemView.findViewById(R.id.userimage);
            cancel = (Button)itemView.findViewById(R.id.cancel);
            submit = (Button)itemView.findViewById(R.id.submit);
            expand = (TextViewExpandableAnimation)itemView.findViewById(R.id.info);
        }
    }

    private void addtowhishlist(String id,String action) {
        Constantsdialoque.showlDialog(activity);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(C.Bae_Url)
                .build();
        Requestwithparams api = restAdapter.create(Requestwithparams.class);
        api.update(id,action,new Callback<update>() {
            @Override
            public void success(update addtocart, Response response) {
                if (response != null && addtocart != null) {
                    if (addtocart.getStatus()) {
                        Toast.makeText(activity, "" + addtocart.getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(activity, "" + addtocart.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    Constantsdialoque.dismisDialog();
                    //  ((Shopping) cotext).apiCall();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(activity, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
