package com.newer.domain;

import java.io.Serializable;

public class Park implements Serializable {
    private Integer parkid;
    private Integer sum;
    private String site;
    private String parktype;

    public Integer getParkid() {
        return parkid;
    }

    public void setParkid(Integer parkid) {
        this.parkid = parkid;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getParktype() {
        return parktype;
    }

    public void setParktype(String parktype) {
        this.parktype = parktype;
    }

    @Override
    public String toString() {
        return "Park{" +
                "parkid=" + parkid +
                ", sum=" + sum +
                ", site='" + site + '\'' +
                ", parktype='" + parktype + '\'' +
                '}';
    }
}
