//import logo from './logo.svg';
//import './App.css';

import { useState } from "react";

function App() {
  const nombres = ["Ana","Pepe","María","Lolo"];
  const [contador, setContador] = useState(0);

  const mostrarListado = () => {
    return(
    <ol>
      {nombres.map(nombres => <li>{nombres}</li>)}
    </ol>
    )
  }

  const aumentarContador = () => {
    setContador(contador + 1);
  }

  return (
    <div className="App">
      <p>Listado de nombres</p>
      {mostrarListado()}
      <p>Contador: {contador}</p>
      <button onClick={aumentarContador}>Aumentar contador</button>
    </div>
  );
}

export default App;
