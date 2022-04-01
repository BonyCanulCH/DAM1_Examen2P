package com.example.dam1_examen2p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PantallaLogeo extends AppCompatActivity {
    TextView notificacion;
    ImageView imv_opcpizza;
    ImageView imv_opcbebida;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_logeo);
        notificacion = (TextView) findViewById(R.id.notificacion);
        imv_opcpizza = (ImageView) findViewById(R.id.imv_opcpizza);
        imv_opcbebida = (ImageView) findViewById(R.id.imv_opcbebida);
        Bundle extras = getIntent().getExtras();

        if(extras!=null){
            String dato1 = extras.getString("Nombre");
            if(!dato1.equals("")){
                notificacion.setText("Bienvenido estimado"+dato1+" ¿qué te podemos llevar hacia tu casa? Por favor, selecciona:");
            }
            else
                notificacion.setText("Los datos que enviaste son incorrectos");
                LeerInfo();

        }
        imv_opcpizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantallaLogeo.this,Pizzas.class);
                startActivity(intent);
            }
        });
        imv_opcbebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantallaLogeo.this,Bebidas.class);
                startActivity(intent);
            }
        });
        /*private void LeerInfo(){
            preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
            String dato1 = preferences.getString("Nombre","No hay dato");
            if(!dato1.equals(""))
                notificacion.setText("Bienvenido estimado"+dato1+" ¿qué te podemos llevar hacia tu casa? Por favor, selecciona:");
            else
                notificacion.setText("Los datos que enviaste son incorrectos");
        }*/

        //notificacion.setText("Hola estimado"+);

    }
    private void LeerInfo(){
        preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String dato1 = preferences.getString("Nombre","No hay dato");
        if(!dato1.equals(""))
            notificacion.setText("Bienvenido estimado"+dato1+" ¿qué te podemos llevar hacia tu casa? Por favor, selecciona:");
        else
            notificacion.setText("Los datos que enviaste son incorrectos");
    }
}