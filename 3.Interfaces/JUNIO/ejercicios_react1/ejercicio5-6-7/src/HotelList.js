const HotelList = (props) => {
    return (
      <ul>
        {props.hoteles.map((hotel) => 
        <li key= {hotel.id}> 
          <h1>{hotel.name}</h1>
          <h2>Estrellas: {hotel.estrellas}</h2> 
          <h2>Ciudad: {hotel.ciudad}</h2>
          <h2>Precio: {hotel.precio}€</h2>
          <img alt="imagen hotel" style={{"width":"430px", "height":"auto"}} src={hotel.img}/>
          <div>
            <h2>Comentario: </h2>
            {/* <ul {hotel.comentarios.map}></ul> */}
            
          </div>
        </li>)}
        
      </ul>
    );
};

export default HotelList;