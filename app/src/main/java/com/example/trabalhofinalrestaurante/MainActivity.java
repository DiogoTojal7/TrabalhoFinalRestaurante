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
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDados bd=new BaseDados(MainActivity.this);
                bd.apaga_tabela_Clientes(bd.dbw);
                bd.apaga_tabela_Mesa(bd.dbw);
                bd.apaga_tabela_produtos(bd.dbw);
                bd.apaga_tabela_tipo_produto(bd.dbw);
                bd.apaga_tabela_Mesa_Clientes(bd.dbw);
                bd.apaga_tabela_Produtos_Mesa_Cliente(bd.dbw);
                bd.apaga_tabela_Pagamento(bd.dbw);
                bd.Criar_tabela_Mesa_Clientes(bd.dbw);
                bd.Criar_tabela_Clientes(bd.dbw);
                bd.Criar_tabela_TipoProduto(bd.dbw);
                bd.Criar_tabela_Mesa(bd.dbw);
                bd.Criar_tabela_Produtos(bd.dbw);
                bd.Criar_tabela_Produtos_Mesa_Cliente(bd.dbw);
                bd.Criar_tabela_Pagamento(bd.dbw);
                bd.inserir_tipo_produtos(bd.dbw);
                bd.inserir_produtos(bd.dbw);
                bd.inserir_mesa(bd.dbw);
            }
        });


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Escolha_Mesa.class));
            }
        });
    }
}
