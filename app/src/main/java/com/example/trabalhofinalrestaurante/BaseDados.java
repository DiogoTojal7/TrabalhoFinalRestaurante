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

        tabsc="insert into produtos(ID_Produto,ID_Tipo,Nome,Marca,Descricao,Preco,Risco_Alergia) values (6,1,'Tábua de petiscos','Moda casa','Tábua com vários petiscos: moelas, salada de bacalhau, ameijoa com cebola, camarao frito. Aconselhável: 2 pessoas',16,'Risco de alergia: 1')";
        bd.execSQL(tabsc);

        tabsc="insert into produtos(ID_Produto,ID_Tipo,Nome,Marca,Descricao,Preco,Risco_Alergia) values (7,1,'Cogumelos salteados','Moda casa','Cogumelos salteados com caju. Aconselhável: 2 pessoas',4.89,'Risco de alergia: 4')";
        bd.execSQL(tabsc);
    }

    //INSERIR PESSOAS (REGISTO)
    public void inserir_pessoas_REGISTO(SQLiteDatabase bd, String nome,String nif,String datanasc)
    {
        tabsc="insert into Clientes(Nome,Nif,Data_nasc) values('" + nome + "','"+nif+"','"+datanasc+"')";
        bd.execSQL(tabsc);

    }

    //Inserir Mesa_Clientes
    public void inserir_Mesa_Cliente(SQLiteDatabase bd, int idcliente,int idmesa)
    {
        tabsc="insert into Mesa_Clientes(ID_Cliente,ID_Mesa) values("+idcliente+","+idmesa+")";
        bd.execSQL(tabsc);
    }

    //INSERIR PEDIDO (JUNÇÃO DA MESA_CLIENTE COM OS PRODUTOS)
    public void inserir_produtos_mesa(SQLiteDatabase bd,int id_mesacliente,int idproduto,int quantidade)
    {
        tabsc="insert into Produtos_Mesa_Cliente (ID_MESA_CLIENTE,ID_PRODUTO,Quantidade) values("+id_mesacliente+","+idproduto+","+quantidade+")";
        bd.execSQL(tabsc);
    }
    public void inserir_pagamento(SQLiteDatabase bd, int idmesacliente,String pagamento)
    {
        tabsc="insert into Pagamento (ID_MESA_CLIENTE,Tipo_Pagamento) values("+idmesacliente+",'"+pagamento+"')";
        bd.execSQL(tabsc);
    }

    // buscar valores

    public String selectIDMesa_Cliente(SQLiteDatabase bd, int idcliente,int idmesa)
    {
        String id="";
        Cursor res=bd.rawQuery("Select IDMesa_Cliente from Mesa_Clientes where ID_Cliente="+idcliente+" and ID_Mesa="+idmesa,null);
        res.moveToFirst();
        while(res.isAfterLast() == false){
            id=(res.getString(res.getColumnIndex("IDMesa_Cliente")));
            res.moveToNext();
        }
        return id;
    }

    public String   selectIDCliente(SQLiteDatabase bd, String nome, String nif) {
        String id="";
        Cursor res =  bd.rawQuery( "select ID_Cliente from Clientes where Nome like'"+nome+"' and Nif like '"+nif+"'", null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
         id=(res.getString(res.getColumnIndex("ID_Cliente")));
            res.moveToNext();
        }
        return id;
    }

    public String   selecttotalPagamento(SQLiteDatabase bd, int id_mesacliente) {
        String total="";
        Cursor res =  bd.rawQuery( "Select sum(Quantidade*preco)  as total from Produtos_Mesa_Cliente join produtos on Produtos_Mesa_Cliente.ID_PRODUTO=produtos.ID_Produto WHERE ID_MESA_CLIENTE="+id_mesacliente, null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            total=(res.getString(res.getColumnIndex("total")));
            res.moveToNext();
        }
        return total;
    }


    public ArrayList<String>  Lista_Mesa_ABERTAS(SQLiteDatabase bd) {
        ArrayList<String> array_list = new ArrayList<String>();


        Cursor res =  bd.rawQuery( "select ID_Mesa,Localizacao, NumeroLugares, Disponivel from Mesa", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add("Numero da mesa: "+ res.getString(res.getColumnIndex("ID_Mesa"))+"\nLocalização: "+ res.getString(res.getColumnIndex("Localizacao"))+ "\nNúmero Lugares: "+res.getString(res.getColumnIndex("NumeroLugares")));
            res.moveToNext();
        }
        return array_list;
    }

    //buscar todos os dados

    public ArrayList<String>  lista_Produtos_Mesa_Cliente (SQLiteDatabase bd) {
        ArrayList<String> array_list = new ArrayList<String>();


        Cursor res =  bd.rawQuery( "select ID_PEDIDO,ID_MESA_CLIENTE,ID_PRODUTO,Quantidade from Produtos_Mesa_Cliente ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add("ID Pedido: "+res.getString(res.getColumnIndex("ID_PEDIDO"))+"\nID Mesa_Cliente: "+res.getString(res.getColumnIndex("ID_MESA_CLIENTE"))+ "\nID Produto: " +res.getString(res.getColumnIndex("ID_PRODUTO"))+ "\nQuantidade: " +res.getString(res.getColumnIndex("Quantidade")));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<String>  lista_mesa_clientes(SQLiteDatabase bd) {
        ArrayList<String> array_list = new ArrayList<String>();


        Cursor res =  bd.rawQuery( "select IDMesa_Cliente,ID_Cliente,ID_Mesa from Mesa_Clientes", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add("IDMesa_Cliente: "+res.getString(res.getColumnIndex("IDMesa_Cliente"))+"\nID_CLIENTE: "+res.getString(res.getColumnIndex("ID_Cliente"))+ "\nID_MESA: " +res.getString(res.getColumnIndex("ID_Mesa")));
            res.moveToNext();
        }
        return array_list;
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
            array_list.add("Nome: "+res.getString(res.getColumnIndex("Nome"))+ "\nMarca: " +res.getString(res.getColumnIndex("Marca"))+ "\nDescrição: " +res.getString(res.getColumnIndex("Descricao"))+ "\nPreço: " +res.getString(res.getColumnIndex("Preco"))+ "€" +"\nNível de alergia: " +res.getString(res.getColumnIndex("Risco_Alergia")));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<String>  lista_pessoas(SQLiteDatabase bd) {
        ArrayList<String> array_list = new ArrayList<String>();


        Cursor res =  bd.rawQuery( "select ID_Cliente, Nome,Nif,Data_nasc from Clientes", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add("ID: "+res.getString(res.getColumnIndex("ID_Cliente"))+ "\nNome: " +res.getString(res.getColumnIndex("Nome"))+ "\nNif: " +res.getString(res.getColumnIndex("Nif"))+ "\nData_nasc: " +res.getString(res.getColumnIndex("Data_nasc")));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String>  lista_entradas(SQLiteDatabase bd) {
        ArrayList<String> array_list = new ArrayList<String>();


        Cursor res =  bd.rawQuery( "select ID_Produto, Nome,Marca,Descricao,Preco, Risco_Alergia from produtos where ID_Tipo=1", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add("Número entrada: "+res.getString(res.getColumnIndex("ID_Produto"))+ "\nNome: " +res.getString(res.getColumnIndex("Nome"))+ "\nMarca: " +res.getString(res.getColumnIndex("Marca"))+ "\nDescrição: " +res.getString(res.getColumnIndex("Descricao"))+ "\nPreço: " +res.getString(res.getColumnIndex("Preco"))+ "\nRisco de Alergia: " +res.getString(res.getColumnIndex("Risco_Alergia")));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<String>  lista_bebidas(SQLiteDatabase bd) {
        ArrayList<String> array_list = new ArrayList<String>();


        Cursor res =  bd.rawQuery( "select ID_Produto, Nome,Marca,Descricao,Preco, Risco_Alergia from produtos where ID_Tipo=2", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add("Número bebida: "+res.getString(res.getColumnIndex("ID_Produto"))+ "\nNome: " +res.getString(res.getColumnIndex("Nome"))+ "\nMarca: " +res.getString(res.getColumnIndex("Marca"))+ "\nDescrição: " +res.getString(res.getColumnIndex("Descricao"))+ "\nPreço: " +res.getString(res.getColumnIndex("Preco"))+ "\nRisco de Alergia: " +res.getString(res.getColumnIndex("Risco_Alergia")));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String>  lista_carnes(SQLiteDatabase bd) {
        ArrayList<String> array_list = new ArrayList<String>();


        Cursor res =  bd.rawQuery( "select ID_Produto, Nome,Marca,Descricao,Preco, Risco_Alergia from produtos where ID_Tipo=4", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add("Número Prato Carne: "+res.getString(res.getColumnIndex("ID_Produto"))+ "\nNome: " +res.getString(res.getColumnIndex("Nome"))+ "\nMarca: " +res.getString(res.getColumnIndex("Marca"))+ "\nDescrição: " +res.getString(res.getColumnIndex("Descricao"))+ "\nPreço: " +res.getString(res.getColumnIndex("Preco"))+ "\nRisco de Alergia: " +res.getString(res.getColumnIndex("Risco_Alergia")));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String>  lista_peixes(SQLiteDatabase bd) {
        ArrayList<String> array_list = new ArrayList<String>();


        Cursor res =  bd.rawQuery( "select ID_Produto, Nome,Marca,Descricao,Preco, Risco_Alergia from produtos where ID_Tipo=3", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add("Número Prato Peixe: "+res.getString(res.getColumnIndex("ID_Produto"))+ "\nNome: " +res.getString(res.getColumnIndex("Nome"))+ "\nMarca: " +res.getString(res.getColumnIndex("Marca"))+ "\nDescrição: " +res.getString(res.getColumnIndex("Descricao"))+ "\nPreço: " +res.getString(res.getColumnIndex("Preco"))+ "\nRisco de Alergia: " +res.getString(res.getColumnIndex("Risco_Alergia")));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String>  lista_sobremesas(SQLiteDatabase bd) {
        ArrayList<String> array_list = new ArrayList<String>();


        Cursor res =  bd.rawQuery( "select ID_Produto, Nome,Marca,Descricao,Preco, Risco_Alergia from produtos where ID_Tipo=5", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add("Número Sobremesa: "+res.getString(res.getColumnIndex("ID_Produto"))+ "\nNome: " +res.getString(res.getColumnIndex("Nome"))+ "\nMarca: " +res.getString(res.getColumnIndex("Marca"))+ "\nDescrição: " +res.getString(res.getColumnIndex("Descricao"))+ "\nPreço: " +res.getString(res.getColumnIndex("Preco"))+ "\nRisco de Alergia: " +res.getString(res.getColumnIndex("Risco_Alergia")));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<String>  lista_pagamentos(SQLiteDatabase bd,int id_mesacliente) {
        ArrayList<String> array_list = new ArrayList<String>();


        Cursor res =  bd.rawQuery( "select ID_PEDIDO, Nome,Quantidade,Preco,Quantidade*Preco as Total from Produtos_Mesa_Cliente join produtos on Produtos_Mesa_Cliente.ID_PRODUTO=produtos.ID_Produto where ID_MESA_CLIENTE="+id_mesacliente, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add("Nome produto: "+res.getString(res.getColumnIndex("Nome"))+ "\nQuantidade: " +res.getString(res.getColumnIndex("Quantidade"))+ "\nPreco: " +res.getString(res.getColumnIndex("Preco"))+ "\nTotal: " +res.getString(res.getColumnIndex("Total")));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<String>  lista_tablepagamentos(SQLiteDatabase bd) {
        ArrayList<String> array_list = new ArrayList<String>();


        Cursor res =  bd.rawQuery( "select ID_Pagamento, ID_MESA_CLIENTE,Tipo_Pagamento from Pagamento", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add("Número Pagamento: "+res.getString(res.getColumnIndex("ID_Pagamento"))+ "\nID_MesaCliente: " +res.getString(res.getColumnIndex("ID_MESA_CLIENTE"))+ "\nTipo_Pagamento: " +res.getString(res.getColumnIndex("Tipo_Pagamento")));
            res.moveToNext();
        }
        return array_list;
    }




}
