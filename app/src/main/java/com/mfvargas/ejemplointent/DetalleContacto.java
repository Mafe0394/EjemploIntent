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
import androidx.databinding.DataBindingUtil;

import com.mfvargas.ejemplointent.databinding.ActivityDetalleContactoBinding;
import com.mfvargas.ejemplointent.modelo.Contacto;

public class DetalleContacto extends AppCompatActivity{

    // Variables globales
    private TextView nombre;
    private TextView telefono;
    private TextView email;
    private Contacto contacto;


    private ActivityDetalleContactoBinding activityDetalleContactoBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetalleContactoBinding= DataBindingUtil.setContentView(this,
                R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();

        contacto = new Contacto(parametros.getString("nombre"),
                parametros.getString("telefono"),
                parametros.getString("email"),
                parametros.getInt("foto"));

        activityDetalleContactoBinding.setContacto(contacto);
    }


    //Práctica intent
    public void llamar(View v) {

        String tel = contacto.getTelefono();
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
        String email=contacto.getEmail();
        Intent emailIntent=new Intent(Intent.ACTION_SEND);
        //contine la acción que va a suceder
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL,email);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"Email "));
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(DetalleContacto.this,
                MainActivity.class);
        startActivity(intent);
        finish();
    }
}
