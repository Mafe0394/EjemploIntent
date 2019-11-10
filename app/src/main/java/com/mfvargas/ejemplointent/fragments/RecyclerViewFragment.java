package com.mfvargas.ejemplointent.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mfvargas.ejemplointent.R;

public class RecyclerViewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        //Inflar layout con fragment
        View v=inflater.inflate(R.layout.fragment_recycler_view,
                container,
                false);
        return v;
    }
}
