package com.example.trabalhofinalrestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt= (Button) findViewById(R.id.btnpassaoutrapagina);
        Button bt2= (Button) findViewById(R.id.btncribd);
        Button bt3= (Button) findViewById(R.id.btninseredados);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDados bd=new BaseDados(MainActivity.this);
                bd.Criar_tabela_TipoProduto(bd.dbw);
                bd.Criar_tabela_Produtos(bd.dbw);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDados bd=new BaseDados(MainActivity.this);
                bd.inserir_tipo_produtos(bd.dbw);
                bd.inserir_produtos(bd.dbw);
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Consulta_TipoProdutos.class));
            }
        });
    }
}
