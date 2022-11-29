
import './App.css';
import { useState } from 'react';

const tareas = [
  {name: "Estudiar Javascript", done: false},
  {name: "Aprender React", done: false},
  {name: "Hacer el pino mientras programo en React", done: false}
]

const App = () => {
    const [tarea, setTareas] = useState('');

    return(
    <div>
      <h1>Mi lista de tareas😎</h1>
      <p>{tarea}</p>
      <form>
        <label>Escribe algo</label>
        <input type="text" id='tarea' value={tarea} onChange={(event)=>{setTareas(event.target.value)}}></input>
        <button>Añadir</button>
      </form>
      <ul>
        {tareas.map((tarea) => <li>{tarea.name}</li>)}
      </ul>
    </div>


    );
  
}

export default App;
