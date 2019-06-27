package com.example.shruthi.elab.User.model;

import java.io.Serializable;

public class BookAppointment implements Serializable
{
    private String strName;
    private String strDOB;
    private String strPAge;
    private String strFatherName;
    private String strAddress;
    private String strMobileNumber;
    private String strEmailId;
    private String strDate;
    private String strRegarding;
    private String userID;
    private String reportPath;
    private String reportedGenerationDate;
    private String strNodeId;

    public String getReportedGenerationDate() {
        return reportedGenerationDate;
    }

    public void setReportedGenerationDate(String reportedGenerationDate) {
        this.reportedGenerationDate = reportedGenerationDate;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    private String statusupdate;

    public BookAppointment()
    {

    }

    public BookAppointment(String userId,String strName, String strDOB, String strAge, String strAddress, String strMobileNumber, String strFatherName, String strEmailId, String strRegarding,String strDate,String status,String strNodeId) {
        this.strName = strName;
        this.strDOB = strDOB;
        this.strPAge = strAge;
        this.strFatherName = strFatherName;
        this.strAddress = strAddress;
        this.strMobileNumber = strMobileNumber;
        this.strEmailId = strEmailId;
        this.strRegarding = strRegarding;
        this.strDate = strDate;
        this.userID = userId;
        this.statusupdate = status;
        this.strNodeId = strNodeId;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrDOB() {
        return strDOB;
    }

    public void setStrDOB(String strDOB) {
        this.strDOB = strDOB;
    }


    public String getStrFatherName() {
        return strFatherName;
    }

    public void setStrFatherName(String strFatherName) {
        this.strFatherName = strFatherName;
    }

    public String getStrRegarding() {
        return strRegarding;
    }

    public void setStrRegarding(String strRegarding) {
        this.strRegarding = strRegarding;
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

    public String getStrPAge() {
        return strPAge;
    }

    public void setStrPAge(String strPAge) {
        this.strPAge = strPAge;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStatusupdate() {
        return statusupdate;
    }

    public void setStatusupdate(String statusupdate) {
        this.statusupdate = statusupdate;
    }

    public String getNodeId() {
        return strNodeId;
    }

    public void setNodeId(String generatedRandomKey) {
        this.strNodeId = generatedRandomKey;
    }
}
