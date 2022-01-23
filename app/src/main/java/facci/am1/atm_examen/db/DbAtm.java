package facci.am1.atm_examen.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import facci.am1.atm_examen.entidades.Atm;

public class DbAtm extends DbHelper{

    Context context;

    public DbAtm(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarATM(String  cedula, String nombres, String apellidos, String direccion, String tipocar, String corp) {
       long id = 0;

       try{
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("cedula", cedula);
        values.put("nombres", nombres);
        values.put("apellidos", apellidos);
        values.put("direccion", direccion);
        values.put("tipocar", tipocar);
        values.put("corp", corp);

        id =  db.insert(TABLE_ATM,null, values);

    }catch (Exception ex) {
        ex.toString();
    }

    return id;
    }

    public ArrayList<Atm> mostrarAtm(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Atm> listaAtm = new ArrayList<>();
        Atm atm = null;
        Cursor cursorAtm = null;


        cursorAtm = db.rawQuery("SELECT * FROM " + TABLE_ATM, null);

        if(cursorAtm.moveToFirst()){
            do{
                atm = new Atm();
                atm.setId(cursorAtm.getInt(0));
                atm.setNombres(cursorAtm.getString(2));
                atm.setTipocar(cursorAtm.getString(5));
                atm.setCorp(cursorAtm.getString(6));
                listaAtm.add(atm);
            }while (cursorAtm.moveToNext());
        }

            cursorAtm.close();

        return listaAtm;
    }

    public Atm verAtm(int id){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Atm atm = null;
        Cursor cursorAtm ;


        cursorAtm = db.rawQuery("SELECT * FROM " + TABLE_ATM + " WHERE id ="+ id + " LIMIT 1" , null);

        if(cursorAtm.moveToFirst()){
                atm = new Atm();
                atm.setId(cursorAtm.getInt(0));
                atm.setCedula(cursorAtm.getString(1));
                atm.setNombres(cursorAtm.getString(2));
                atm.setApellidos(cursorAtm.getString(3));
                atm.setDireccion(cursorAtm.getString(4));
                atm.setTipocar(cursorAtm.getString(5));
                atm.setCorp(cursorAtm.getString(6));


        }

        cursorAtm.close();

        return atm;
    }

}
