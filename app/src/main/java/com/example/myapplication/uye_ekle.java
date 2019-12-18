package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class uye_ekle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_ekle);

        final EditText uyead=findViewById(R.id.uyead);
        final EditText uyetel=findViewById(R.id.uyetelefon);
        final EditText uyeokulno=findViewById(R.id.uyeokulno);
        final EditText uyetc=findViewById(R.id.uyetc);
        final EditText uyebolum=findViewById(R.id.uyebolum);

        Button btn_tamamla=findViewById(R.id.btn_tamamla);

        btn_tamamla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ad=uyead.getText().toString();
                String tel=uyetel.getText().toString();
                String okulno=uyeokulno.getText().toString();
                String tc=uyetc.getText().toString();
                String bolum=uyebolum.getText().toString();

                if(ad.isEmpty() || tel.isEmpty() || okulno.isEmpty() || tc.isEmpty() || bolum.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Alanları Boş geçemezsiniz",Toast.LENGTH_LONG).show();
                    return;
                }
                Uye uye=new Uye(ad,tc,okulno,tc,bolum);
                Database db=new Database(getApplicationContext());
              long id= db.uyeEkle(uye);

                if(id>0)
                {
                    Toast.makeText(getApplicationContext(),"Kayıt Başarılı! ID= "+id,Toast.LENGTH_LONG).show();
                    uyead.setText("");
                    uyetel.setText("");
                    uyeokulno.setText("");
                    uyetc.setText("");
                    uyebolum.setText("");
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Kayıt Başarısız ",Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
