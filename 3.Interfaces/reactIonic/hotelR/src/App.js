import './App.css';
import { useState } from 'react';
import HotelList from './HotelList';
import HotelForm from './HotelForm';
import { useEffect } from 'react';

function App() {

  //JSON HOTELES
  const [hoteles,setHoteles] = useState([]);

  const getHoteles = async () => {
    const response = await fetch('http://localhost:3000/listaHoteles');
    const apiHoteles = await response.json();
    setHoteles(apiHoteles);
  }

  useEffect(
    () => {
        getHoteles();
    },
    []
);

  const postHoteles = async (hotel) => {
    const response = await fetch('http://localhost:3000/listaHoteles', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(hotel)
    });
    const data = response.json()
  }

  const onAddHotel = (hotel) => {
    postHoteles(hotel);
    setHoteles([...hoteles, hotel]);
  }



//HTML
  return (
    <div className="App">
      <header className="App-header">
        <HotelList hoteles={hoteles} setHoteles={setHoteles}/>
        <h1> ------------------------------------------ </h1>
        <HotelForm onAddHotel={onAddHotel}/>
        <h1> ------------------------------------------ </h1>
        

     </header>
    </div>
  );
};

export default App;
