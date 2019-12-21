package com.example.myapplication;

public class Etkinlik {
    private  int Id;
    private  String Ad;
    private String Tarih;
    private String Katilimci;

    public Etkinlik()
    {

    }
    public Etkinlik(String ad, String tarih, String katilimci) {
        Ad = ad;
        Tarih=tarih;
        Katilimci=katilimci;
    }

    public Etkinlik(int id) {
        Id = id;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    public String getTarih() {
        return Tarih;
    }

    public void setTarih(String tarih) {
        Tarih = tarih;
    }

    public String getKatilimci() {
        return Katilimci;
    }

    public void setKatilimci(String katilimci) {
        Katilimci = katilimci;
    }


}
