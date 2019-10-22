package com.mfvargas.ejemplointent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

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

        //Creación de intent explicito que permita unir las 2 actividades
        //Crear listener, está atento al click en la lista
        listaContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //con position se sabe que indice tiene el item con el
                //que se está interactuando
                Intent intent=new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),
                        contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),
                        contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),
                        contactos.get(position ).getEmail());
                startActivity(intent);

            }
        });

    }
}
