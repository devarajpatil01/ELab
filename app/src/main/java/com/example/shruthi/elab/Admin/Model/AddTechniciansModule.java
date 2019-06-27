package com.example.shruthi.elab.Admin.Model;

import java.io.Serializable;

public class AddTechniciansModule implements Serializable {

    private String strName;
    private String strDOB;
    private String strPAge;
    private String strAddress;
    private String strMobileNumber;
    private String strEmailId;


    public AddTechniciansModule()
    {

    }

    public AddTechniciansModule(String strName, String strDOB, String strAge, String strAddress, String strMobileNumber, String strEmailId) {

        this.strName = strName;
        this.strDOB = strDOB;
        this.strPAge = strAge;
        this.strAddress = strAddress;
        this.strMobileNumber = strMobileNumber;
        this.strEmailId = strEmailId;
    }

    public String getStrDOB() {
        return strDOB;
    }

    public void setStrDOB(String strDOB) {
        this.strDOB = strDOB;
    }

    public String getStrPAge() {
        return strPAge;
    }

    public void setStrPAge(String strPAge) {
        this.strPAge = strPAge;
    }

    public String getStrAddress() {
        return strAddress;
    }

    public void setStrAddress(String strAddress) {
        this.strAddress = strAddress;
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

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

}
