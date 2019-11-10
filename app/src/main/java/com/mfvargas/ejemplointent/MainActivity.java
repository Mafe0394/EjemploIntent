package com.mfvargas.ejemplointent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mfvargas.ejemplointent.adaptador.ContactoAdaptador;
import com.mfvargas.ejemplointent.modelo.Contacto;
import com.mfvargas.ejemplointent.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Colección de contacto

    ArrayList<Contacto> contactos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        contactos= new ArrayList<Contacto>();
        contactos.add(new Contacto("Pedro Rosales",
                "7777775","pedro@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Gato Perez",
                "3333361","gato@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Loli  PopKorn",
                "6549852","lolipop@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Felipin Felipepinillos",
                "5466487","Felipin@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Pedro Rosales",
                "7777775","pedro@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Gato Perez",
                "3333361","gato@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Loli  PopKorn",
                "6549852","lolipop@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Felipin Felipepinillos",
                "5466487","Felipin@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Pedro Rosales",
                "7777775","pedro@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Gato Perez",
                "3333361","gato@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Loli  PopKorn",
                "6549852","lolipop@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Felipin Felipepinillos",
                "5466487","Felipin@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Pedro Rosales",
                "7777775","pedro@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Gato Perez",
                "3333361","gato@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Loli  PopKorn",
                "6549852","lolipop@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Felipin Felipepinillos",
                "5466487","Felipin@gmail.com",
                R.drawable.ic_face_24px));

        ContactoAdaptador contactoAdaptador=new ContactoAdaptador(contactos,this);
        activityMainBinding.rvListaPeliculas.setAdapter(contactoAdaptador);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        activityMainBinding.rvListaPeliculas.setLayoutManager(linearLayoutManager);



    }
}
