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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import com.example.asim.customlistview.R;
import com.example.asim.customlistview.wishlist_work.api.Getdata;
import com.example.asim.customlistview.wishlist_work.api.Requestwithparams;
import com.example.asim.customlistview.wishlist_work.model.Addtocart;
import com.example.asim.customlistview.wishlist_work.model.Addtowhishlist;
import com.example.asim.customlistview.wishlist_work.model.Fetch;
import com.example.asim.customlistview.wishlist_work.model.FetchAll;
import com.example.asim.customlistview.wishlist_work.view.TextViewExpandableAnimation;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Zahoor on 7/24/2017.
 */

public class Shoppingadapter  extends  RecyclerView.Adapter<Shoppingadapter.ViewHolder> {
   public static Fetch fetch;
    Activity activity;
    Context cotext;
    public Shoppingadapter(Shopping shopping, Fetch getspeakers, Context context) {
        fetch=getspeakers;
        activity=shopping;
        cotext=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rowitem_shopping_screen, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    public static FetchAll getItem(int position) {
        return fetch.getFetchAll().get(position);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if(position % 2 == 1){
            holder.rowItem.setBackgroundColor(Color.parseColor("#ECECEC"));

        }else{
            holder.rowItem.setBackgroundColor(Color.parseColor("#A2DED0"));
        }
        Glide.with(holder.userimage.getContext())
                .load(getItem(position).getVehiclePicture())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.userimage);
        holder.expand.resetState(true);
        holder.expand.setText("vehicleName : "+getItem(position).getVehicleName()+"\n"+"vehicleFobprice   : "+getItem(position).getVehicleFobprice()
                +"\n"+"vehicleEngine  : "+getItem(position).getVehicleEngine()+"\n"+"vehicleStock : "+getItem(position).getVehicleStock()+
                "\n"+"vehicleColor :"+getItem(position).getVehicleColor()+ "\n"+"vehicleMake :"+getItem(position).getVehicleMake()+
                "\n"+"vehicleModel :"+getItem(position).getVehicleModel()+ "\n"+"vehicleYear :"+getItem(position).getVehicleYear()
                +"vehicleSteering :"+getItem(position).getVehicleSteering()+"vehicleTransmission :"+getItem(position).getVehicleTransmission()
                +"vehicleChasis :"+getItem(position).getVehicleChasis()+"vehicleStatus :"+getItem(position).getVehicleStatus()
                );
holder.submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        addtocart(getItem(position).getVehicleID());
    }
});
        holder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtowhishlist(getItem(position).getVehicleID());
            }
        });
    }

    @Override
    public int getItemCount() {
        return fetch.getFetchAll().size();
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

    private void addtocart(String id) {
        Constantsdialoque.showlDialog(activity);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(C.Bae_Url)
                .build();
        Requestwithparams api = restAdapter.create(Requestwithparams.class);
        api.Addtocart(id,"cart",new Callback<Addtocart>() {
            @Override
            public void success(Addtocart addtocart, Response response) {
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

    private void addtowhishlist(String id) {
        Constantsdialoque.showlDialog(activity);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(C.Bae_Url)
                .build();
        Requestwithparams api = restAdapter.create(Requestwithparams.class);
        api.Addtowhishlist(id,"wish",new Callback<Addtowhishlist>() {
            @Override
            public void success(Addtowhishlist addtocart, Response response) {
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
