package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database2 extends SQLiteOpenHelper {
    private  static final String veritabani_adi2="veritabani_etkinligim";
    private  static final  String etkinlik_tablosu="tb1_Etkinlik";
    private  static  final int veritabani_versiyonu=1;



    public Database2(@Nullable Context context) {
        super(context,veritabani_adi2,null,veritabani_versiyonu);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_EtkinlikTablosuOlusturma="CREATE TABLE " +etkinlik_tablosu+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,EtkinlikAdi TEXT,EtkinlikTarih TEXT,EtkinlikKatilimci TEXT)";
        db.execSQL(sql_EtkinlikTablosuOlusturma);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+etkinlik_tablosu);
    }
// DEVAM

    public long etkinlikEkle(Etkinlik etkinlik) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("EtkinlikAdi",etkinlik.getAd());
        cv.put("EtkinlikTarih",etkinlik.getTarih());
        cv.put("EtkinlikKatilimci",etkinlik.getKatilimci());


        long id=   db.insert(etkinlik_tablosu,null,cv);
        return id;
    }

    public List<Etkinlik> getirEtkinlikListesi() {
        List<Etkinlik>EtkinlikList=new ArrayList<Etkinlik>();
        SQLiteDatabase db=this.getReadableDatabase();
        String sqlSorgusu= " Select * from "+etkinlik_tablosu;

        Cursor c=db.rawQuery(sqlSorgusu,null);
        int siraNoID=c.getColumnIndex("ID");
        int siraNoAd=c.getColumnIndex("EtkinlikAdi");
        int siraNoTel=c.getColumnIndex("EtkinlikTarih");
        int siraNoOkulNo=c.getColumnIndex("EtkinlikKatilimci");

        try
        {
            while (c.moveToNext())
            {
                Etkinlik _uye=new Etkinlik();
                _uye.setAd(c.getString(siraNoAd));
                _uye.setTarih(c.getString(siraNoTel));
                _uye.setKatilimci(c.getString(siraNoOkulNo));

                EtkinlikList.add(_uye);

            }
        }finally {
            c.close();
            db.close();
        }
        return EtkinlikList;
    }
}
