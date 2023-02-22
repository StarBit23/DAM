package com.pmdm.virgen.pueblosconnavigationdraweb.listadoUsuarios;

import static io.realm.Realm.getApplicationContext;

import android.content.Context;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmHelper {
    private Realm realm;

    public RealmHelper(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void addUser(Usuario user) {
        realm.executeTransactionAsync(realm -> realm.copyToRealm(user));
    }

    public Usuario getUser(String username) {
        return realm.where(Usuario.class).equalTo("username", username).findFirst();
    }

    // otros métodos para actualizar y eliminar usuarios
}

