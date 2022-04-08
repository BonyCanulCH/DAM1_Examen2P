package com.example.dam1_examen2p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PantallaLogeo extends AppCompatActivity {
    TextView mensaje;
    Button regresar;
    ImageButton boton1;
    ImageButton boton2;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_logeo);
        mensaje = (TextView) findViewById(R.id.mensaje);
        regresar = (Button) findViewById(R.id.regresar);
        boton1=(ImageButton) findViewById(R.id.boton1);
        boton2=(ImageButton) findViewById(R.id.boton2);


        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //codigo para el evento click
                Intent intent = new Intent(PantallaLogeo.this,Pizzas.class);
                startActivity(intent);

            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //codigo para el evento click
                Intent intent = new Intent(PantallaLogeo.this,Bebidas.class);
                startActivity(intent);

            }

        });



        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String dato1 = extras.getString("Nombre");
            //String dato2 = extras.getString("Direccion");
            if(!dato1.equals("")){
                mensaje.setText("Bienvenido "+dato1+" te haz logueado correctamente");
            }
            else
                mensaje.setText("Los datos que enviaste son incorrectos");

        }
        else {
            mensaje.setText("No se envio ningun extra en el intent");
            LeerDatos();
        }

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantallaLogeo.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void LeerDatos() {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String dato1 = preferences.getString("Nombre","No hay dato");
        //String dato2 = preferences.getString("Direccion","No hay dato");
        if(!dato1.equals(""))
            mensaje.setText("Bienvenido "+dato1+" que te gustaria ordenar? ");
        else
            mensaje.setText("Los datos que enviaste son incorrectos nombre: "+dato1);


    }
}