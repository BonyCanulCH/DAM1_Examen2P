package com.example.dam1_examen2p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nameuser;
    Button ingresar;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameuser = (EditText) findViewById(R.id.nameuser);
        ingresar = (Button) findViewById(R.id.botonlogin);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _nameuser="";
                _nameuser = nameuser.getText().toString();
                GuardarInfo(_nameuser);
                Intent intent = new Intent(MainActivity.this,PantallaLogeo.class);
                startActivity(intent);
            }
        });
    }
    private void GuardarInfo(String nameuser) {
        preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Nombre", nameuser);
        editor.commit();
    }
}