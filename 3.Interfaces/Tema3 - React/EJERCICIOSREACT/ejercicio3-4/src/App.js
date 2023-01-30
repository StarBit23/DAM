import './App.css';
import { useState } from 'react';

const App = () => {
  const [count, setContador] = useState(10);

  const [maximo, setMax] = useState(30);

  const [minimo, setMin] = useState(0);

  const Sumar = () => {
    if (count===maximo) {
      
    }else{
      setContador(count + 1)
    }
  }
  
  const Restar = () => {
    if (count===minimo) {
      
    }else{
      setContador(count - 1)
    }
  }

  const Reiniciar = () => {
    setContador(10)
  }

  const establecerMaximo = () => {
    setMax(maximo + 1)
  }

  const establecerMinimo = () => {
    setMin(minimo - 1)
  }

  return (
    <div className="App">
      <header className="App-header">
        <div id='contador'></div>
        <button onClick={Restar}>-Restar-</button>
        <span>{count}</span>
        <button onClick={Sumar}>+Sumar+</button>
        <p></p>
        <button onClick={Reiniciar}>REINICIAR</button>
        
        <p></p>
        
        <div id='setMaxMin'></div>
        <button onClick={establecerMaximo}>MAXIMO</button>
        <button onClick={establecerMinimo}>MINIMO</button>
      </header>
    </div>
  );
}

export default App;
