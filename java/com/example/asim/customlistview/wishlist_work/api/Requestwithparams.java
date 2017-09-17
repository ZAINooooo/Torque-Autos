package com.example.asim.customlistview.wishlist_work.api;

import com.example.asim.customlistview.wishlist_work.C;
import com.example.asim.customlistview.wishlist_work.model.Addtocart;
import com.example.asim.customlistview.wishlist_work.model.Addtowhishlist;
import com.example.asim.customlistview.wishlist_work.model.update;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Zahoor on 7/24/2017.
 */

public interface Requestwithparams {

    @FormUrlEncoded
    @POST(C.Addtocart)
    public void Addtocart(@Field("id") String id,
                          @Field("action") String action,
                          Callback<Addtocart> response);

    @FormUrlEncoded
    @POST(C.Addtowhishlist)
    public void Addtowhishlist(@Field("id") String id,
                               @Field("action") String action,
                               Callback<Addtowhishlist> response);


    @FormUrlEncoded
    @POST(C.update)
    public void update(@Field("listID") String id,
                               @Field("action") String action,
                               Callback<update> response);
}
