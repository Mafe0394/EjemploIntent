package com.mfvargas.ejemplointent.adaptador;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mfvargas.ejemplointent.modelo.Contacto;
import com.mfvargas.ejemplointent.DetalleContacto;
import com.mfvargas.ejemplointent.R;
import com.mfvargas.ejemplointent.databinding.ContainerRecyclerViewBinding;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity) {
        this.contactos=contactos;
        this.activity=activity;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContainerRecyclerViewBinding binding= DataBindingUtil.inflate(LayoutInflater.
                        from(parent.getContext()),R.layout.container_recycler_view,
                        parent,false);
        return new ContactoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto=contactos.get(position);
        contactoViewHolder.bindConnection(contacto);
        contactoViewHolder.binding.tvNombre.setTypeface(Typeface.DEFAULT_BOLD);
        contactoViewHolder.binding.cvContacto.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =new Intent(activity, DetalleContacto.class);
                        intent.putExtra("nombre",contacto.getNombre());
                        intent.putExtra("telefono",contacto.getTelefono());
                        intent.putExtra("email",contacto.getEmail());
                        intent.putExtra("foto",contacto.getImagen());
                        activity.startActivity(intent);
                }
                }
        );
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        //Declaramos los views
        private ContainerRecyclerViewBinding binding;

        public ContactoViewHolder(ContainerRecyclerViewBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void bindConnection(Contacto contacto){
            this.binding.setContacto(contacto);
        }
    }
}
