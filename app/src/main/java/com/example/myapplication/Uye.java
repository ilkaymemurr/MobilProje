package com.example.myapplication;

public class Uye {
    private  int Id;
    private  String Ad;
    private String Tel;
    private String OkulNo;
    private String Tc;
    private  String Bolum;
    public Uye()
    {

    }
    public Uye(String ad, String tel, String okulNo, String tc, String bolum) {
        Ad = ad;
        Tel = tel;
        OkulNo = okulNo;
        Tc = tc;
        Bolum = bolum;
    }

    public Uye(int id) {
        Id = id;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getOkulNo() {
        return OkulNo;
    }

    public void setOkulNo(String okulNo) {
        OkulNo = okulNo;
    }

    public String getTc() {
        return Tc;
    }

    public void setTc(String tc) {
        Tc = tc;
    }

    public String getBolum() {
        return Bolum;
    }

    public void setBolum(String bolum) {
        Bolum = bolum;
    }
}
