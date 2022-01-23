package facci.am1.atm_examen.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "agencia.db";
    public static final String TABLE_ATM = "t_ATM";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_ATM+ "("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "cedula TEXT NOT NULL,"+
                "nombres TEXT NOT NULL,"+
                "apellidos TEXT NOT NULL,"+
                "direccion TEXT NOT NULL,"+
                "tipocar TEXT NOT NULL,"+
                "corp TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_ATM);
        onCreate(sqLiteDatabase);


    }
}
