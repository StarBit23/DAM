const MuseoFormulario = ({onAddMuseo}) => {
    const addMuseo = () => {    
      const museo = {
        name: document.getElementById("nombre").value,
        location: document.getElementById("location").value,
        municipio: document.getElementById("municipio").value,
        web : document.getElementById("web").value,
        img: document.getElementById("img").value,
      }
      onAddMuseo(museo);
    }

  return (
    <>
  <span>Nombre: </span><input id='nombre' type={"text"} placeholder="nombre"></input><br/>
  <span>Location: </span><input id='location' type={"text"} placeholder="location"></input><br/>
  <span>Municipio: </span><input id='municipio' placeholder="municipio"></input><br/>
  <span>Web: </span><input id='web' placeholder="web"></input><br/>
  <span>Imagen(URL): </span><input id='img' type={"text"} placeholder="url imagen"></input><br/>
   <button onClick={addMuseo} style={{textAlign: "center"}}>Nuevo museo</button>
   </>
  );
}

export default MuseoFormulario;