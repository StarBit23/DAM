import './App.css';

const listaHoteles = [
  {id:1, name:"Only YOU Hotel",
   estrellas:5, ciudad:"Málaga",
    precio:"202", img:"https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_470,q_auto,w_805//partnerimages/12/56/1256506366.jpeg"
  },
  {id:2, name:"Hotel Ohtels",
   estrellas:4, ciudad:"Gibraltar",
    precio:"79", img:"https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_470,q_auto,w_805//partnerimages/33/03/330311958.jpeg"
  },
  {id:3, name:"Playaballena Aquapark y Spa Hotel",
   estrellas:4, ciudad:"Rota",
    precio:"83", img:"https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_470,q_auto,w_805//uploadimages/24/23/24231942.jpeg"
  },
  {id:4, name:"Rincón de Pepe",
   estrellas:4, ciudad:"Murcia",
    precio:"85", img:"https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_470,q_auto,w_805//uploadimages/42/16/42168000.jpeg"
  }
]
  
    
  const HotelView = () => {
      return <p>{listaHoteles[1]}</p>;
  }


function App() {
  return (
    <div className="App">
      <header className="App-header">
        <HotelView></HotelView>
     </header>
    </div>
  );
}

export default App;
