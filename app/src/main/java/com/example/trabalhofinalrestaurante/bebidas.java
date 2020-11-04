package com.example.trabalhofinalrestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class bebidas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);
        final String idmesacliente=getIntent().getStringExtra("IdMesaCliente");
        Button btnconfirma=(Button)findViewById(R.id.btnconfirmarbebida);
        final BaseDados bd=new BaseDados(bebidas.this);
        ArrayAdapter<String> itemsAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bd.lista_bebidas(bd.dbr));
        ListView listView = (ListView) findViewById(R.id.listabebidas);
        listView.setAdapter(itemsAdapter);
        btnconfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editnumerobebida=(EditText)findViewById(R.id.editNumerobebida);
                EditText editquantidadebebida=(EditText)findViewById(R.id.editQuantidadeBebida);
                if(editnumerobebida.getText().toString().matches("")||editquantidadebebida.getText().toString().matches(""))
                {
                    opendialog();
                    return;
                }
                int numerobebida=Integer.parseInt(editnumerobebida.getText().toString());
                int qantidadebebida=Integer.parseInt(editquantidadebebida.getText().toString());
                int idmesaclienteINT=Integer.parseInt(idmesacliente);
                bd.inserir_produtos_mesa(bd.dbw,idmesaclienteINT,numerobebida,qantidadebebida);
                opendialog();
                editnumerobebida.setText("");
                editquantidadebebida.setText("");
                //startActivity(new Intent(bebidas.this,Consulta_TipoProdutos.class));
            }
        });

    }
    public void opendialog()
    {
        Dialog_Confirmarproduto dialog  =new Dialog_Confirmarproduto();
        dialog.show(getSupportFragmentManager(),"exemplo");
    }
}
