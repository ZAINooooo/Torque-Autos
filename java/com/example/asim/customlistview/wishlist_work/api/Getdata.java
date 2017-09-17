package com.example.asim.customlistview.wishlist_work.api;

import com.example.asim.customlistview.wishlist_work.C;
import com.example.asim.customlistview.wishlist_work.model.Fetch;
import com.example.asim.customlistview.wishlist_work.model.cart;
import com.example.asim.customlistview.wishlist_work.model.whish;
import retrofit.Callback;
import retrofit.http.GET;

import static io.fabric.sdk.android.services.network.HttpMethod.GET;

/**
 * Created by Zahoor on 7/24/2017.
 */

public interface Getdata {
    @GET(C.Fetch)
    public void getenquiry(Callback<Fetch> response);

    @GET(C.whishlist)
    public void getwhish(Callback<whish> response);

    @GET(C.cartlist)
    public void getcart(Callback<cart> response);
}
