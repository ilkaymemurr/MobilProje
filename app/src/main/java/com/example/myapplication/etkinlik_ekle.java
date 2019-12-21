package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class etkinlik_ekle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etkinlik_ekle);


        final EditText etkinlik_adi=findViewById(R.id.etkinlik_adi);
        final Calendar takvim=Calendar.getInstance();
        final EditText katilimcilar=findViewById(R.id.katilimcilar);
        Button btn=findViewById(R.id.button);
        Button tamamla=findViewById(R.id.button6);
        final String[] deneme = new String[1];
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String etkinlikadi=etkinlik_adi.getText().toString();
                String katilimci=katilimcilar.getText().toString();
                int year = takvim.get(Calendar.YEAR); //Güncel Yılı alıyoruz.
                int month = takvim.get(Calendar.MONTH); //Güncel Ayı alıyoruz.
                int day = takvim.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePicker;//Datepicker objemiz
                datePicker =new DatePickerDialog(etkinlik_ekle.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        String tarih=dayOfMonth + "/" + month+ "/"+year;
                        deneme[0] =tarih;
                    //  Toast.makeText(getApplicationContext()," "+ deneme[0] ,Toast.LENGTH_LONG).show();


                    }
                },year,month,day);
                datePicker.setTitle("Tarih Seçiniz");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Seç", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", datePicker);
                datePicker.show();




                  /*  Toast.makeText(getApplicationContext()," "+ deneme[0] ,Toast.LENGTH_LONG).show();

                    */

            }
        });
        tamamla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String etkinlikadi=etkinlik_adi.getText().toString();
                String katilimci=katilimcilar.getText().toString();
                Etkinlik etkinlik=new Etkinlik(etkinlikadi,deneme[0],katilimcilar.getText().toString());
                Database2 db2=new Database2(getApplicationContext());
                long id= db2.etkinlikEkle(etkinlik);
                Toast.makeText(getApplicationContext()," İŞLEM BAŞARIYLA GERÇEKLEŞTİ",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(etkinlik_ekle.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
