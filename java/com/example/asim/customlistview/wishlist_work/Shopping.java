package com.example.asim.customlistview.wishlist_work;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.asim.customlistview.R;

import com.example.asim.customlistview.wishlist_work.api.Getdata;
import com.example.asim.customlistview.wishlist_work.model.Fetch;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Zahoor on 7/23/2017.
 */

public class Shopping extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_screen);
        DoIntialize();
    }

    private void DoIntialize()
    {
        context=this;
        mRecyclerView = (RecyclerView) findViewById(R.id.booking);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        apiCall();
    }

    public void apiCall() {
        Constantsdialoque.showlDialog(Shopping.this);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(C.Bae_Url)
                .build();
        Getdata api = restAdapter.create(Getdata.class);
        api.getenquiry(new Callback<Fetch>() {
            @Override
            public void success(Fetch getspeakers, Response response) {
                if (response != null && getspeakers != null) {
                    mAdapter = new Shoppingadapter(Shopping.this, getspeakers,context);
                    mRecyclerView.setAdapter(mAdapter);
                } else {
                    Toast.makeText(Shopping.this, "No Data Yet", Toast.LENGTH_SHORT).show();
                }
                Constantsdialoque.dismisDialog();
            }
            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(Shopping.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
