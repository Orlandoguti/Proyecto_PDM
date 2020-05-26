package com.example.medisis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    ArrayList<String>listado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=(ListView)findViewById(R.id.li1);
        CargarListado();
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void CargarListado(){
        listado=ListaPersonas();
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,listado);
        listView.setAdapter(adapter);
    }
    private ArrayList<String>ListaPersonas(){
        ArrayList<String> datos=new ArrayList<String>();
        AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos =admin.getWritableDatabase();
        String sql = "select codigo,descripcion,precio from articulos ";
        Cursor c = BaseDeDatos.rawQuery(sql,null);
        if(c.moveToFirst()){
            do{
                String linea= c.getInt(0)+" - " + c.getString(1)+" - "+ c.getString(2);
                datos.add(linea);
            }while (c.moveToNext());
        }
        BaseDeDatos.close();
        return datos;
    }
}
