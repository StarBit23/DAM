
  const HotelForm = ({onAddHotel}) => {

    const addHotel = () => {
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
        img: document.getElementById("img").value,
        comentarios: [document.getElementById("comentarioUser").value, document.getElementById("comentarioDescripcion").value]
      }
      onAddHotel(hotel);
    }
  

  return (
    <>
  <span>Nombre: </span><input id='nombre' type={"text"} placeholder="nombre"></input><br/>
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

  <span>Escribe un comentario: </span><br/>
  <input id='comentarioUser' type={"text"} placeholder="nombre ususario"></input><br/>
  <textarea id='comentarioDescripcion'  placeholder="descripción"></textarea>

   <button onClick={addHotel} style={{textAlign: "center"}}>AÑADIR</button>
   </>
  );

}
  
  export default HotelForm;