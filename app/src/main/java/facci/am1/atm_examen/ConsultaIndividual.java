package facci.am1.atm_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import facci.am1.atm_examen.db.DbAtm;
import facci.am1.atm_examen.entidades.Atm;

public class ConsultaIndividual extends AppCompatActivity {


    EditText txtCedula, txtNombres, txtApellidos, txtDireccion, txtTipocar, txtCorp;
    Button btnGuarda;

    Atm atm ;

    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_individual);

        txtCedula = findViewById(R.id.txtCedula);
        txtNombres = findViewById(R.id.txtNombres);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtTipocar = findViewById(R.id.txtTipocar);
        txtCorp = findViewById(R.id.txtCorp);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                id = Integer.parseInt(null);

            }else {
                id = extras.getInt("ID");
            }
        } else {
            id = (int) savedInstanceState.getSerializable("ID");
        }
        DbAtm dbAtm = new DbAtm(ConsultaIndividual.this);
        atm = dbAtm.verAtm(id);

        if(atm != null){
            txtCedula.setText(atm.getCedula());
            txtNombres.setText(atm.getNombres());
            txtApellidos.setText(atm.getApellidos());
            txtDireccion.setText(atm.getDireccion());
            txtTipocar.setText(atm.getTipocar());
            txtCorp.setText(atm.getCorp());

            txtCedula.setInputType(InputType.TYPE_NULL);
            txtNombres.setInputType(InputType.TYPE_NULL);
            txtApellidos.setInputType(InputType.TYPE_NULL);
            txtDireccion.setInputType(InputType.TYPE_NULL);
            txtTipocar.setInputType(InputType.TYPE_NULL);
            txtCorp.setInputType(InputType.TYPE_NULL);





        }
    }
}