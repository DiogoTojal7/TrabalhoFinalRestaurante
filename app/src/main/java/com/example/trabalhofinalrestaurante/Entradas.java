package com.example.trabalhofinalrestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Entradas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entradas);
        final String idmesacliente=getIntent().getStringExtra("IdMesaCliente");
        Button btnpassaoutrapagina=(Button)findViewById(R.id.btnpassaoutrapagina2);
        final BaseDados bd=new BaseDados(Entradas.this);
        ArrayAdapter<String> itemsAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bd.lista_entradas(bd.dbr));
        ListView listView = (ListView) findViewById(R.id.listaentradas);
        listView.setAdapter(itemsAdapter);

        btnpassaoutrapagina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editnumeroprod=(EditText)findViewById(R.id.editnumeroProduto);
                EditText editquantidade=(EditText)findViewById(R.id.editQuantidade);
                if(editnumeroprod.getText().toString().matches("")||editquantidade.getText().toString().matches(""))
                {
                    opendialog();
                    return;
                }
                int numeroprod=Integer.parseInt(editnumeroprod.getText().toString());
                int quantidadeprod=Integer.parseInt(editquantidade.getText().toString());
                int idmesaclienteINT=Integer.parseInt(idmesacliente);
                bd.inserir_produtos_mesa(bd.dbw,idmesaclienteINT,numeroprod,quantidadeprod);
                opendialog();
                editnumeroprod.setText("");
                editquantidade.setText("");
            }
        });
    }
    public void opendialog()
    {
        Dialog_Confirmarproduto dialog  =new Dialog_Confirmarproduto();
        dialog.show(getSupportFragmentManager(),"exemplo");
    }
}
