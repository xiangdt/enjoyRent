package com.newer.domain;

import java.util.Date;

public class User {
    private Integer userid;
    private String username;
    private String password;
    private String name;
    private String sex;
    private String cardid;
    private String mobile;
    private String email;
    private String address;
    private String userstate;
    private String frontcardimg;
    private String versocardimg;
    private String licenseimg;
    private String licensenum;
    private Date jointime;

    public String getFrontcardimg() {
        return frontcardimg;
    }

    public void setFrontcardimg(String frontcardimg) {
        this.frontcardimg = frontcardimg;
    }

    public String getVersocardimg() {
        return versocardimg;
    }

    public void setVersocardimg(String versocardimg) {
        this.versocardimg = versocardimg;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserstate() {
        return userstate;
    }

    public void setUserstate(String userstate) {
        this.userstate = userstate;
    }


    public String getLicenseimg() {
        return licenseimg;
    }

    public void setLicenseimg(String licenseimg) {
        this.licenseimg = licenseimg;
    }

    public String getLicensenum() {
        return licensenum;
    }

    public void setLicensenum(String licensenum) {
        this.licensenum = licensenum;
    }

    public Date getJointime() {
        return jointime;
    }

    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", cardid='" + cardid + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", userstate='" + userstate + '\'' +
                ", frontcardimg='" + frontcardimg + '\'' +
                ", versocardimg='" + versocardimg + '\'' +
                ", licenseimg='" + licenseimg + '\'' +
                ", licensenum='" + licensenum + '\'' +
                ", jointime=" + jointime +
                '}';
    }
}
