package com.mfvargas.ejemplointent.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mfvargas.ejemplointent.R;
import com.mfvargas.ejemplointent.adaptador.ContactoAdaptador;
import com.mfvargas.ejemplointent.databinding.FragmentRecyclerViewBinding;
import com.mfvargas.ejemplointent.modelo.Contacto;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Contacto> contactos;
    private FragmentRecyclerViewBinding fragmentRecyclerViewBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        //Inflar layout con fragment
        fragmentRecyclerViewBinding= DataBindingUtil.inflate(
                inflater,R.layout.fragment_recycler_view,container,
                false);
        View v=fragmentRecyclerViewBinding.getRoot();

        //Llenamos con una lista aleatoria
        llenarListaContactos();


        ContactoAdaptador contactoAdaptador=new ContactoAdaptador(contactos,this.getActivity());
        fragmentRecyclerViewBinding.rvListaPeliculas.setAdapter(contactoAdaptador);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        fragmentRecyclerViewBinding.rvListaPeliculas.setLayoutManager(linearLayoutManager);

        return v;
    }

    private void llenarListaContactos(){
        contactos= new ArrayList<Contacto>();
        contactos.add(new Contacto("Pedro Rosales",
                "7777775","pedro@gmail.com",
                R.drawable.ic_girl));
        contactos.add(new Contacto("Gato Perez",
                "3333361","gato@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Loli  PopKorn",
                "6549852","lolipop@gmail.com",
                R.drawable.ic_girl));
        contactos.add(new Contacto("Felipin Felipepinillos",
                "5466487","Felipin@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Pedro Rosales",
                "7777775","pedro@gmail.com",
                R.drawable.ic_girl));
        contactos.add(new Contacto("Gato Perez",
                "3333361","gato@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Loli  PopKorn",
                "6549852","lolipop@gmail.com",
                R.drawable.ic_girl));
        contactos.add(new Contacto("Felipin Felipepinillos",
                "5466487","Felipin@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Pedro Rosales",
                "7777775","pedro@gmail.com",
                R.drawable.ic_girl));
        contactos.add(new Contacto("Gato Perez",
                "3333361","gato@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Loli  PopKorn",
                "6549852","lolipop@gmail.com",
                R.drawable.ic_girl));
        contactos.add(new Contacto("Felipin Felipepinillos",
                "5466487","Felipin@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Pedro Rosales",
                "7777775","pedro@gmail.com",
                R.drawable.ic_girl));
        contactos.add(new Contacto("Gato Perez",
                "3333361","gato@gmail.com",
                R.drawable.ic_face_24px));
        contactos.add(new Contacto("Loli  PopKorn",
                "6549852","lolipop@gmail.com",
                R.drawable.ic_girl));
        contactos.add(new Contacto("Felipin Felipepinillos",
                "5466487","Felipin@gmail.com",
                R.drawable.ic_face_24px));
    }
}
