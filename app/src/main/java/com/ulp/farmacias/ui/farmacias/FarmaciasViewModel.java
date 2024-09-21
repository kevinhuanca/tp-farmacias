package com.ulp.farmacias.ui.farmacias;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ulp.farmacias.MainActivity;
import com.ulp.farmacias.model.Farmacia;

import java.util.List;

public class FarmaciasViewModel extends AndroidViewModel {

    private MutableLiveData<List<Farmacia>> farmacias;

    public FarmaciasViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Farmacia>> getFarmacias() {
        if (farmacias == null) {
            farmacias = new MutableLiveData<>();
        }
        return farmacias;
    }

    public void mostrarFarmacias() {
        farmacias.setValue(MainActivity.farmacias);
    }

}