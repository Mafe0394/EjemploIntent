package com.mfvargas.ejemplointent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class DetalleContacto extends AppCompatActivity {

    // Variables globales
    private TextView nombre;
    private TextView telefono;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();

        String Nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String Telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String Email = parametros.getString(getResources().getString(R.string.pemail));

        nombre = findViewById(R.id.tvNombre);
        telefono = findViewById(R.id.tvTelefono);
        email = findViewById(R.id.tvEmail);

        nombre.setText(Nombre);
        telefono.setText(Telefono);
        email.setText(Email);
    }


    //Práctica intent
    public void llamar(View v) {

        String tel = telefono.getText().toString();
        //Uri->Recurso accesible, es necesario definir permisos
        //alt+enter

        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL,
                Uri.parse("tel:" + tel)));
    }

    public void enviarmail(View v){
        String email1=email.getText().toString();
        Intent emailIntent=new Intent(Intent.ACTION_SEND);
        //contine la acción que va a suceder
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL,email1);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"Email "));
    }
}
