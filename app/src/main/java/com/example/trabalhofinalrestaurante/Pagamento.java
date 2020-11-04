package com.example.trabalhofinalrestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class Pagamento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        final String idmesacliente=getIntent().getStringExtra("IdMesaCliente");
        final int idmesaclienteINT=Integer.parseInt(idmesacliente);
        final BaseDados bd=new BaseDados(Pagamento.this);
        ArrayAdapter<String> itemsAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bd.lista_pagamentos(bd.dbr,idmesaclienteINT));
        ListView listView = (ListView) findViewById(R.id.Lista_pagamento);
        listView.setAdapter(itemsAdapter);
        Button btnpagar=(Button)findViewById(R.id.btnpagamento);
        TextView txttotalrefeicao=(TextView)findViewById(R.id.textviewtotalrefeicao);
        String TotalPagamento;
        TotalPagamento=bd.selecttotalPagamento(bd.dbr,idmesaclienteINT);
        txttotalrefeicao.setText("Total:"+TotalPagamento);
        final CheckBox checkDinheiro=(CheckBox)findViewById(R.id.checkdinh);
        final CheckBox checkmultibanco=(CheckBox)findViewById(R.id.checkMul);
        if (checkDinheiro.isSelected())
        {
            checkmultibanco.setChecked(false);
        }
        if (checkmultibanco.isSelected())
        {
            checkDinheiro.setChecked(false);
        }
        btnpagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String meiopagamento="";
                if(checkDinheiro.isChecked()==true)
                {
                    meiopagamento="Dinheiro";
                }
                else if(checkmultibanco.isChecked()==true)
                {
                    meiopagamento="Multibanco";
                }
                bd.inserir_pagamento(bd.dbw,idmesaclienteINT,meiopagamento);
                startActivity(new Intent(Pagamento.this,Final.class));
            }
        });
    }
}
