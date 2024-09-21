package com.ulp.farmacias;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LoginActivityViewModel extends AndroidViewModel {

    private MutableLiveData<String> mensaje;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMensaje() {
        if (mensaje == null) {
            mensaje = new MutableLiveData<>();
        }
        return mensaje;
    }

    public void validarIngreso(String usuario, String clave) {
        if(usuario.equals("luis@gmail.com") && clave.equals("123")) {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intent);
            mensaje.setValue("");
        } else {
            mensaje.setValue("Usuario o Clave incorrecta.");
        }
    }

}
