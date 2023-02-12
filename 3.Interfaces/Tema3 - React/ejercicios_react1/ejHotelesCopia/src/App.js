import './App.css';
import { useState } from 'react';
import HotelView from './HotelView';
import { useEffect } from 'react';
//import HotelForm from './HotelForm';

const listaHoteles = [
  {id:1, name:"Only YOU Hotel",
   estrellas:"★★★★★", ciudad:"Málaga",
    precio:"202", img:"https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_470,q_auto,w_805//partnerimages/12/56/1256506366.jpeg"
  },
  {id:2, name:"Hotel Ohtels",
   estrellas:"★★★★", ciudad:"Gibraltar",
    precio:"79", img:"https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_470,q_auto,w_805//partnerimages/33/03/330311958.jpeg"
  },
  {id:3, name:"Playaballena Aquapark y Spa Hotel",
   estrellas:"★★★★", ciudad:"Rota",
    precio:"83", img:"https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_470,q_auto,w_805//uploadimages/24/23/24231942.jpeg"
  },
  {id:4, name:"Rincón de Pepe",
   estrellas:"★★★★", ciudad:"Murcia",
    precio:"85", img:"https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_470,q_auto,w_805//uploadimages/42/16/42168000.jpeg"
  }
];

const HotelList = (props) => {
  //const mapHoteles = props.hoteles.map((hotel) => <li key= {hotel.id}> {hotel.name}</li>);
    return (
      <ul>
        {props.hoteles.map((hotel) => 
        <li key= {hotel.id}> 
          <h1>{hotel.name}</h1>
          <h2>Estrellas: {hotel.estrellas}</h2> 
          <h2>Ciudad: {hotel.ciudad}</h2>
          <h2>Precio: {hotel.precio}€</h2>
          <img style={{"width":"430px", "height":"auto"}} src={hotel.img}/> 
        </li>)}
        
      </ul>
    );
};





function App() {

  const [hoteles,setHoteles] = useState(listaHoteles)

  const HotelForm = () => {
    let numEstrellas = document.getElementById("estrellas").value;
    if (numEstrellas==="1") {
      numEstrellas="★"
    }
    else if (numEstrellas==="2") {
      numEstrellas="★★"
    }
    else if (numEstrellas==="3") {
      numEstrellas="★★★"
    }
    else if (numEstrellas==="4") {
      numEstrellas="★★★★"
    }
    else if (numEstrellas==="5") {
      numEstrellas="★★★★★"
    }
    else {numEstrellas="undef"};
    const hotel = {
      name: document.getElementById("nombre").value,
      estrellas: numEstrellas,
      ciudad: document.getElementById("ciudad").value,
      precio: document.getElementById("precio").value,
      img: document.getElementById("img").value
    }
    
    setHoteles([...hoteles,hotel])
  }

////////////////////////////////////////////
  const getHoteles = async () => {
    const response = await fetch('http://localhost:3000/listaHoteles');
    const apiHoteles = await response.json();
    setHoteles(apiHoteles);
  }

  const postHoteles = async (hotel) => {
    const response = await fetch('http://localhost:3000/listaHoteles', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(hotel)
    });
    const data = response.json()
    console.log(data);
    getHoteles();
  }
  /////////////////////////////////////////////

  const HotelList2 = ({getHoteles, hotel}) => {
    useEffect(
      () => {
          getHoteles();
      },
      []
  );
  }

  return (
    <div className="App">
      <header className="App-header">
        <HotelView hotel={listaHoteles[0]}></HotelView>
        <h1> ------------------------------------------ </h1>
        {/* <HotelList hoteles={hoteles}></HotelList> */}
        <HotelList2 getHoteles={getHoteles}/>
        {/* <HotelForm></HotelForm> */}
        <h1> ------------------------------------------ </h1>
        <span>Nombre: </span><input id='nombre' type={"text"} placeholder="nombre"></input><br/>
        {/* <input id='estrellas' type={"number"} max={5} min={1} minLength={1} placeholder="estrellas"></input><br/> */}
        <span>Estrellas: </span><select id='estrellas'placeholder="estrellas">
          <option value='1'>1</option>
          <option value='2'>2</option>
          <option value='3'>3</option>
          <option value='4'>4</option>
          <option value='5'>5</option>
          </select><br/>
        <span>Ciudad: </span><input id='ciudad' type={"text"} placeholder="ciudad"></input><br/>
        <span>Precio: </span><input id='precio' type={"number"} min={0} placeholder="precio"></input><br/>
        <span>URL imagen: </span><input id='img' type={"text"} placeholder="url imagen"></input><br/>

         <button onClick={HotelForm.bind()} style={{textAlign: "center"}}>AÑADIR</button>
         {/* <HotelForm2 postHoteles={postHoteles} /> */}

     </header>
    </div>
  );
};

export default App;
