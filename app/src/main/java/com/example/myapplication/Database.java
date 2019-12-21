package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private  static final String veritabani_adi="veritabani_uyem";
    private  static final  String uye_tablosu="tb1_Ogrenci";
    private  static  final int veritabani_versiyonu=1;




    public Database(@Nullable Context context) {
        super(context,veritabani_adi,null,veritabani_versiyonu);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String sql_UyeTablosuOlusturma="CREATE TABLE " +uye_tablosu+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,UyeAdi TEXT,UyeTel TEXT,UyeOkulNo TEXT,UyeTc TEXT,UyeBolum Text)";
      db.execSQL(sql_UyeTablosuOlusturma);
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+uye_tablosu);
    }

    public long uyeEkle(Uye uye) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("UyeAdi",uye.getAd());
        cv.put("UyeTel",uye.getTel());
        cv.put("UyeOkulNo",uye.getOkulNo());
        cv.put("UyeTc",uye.getTc());
        cv.put("UyeBolum",uye.getBolum());

        long id=   db.insert(uye_tablosu,null,cv);
        return id;
    }

    public List<Uye> getirUyeListesi() {
        List<Uye>uyeList=new ArrayList<Uye>();
        SQLiteDatabase db=this.getReadableDatabase();
        String sqlSorgusu= " Select * from "+uye_tablosu;

        Cursor c=db.rawQuery(sqlSorgusu,null);
        int siraNoID=c.getColumnIndex("ID");
        int siraNoAd=c.getColumnIndex("UyeAdi");
        int siraNoTel=c.getColumnIndex("UyeTel");
        int siraNoOkulNo=c.getColumnIndex("UyeOkulNo");
        int siraNoTc=c.getColumnIndex("UyeTc");
        int siraNoBolum=c.getColumnIndex("UyeBolum");
        try
        {
            while (c.moveToNext())
            {
                Uye _uye=new Uye();
                _uye.setAd(c.getString(siraNoAd));
                _uye.setTel(c.getString(siraNoTel));
                _uye.setOkulNo(c.getString(siraNoOkulNo));
                _uye.setTc(c.getString(siraNoTc));
                _uye.setBolum(c.getString(siraNoBolum));
                uyeList.add(_uye);

            }
        }finally {
            c.close();
            db.close();
        }
        return uyeList;
    }
}
