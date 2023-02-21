import {
  IonContent,
  IonIcon,
  IonItem,
  IonLabel,
  IonList,
  IonListHeader,
  IonMenu,
  IonMenuToggle,
  IonNote,
} from '@ionic/react';

import { useLocation } from 'react-router-dom';
import { add, business } from 'ionicons/icons';
import './Menu.css';

const Menu = () => {
  const location = useLocation();

  return (
    <IonMenu contentId="main" type="overlay">
      <IonContent>
        <IonList id="inbox-list">
          <IonListHeader>Inbox</IonListHeader>
          <IonNote>IES Virgen del Carmen</IonNote>
          <IonMenuToggle key="empresa" autoHide={false}>
                <IonItem className={location.pathname === "/" ? 'selected' : ''} routerLink={"/"} routerDirection="none" lines="none" detail={false}>
                  <IonIcon slot="start" ios={business} md={business} />
                  <IonLabel>Empresas</IonLabel>
                </IonItem>
              </IonMenuToggle>
              <IonMenuToggle key="nueva_empresa" autoHide={false}>
                <IonItem className={location.pathname === "/new" ? 'selected' : ''} routerLink={"/new"} routerDirection="none" lines="none" detail={false}>
                  <IonIcon slot="start" ios={add} md={add} />
                  <IonLabel>Nueva Empresa</IonLabel>
                </IonItem>
              </IonMenuToggle>
        </IonList>

      </IonContent>
    </IonMenu>
  );
};

export default Menu;
