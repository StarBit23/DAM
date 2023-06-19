const HotelComent = ({onAddComent}) => {

  const addComent = () => {
    const comentario = {
      comentarios: [document.getElementById("comentarioUser").value, document.getElementById("comentarioDescripcion").value]
    }
    onAddComent(comentario);
  }

  return(
    <>
  <input id='comentarioUser' type={"text"} placeholder="nombre ususario"></input><br/>
  <textarea id='comentarioDescripcion'  placeholder="descripción"></textarea>

   <button onClick={addComent} style={{textAlign: "center"}}>COMENTAR</button>
    </>
  )

}
  
  export default HotelComent;