package com.example.trabalhofinalrestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Ementa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ementa);
         final String idmesa_cliente= getIntent().getStringExtra("IDMESA_CLIENTE");
        ImageButton btimgEntrada=(ImageButton)findViewById(R.id.imgbtnentrada);
        ImageButton btimgBebida=(ImageButton)findViewById(R.id.imgbtnbebida);
        ImageButton btimgCarne=(ImageButton)findViewById(R.id.imgbtncarne);
        ImageButton btimgPeixe=(ImageButton)findViewById(R.id.imgbtnpeixe);
        ImageButton btimgSobremesa=(ImageButton)findViewById(R.id.imgbtnsobremesa);
        Button btnPagamento=(Button)findViewById(R.id.btnavancapagametno);
        btnPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(Ementa.this,Pagamento.class);
                int1.putExtra("IdMesaCliente",idmesa_cliente);
                startActivity(int1);
            }
        });
        btimgEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(Ementa.this,Entradas.class);
                int1.putExtra("IdMesaCliente",idmesa_cliente);
                startActivity(int1);
            }
        });

        btimgBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(Ementa.this,bebidas.class);
                int1.putExtra("IdMesaCliente",idmesa_cliente);
                startActivity(int1);            }
        });

        btimgCarne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(Ementa.this,Carnes.class);
                int1.putExtra("IdMesaCliente",idmesa_cliente);
                startActivity(int1);
            }
        });
        btimgPeixe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(Ementa.this,Peixe.class);
                int1.putExtra("IdMesaCliente",idmesa_cliente);
                startActivity(int1);
            }
        });
        btimgSobremesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(Ementa.this,Sobremesa.class);
                int1.putExtra("IdMesaCliente",idmesa_cliente);
                startActivity(int1);
            }
        });
    }
}
