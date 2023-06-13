
const patchComentariosHotel = async (hotel) => {
  const response = await fetch('http://localhost:3000/listaHoteles/' + hotel.id, {
    method: 'PATCH',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(hotel)
  });
  const data = response.json();
}

const HotelList = (props) => {


    const saveComentarios = async (hoteles, hotel, comentario, usuario) => {
      hotel.comentarios = [...hotel.comentarios, {usuario, comentario}];
      await patchComentariosHotel(hotel);
      for(let i=0; i < hoteles.length; i++) {
        if (hoteles[i].id === hotel.id) {
          hoteles[i].comentarios = hotel.comentarios;
        }
      }
      props.setHoteles([...hoteles]);
    }



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
            <ul >{hotel.comentarios.map((comentario)=><li>{comentario.usuario} - {comentario.comentario}</li>)}</ul> 
            <input id="nombreComentario" type="text" placeholder="Nombre"></input>
            <input id="comentario" type="text" placeholder="Escriba un comentario"></input>
            <button onClick={(e)=>{
              saveComentarios(props.hoteles, hotel, e.target.previousSibling.value, e.target.previousSibling.previousSibling.value)}}>Enviar</button>
          </div>
        </li>)}
        
      </ul>
    );
};

export default HotelList;