package com.example.trabalhofinalrestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btlogin=(Button)findViewById(R.id.btnLOGINENTRAR);
        final EditText txtnome=(EditText)findViewById(R.id.txtnomelogin);
        final EditText txtnif=(EditText)findViewById(R.id.txtniflogin);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtnome.getText().toString().matches("")||txtnif.getText().toString().matches(""))
                {
                    opendialog();
                    return;
                }
                BaseDados bd=new BaseDados(Login.this);
                String idcliente;
                idcliente=bd.selectIDCliente(bd.dbr,txtnome.getText().toString(),txtnif.getText().toString());
                if(idcliente.matches(""))
                {
                    opendialog_util_dados_erro();
                    txtnif.setText("");
                    txtnome.setText("");
                }
                else
                {
                    Intent int1=new Intent(Login.this,Mesa_Util_Escolha.class);
                    int1.putExtra("IDCLIENTE",idcliente);
                    startActivity(int1);
                }
            }
        });
    }

    public void opendialog_util_dados_erro()
    {
        Dialog_Dados_Util_Errados dialog_dados_util_errados=new Dialog_Dados_Util_Errados();
        dialog_dados_util_errados.show(getSupportFragmentManager(),"errodados");
    }
    public void opendialog()
    {
        Dialog dialog  =new Dialog();
        dialog.show(getSupportFragmentManager(),"exemplo");
    }
}
