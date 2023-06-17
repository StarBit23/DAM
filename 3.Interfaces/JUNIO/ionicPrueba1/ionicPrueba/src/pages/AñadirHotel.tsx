import React, { useState } from 'react';
import { IonButton, IonButtons, IonContent, IonHeader, IonIcon, IonInput, IonItem, IonLabel, IonList, IonMenuButton, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import { useParams } from 'react-router';
import { addOutline } from 'ionicons/icons';
import ListaHoteles from './ListaHoteles';

interface NewHotel {
  nombre: string;
  localidad: string;
  precio: string;
}

const AñadirHotel: React.FC = () => {
  const { name } = useParams<{ name: string }>();

  const [hotels, setHotels] = useState([
    { nombre: 'Hotel A', localidad: 'Ciudad A', precio: '100' },
    { nombre: 'Hotel B', localidad: 'Ciudad B', precio: '150' },
    { nombre: 'Hotel C', localidad: 'Ciudad C', precio: '200' },
  ]);

  const addHotel = () => {
    const nombreValue = (document.getElementById('nombreInput') as HTMLIonInputElement)?.value;
    const localidadValue = (document.getElementById('localidadInput') as HTMLIonInputElement)?.value;
    const precioValue = (document.getElementById('precioInput') as HTMLIonInputElement)?.value;

    const nombre = nombreValue ? nombreValue.toString() : '';
    const localidad = localidadValue ? localidadValue.toString() : '';
    const precio = precioValue ? precioValue.toString() : '';
  
    if (nombre && localidad && precio) {
      const newHotel: NewHotel = { nombre, localidad, precio };
      setHotels((prevHotels) => [...prevHotels, newHotel]);
    }
  };
  
  
  

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonButtons slot="start">
            <IonMenuButton />
          </IonButtons>
          <IonTitle>{name}</IonTitle>
        </IonToolbar>
      </IonHeader>

      <IonContent fullscreen>
        <p>En esta página añadimos hoteles</p>
        <IonItem>
          <IonInput
            name="nombre"
            label="Nombre:"
            placeholder="Aqui el nombre"
          ></IonInput>
        </IonItem>
        <IonItem>
          <IonInput
            name="localidad"
            label="Localidad:"
            placeholder="Aqui la localidad"
          ></IonInput>
        </IonItem>
        <IonItem>
          <IonInput
            name="precio"
            label="Precio"
            type="number"
            placeholder="Aqui el precio"
          ></IonInput>
        </IonItem>
        <IonItem>
          <IonButton onClick={addHotel} shape="round">
            <IonIcon slot="start" icon={addOutline}></IonIcon> Añadir
          </IonButton>
        </IonItem>
      </IonContent>
    </IonPage>
  );
};

export default AñadirHotel;
