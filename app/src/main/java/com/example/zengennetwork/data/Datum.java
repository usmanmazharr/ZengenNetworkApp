package com.example.zengennetwork.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Datum {
    @SerializedName("Emp_ID")
    @Expose
    private String empID;
    @SerializedName("Emp_Name")
    @Expose
    private String empName;
    @SerializedName("Social_Media")
    @Expose
    private Object socialMedia;
    @SerializedName("Emp_Pic")
    @Expose
    private String empPic;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("Designation")
    @Expose
    private String designation;
    @SerializedName("Seniority")
    @Expose
    private String seniority;
    @SerializedName("Joining_Date")
    @Expose
    private String joiningDate;
    @SerializedName("Pay_Scale")
    @Expose
    private String payScale;
    @SerializedName("Salary")
    @Expose
    private String salary;
    @SerializedName("Allowed_holidays")
    @Expose
    private String allowedHolidays;
    @SerializedName("Availed_holidays")
    @Expose
    private Object availedHolidays;

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Object getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(Object socialMedia) {
        this.socialMedia = socialMedia;
    }

    public String getEmpPic() {
        return empPic;
    }

    public void setEmpPic(String empPic) {
        this.empPic = empPic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) { this.designation = designation; }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getPayScale() {
        return payScale;
    }

    public void setPayScale(String payScale) {
        this.payScale = payScale;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAllowedHolidays() {
        return allowedHolidays;
    }

    public void setAllowedHolidays(String allowedHolidays) {
        this.allowedHolidays = allowedHolidays;
    }

    public Object getAvailedHolidays() {
        return availedHolidays;
    }

    public void setAvailedHolidays(Object availedHolidays) {
        this.availedHolidays = availedHolidays;
    }

}