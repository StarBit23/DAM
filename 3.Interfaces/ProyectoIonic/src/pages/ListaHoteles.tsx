import React, { useEffect, useState } from 'react';
import {IonButtons, IonCol, IonContent, IonGrid, IonHeader, IonItem, IonItemOption, IonItemOptions, IonItemSliding, IonLabel, IonList, IonMenuButton, IonPage, IonRow, IonTitle, IonToolbar, ItemReorderEventDetail } from '@ionic/react';
import './ListaHoteles.css';
import { useHistory, useLocation } from 'react-router';


const MostrarHoteles: React.FC = () => {
  //JSON HOTELES
  const [hoteles, setHoteles] = useState([]);
  const location = useLocation();
  const history = useHistory();

  const getHoteles = async () => {
    const response = await fetch('http://localhost:3000/listaHoteles');
    const apiHoteles = await response.json();
    setHoteles(apiHoteles);
  }
  
  console.log(location.key);
  useEffect(
    () => {
        getHoteles();
    },
    [history]
);

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonButtons slot="start">
            <IonMenuButton />
          </IonButtons>
          <IonTitle>{"Lista hoteles"}</IonTitle>
        </IonToolbar>
      </IonHeader>
     <IonContent fullscreen>
      <IonList>
      {/* The reorder gesture is disabled by default, enable it to drag and drop items */}
      <IonGrid>
        <IonRow>
          <IonCol>Hotel</IonCol>
          <IonCol>Localidad</IonCol>
          <IonCol>Precio</IonCol>
        </IonRow>
      </IonGrid>
      
      
      {
        hoteles.map( hotel => (
          <IonItemSliding key={hotel.id}>
          <IonItem>
            <IonLabel>{hotel.nombre}</IonLabel><IonLabel>{hotel.localidad}</IonLabel><IonLabel>{hotel.precio}€</IonLabel>
          </IonItem>
          <IonItemOptions>
            <IonItemOption>Editar</IonItemOption>
            <IonItemOption color="danger">Borrar</IonItemOption>
          </IonItemOptions>
        </IonItemSliding>
  
        )) 
      }
      </IonList>
     </IonContent>

      
    </IonPage>
    
  );
}
export default MostrarHoteles;
