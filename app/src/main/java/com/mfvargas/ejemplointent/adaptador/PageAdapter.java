package com.mfvargas.ejemplointent.adaptador;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/*Nos va ayudar a manejar a insertar cada fragment en
    cada Tab*/
public class PageAdapter extends FragmentPagerAdapter {

    //Lista de fragmentos
    private ArrayList<Fragment> fragments;

    /*Constructo, además del constructor, debemos pasar un arrayList
    de fragments*/
    public PageAdapter(@NonNull FragmentManager fm, int behavior,
                       ArrayList<Fragment> fragments) {
        super(fm, behavior);
        this.fragments=fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        /*Devolvemos un fragment a partir de la posición
        en la que se encuentre nuestro TabLayout
         */
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        //Devolvemos el tamaño de la lista de fragments
        return fragments.size();
    }


}
