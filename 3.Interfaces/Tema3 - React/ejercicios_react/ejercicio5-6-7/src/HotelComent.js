const HotelComent = ({onAddComent}) => {

    const addComent = () => {
      const coment = {
        name: document.getElementById("nombre").value,
        ciudad: document.getElementById("ciudad").value,
      }
      onAddComent(coment);
    }
  

  return (
    <>
  <span>Nombre: </span><input id='nombre' type={"text"} placeholder="nombre"></input><br/>
  <span>Descripcion: </span><textarea id='ciudad' type={"text"} placeholder="ciudad"></textarea><br/>

   <button onClick={addComent} style={{textAlign: "center"}}>COMENTAR</button>
   </>
  );

}
  
  export default HotelComent;