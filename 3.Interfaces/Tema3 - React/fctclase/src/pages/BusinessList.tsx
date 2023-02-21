import { IonButtons, IonContent, IonHeader, IonList, IonMenuButton, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import React from 'react';
import { IonItem, IonLabel } from '@ionic/react';
import { Business } from '../models/Business';


const business: Business[] = [
    {
        name: "Petroprix",
        location: "Martos"
    },
    {
        name: "ISR",
        location: "Jaén"
    }
]

const BusinessList: React.FC = () => {

    return (
        <IonPage>
            <IonHeader>
                <IonToolbar>
                    <IonButtons slot="start">
                        <IonMenuButton />
                    </IonButtons>
                    <IonTitle>Empresas</IonTitle>
                </IonToolbar>
            </IonHeader>

            <IonContent fullscreen>
                <IonHeader collapse="condense">
                    <IonToolbar>
                        <IonTitle size="large">Empresas</IonTitle>
                    </IonToolbar>
                </IonHeader>

                <IonList>
                    {
                        business.map((business) =>
                            <IonItem>
                                <IonLabel>{business.name}</IonLabel>
                            </IonItem>
                        )
                    }
                </IonList>

            </IonContent>
        </IonPage>
    );
};

export default BusinessList;
