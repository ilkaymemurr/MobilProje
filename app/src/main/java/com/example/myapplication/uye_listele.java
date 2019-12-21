package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class uye_listele extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_listele);

        final EditText txtUyeListesi=findViewById(R.id.editText);
        Database db=new Database(getApplicationContext());

        List<Uye>uyeList=new ArrayList<Uye>();
        uyeList=db.getirUyeListesi();

        StringBuilder sb=new StringBuilder();
        for(Uye _uye:uyeList)
        {
String icerik="";
icerik="<- Güçlüyüz Çünkü Sen Varsın! ->\n\nAdı: "+_uye.getAd() + "\n\nTel: "+_uye.getTel() + "\n\nOkul No: "+_uye.getOkulNo()+"\n\nTC: "+_uye.getTc()+"\n\nBölüm: "+_uye.getBolum()+"\n\n";
sb.append(icerik);
        }
        txtUyeListesi.setText(sb);
    }
}
