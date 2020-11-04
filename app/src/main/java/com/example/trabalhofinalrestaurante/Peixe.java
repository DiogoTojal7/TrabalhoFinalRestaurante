package com.example.trabalhofinalrestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Peixe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peixe);
        final String idmesacliente=getIntent().getStringExtra("IdMesaCliente");
        Button btnconfirmapeixe=(Button)findViewById(R.id.btnconfirmarpeixe);
        final BaseDados bd=new BaseDados(Peixe.this);
        ArrayAdapter<String> itemsAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bd.lista_peixes(bd.dbr));
        ListView listView = (ListView) findViewById(R.id.listapeixe);
        listView.setAdapter(itemsAdapter);
        btnconfirmapeixe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editnumeropeixe=(EditText)findViewById(R.id.editnumeropeixe);
                EditText editquantidadepeixe=(EditText)findViewById(R.id.editquantidadepeixe);
                if(editnumeropeixe.getText().toString().matches("")||editquantidadepeixe.getText().toString().matches(""))
                {
                    opendialog();
                    return;
                }
                int numeropeixe=Integer.parseInt(editnumeropeixe.getText().toString());
                int quantidadepeixe=Integer.parseInt(editquantidadepeixe.getText().toString());
                int idmesaclienteINT=Integer.parseInt(idmesacliente);
                bd.inserir_produtos_mesa(bd.dbw,idmesaclienteINT,numeropeixe,quantidadepeixe);
               opendialog();
               editnumeropeixe.setText("");
               editquantidadepeixe.setText("");
                // startActivity(new Intent(Peixe.this,Consulta_TipoProdutos.class));
            }
        });
    }
    public void opendialog()
    {
        Dialog_Confirmarproduto dialog  =new Dialog_Confirmarproduto();
        dialog.show(getSupportFragmentManager(),"exemplo");
    }
}
