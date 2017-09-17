package com.example.asim.customlistview.wishlist_work.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Zahoor on 7/24/2017.
 */

public class FetchAll {
    @SerializedName("vehicleID")
    @Expose
    private String vehicleID;
    @SerializedName("vehicleName")
    @Expose
    private String vehicleName;
    @SerializedName("vehicleFobprice")
    @Expose
    private String vehicleFobprice;
    @SerializedName("vehicleEngine")
    @Expose
    private String vehicleEngine;
    @SerializedName("vehicleStock")
    @Expose
    private String vehicleStock;
    @SerializedName("vehicleColor")
    @Expose
    private String vehicleColor;
    @SerializedName("vehicleMake")
    @Expose
    private String vehicleMake;
    @SerializedName("vehicleModel")
    @Expose
    private String vehicleModel;
    @SerializedName("vehicleYear")
    @Expose
    private String vehicleYear;
    @SerializedName("vehicleSteering")
    @Expose
    private String vehicleSteering;
    @SerializedName("vehicleTransmission")
    @Expose
    private String vehicleTransmission;
    @SerializedName("vehicleChasis")
    @Expose
    private String vehicleChasis;
    @SerializedName("vehicleStatus")
    @Expose
    private String vehicleStatus;
    @SerializedName("vehiclePicture")
    @Expose
    private String vehiclePicture;

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleFobprice() {
        return vehicleFobprice;
    }

    public void setVehicleFobprice(String vehicleFobprice) {
        this.vehicleFobprice = vehicleFobprice;
    }

    public String getVehicleEngine() {
        return vehicleEngine;
    }

    public void setVehicleEngine(String vehicleEngine) {
        this.vehicleEngine = vehicleEngine;
    }

    public String getVehicleStock() {
        return vehicleStock;
    }

    public void setVehicleStock(String vehicleStock) {
        this.vehicleStock = vehicleStock;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(String vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getVehicleSteering() {
        return vehicleSteering;
    }

    public void setVehicleSteering(String vehicleSteering) {
        this.vehicleSteering = vehicleSteering;
    }

    public String getVehicleTransmission() {
        return vehicleTransmission;
    }

    public void setVehicleTransmission(String vehicleTransmission) {
        this.vehicleTransmission = vehicleTransmission;
    }

    public String getVehicleChasis() {
        return vehicleChasis;
    }

    public void setVehicleChasis(String vehicleChasis) {
        this.vehicleChasis = vehicleChasis;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getVehiclePicture() {
        return vehiclePicture;
    }

    public void setVehiclePicture(String vehiclePicture) {
        this.vehiclePicture = vehiclePicture;
    }

}
