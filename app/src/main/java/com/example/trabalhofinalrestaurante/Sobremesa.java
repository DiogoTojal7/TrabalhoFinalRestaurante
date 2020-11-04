package com.example.trabalhofinalrestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Sobremesa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobremesa);
        final String idmesacliente=getIntent().getStringExtra("IdMesaCliente");
        Button btnconfirmasobremesa=(Button)findViewById(R.id.btnsobremesa);
        final BaseDados bd=new BaseDados(Sobremesa.this);
        ArrayAdapter<String> itemsAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bd.lista_sobremesas(bd.dbr));
        ListView listView = (ListView) findViewById(R.id.listasobremesas);
        listView.setAdapter(itemsAdapter);
        btnconfirmasobremesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editnumerosobremesa=(EditText)findViewById(R.id.editnumerosobremesa);
                EditText editquantidadesobremesa=(EditText)findViewById(R.id.editquantidadesobremesa);
                if(editnumerosobremesa.getText().toString().matches("")||editquantidadesobremesa.getText().toString().matches(""))
                {
                    opendialog();
                    return;
                }
                int numerosobremesa=Integer.parseInt(editnumerosobremesa.getText().toString());
                int quantidadesobremesa=Integer.parseInt(editquantidadesobremesa.getText().toString());
                int idmesaclienteINT=Integer.parseInt(idmesacliente);
                bd.inserir_produtos_mesa(bd.dbw,idmesaclienteINT,numerosobremesa,quantidadesobremesa);
                opendialog();
                editnumerosobremesa.setText("");
                editquantidadesobremesa.setText("");
                //startActivity(new Intent(Sobremesa.this,Consulta_TipoProdutos.class));

            }
        });
    }
    public void opendialog()
    {
        Dialog_Confirmarproduto dialog  =new Dialog_Confirmarproduto();
        dialog.show(getSupportFragmentManager(),"exemplo");
    }
}
