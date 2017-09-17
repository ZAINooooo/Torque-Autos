package com.example.asim.customlistview.wishlist_work.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Zahoor on 7/24/2017.
 */

public class Fetch {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("fetch_all")
    @Expose
    private List<FetchAll> fetchAll = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<FetchAll> getFetchAll() {
        return fetchAll;
    }

    public void setFetchAll(List<FetchAll> fetchAll) {
        this.fetchAll = fetchAll;
    }
}
