import { IonAvatar, IonButton, IonButtons, IonCol, IonContent, IonGrid, IonHeader, IonInfiniteScroll, IonInfiniteScrollContent, IonInput, IonItem, IonItemOption, IonItemOptions, IonItemSliding, IonLabel, IonList, IonMenuButton, IonModal, IonPage, IonRefresher, IonRefresherContent, IonRow, IonSearchbar, IonTitle, IonToolbar, RefresherEventDetail } from '@ionic/react';
import { useHistory } from 'react-router';
import React, { useState, useEffect } from 'react';

interface Museo {
  id: number;
  name: string;
  image: string;
}

const ListadoMuseos: React.FC = () => {
  const [museos, setMuseos] = useState<Museo[]>([]);
  const [disableInfiniteScroll, setDisableInfiniteScroll] = useState(false);
  const [currentPage, setCurrentPage] = useState(1);
  const history = useHistory();
  const [showConfirmDialog, setShowConfirmDialog] = useState(false);
  const [museoToDelete, setMuseoToDelete] = useState<Museo | null>(null);

  //actualizar museos
  const actualizarMuseos = async () => {
    const response = await fetch(`http://localhost:3000/museos?page=${currentPage}`);
    const apiMuseos = await response.json();
    setMuseos(apiMuseos);
    setCurrentPage(currentPage + 1);
  };
  
  function handleRefresh(event: CustomEvent<RefresherEventDetail>) {
    setTimeout(() => {
      // Any calls to load data go here
      event.detail.complete();
      actualizarMuseos();
    }, 2000);
  }

  //borro el museo indicado por id
  const borrarMuseo = async (id) => {

    await fetch(`http://localhost:3000/museos/${id}`, {
      method: 'DELETE'
    });
    await actualizarMuseos();
  };
  
  //dialogoBorrarMuseos
  const mostrarDialogoBorrar = (museo: Museo) => {
    setMuseoToDelete(museo);
    setShowConfirmDialog(true);
};

const handleBorrarConfirmado = async () => {
  if (museoToDelete) {
    await borrarMuseo(museoToDelete.id);
    setShowConfirmDialog(false);
  }
};

const handleBorrarCancelado = () => {
  setShowConfirmDialog(false);
};

  //recojo el json de museos
  const getMuseos = async () => {
    const response = await fetch(`http://localhost:3000/museos?page=${currentPage}`);
    const apiMuseos = await response.json();
    setMuseos((prevMuseos) => [...prevMuseos, ...apiMuseos]);
    setCurrentPage(currentPage + 1);
  };

  useEffect(() => {
    actualizarMuseos();
  }, []);

  //manejo el inifinite scroll
  const loadData = async (event: CustomEvent<void>) => {
    await getMuseos();

    if (disableInfiniteScroll) {
      (event.target as HTMLIonInfiniteScrollElement).complete();
      return;
    }
    if (museos.length % 10 !== 0) {
      setDisableInfiniteScroll(true);
    }

    (event.target as HTMLIonInfiniteScrollElement).complete();
  };

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonButtons slot="start">
            <IonMenuButton />
          </IonButtons>
          <IonTitle>Listado museos</IonTitle>
          {/* barra de busqueda */}
          <>
            <IonSearchbar show-clear-button="always" clear-icon="trash-bin" animated={true} placeholder="Busca por location"></IonSearchbar>
          </>
        </IonToolbar>
      </IonHeader>


      <IonContent>
        {/* refresher */}
      <IonRefresher slot="fixed" onIonRefresh={handleRefresh}>
          <IonRefresherContent></IonRefresherContent>
        </IonRefresher>
        <p>Tira para refrescar!</p>

        {/* listado museos */}
        <IonList>
          {museos.map((museo) => (
            <IonItemSliding key={museo.id}>
              <IonItem>
                <IonAvatar slot="start">
                  <img src={museo.image} alt={museo.name} />
                </IonAvatar>
                <IonLabel>{museo.name}</IonLabel><IonLabel>{museo.location}</IonLabel>
              </IonItem>
              <IonItemOptions>
                <IonItemOption>Editar</IonItemOption>
                <IonItemOption color="danger" onClick={() => mostrarDialogoBorrar(museo)}>Borrar</IonItemOption>
              </IonItemOptions>
            </IonItemSliding>
          ))}
        </IonList>
          
        {/* infinite scroll */}
        <IonInfiniteScroll threshold="100px" disabled={disableInfiniteScroll} onIonInfinite={loadData}>
          <IonInfiniteScrollContent loadingText="Cargando más museos..." />
        </IonInfiniteScroll>
        
        {/* dialogo borrar */}
          <IonModal isOpen={showConfirmDialog}>
          <IonContent>
            <h2>¿Quieres borrar el museo seleccionado?</h2>
            <IonButton onClick={handleBorrarConfirmado}>Si</IonButton>
            <IonButton onClick={handleBorrarCancelado}>No</IonButton>
          </IonContent>
        </IonModal>


            
      </IonContent>
    </IonPage>
  );
};

export default ListadoMuseos;
