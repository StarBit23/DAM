import './App.css';
import { useState } from 'react';

const App = () => {
  const [count, setContador] = useState(10);

  const [maximo, setMax] = useState(30);

  const [minimo, setMin] = useState(0);

  const Sumar = () => {
    if (count>=maximo) {
      
    }else{
      setContador(count + 1)
    }
  }
  
  const Restar = () => {
    if (count<=minimo) {
      
    }else{
      setContador(count - 1)
    }
  }

  const Reiniciar = () => {
    setContador(10)
    //setMax(30)
    //setMin(0)
  }

  function establecerMaximo(event) {
    setMax(event.target.value);
  }
  function establecerMinimo(event) {
    setMin(event.target.value);
  }

  return (
    <div className="App">
      <header className="App-header">
        <div className="contador">
          <button onClick={Restar}>-</button>
          <span>{count}</span>
          <button onClick={Sumar}>+</button>
          <p></p>
          <button onClick={Reiniciar}>REINICIAR</button>
        </div>
        
        
        <p></p>
        
        <div id='setMaxMin'>
          <span>MAXIMO:{maximo}</span>
          <div id='idmaximo'>
          <input type="number" name="country_code" pattern="[0-9]+" onChange={establecerMaximo} placeholder="maximo" required="required"/>
          </div>
        
          <span>MINIMO:{minimo}</span>
          <div id='idminimo'>
          <input type="number" name="country_code" pattern="[0-9]+" onChange={establecerMinimo} placeholder="minimo" required="required"/>
         </div>
        </div>
        
        
        
      </header>
    </div>
  );
}

export default App;
