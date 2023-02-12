import { useState } from 'react';

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

  const HotelForm = () => {
    const [hoteles,setHoteles] = useState(listaHoteles)

    const HotelForm1 = () => {
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
  HotelForm1();
  }
  

  export default HotelForm;