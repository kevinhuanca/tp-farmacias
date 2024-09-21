package com.ulp.farmacias.ui.salir;

import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ulp.farmacias.R;

public class SalirFragment extends Fragment {

    public static SalirFragment newInstance() {
        return new SalirFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        new AlertDialog.Builder(getContext())
                .setTitle("Salir")
                .setMessage("¿Estás seguro de querer salir?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /* System.exit(0); // salida forzada (no es buena practica) */
                        getActivity().finishAffinity(); // cierra todas las activities
                        /* getActivity().finish(); // cierra la activity actual */
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();

        return inflater.inflate(R.layout.fragment_salir, container, false);
    }

}