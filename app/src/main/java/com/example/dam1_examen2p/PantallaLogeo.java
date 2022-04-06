package com.example.dam1_examen2p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PantallaLogeo extends AppCompatActivity {
    TextView textView_name;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String key_name = "name";
    private static final String Key_password = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_logeo);

        textView_name = findViewById(R.id.notificacion);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(key_name,null);
        String password = sharedPreferences.getString(Key_password,null);

        if(name!=null || password !=null){
            textView_name.setText("Bienvenido " +name + "¿qué te podemos llevar hasta tu casa este día?");
        }
    }
    public void pizza (View view){
        Intent pizza = new Intent(this,Pizzas.class);
        startActivity(pizza);
    }
    public void bebida (View view){
        Intent bebida = new Intent(this,Bebidas.class);
        startActivity(bebida);
    }

}