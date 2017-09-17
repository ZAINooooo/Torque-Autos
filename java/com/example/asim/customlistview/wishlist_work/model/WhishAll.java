package com.example.asim.customlistview.wishlist_work.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Zahoor on 7/24/2017.
 */

public class WhishAll {
    @SerializedName("listID")
    @Expose
    private String listID;
    @SerializedName("vehicleID")
    @Expose
    private String vehicleID;
    @SerializedName("status")
    @Expose
    private String status;

    public String getListID() {
        return listID;
    }

    public void setListID(String listID) {
        this.listID = listID;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
