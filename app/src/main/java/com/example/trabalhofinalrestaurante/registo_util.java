package com.example.trabalhofinalrestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class registo_util extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registo_util);
        Button btregisto=(Button) findViewById(R.id.btnregistoUtil);
        final EditText editnome=(EditText) findViewById(R.id.edittnome);
        final EditText editnif=(EditText) findViewById(R.id.editNIF);
        final EditText editdatanas=(EditText) findViewById(R.id.editdatanasc);
        btregisto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDados bd=new BaseDados(registo_util.this);
                if(editnome.getText().toString().matches("")||editdatanas.getText().toString().matches("")||editnif.getText().toString().matches(""))
                {
                    opendialog();
                    return;
                }
                bd.inserir_pessoas_REGISTO(bd.dbw,editnome.getText().toString(),editnif.getText().toString(),editdatanas.getText().toString());
                String x=bd.selectIDCliente(bd.dbr,editnome.getText().toString(),editnif.getText().toString());
                int xint=Integer.parseInt(x);
                editdatanas.setText("");
                editnome.setText("");
                editnif.setText("");
                Intent int1=new Intent(registo_util.this,Mesa_Util_Escolha.class);
                int1.putExtra("IDCLIENTE",x);
                startActivity(int1);


            }
        });

    }
    public void opendialog()
    {
        Dialog dialog  =new Dialog();
        dialog.show(getSupportFragmentManager(),"exemplo");
    }
}
