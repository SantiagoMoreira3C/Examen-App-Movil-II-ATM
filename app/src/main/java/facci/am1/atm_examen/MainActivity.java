package facci.am1.atm_examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;

import facci.am1.atm_examen.adaptadores.ListaAtmAdapter;
import facci.am1.atm_examen.db.DbAtm;
import facci.am1.atm_examen.db.DbHelper;
import facci.am1.atm_examen.entidades.Atm;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaAtm;
    ArrayList<Atm> listaArrayAtm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         listaAtm = findViewById(R.id.listaATM);
         listaAtm.setLayoutManager(new LinearLayoutManager(this));
        DbAtm dbAtm = new DbAtm(MainActivity.this);

       
        listaArrayAtm = new ArrayList<>();

        ListaAtmAdapter adapter =   new ListaAtmAdapter(dbAtm.mostrarAtm());
        listaAtm.setAdapter(adapter);

        


        /* btnCrear = findViewById(R.id.btnCrear);

            btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null){
                    Toast.makeText(MainActivity.this, "Base de datos Creada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Error al crear base de datos", Toast.LENGTH_LONG).show();
                }

            }
        });

                */
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
                  switch (item.getItemId()){
                      case R.id.menuNuevo:
                          nuevoRegistro();
                          return true;

                      default:
                          return super.onOptionsItemSelected(item);
                      
        }
    }

    private void nuevoRegistro(){
        Intent intent  = new Intent(this, RegistroATM.class);
        startActivity(intent);
    }

    
}