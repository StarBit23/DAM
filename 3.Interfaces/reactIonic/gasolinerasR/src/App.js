import './App.css';
import './ListadoGasolineras'
import { useState } from 'react';
import { useEffect } from 'react';
import ListadoGasolineras from './ListadoGasolineras';
import AddGasolinera from './AddGasolinera';

function App() {
  //JSON
const [gasolineras,setGasolineras] = useState([]);

//VER GASOLINERAS EN EL JSON
const getGasolineras = async () => {
  const response = await fetch('http://localhost:3000/gasolineras');
  const apiGasolineras = await response.json();
  setGasolineras(apiGasolineras);
}
useEffect(
  () => {
      getGasolineras();
  },
  []
);

//CREAR NUEVA GASOLINERA
const postGasolineras = async (gasolinera) => {
  const response = await fetch('http://localhost:3000/gasolineras', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(gasolinera)
  });
  const data = response.json()
}

const addGasolinera = (gasolinera) => {
  postGasolineras(gasolinera);
  setGasolineras([...gasolineras, gasolinera]);
}


  //CODIGO HTML
  return (
    <div className="App">
      <header className="App-header">
        <h1 className="title">LISTADO GASOLINERAS</h1>
        
        <ListadoGasolineras gasolineraprop={gasolineras}/>
          
        <h2>| | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | </h2>

        <AddGasolinera addGasolinera={addGasolinera}/>
        

     </header>
    </div>
  );
};

export default App;
