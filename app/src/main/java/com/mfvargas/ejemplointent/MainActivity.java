package com.mfvargas.ejemplointent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Colección de contacto

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos=new ArrayList<Contacto>();
        contactos.add(new Contacto("Pedro Rosales","7777775","pedro@gmail.com"));
        contactos.add(new Contacto("Gato Perez","3333361","gato@gmail.com"));
        contactos.add(new Contacto("Loli  PopKorn","6549852","lolipop@gmail.com"));
        contactos.add(new Contacto("Felipin Felipepinillos","5466487","Felipin@gmail.com"));

        ListView listaContactos=findViewById(R.id.ListaContactos);

        ArrayList<String> nombresContacto= new ArrayList<>();
        for (Contacto contacto:contactos) {
            nombresContacto.add(contacto.getNombre());
        }

        listaContactos.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,nombresContacto));


    }
}
