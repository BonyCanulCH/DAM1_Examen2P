package com.example.dam1_examen2p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Pizzas extends AppCompatActivity {
    EditText comprarp,preciop;
    Button pagarp;
    Button menupizza;


    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzas);
        menupizza=(Button) findViewById(R.id.menupizza);
        pagarp = (Button) findViewById(R.id.pagarp);
        comprarp = (EditText) findViewById(R.id.comprarp);
        preciop = (EditText) findViewById(R.id.preciop);




        menupizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _comprarp="";
                String _preciop="";
                _comprarp = comprarp.getText().toString();
                _preciop = preciop.getText().toString();
                GuardarDatos(_comprarp,_preciop);
                Intent intent = new Intent(Pizzas.this,Bebidas.class);
                //intent.putExtra("Comprarb",_comprarb);
                //intent.putExtra("Preciob",_preciob);
                startActivity(intent);
            }
        });

        pagarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _comprarp="";
                String _preciop="";
                _comprarp = comprarp.getText().toString();
                _preciop = preciop.getText().toString();
                GuardarDatos(_comprarp,_preciop);
                Intent intent = new Intent(Pizzas.this,PantallaFinal.class);
                //intent.putExtra("Comprarb",_comprarb);
                //intent.putExtra("Preciob",_preciob);
                startActivity(intent);
            }
        });
    }
    private void GuardarDatos(String comprarp, String preciop) {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Pizza",comprarp);
        editor.putString("preciop",preciop);
        editor.commit();
    }

}