package com.example.dam1_examen2p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bebidas extends AppCompatActivity {
    EditText comprarb,preciob;
    Button pagarb;
    Button menubebida;


    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);
        menubebida =(Button) findViewById(R.id.menubebida);
        pagarb = (Button) findViewById(R.id.pagarb);
        comprarb = (EditText) findViewById(R.id.comprarb);
        preciob = (EditText) findViewById(R.id.preciob);




        menubebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _comprarb="";
                String _preciob="";
                _comprarb = comprarb.getText().toString();
                _preciob = preciob.getText().toString();
                GuardarDatos(_comprarb,_preciob);
                Intent intent = new Intent(Bebidas.this,Pizzas.class);
                //intent.putExtra("Comprarb",_comprarb);
                //intent.putExtra("Preciob",_preciob);
                startActivity(intent);
            }
        });

        pagarb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _comprarb="";
                String _preciob="";
                _comprarb = comprarb.getText().toString();
                _preciob = preciob.getText().toString();
                GuardarDatos(_comprarb,_preciob);
                Intent intent = new Intent(Bebidas.this,PantallaFinal.class);
                //intent.putExtra("Comprarb",_comprarb);
                //intent.putExtra("Preciob",_preciob);
                startActivity(intent);
            }
        });
    }
    private void GuardarDatos(String comprarb, String preciob) {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Bebida",comprarb);
        editor.putString("Preciob",preciob);
        editor.commit();
    }

}