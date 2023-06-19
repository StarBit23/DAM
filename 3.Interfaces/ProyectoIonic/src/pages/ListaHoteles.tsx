import React, { useEffect, useState } from 'react';
import {IonButton, IonButtons, IonCol, IonContent, IonGrid, IonHeader, IonInput, IonItem, IonItemOption, IonItemOptions, IonItemSliding, IonLabel, IonList, IonMenuButton, IonModal, IonPage, IonRow, IonTitle, IonToolbar, ItemReorderEventDetail } from '@ionic/react';
import './ListaHoteles.css';
import { useHistory, useLocation } from 'react-router';


const ListaHoteles: React.FC = () => {
  const [editarHotelVisible, setEditarHotelVisible] = useState(false);
  const [hotelEditando, setHotelEditando] = useState(null);

  const abrirEditarHotel = (hotel) => {
    setHotelEditando(hotel);
    setEditarHotelVisible(true);
  };

  //EDITAR HOTEL
  const guardarCambios = async () => {
    try {
      const response = await fetch(`http://localhost:3000/listaHoteles/${hotelEditando.id}`, {
        method: 'PATCH',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(hotelEditando)
      });
  
      if (response.ok) {
        // Si la respuesta es exitosa, actualiza la lista de hoteles con los cambios
        const updatedHoteles = hoteles.map((hotel) => {
          if (hotel.id === hotelEditando.id) {
            return { ...hotel, ...hotelEditando };
          }
          return hotel;
        });
        setHoteles(updatedHoteles);
  
        // Cierra el diálogo de edición
        setEditarHotelVisible(false);
      } else {
        throw new Error('Error al guardar los cambios del hotel');
      }
    } catch (error) {
      console.log(error);
    }
  };

  //BORRAR HOTEL
  const borrarHotel = async (id) => {
    await fetch(`http://localhost:3000/listaHoteles/${id}`, {
      method: 'DELETE'
    });
    // Actualizar la lista de hoteles después de borrar
    const updatedHoteles = hoteles.filter((hotel) => hotel.id !== id);
    setHoteles(updatedHoteles);
  }
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

      {/* formulario editar */}
     <IonModal isOpen={editarHotelVisible} onDidDismiss={() => setEditarHotelVisible(false)}>
  <IonHeader>
    <IonToolbar>
      <IonTitle>Editar Hotel</IonTitle>
    </IonToolbar>
  </IonHeader>
  <IonContent>
    {hotelEditando && (
      <IonList>
        <IonItem>
          <IonLabel>Nombre</IonLabel>
          <IonInput
            value={hotelEditando.nombre}
            onIonChange={(e) =>
              setHotelEditando({ ...hotelEditando, nombre: e.target.value })
            }
          ></IonInput>
        </IonItem>
        <IonItem>
          <IonLabel>Localidad</IonLabel>
          <IonInput
            value={hotelEditando.localidad}
            onIonChange={(e) =>
              setHotelEditando({ ...hotelEditando, localidad: e.target.value })
            }
          ></IonInput>
        </IonItem>
        <IonItem>
          <IonLabel>Precio</IonLabel>
          <IonInput
            value={hotelEditando.precio}
            onIonChange={(e) =>
              setHotelEditando({ ...hotelEditando, precio: e.target.value })
            }
          ></IonInput>
        </IonItem>
        <IonButton onClick={guardarCambios}>Guardar Cambios</IonButton>
      </IonList>
    )}
  </IonContent>
</IonModal>

      {/* listado hoteles */}
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
            <IonItemOption onClick={() => abrirEditarHotel(hotel)}>Editar</IonItemOption>
            <IonItemOption color="danger" onClick={() => borrarHotel(hotel.id)}>Borrar</IonItemOption>
          </IonItemOptions>
        </IonItemSliding>

        
  
        )) 
      }
      </IonList>
     </IonContent>

      
    </IonPage>
    
  );
}
export default ListaHoteles;
