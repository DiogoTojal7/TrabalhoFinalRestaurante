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

import org.w3c.dom.Text;

public class Mesa_Util_Escolha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesa__util__escolha);
        final String idcliente= getIntent().getStringExtra("IDCLIENTE");
        final int num=Integer.parseInt(idcliente);
        Button btnavancar=(Button)findViewById(R.id.btnavancarmesa);
        ListView listamesas=(ListView)findViewById(R.id.listmesas);
        BaseDados bd=new BaseDados(Mesa_Util_Escolha.this);
        ArrayAdapter<String> itemsAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bd.Lista_Mesa_ABERTAS(bd.dbr));
        listamesas.setAdapter(itemsAdapter);

        btnavancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDados bd=new BaseDados(Mesa_Util_Escolha.this);
                EditText editnumeromesa=(EditText)findViewById(R.id.editNumeroMesa);
                String numeromesa=editnumeromesa.getText().toString();
                int numeromesaint=Integer.parseInt(numeromesa);
                bd.inserir_Mesa_Cliente(bd.dbr,num,numeromesaint);
                String numMesa_Cliente=bd.selectIDMesa_Cliente(bd.dbr,num,numeromesaint);
                Intent int1=new Intent(Mesa_Util_Escolha.this,Ementa.class);
                int1.putExtra("IDMESA_CLIENTE",numMesa_Cliente);
                startActivity(int1);
            }
        });

    }

}
