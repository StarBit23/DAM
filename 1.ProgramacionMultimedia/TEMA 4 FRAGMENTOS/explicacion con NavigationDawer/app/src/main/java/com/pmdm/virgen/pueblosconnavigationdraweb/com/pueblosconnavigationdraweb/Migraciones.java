package com.pmdm.virgen.pueblosconnavigationdraweb.com.pueblosconnavigationdraweb;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

public class Migraciones implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        Long version = oldVersion;
        if (oldVersion == 0) {
            //instrucciones para migracion desde la version 0
            schema.get("Juego")
                    .addField("nombre",String.class, FieldAttribute.REQUIRED);
            schema.get("Juego")
                    .addField("descripcion",String.class, FieldAttribute.REQUIRED);
            version++;
        }
        if (oldVersion == 1) {
            //instrucciones para migracion desde la version 1
            schema.get("Juego")
                    .addField("nombreDescripcion",String.class, FieldAttribute.REQUIRED)
                    .transform(new RealmObjectSchema.Function() {
                        @Override
                        public void apply(DynamicRealmObject obj) {
                            String nombreYDescripcion = obj.get("nombre").toString() + obj.get("descripcion").toString();
                            obj.setString("nombreDescripcion", nombreYDescripcion);
                        }
                    })
                    .removeField("nombre")
                    .removeField("descripcion");
            version++;
        }

        //resto de versiones si es necesario
    }
}
