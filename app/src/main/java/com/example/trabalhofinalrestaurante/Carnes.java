package com.example.trabalhofinalrestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Carnes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnes);
        final String idmesacliente=getIntent().getStringExtra("IdMesaCliente");
        Button btnconfirmaCarne=(Button)findViewById(R.id.btnconfirmarcarne);
        final BaseDados bd=new BaseDados(Carnes.this);
        ArrayAdapter<String> itemsAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bd.lista_carnes(bd.dbr));
        ListView listView = (ListView) findViewById(R.id.listacarnes);
        listView.setAdapter(itemsAdapter);
        btnconfirmaCarne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editnumerocarne=(EditText)findViewById(R.id.editnumeroCarne);
                EditText editquantidadecarne=(EditText)findViewById(R.id.editquantidadecarne);
                if(editnumerocarne.getText().toString().matches("")||editquantidadecarne.getText().toString().matches(""))
                {
                    opendialog();
                    return;
                }
                int numerocarne=Integer.parseInt(editnumerocarne.getText().toString());
                int quantidadecarne=Integer.parseInt(editquantidadecarne.getText().toString());
                int idmesaclienteINT=Integer.parseInt(idmesacliente);
                bd.inserir_produtos_mesa(bd.dbw,idmesaclienteINT,numerocarne,quantidadecarne);
                opendialog();
                editnumerocarne.setText("");
                editquantidadecarne.setText("");
                //startActivity(new Intent(Carnes.this,Consulta_TipoProdutos.class));
            }
        });
    }
    public void opendialog()
    {
        Dialog_Confirmarproduto dialog  =new Dialog_Confirmarproduto();
        dialog.show(getSupportFragmentManager(),"exemplo");
    }
}
