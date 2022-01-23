package facci.am1.atm_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import facci.am1.atm_examen.db.DbAtm;

public class RegistroATM extends AppCompatActivity {

    EditText txtCedula, txtNombres, txtApellidos, txtDireccion, txtTipocar, txtCorp;
    Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_atm);

        txtCedula = findViewById(R.id.txtCedula);
        txtNombres = findViewById(R.id.txtNombres);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtTipocar = findViewById(R.id.txtTipocar);
        txtCorp = findViewById(R.id.txtCorp);
        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                DbAtm dbAtm = new DbAtm(RegistroATM.this);
                long id = dbAtm.insertarATM(txtCedula.getText().toString(),txtNombres.getText().toString(), txtApellidos.getText().toString(), txtDireccion.getText().toString(), txtTipocar.getText().toString(), txtCorp.getText().toString());
                if(id > 0){
                    Toast.makeText(RegistroATM.this, "Transportista guardado", Toast.LENGTH_LONG).show();
                    limpiar();
                }else {
                    Toast.makeText(RegistroATM.this, "Error al guardar dato", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void limpiar(){
        txtCedula.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtTipocar.setText("");
        txtCorp.setText("");
    }
}