package com.mfvargas.ejemplointent.modelo;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class Contacto {

    private int imagen=0;
    private String nombre="";
    private String telefono="";
    private String email="";


    //Constructor
    public Contacto(String nombre, String telefono, String email,int imagen) {
        this.imagen=imagen;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email=email;
    }


    //Getters and Setters
    public void setImagen(int imagen){this.imagen=imagen;}

    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @BindingAdapter({"databinding:image"})
    public static void loadImage(ImageView view, int image){
        view.setImageResource(image);
    }



}
