package com.example.shruthi.elab.Admin.Model;

public class PostStatus {

    private String pId;
    private String strBooked;
    private String strCancel;
    private String strMobileNumber;
    private String strEmailId;


    public PostStatus()
    {

    }

    public PostStatus(String strBooked,String strCancel,String strMobileNumber,String strEmailId ) {
        this.strBooked = strBooked;
        this.strMobileNumber = strCancel;
        this.strCancel = strMobileNumber;
        this.strEmailId = strEmailId;

    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getStrBooked() {
        return strBooked;
    }

    public void setStrBooked(String strBooked) {
        this.strBooked = strBooked;
    }

    public String getStrCancel() {
        return strCancel;
    }

    public void setStrCancel(String strCancel) {
        this.strCancel = strCancel;
    }

    public String getStrMobileNumber() {
        return strMobileNumber;
    }

    public void setStrMobileNumber(String strMobileNumber) {
        this.strMobileNumber = strMobileNumber;
    }

    public String getStrEmailId() {
        return strEmailId;
    }

    public void setStrEmailId(String strEmailId) {
        this.strEmailId = strEmailId;
    }

}
