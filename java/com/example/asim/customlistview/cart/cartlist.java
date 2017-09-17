package com.example.asim.customlistview.cart;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.asim.customlistview.R;
import com.example.asim.customlistview.wishlist_work.C;
import com.example.asim.customlistview.wishlist_work.Constantsdialoque;
import com.example.asim.customlistview.wishlist_work.api.Getdata;
import com.example.asim.customlistview.wishlist_work.model.cart;
import com.example.asim.customlistview.wishlist_work.view.cartlistadapter;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Zahoor on 7/24/2017.
 */

public class cartlist extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whishlist);
        DoIntialize();
    }

    private void DoIntialize()
    {
        context=this;
        mRecyclerView = (RecyclerView) findViewById(R.id.booking);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        apiCall();
    }

    public void apiCall() {
        Constantsdialoque.showlDialog(cartlist.this);
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(C.Bae_Url).build();
        Getdata api = restAdapter.create(Getdata.class);
        api.getcart(new Callback<cart>() {
            @Override
            public void success(cart getspeakers, Response response) {
                if (response != null && getspeakers != null) {
                    mAdapter = new cartlistadapter(cartlist.this, getspeakers,context);
                    mRecyclerView.setAdapter(mAdapter);
                } else {
                    Toast.makeText(cartlist.this, "No Data Yet", Toast.LENGTH_SHORT).show();
                }
                Constantsdialoque.dismisDialog();
            }
            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(cartlist.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
