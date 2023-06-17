import React from 'react';
import { IonContent, IonHeader, IonItem, IonLabel, IonList, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import { useLocation } from 'react-router';

const ListaHoteles: React.FC = () => {
  const location = useLocation<{ hotels: any[] }>();
  const { hotels } = location.state || { hotels: [] };

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Lista de Hoteles</IonTitle>
        </IonToolbar>
      </IonHeader>

      <IonContent fullscreen>
        <IonList>
          {hotels.map((hotel, index) => (
            <IonItem key={index}>
              <IonLabel>
                <h2>{hotel.nombre}</h2>
                <p>{hotel.localidad}</p>
                <p>{hotel.precio}€</p>
              </IonLabel>
            </IonItem>
          ))}
        </IonList>
      </IonContent>
    </IonPage>
  );
};

export default ListaHoteles;