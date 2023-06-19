import { IonBadge, IonButton, IonButtons, IonContent, IonHeader, IonItem, IonLabel, IonList, IonMenuButton, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import { useParams } from 'react-router';
import ExploreContainer from '../components/ExploreContainer';
import './Page.css';
import { useState } from 'react';
import AñadirHotel from './AñadirHotel';
import { add } from 'ionicons/icons';

const Contador: React.FC = () => {

  const [contador, setContador] = useState(0);

  const { name } = useParams<{ name: string; }>();

  const incrementar = () => {
    setContador(contador + 1);
  }

  

  const decrementar = () => {
    setContador(contador - 1);
  }

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonButtons slot="start">
            <IonMenuButton />
          </IonButtons>
          <IonTitle>{"Contador"}</IonTitle>
        </IonToolbar>
      </IonHeader>

      <IonContent fullscreen>
        <IonHeader collapse="condense">
          <IonToolbar>
            <IonTitle size="large">{name}</IonTitle>
          </IonToolbar>
        </IonHeader>

        <p>Esto es una prueba</p>
      <IonList>
        <IonItem>
          <IonButton onClick={decrementar}>Restar</IonButton>
          <IonButton onClick={incrementar}>Sumar</IonButton>
        </IonItem>
        <IonItem>
          <IonBadge slot="end">{contador}</IonBadge>
          <IonLabel>Contador</IonLabel>
        </IonItem>
      </IonList>
        

      </IonContent>
    </IonPage>
  );
};

export default Contador;