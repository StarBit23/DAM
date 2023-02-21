package com.pmdm.virgen.pueblosconnavigationdraweb.listadoUsuarios;

import android.content.Context;

import io.realm.Realm;

public class RealmHelper {

    private Realm realm;

    public RealmHelper(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void addUser(Usuario user) {
        realm.executeTransaction(realm -> realm.copyToRealm(user));
    }

    public Usuario getUser(String username) {
        return realm.where(Usuario.class).equalTo("username", username).findFirst();
    }

    // otros métodos para actualizar y eliminar usuarios
}

