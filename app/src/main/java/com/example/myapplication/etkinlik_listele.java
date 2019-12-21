package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class etkinlik_listele extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etkinlik_listele);


        final EditText txtEtkinlikListesi=findViewById(R.id.editText2);
        Database2 db2=new Database2(getApplicationContext());

        List<Etkinlik> uyeList=new ArrayList<Etkinlik>();
        uyeList=db2.getirEtkinlikListesi();

        StringBuilder sb=new StringBuilder();
        for(Etkinlik _uye:uyeList)
        {
            String icerik="";
            icerik="<- Güçlüyüz Çünkü Sen Varsın! ->\n\nEtkinlik Adı: "+_uye.getAd() + "\n\nTarih: "+_uye.getTarih() + "\n\nKatılımcılar: \n"+_uye.getKatilimci()+"\n\n";
            sb.append(icerik);
        }
        txtEtkinlikListesi.setText(sb);
    }
}
