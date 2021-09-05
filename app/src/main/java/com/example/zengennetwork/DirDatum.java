
package com.example.zengennetwork;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DirDatum {

    @SerializedName("BOD_ID")
    @Expose
    private String bodId;
    @SerializedName("BOD_name")
    @Expose
    private String bODName;
    @SerializedName("BOD_TAGLINE")
    @Expose
    private String bodTagline;
    @SerializedName("BOD_QUOTE")
    @Expose
    private String bodQuote;
    @SerializedName("BOD_PIC")
    @Expose
    private String bodPic;
    @SerializedName("BOD_QUALIFICATION")
    @Expose
    private Object bodQualification;
    @SerializedName("BOD_Social")
    @Expose
    private Object bODSocial;

    public String getBodId() {
        return bodId;
    }

    public void setBodId(String bodId) {
        this.bodId = bodId;
    }

    public String getBODName() {
        return bODName;
    }

    public void setBODName(String bODName) {
        this.bODName = bODName;
    }

    public String getBodTagline() {
        return bodTagline;
    }

    public void setBodTagline(String bodTagline) {
        this.bodTagline = bodTagline;
    }

    public String getBodQuote() {
        return bodQuote;
    }

    public void setBodQuote(String bodQuote) {
        this.bodQuote = bodQuote;
    }

    public String getBodPic() {
        return bodPic;
    }

    public void setBodPic(String bodPic) {
        this.bodPic = bodPic;
    }

    public Object getBodQualification() {
        return bodQualification;
    }

    public void setBodQualification(Object bodQualification) {
        this.bodQualification = bodQualification;
    }

    public Object getBODSocial() {
        return bODSocial;
    }

    public void setBODSocial(Object bODSocial) {
        this.bODSocial = bODSocial;
    }

}
