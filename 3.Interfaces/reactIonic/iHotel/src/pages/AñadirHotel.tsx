import React, { useState } from 'react';
import { IonButton, IonButtons, IonContent, IonHeader, IonIcon, IonInput, IonItem, IonLabel, IonList, IonMenuButton, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import { useHistory, useParams } from 'react-router';
import { addOutline } from 'ionicons/icons';

interface NewHotel {
  nombre: string;
  localidad: string;
  precio: string;
}

const AñadirHotel: React.FC = () => {
  const history = useHistory();

  const [nombre, setNombre] = useState("");
  const [localidad, setLocalidad] = useState("");
  const [precio, setPrecio] = useState("");

  const navigateToListaHoteles = () => {
    history.push('/page/listaHoteles');
  };

  //JSON
  const [hoteles,setHoteles] = useState([]);

  const postHoteles = async (hotel) => {
    const response = await fetch('http://localhost:3000/listaHoteles', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(hotel)
    });
    const data = await response.json()
  }

  const onAddHotel = (hotel) => {
    postHoteles(hotel);
    setHoteles([...hoteles, hotel]);
  }

  const { name } = useParams<{ name: string }>();

  const addHotel = () => {
    const hotel = {
      nombre,
      localidad,
      precio,
    }
    console.log(hotel);

    onAddHotel(hotel);
    navigateToListaHoteles();
  
  };
  
  
  

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonButtons slot="start">
            <IonMenuButton />
          </IonButtons>
          <IonTitle>{"Añadir hotel"}</IonTitle>
        </IonToolbar>
      </IonHeader>

      <IonContent fullscreen>
        <p>En esta página añadimos hoteles</p>
        <IonItem>
          <IonInput
            id="nombre"
            name="nombre"
            label="Nombre:"
            placeholder="Aqui el nombre"
            onIonChange={event => setNombre(event.detail.value) }
          ></IonInput>
        </IonItem>
        <IonItem>
          <IonInput
            id="localidad"
            name="localidad"
            label="Localidad:"
            placeholder="Aqui la localidad"
            onIonChange={event => setLocalidad(event.detail.value) }
          ></IonInput>
        </IonItem>
        <IonItem>
          <IonInput
            id="precio"
            name="precio"
            label="Precio"
            type="number"
            placeholder="Aqui el precio"
            onIonChange={event => setPrecio(event.detail.value) }
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
