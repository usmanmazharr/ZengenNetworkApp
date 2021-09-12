
package com.example.zengennetwork.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DepDatum {

    @SerializedName("dept_id")
    @Expose
    private String deptId;
    @SerializedName("dept_name")
    @Expose
    private String deptName;
    @SerializedName("no_of_members")
    @Expose
    private String noOfMembers;
    @SerializedName("Project_assigned")
    @Expose
    private String projectAssigned;
    @SerializedName("dept_location")
    @Expose
    private String deptLocation;
    @SerializedName("name_1")
    @Expose
    private String name1;
    @SerializedName("emp_pic")
    @Expose
    private String empPic;
    @SerializedName("name_2")
    @Expose
    private String name2;
    @SerializedName("emp_pic2")
    @Expose
    private String empPic2;
    @SerializedName("NAMES_OF_EMPLOYEEs")
    @Expose

    private String nAMESOFEMPLOYEEs;
    @SerializedName("PICS_OF_EMPLOYEES")
    @Expose
    private String picsOfEmployees;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getNoOfMembers() {
        return noOfMembers;
    }

    public void setNoOfMembers(String noOfMembers) {
        this.noOfMembers = noOfMembers;
    }

    public String getProjectAssigned() {
        return projectAssigned;
    }

    public void setProjectAssigned(String projectAssigned) {
        this.projectAssigned = projectAssigned;
    }

    public String getDeptLocation() {
        return deptLocation;
    }

    public void setDeptLocation(String deptLocation) {
        this.deptLocation = deptLocation;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getEmpPic() {
        return empPic;
    }

    public void setEmpPic(String empPic) {
        this.empPic = empPic;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getEmpPic2() {
        return empPic2;
    }

    public void setEmpPic2(String empPic2) {
        this.empPic2 = empPic2;
    }


    public String getNAMESOFEMPLOYEEs() {
        return nAMESOFEMPLOYEEs;
    }

    public void setNAMESOFEMPLOYEEs(String nAMESOFEMPLOYEEs) {
        this.nAMESOFEMPLOYEEs = nAMESOFEMPLOYEEs;
    }

    public String getPicsOfEmployees() {
        return picsOfEmployees;
    }

    public void setPicsOfEmployees(String picsOfEmployees) {
        this.picsOfEmployees = picsOfEmployees;
    }

}
