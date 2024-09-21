package com.ulp.farmacias.ui.farmacias;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ulp.farmacias.R;
import com.ulp.farmacias.databinding.FragmentFarmaciasBinding;
import com.ulp.farmacias.model.Farmacia;

import java.util.List;

public class FarmaciasFragment extends Fragment {

    private FarmaciasViewModel mViewModel;
    private FragmentFarmaciasBinding binding;

    public static FarmaciasFragment newInstance() {
        return new FarmaciasFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(FarmaciasViewModel.class);
        binding =FragmentFarmaciasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mViewModel.getFarmacias().observe(getViewLifecycleOwner(), new Observer<List<Farmacia>>() {
            @Override
            public void onChanged(List<Farmacia> farmacias) {
                FarmaciaAdapter farmaciaAdapter = new FarmaciaAdapter(farmacias, inflater);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
                binding.rvLista.setAdapter(farmaciaAdapter);
                binding.rvLista.setLayoutManager(gridLayoutManager);
            }
        });
        mViewModel.mostrarFarmacias();

        return root;
    }

}