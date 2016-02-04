package com.unir.leonardotalero.myapplicationlogin;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Bienvenido_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido_);

        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        String usuario = prefs.getString("usuario", null);
        String password = prefs.getString("pass", null);

        TextView textusuario = (TextView)findViewById(R.id.textViewUsuario);

        textusuario.setText("Bienvenido: "+usuario+" with password finished in:"+password.substring(password.length()-3,password.length()));
    }
}
