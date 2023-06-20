import ListadoMuseo from './ListadoMuseos';
import MuseoFormulario from './MuseoFormulario';
import { useState } from 'react';
import { useEffect } from 'react';

function App() {

  const [museos,setMuseos] = useState([]);

  const getMuseos = async () => {
    const response = await fetch('http://localhost:3000/museos');
    const apiMuseos = await response.json();
    setMuseos(apiMuseos);
  }

  useEffect(
    () => {
        getMuseos();
    },
    []
);

const postMuseos = async (hotel) => {
  const response = await fetch('http://localhost:3000/museos', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(hotel)
  });
  const data = response.json()
}

const onAddMuseo = (museo) => {
  postMuseos(museo);
  setMuseos([...museos, museo]);
}

  return (
    <div className="App">
      <header className="App-header">
        <ListadoMuseo museos={museos} setMuseos={setMuseos}/>
        <h1> ------------------------------------------ </h1>
        <MuseoFormulario onAddMuseo={onAddMuseo}/>      
     </header>
    </div>
  );
}

export default App;
