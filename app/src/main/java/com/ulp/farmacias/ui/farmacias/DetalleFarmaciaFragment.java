package com.ulp.farmacias.ui.farmacias;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ulp.farmacias.R;
import com.ulp.farmacias.databinding.FragmentDetalleFarmaciaBinding;
import com.ulp.farmacias.model.Farmacia;

public class DetalleFarmaciaFragment extends Fragment {

    private DetalleFarmaciaViewModel mViewModel;
    private FragmentDetalleFarmaciaBinding binding;

    public static DetalleFarmaciaFragment newInstance() {
        return new DetalleFarmaciaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(DetalleFarmaciaViewModel.class);
        binding = FragmentDetalleFarmaciaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mViewModel.getFarmacia().observe(getViewLifecycleOwner(), new Observer<Farmacia>() {
            @Override
            public void onChanged(Farmacia farmacia) {
                binding.tvNombreDetalle.setText(farmacia.getNombre());
                binding.tvDireccionDetalle.setText(farmacia.getDireccion());
                binding.tvHorarioDetalle.setText(farmacia.getHorario());
                binding.ivFotoDetalle.setImageResource(farmacia.getFoto());
            }
        });
        mViewModel.rescatarDatos(getArguments());

        return root;
    }

}