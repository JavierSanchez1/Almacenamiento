package com.example.javiersanchez.almacenamiento;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText texto, apellidos;
    Button guardar;
    TextView mostrar;
    String miFichero="Preferencias";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto=findViewById(R.id.editText);
        guardar=findViewById(R.id.button);
        mostrar=findViewById(R.id.textView2);

        SharedPreferences preferences = getSharedPreferences(miFichero,Context.MODE_PRIVATE);
        final String nombre=preferences.getString("nombre", "No existe");
        mostrar.setText(nombre);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(miFichero,Context.MODE_PRIVATE);
                String nombre=texto.getText().toString();
                preferences.edit().putString("nombre", nombre).commit();
                mostrar.setText(nombre);
            }
        });
    }
}
