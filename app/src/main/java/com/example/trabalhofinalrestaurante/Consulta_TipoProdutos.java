package com.example.trabalhofinalrestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class Consulta_TipoProdutos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta__tipo_produtos);

        BaseDados bd=new BaseDados(Consulta_TipoProdutos.this);
       // ArrayAdapter<String> itemsAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bd.lista_tipo_produtos(bd.dbr));
        //ArrayAdapter<String> itemsAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bd.lista_produtos(bd.dbr));
        //ArrayAdapter<String> itemsAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bd.lista_pessoas(bd.dbr));
       // ArrayAdapter<String> itemsAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bd.selectIDCliente(bd.dbr,nome,nif));
      //  ArrayAdapter<String> itemsAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bd.lista_mesa_clientes(bd.dbr));
       // ArrayAdapter<String> itemsAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bd.lista_Produtos_Mesa_Cliente(bd.dbr));
        ArrayAdapter<String> itemsAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bd.lista_tablepagamentos(bd.dbr));

        ListView listView = (ListView) findViewById(R.id.listaTipoProdutos);
        listView.setAdapter(itemsAdapter);
    }
}
