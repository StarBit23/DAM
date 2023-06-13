const HotelView = ({hotel}) => {
    return (
      <div className="hotelView">
        <h1>{hotel.name}</h1>
        <h2>Estrellas: {hotel.estrellas}</h2>
        <h2>Ciudad: {hotel.ciudad}</h2>
        <h2>Precio: {hotel.precio}€</h2>
        <img alt="imagen hotel" style={{"width":"430px", "height":"auto"}} src={hotel.img}/>
      </div>
    );
};

export default HotelView;