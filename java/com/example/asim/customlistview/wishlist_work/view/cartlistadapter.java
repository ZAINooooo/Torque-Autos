package com.example.asim.customlistview.wishlist_work.view;

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
import com.example.asim.customlistview.wishlist_work.Constantsdialoque;
import com.example.asim.customlistview.R;
import com.example.asim.customlistview.wishlist_work.api.Requestwithparams;
import com.example.asim.customlistview.cart.cartlist;
import com.example.asim.customlistview.wishlist_work.model.cart;
import com.example.asim.customlistview.wishlist_work.model.cartall;
import com.example.asim.customlistview.wishlist_work.model.update;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Zahoor on 7/24/2017.
 */

public class cartlistadapter  extends  RecyclerView.Adapter<cartlistadapter.ViewHolder> {
    public static cart cart;
    Activity activity;
    Context cotext;
    public cartlistadapter(cartlist shopping, com.example.asim.customlistview.wishlist_work.model.cart getspeakers, Context context) {
        cart=getspeakers;
        activity=shopping;
        cotext=context;
    }
    @Override
    public cartlistadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_cartlist, parent, false);
        cartlistadapter.ViewHolder vh = new cartlistadapter.ViewHolder(v);
        return vh;
    }
    public static cartall getItem(int position) {
        return cart.getFetchAll().get(position);
    }
    @Override
    public void onBindViewHolder(cartlistadapter.ViewHolder holder, final int position) {
        if(position % 2 == 1){
            holder.rowItem.setBackgroundColor(Color.parseColor("#ECECEC"));

        }else{
            holder.rowItem.setBackgroundColor(Color.parseColor("#A2DED0"));
        }

        holder.expand.resetState(true);
        holder.expand.setText("listid : "+getItem(position).getListID()+"\n"+"vehicalid   : "+getItem(position).getVehicleID()
                +"\n"+"status  : "+getItem(position)
        );
        holder.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "your order has been confirmed. our team will contact you shorty", Toast.LENGTH_SHORT).show();
            }
        });
        holder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtowhishlist(getItem(position).getVehicleID(),"2");
            }
        });
    }

    @Override
    public int getItemCount() {
        return cart.getFetchAll().size();
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
