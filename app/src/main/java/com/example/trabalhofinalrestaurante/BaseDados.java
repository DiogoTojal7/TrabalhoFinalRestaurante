package com.example.trabalhofinalrestaurante;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class BaseDados extends SQLiteOpenHelper {
    Context co;
    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME = "Restaurante.db";
    public  String tabsc= "";
    SQLiteDatabase dbw = this.getWritableDatabase();
    SQLiteDatabase dbr = this.getReadableDatabase();

    public BaseDados(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        co=context;
    }
    public void onCreate(SQLiteDatabase db) {

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void onDowngrade(SQLiteDatabase db,int oldVersion, int newVersion)
    {
        onUpgrade(db,oldVersion,newVersion);
    }
    public void Criar_tabela_Clientes(SQLiteDatabase bd)
    {
        tabsc="Create table Clientes ("+
                "ID_Cliente Integer Primary Key AUTOINCREMENT,"+
                "Nome Text,"+
                "Nif Text,"+
                "Data_nasc Text)";
        try
        {
            bd.execSQL(tabsc);
            Log.i("Tabela clientes","A tabela clientes foi criada com sucesso");
        }
        catch(Exception e)
        {
            Log.i("Tabela clientes","A tabela clientes ja existe");
        }

    }

    public void Criar_tabela_Mesa(SQLiteDatabase bd)
    {
        tabsc="Create table Mesa ("+
                "ID_Mesa Integer Primary Key,"+
                "Localizacao Text,"+
                "NumeroLugares Integer,"+
                "Disponivel Text)";
        try
        {
            bd.execSQL(tabsc);
            Log.i("Tabela Mesa","A tabela Mesa foi criada com sucesso");
        }
        catch(Exception e)
        {
            Log.i("Tabela Mesa","A tabela Mesa ja existe");
        }
    }

    public void Criar_tabela_Mesa_Clientes(SQLiteDatabase bd)
    {
        tabsc="Create table Mesa_Clientes ("+
                "IDMesa_Cliente Integer Primary Key AUTOINCREMENT,"+
                "ID_Cliente Integer,"+
                "ID_Mesa Integer,"+
                "FOREIGN KEY(ID_Cliente) REFERENCES Clientes(ID_Cliente),"+
                "FOREIGN KEY(ID_Mesa) REFERENCES Mesa(ID_Mesa))";
        try
        {
            bd.execSQL(tabsc);
            Log.i("Tabela Mesa_Clientes","A tabela Mesa_Clientes foi criada com sucesso");
        }
        catch(Exception e)
        {
            Log.i("Tabela Mesa_Clientes","A tabela Mesa_Clientes ja existe");
        }
    }

    public void Criar_tabela_TipoProduto(SQLiteDatabase bd)
    {
        tabsc="Create table tipo_produto ("+
                "ID_Tipo Integer Primary Key,"+
                "Descricao Text)";
        try
        {
            bd.execSQL(tabsc);
            Log.i("Tabela TipoProduto","A tabela TipoProduto foi criada com sucesso");
        }
        catch(Exception e)
        {
            Log.i("Tabela TipoProduto","A tabela TipoProduto ja existe");
        }
    }
    public void Criar_tabela_Produtos(SQLiteDatabase bd)
    {
        tabsc="Create table produtos ("+
                "ID_Produto Integer Primary Key,"+
                "ID_Tipo Integer,"+
                "Nome Text,"+
                "Marca Text,"+
                "Descricao Text,"+
                "Preco REAL,"+
                "Risco_Alergia Text,"+
                "FOREIGN KEY(ID_Tipo) REFERENCES tipo_produto(ID_Tipo))";
        try
        {
            bd.execSQL(tabsc);
            Log.i("Tabela Produtos","A tabela Produtos foi criada com sucesso");
        }
        catch(Exception e)
        {
            Log.i("Tabela Produtos","A tabela Produtos ja existe");
        }
    }

    public void Criar_tabela_Produtos_Mesa_Cliente(SQLiteDatabase bd)
    {
        tabsc="Create table Produtos_Mesa_Cliente ("+
                "ID_PEDIDO Integer Primary Key AUTOINCREMENT,"+
                "ID_MESA_CLIENTE Integer,"+
                "ID_PRODUTO Integer,"+
                "Quantidade Integer,"+
                "FOREIGN KEY(ID_MESA_CLIENTE) REFERENCES Mesa_Clientes(IDMesa_Cliente),"+
                "FOREIGN KEY(ID_PRODUTO) REFERENCES produtos(ID_Produto))";
        try
        {
            bd.execSQL(tabsc);
            Log.i("Tabela P-M-C","A tabela Produtos_Mesa_Cliente foi criada com sucesso");
        }
        catch(Exception e)
        {
            Log.i("Tabela P-M-C","A tabela Produtos_Mesa_Cliente ja existe");
        }
    }

    public void Criar_tabela_Pagamento(SQLiteDatabase bd)
    {
        tabsc="Create table Pagamento ("+
                "ID_Pagamento Integer Primary Key AUTOINCREMENT,"+
                "ID_MESA_CLIENTE Integer,"+
                "Tipo_Pagamento Text,"+
                "FOREIGN KEY(ID_MESA_CLIENTE) REFERENCES Mesa_Clientes(IDMesa_Cliente))";
        try
        {
            bd.execSQL(tabsc);
            Log.i("Tabela Pagamento","A tabela Pagamento foi criada com sucesso");
        }
        catch(Exception e)
        {
            Log.i("Tabela Pagamento","A tabela Pagamento ja existe");
        }
    }

    public void apaga_tabela_Clientes(SQLiteDatabase bd)
    {
        tabsc="drop TABLE Clientes";
        try
        {
            bd.execSQL(tabsc);
            Log.i("Tabela Clientes","A tabela Clientes foi apagada");
        }
        catch(Exception e) {
            Log.i("Tabela Clientes","A tabela Clientes nao foi apagada");
        }
    }
    public void apaga_tabela_Mesa(SQLiteDatabase bd)
    {
        tabsc="drop TABLE Mesa";
        try
        {
            bd.execSQL(tabsc);
            Log.i("Tabela Mesa","A tabela Mesa foi apagada");
        }
        catch(Exception e) {
            Log.i("Tabela Mesa","A tabela Mesa nao foi apagada");
        }
    }
    public void apaga_tabela_Mesa_Clientes(SQLiteDatabase bd)
    {
        tabsc="drop TABLE Mesa_Clientes";
        try
        {
            bd.execSQL(tabsc);
            Log.i("Tabela Mesa_Clientes","A tabela Mesa_Clientes foi apagada");
        }
        catch(Exception e) {
            Log.i("Tabela Mesa_Clientes","A tabela Mesa_Clientes nao foi apagada");
        }
    }
    public void apaga_tabela_tipo_produto(SQLiteDatabase bd)
    {
        tabsc="drop TABLE tipo_produto";
        try
        {
            bd.execSQL(tabsc);
            Log.i("Tabela tipo_produto","A tabela tipo_produto foi apagada");
        }
        catch(Exception e) {
            Log.i("Tabela tipo_produto","A tabela tipo_produto nao foi apagada");
        }
    }
    public void apaga_tabela_produtos(SQLiteDatabase bd)
    {
        tabsc="drop TABLE produtos";
        try
        {
            bd.execSQL(tabsc);
            Log.i("Tabela produtos","A tabela produtos foi apagada");
        }
        catch(Exception e) {
            Log.i("Tabela produtos","A tabela produtos nao foi apagada");
        }
    }
    public void apaga_tabela_Produtos_Mesa_Cliente(SQLiteDatabase bd)
    {
        tabsc="drop TABLE Produtos_Mesa_Cliente";
        try
        {
            bd.execSQL(tabsc);
            Log.i("Tabela P-M-C","A tabela Produtos_Mesa_Cliente foi apagada");
        }
        catch(Exception e) {
            Log.i("Tabela P-M-C","A tabela Produtos_Mesa_Cliente nao foi apagada");
        }
    }
    public void apaga_tabela_Pagamento(SQLiteDatabase bd)
    {
        tabsc="drop TABLE Pagamento";
        try
        {
            bd.execSQL(tabsc);
            Log.i("Tabela Pagamento","A tabela Pagamento foi apagada");
        }
        catch(Exception e) {
            Log.i("Tabela Pagamento","A tabela Pagamento nao foi apagada");
        }
    }

    public void inserir_tipo_produtos(SQLiteDatabase bd)
    {
        tabsc="insert into tipo_produto(ID_Tipo,Descricao) values (1,'Entradas')";
        bd.execSQL(tabsc);

        tabsc="insert into tipo_produto(ID_Tipo,Descricao) values (2,'Bebidas')";
        bd.execSQL(tabsc);

        tabsc="insert into tipo_produto(ID_Tipo,Descricao) values (3,'Pratos de peixe')";
        bd.execSQL(tabsc);

        tabsc="insert into tipo_produto(ID_Tipo,Descricao) values (4,'Pratos de carne')";
        bd.execSQL(tabsc);

        tabsc="insert into tipo_produto(ID_Tipo,Descricao) values (5,'Sobremesas')";
        bd.execSQL(tabsc);

    }
    public void inserir_mesa(SQLiteDatabase bd)
    {
        tabsc="insert into Mesa(ID_Mesa,Localizacao,NumeroLugares,Disponivel) values (1,'Canto Sul, vista mar (Sala 1)',4,'aberta')";
        bd.execSQL(tabsc);

        tabsc="insert into Mesa(ID_Mesa,Localizacao,NumeroLugares,Disponivel) values (2,'Canto norte (sala 1)',2,'aberta')";
        bd.execSQL(tabsc);

        tabsc="insert into Mesa(ID_Mesa,Localizacao,NumeroLugares,Disponivel) values (3,'Canto sudeste, vista mar (sala 1)',6,'aberta')";
        bd.execSQL(tabsc);

        tabsc="insert into Mesa(ID_Mesa,Localizacao,NumeroLugares,Disponivel) values (4,'Centro esquerdo (sala 2)',12,'aberta')";
        bd.execSQL(tabsc);

        tabsc="insert into Mesa(ID_Mesa,Localizacao,NumeroLugares,Disponivel) values (5,'Centro direito (sala 2)',12,'aberta')";
        bd.execSQL(tabsc);
    }

    public void inserir_produtos(SQLiteDatabase bd)
    {
        tabsc="insert into produtos(ID_Produto,ID_Tipo,Nome,Marca,Descricao,Preco,Risco_Alergia) values (1,1,'Tábua de presunto','Presunto Ibérico','Tábua 10 fatias de presunto. Aconselhável: 2 pessoas',7.89,'Risco de alergia: 1')";
        bd.execSQL(tabsc);

        tabsc="insert into produtos(ID_Produto,ID_Tipo,Nome,Marca,Descricao,Preco,Risco_Alergia) values (2,2,'Fanta Laranja','FANTA','Fanta com sabor a laranja. 200 ml (lata)',1.70,'Risco de alergia: 2')";
        bd.execSQL(tabsc);

        tabsc="insert into produtos(ID_Produto,ID_Tipo,Nome,Marca,Descricao,Preco,Risco_Alergia) values (3,3,'Salmão grelhado','IGLO','2 postas de salmão grelhado, com batata cozida e legumes a acompanhar. Aconselhável: 2 pessoas',19.99,'Risco de alergia: 0')";
        bd.execSQL(tabsc);

        tabsc="insert into produtos(ID_Produto,ID_Tipo,Nome,Marca,Descricao,Preco,Risco_Alergia) values (4,4,'Francesinha frango','Moda Porto','Francesinha com fatia de frango, linguíça, ovo estralado, etc. Batata frita de acompanhamento',8.99,'Risco de alergia: 2')";
        bd.execSQL(tabsc);

        tabsc="insert into produtos(ID_Produto,ID_Tipo,Nome,Marca,Descricao,Preco,Risco_Alergia) values (5,5,'Frutas variadas','Moda Casa','Frutas da época: Melão, morangos, laranja e pessego.',3.50,'Risco de alergia: 0')";
        bd.execSQL(tabsc);
    }

    public ArrayList<String>  lista_tipo_produtos(SQLiteDatabase bd) {
        ArrayList<String> array_list = new ArrayList<String>();


        Cursor res =  bd.rawQuery( "select ID_Tipo,Descricao from tipo_produto", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("Descricao")));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<String>  lista_produtos(SQLiteDatabase bd) {
        ArrayList<String> array_list = new ArrayList<String>();


        Cursor res =  bd.rawQuery( "select ID_Produto, ID_Tipo,Nome,Marca, Descricao, Preco,Risco_Alergia from produtos", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add("Nome: "+res.getString(res.getColumnIndex("Nome"))+ "\nMarca: " +res.getString(res.getColumnIndex("Marca"))+ "\nDescrição: " +res.getString(res.getColumnIndex("Descricao"))+ "\nPreço: " +res.getString(res.getColumnIndex("Preco"))+ "\nNível de alergia: " +res.getString(res.getColumnIndex("Risco_Alergia")));
            res.moveToNext();
        }
        return array_list;
    }


}
