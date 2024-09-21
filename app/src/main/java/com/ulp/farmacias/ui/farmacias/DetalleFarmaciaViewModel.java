package com.ulp.farmacias.ui.farmacias;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ulp.farmacias.model.Farmacia;

public class DetalleFarmaciaViewModel extends AndroidViewModel {

    private MutableLiveData<Farmacia> farmacia;

    public DetalleFarmaciaViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Farmacia> getFarmacia() {
        if (farmacia == null) {
            farmacia = new MutableLiveData<>();
        }
        return farmacia;
    }

    public void rescatarDatos(Bundle bundle) {
        Farmacia f = bundle.getSerializable("farmacia", Farmacia.class);
        if (f != null) {
            farmacia.setValue(f);
        }
    }

}