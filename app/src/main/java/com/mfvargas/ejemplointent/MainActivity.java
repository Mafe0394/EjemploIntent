package com.mfvargas.ejemplointent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mfvargas.ejemplointent.adaptador.PageAdapter;
import com.mfvargas.ejemplointent.databinding.ActivityMainBinding;
import com.mfvargas.ejemplointent.fragments.PerfilFragment;
import com.mfvargas.ejemplointent.fragments.RecyclerViewFragment;
import com.mfvargas.ejemplointent.modelo.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Colección de contacto

    ArrayList<Contacto> contactos;

    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);

        //Inicializamos Toolbar
        if(activityMainBinding.tbActivityMain!=null)
            setSupportActionBar(activityMainBinding.tbActivityMain);

        setUpViewPager();




    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments=new ArrayList<>();
        //Añaderemos los fragments que vamos a manejar
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    //Ponemos en orbita los fragments
    private void setUpViewPager(){
        //Configuramos ViewPager
        activityMainBinding.vpActivityMain.setAdapter(
                new PageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                        agregarFragments()));
        //Agregamos ViewPager al TabLayout
        activityMainBinding.tlActivityMain.setupWithViewPager(activityMainBinding.vpActivityMain);

        //Seteamos los íconos de los Tabs
        activityMainBinding.tlActivityMain.getTabAt(0).setIcon(R.drawable.ic_contacts);
        activityMainBinding.tlActivityMain.getTabAt(1).setIcon(R.drawable.ic_user);
        activityMainBinding.tlActivityMain.getTabAt(0).setText("Gato");
    }


}
