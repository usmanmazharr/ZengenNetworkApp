
package com.example.zengennetwork;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
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

}
