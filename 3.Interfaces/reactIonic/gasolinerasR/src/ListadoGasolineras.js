import './App.css'

const ListadoGasolineras = (props) => {
    return (
      <ul>
        {props.gasolineraprop.map((gasolinera) => 
        <li key= {gasolinera.id}> 
        <div className='list'>
          <li><h2>Localidad: {gasolinera.localidad}</h2></li>
          <li><h2>Direccion: {gasolinera.direccion}</h2></li> 
          <li><h2>Horario: {gasolinera.horario}</h2></li>
          <li><h2>Empresa: {gasolinera.empresa}</h2></li>
          <li><h2>Gasolina: {gasolinera.precio_gasolina}€</h2></li>
          <li><h2>Diesel: {gasolinera.precio_diesel}€</h2></li>
        </div>
          
        </li>)}
      </ul>
    );
};

export default ListadoGasolineras;