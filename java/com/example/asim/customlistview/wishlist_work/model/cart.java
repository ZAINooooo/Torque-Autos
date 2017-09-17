package com.example.asim.customlistview.wishlist_work.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Zahoor on 7/24/2017.
 */

public class cart {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("fetch_all")
    @Expose
    private List<cartall> fetchAll = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<cartall> getFetchAll() {
        return fetchAll;
    }

    public void setFetchAll(List<cartall> fetchAll) {
        this.fetchAll = fetchAll;
    }

}
