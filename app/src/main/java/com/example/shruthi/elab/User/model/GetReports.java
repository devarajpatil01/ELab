package com.example.shruthi.elab.User.model;

import android.widget.ImageView;

import java.io.Serializable;

public class GetReports implements Serializable {



    private int pId;
    private String strName;
    private String strDate;
    private String strMobileNumber;



    public String imageURL;


    public GetReports(
            int pId,String strName, String strDate,String strMobileNumber, String imageURL) {
        this.pId = pId;
        this.strName = strName;
        this.strDate = strDate;
        this.strMobileNumber =strMobileNumber;
        this.imageURL = imageURL;
    }

    public GetReports(){

    }
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public String getStrMobileNumber() {
        return strMobileNumber;
    }

    public void setStrMobileNumber(String strMobileNumber) {
        this.strMobileNumber = strMobileNumber;
    }


}
