package com.mfvargas.ejemplointent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleContacto extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros=getIntent().getExtras();
        String Nombre=parametros.getString(getResources().getString(R.string.pnombre));
        String Telefono=parametros.getString(getResources().getString(R.string.ptelefono));
        String Email=parametros.getString(getResources().getString(R.string.pemail));
        TextView nombre=findViewById(R.id.tvNombre);
        TextView telefono=findViewById(R.id.tvTelefono);
        TextView email=findViewById(R.id.tvEmail);
        nombre.setText(Nombre);
        telefono.setText(Telefono);
        email.setText(Email);
    }
}
