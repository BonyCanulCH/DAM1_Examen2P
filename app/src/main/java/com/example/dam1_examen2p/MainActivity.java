package com.example.dam1_examen2p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombre,contra;
    Button iniciar;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText) findViewById(R.id.nombre);
        contra = (EditText) findViewById(R.id.contra);
        iniciar = (Button) findViewById(R.id.boton);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _nombre="";
                String _contra="";
                _nombre = nombre.getText().toString();
                _contra = contra.getText().toString();
                GuardarDatos(_nombre);
                Intent intent = new Intent(MainActivity.this,PantallaLogeo.class);
                intent.putExtra("Nombre",_nombre);
                //intent.putExtra("Direccion",_direccion);
                startActivity(intent);
            }
        });
    }
    private void GuardarDatos(String nombre) {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Nombre",nombre);
        //editor.putString("Direccion",direccion);
        editor.commit();
    }
}