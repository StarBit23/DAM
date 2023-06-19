const AddGasolinera=({addGasolinera}) => {
    const nuevaGasolinera = () => {
        const gasolinera = {
          localidad: document.getElementById("localidad").value,
          direccion: document.getElementById("direccion").value,
          horario: document.getElementById("horario").value,
          empresa: document.getElementById("empresa").value,
          precio_gasolina: document.getElementById("precioGasolina").value,
          precio_diesel: document.getElementById("precioDiesel").value
        }
        addGasolinera(gasolinera);
      }

    return (
      <>
    <span>Localidad: </span><input id='localidad' type={"text"} placeholder="localidad"></input><br/>
    <span>Dirección: </span><input id='direccion' type={"text"} placeholder="direccion"></input><br/>
    <span>Horario: </span><input id='horario' type={"text"} placeholder="horario"></input><br/>
    <span>Empresa: </span><input id='empresa' type={"text"} placeholder="empresa"></input><br/>
    <span>Precio gasolina: </span><input id='precioGasolina' type={"number"} min={0} placeholder="precio gasolina"></input><br/>
    <span>Precio diesel: </span><input id='precioDiesel' type={"number"} min={0} placeholder="precio diesel"></input><br/>

     <button onClick={nuevaGasolinera} style={{textAlign: "center"}}>CREAR NUEVA GASOLINERA</button>
     </>
    );
};

export default AddGasolinera;